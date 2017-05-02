package ohtu;

import javax.swing.JTextField;

public class Nollaa implements Komento {

    private Sovelluslogiikka sovelluslogiikka;
    private JTextField tuloskentta;
    private int luku;

    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovelluslogiikka = sovellus;
        this.tuloskentta = tuloskentta;
    }

    @Override
    public void suorita() {
        try {
            this.luku = Integer.parseInt(tuloskentta.getText());
        } catch (Exception e) {
            System.out.println("Virhe!");
        }
        this.sovelluslogiikka.nollaa();
    }

    @Override
    public void peru() {
        this.sovelluslogiikka.asetaTulos(luku);
    }

}
