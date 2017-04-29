package ohtu;

import java.util.HashMap;
import java.util.Map;

public class Komentotehdas {

    private Map<String, Komento> komennot;

    public Komentotehdas() {
        komennot = new HashMap<String, Komento>();
    }

    public Komento hae(String operaatio) {
        Komento komento = komennot.get(operaatio);

        if (komento == null) {
            komento = komennot.get("tuntematon");
        }

        return komento;
    }
}
