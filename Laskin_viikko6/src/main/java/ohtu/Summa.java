package ohtu;

import javax.swing.JTextField;

public class Summa implements Komento {

    private Sovelluslogiikka sovelluslogiikka;
    private JTextField syotekentta;
    private int luku;

    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
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
        this.sovelluslogiikka.plus(luku);
    }

    @Override
    public void peru() {
        this.sovelluslogiikka.miinus(luku);
        this.luku = 0;
    }

}
