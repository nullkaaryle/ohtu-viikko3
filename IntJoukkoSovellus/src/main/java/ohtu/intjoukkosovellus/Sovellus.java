package ohtu.intjoukkosovellus;

import java.util.Scanner;

public class Sovellus {

    private IntJoukko A, B, C;
    private IntJoukkotoiminnot joukkotoiminnot;
    private Scanner lukija;

    public Sovellus(Scanner lukija) {
        this.A = new IntJoukko();
        this.B = new IntJoukko();
        this.C = new IntJoukko();
        this.joukkotoiminnot = new IntJoukkotoiminnot();
        this.lukija = lukija;
    }

    public void kaynnista() {
        tulostaOhjeet();

        while (true) {
            String komento = lukija.nextLine();

            if (komento.equals("lisää") || komento.equals("li")) {
                lisaa();

            } else if (komento.equalsIgnoreCase("poista") || komento.equalsIgnoreCase("p")) {
                poista();

            } else if (komento.equalsIgnoreCase("kuuluu") || komento.equalsIgnoreCase("k")) {
                kuuluu();

            } else if (komento.equalsIgnoreCase("yhdiste") || komento.equalsIgnoreCase("y")) {
                yhdiste();

            } else if (komento.equalsIgnoreCase("leikkaus") || komento.equalsIgnoreCase("le")) {
                leikkaus();

            } else if (komento.equalsIgnoreCase("erotus") || komento.equalsIgnoreCase("e")) {
                erotus();

            } else if (komento.equalsIgnoreCase("A")) {
                System.out.println(A);

            } else if (komento.equalsIgnoreCase("B")) {
                System.out.println(B);

            } else if (komento.equalsIgnoreCase("C")) {
                System.out.println(C);

            } else if (komento.equalsIgnoreCase("lopeta") || komento.equalsIgnoreCase("quit") || komento.equalsIgnoreCase("q")) {
                System.out.println("Lopetetaan, moikka!");
                break;

            } else {
                System.out.println("Virheellinen komento! " + komento);
            }

            tulostaKomennot();

        }
    }

    private void tulostaOhjeet() {
        System.out.println("Tervetuloa joukkolaboratorioon!");
        System.out.println("Käytössäsi ovat joukot A, B ja C.");
        tulostaKomennot();
        System.out.println("Joukon nimi komentona tarkoittaa pyyntöä tulostaa joukko.");
    }

    private void tulostaKomennot() {
        System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
    }

    private IntJoukko mikaJoukko() {
        String joukko = lukija.nextLine();

        while (true) {

            if (joukko.equals("A") || joukko.equals("a")) {
                return A;

            } else if (joukko.equals("B") || joukko.equals("b")) {
                return B;

            } else if (joukko.equals("C") || joukko.equals("c")) {
                return C;

            } else {
                System.out.println("Virheellinen joukko! " + joukko);
                System.out.print("Yritä uudelleen!");
                joukko = lukija.nextLine();
            }

        }

    }

    private int mikaLuku() {
        String luku = lukija.nextLine();
        return Integer.parseInt(luku);
    }

    private void lisaa() {
        System.out.print("Mihin joukkoon? ");
        IntJoukko joukko = mikaJoukko();
        System.out.print("Mikä luku lisätään? ");
        int luku = mikaLuku();
        joukko.lisaa(luku);
    }

    private void poista() {
        System.out.print("Mistä joukosta? ");
        IntJoukko joukko = mikaJoukko();
        System.out.print("Mikä luku poistetaan? ");
        int luku = mikaLuku();
        joukko.poista(luku);
    }

    private void kuuluu() {
        System.out.print("Mihin joukkoon? ");
        IntJoukko joukko = mikaJoukko();
        System.out.print("Mikä luku? ");
        int luku = mikaLuku();
        boolean kuuluuko = joukko.kuuluu(luku);

        if (kuuluuko) {
            System.out.println(luku + " kuuluu joukkoon ");

        } else {
            System.out.println(luku + " ei kuulu joukkoon ");
        }

    }

    private void yhdiste() {
        System.out.print("1. joukko? ");
        IntJoukko aJoukko = mikaJoukko();
        System.out.print("2. joukko? ");
        IntJoukko bJoukko = mikaJoukko();
        IntJoukko yhdiste = joukkotoiminnot.yhdiste(aJoukko, bJoukko);
        System.out.println("A yhdiste B = " + yhdiste.toString());
    }

    private void leikkaus() {
        System.out.print("1. joukko? ");
        IntJoukko aJoukko = mikaJoukko();
        System.out.print("2. joukko? ");
        IntJoukko bJoukko = mikaJoukko();
        IntJoukko leikkaus = joukkotoiminnot.leikkaus(aJoukko, bJoukko);
        System.out.println("A leikkaus B = " + leikkaus.toString());
    }

    private void erotus() {
        System.out.print("1. joukko? ");
        IntJoukko aJoukko = mikaJoukko();
        System.out.print("2. joukko? ");
        IntJoukko bJoukko = mikaJoukko();
        IntJoukko erotus = joukkotoiminnot.erotus(aJoukko, bJoukko);
        System.out.println("A erotus B = " + erotus.toString());
    }

}
