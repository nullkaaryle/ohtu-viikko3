package ohtu.matkakortti;

/**
 * Matkakortin koodiin ei tehtävässä saa koskea ollenkaan!
 */
public class Matkakortti {

    private int saldo;

    public Matkakortti(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void lataa(int maara) {
        saldo += maara;
    }

    public void osta(int hinta) {
        saldo -= hinta;
    }
}
