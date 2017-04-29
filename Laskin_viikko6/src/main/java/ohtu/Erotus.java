package ohtu;

import javax.swing.JTextField;

public class Erotus implements Komento {

    private Sovelluslogiikka sovelluslogiikka;
    private JTextField syotekentta;

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovelluslogiikka = sovellus;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        this.sovelluslogiikka.miinus(Integer.parseInt(syotekentta.getText()));
    }
}
