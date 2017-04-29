package ohtu;

import javax.swing.JTextField;

public class Nollaa implements Komento {

    private Sovelluslogiikka sovelluslogiikka;

    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovelluslogiikka = sovellus;
    }

    @Override
    public void suorita() {
        this.sovelluslogiikka.nollaa();
    }

}
