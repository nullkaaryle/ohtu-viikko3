package ohtu;

import javax.swing.JTextField;

public class Summa implements Komento {

    private Sovelluslogiikka sovelluslogiikka;
    private JTextField syotekentta;

    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovelluslogiikka = sovellus;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        this.sovelluslogiikka.plus(Integer.parseInt(syotekentta.getText()));
    }

}
