package ohtu;

import javax.swing.JTextField;

public class Erotus implements Komento {

    private Sovelluslogiikka sovelluslogiikka;
    private JTextField syotekentta;
    private int luku;

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovelluslogiikka = sovellus;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        try {
            this.luku = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
            System.out.println("Virhe!");
        }
        this.sovelluslogiikka.miinus(luku);
    }

    @Override
    public void peru() {
        this.sovelluslogiikka.plus(luku);
        this.luku = 0;
    }
}
