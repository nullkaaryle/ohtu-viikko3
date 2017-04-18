package ohtu.intjoukkosovellus;

public class IntJoukkotoiminnot {

    public IntJoukkotoiminnot() {
    }

    public boolean kuuluu(IntJoukko joukkoX, int luku) {
        int alkioidenLkm = joukkoX.mahtavuus();
        int[] ljono = joukkoX.haeLukujono();
        int on = 0;

        for (int i = 0; i < alkioidenLkm; i++) {

            if (luku == ljono[i]) {
                on++;
            }

        }

        return on > 0;
    }

    public IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();

        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }

        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }

        return x;
    }

    public IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();

        for (int i = 0; i < aTaulu.length; i++) {

            for (int j = 0; j < bTaulu.length; j++) {

                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }

            }

        }

        return y;

    }

    public IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();

        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }

        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(i);
        }

        return z;
    }

}
