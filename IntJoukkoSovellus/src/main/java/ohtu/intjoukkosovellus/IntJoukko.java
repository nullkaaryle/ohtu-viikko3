package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int OLETUSKAPASITEETTI = 5;
    public final static int OLETUSKASVATUSKOKO = 5;
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukujono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;
    private IntJoukkotoiminnot joukkotoiminnot;
    private Muotoilija muotoilija;

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {

        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasiteetti ei voi olla negatiivinen");
        }

        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoko ei voi olla negatiivinen");
        }

        lukujono = new int[kapasiteetti];

        for (int i = 0; i < lukujono.length; i++) {
            lukujono[i] = 0;
        }

        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
        this.joukkotoiminnot = new IntJoukkotoiminnot();
        this.muotoilija = new Muotoilija(this);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUSKOKO);
    }

    public IntJoukko() {
        this(OLETUSKAPASITEETTI, OLETUSKASVATUSKOKO);
    }

    public int[] haeLukujono() {
        return lukujono;
    }

    public int haeKasvatuskoko() {
        return kasvatuskoko;
    }

    public int mahtavuus() {
        return this.alkioidenLkm;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {

        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    @Override
    public String toString() {
        return muotoilija.muotoileMerkkijonoksi();
    }

    public int[] toIntArray() {
        return muotoilija.muotoileTauluksi();
    }

    public boolean kuuluu(int luku) {
        return etsiLuvunKohta(luku) != -1;
    }

    private int etsiLuvunKohta(int luku) {
        int kohta = -1;

        for (int i = 0; i < alkioidenLkm; i++) {

            if (luku == lukujono[i]) {
                kohta = i;
            }

        }

        return kohta;

    }

    public boolean lisaa(int luku) {

        if (kuuluu(luku)) {
            return false;
        }

        lukujono[alkioidenLkm] = luku;
        alkioidenLkm++;

        if (alkioidenLkm % lukujono.length == 0) {
            int[] taulukkoVanha = lukujono;
            kopioiTaulukko(lukujono, taulukkoVanha);
            lukujono = new int[alkioidenLkm + kasvatuskoko];
            kopioiTaulukko(taulukkoVanha, lukujono);
        }

        return true;

    }

    public boolean poista(int luku) {

        if (!kuuluu(luku)) {
            return false;
        }

        int luvunKohtaJonossa = etsiLuvunKohta(luku);
        int kopioitavaLuku;

        for (int j = luvunKohtaJonossa; j < alkioidenLkm - 1; j++) {
            kopioitavaLuku = lukujono[j];
            lukujono[j] = lukujono[j + 1];
            lukujono[j + 1] = kopioitavaLuku;
        }

        alkioidenLkm--;
        return true;
    }

}
