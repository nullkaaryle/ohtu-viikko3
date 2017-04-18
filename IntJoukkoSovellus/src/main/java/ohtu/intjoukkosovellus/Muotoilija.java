package ohtu.intjoukkosovellus;

public class Muotoilija {

    private IntJoukko joukko;

    public Muotoilija(IntJoukko joukko) {
        this.joukko = joukko;
    }

    public String muotoileMerkkijonoksi() {
        int alkioidenLkm = joukko.mahtavuus();
        int[] ljono = joukko.haeLukujono();

        if (alkioidenLkm == 0) {
            return "{}";

        } else if (alkioidenLkm == 1) {
            return "{" + ljono[0] + "}";

        } else {
            String tuotos = "{";

            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += ljono[i];
                tuotos += ", ";
            }

            tuotos += ljono[alkioidenLkm - 1];
            tuotos += "}";

            return tuotos;
        }
    }

    public int[] muotoileTauluksi() {
        int alkioidenLkm = joukko.mahtavuus();
        int[] ljono = joukko.haeLukujono();
        int[] taulu = new int[alkioidenLkm];

        for (int i = 0;
                i < taulu.length;
                i++) {
            taulu[i] = ljono[i];
        }

        return taulu;
    }
}
