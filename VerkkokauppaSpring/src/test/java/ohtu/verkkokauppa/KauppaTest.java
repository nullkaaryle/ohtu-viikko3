package ohtu.verkkokauppa;

import org.junit.*;
import static org.mockito.Mockito.*;

/**
 * Kaikkien testien tarkastukset onnistuvat mockiton verify-komennolla.
 */
public class KauppaTest {

    Pankki pankki;
    Viitegeneraattori viite;
    Varasto varasto;
    Kauppa kauppa;
    Tuote maito;
    Tuote piima;
    Tuote kerma;

    /**
     * Luodaan ensin mock-oliot.
     */
    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        viite = mock(Viitegeneraattori.class);
        varasto = mock(Varasto.class);
        kauppa = new Kauppa(varasto, pankki, viite);
        piima = new Tuote(2, "piimä", 3);
        maito = new Tuote(1, "maito", 5);
        kerma = new Tuote(2, "kerma", 7);

        when(viite.uusi()).
                thenReturn(42); // määritellään että viitegeneraattori palauttaa viitteen 42

        when(varasto.haeTuote(1)).
                thenReturn(maito);
        when(varasto.saldo(1)).
                thenReturn(10);

        when(varasto.haeTuote(2)).
                thenReturn(piima);
        when(varasto.saldo(2)).
                thenReturn(3);

        when(varasto.haeTuote(3)).
                thenReturn(kerma);
        when(varasto.saldo(3)).
                thenReturn(0);
    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 5);
    }

    /**
     * aloitetaan asiointi, koriin lisätään kaksi eri tuotetta, joita varastossa
     * on ja suoritetaan ostos. varmistettava että kutsutaan pankin metodia
     * tilisiirto oikealla asiakkaalla, tilinumerolla ja summalla
     */
    @Test
    public void kahdenVarastossaOlevanEriTuotteenValitseminenJaMaksaminen() {
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 8);
    }

    /**
     * aloitetaan asiointi, koriin lisätään kaksi samaa tuotetta jota on
     * varastossa tarpeeksi ja suoritetaan ostos. varmistettava että kutsutaan
     * pankin metodia tilisiirto oikealla asiakkaalla, tilinumerolla ja summalla
     */
    @Test
    public void kahdenVarastossaOlevanSamanTuotteenValitseminenJaMaksaminen() {
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 6);
    }

    /**
     * aloitetaan asiointi, koriin lisätään tuote jota on varastossa tarpeeksi
     * ja tuote joka on loppu ja suoritetaan ostos. varmistettava että kutsutaan
     * pankin metodia tilisiirto oikealla asiakkaalla, tilinumerolla ja summalla
     */
    @Test
    public void yhdenVarastossaOlevanJaYhdenLoppuunmyydynTuotteenValitseminenJaMaksaminen() {
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(3);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 5);
    }

    @Test
    public void ostoskorissaOlevanTuotteenPoistaminenOnnistuu() {
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(2);
        kauppa.poistaKorista(2);

        verify(varasto, times(2)).haeTuote(2);
        verify(varasto, times(1)).palautaVarastoon(piima);
    }

    /**
     * varmistettava, että metodin aloitaAsiointi kutsuminen nollaa edellisen
     * ostoksen tiedot (eli edellisen ostoksen hinta ei näy uuden ostoksen
     * hinnassa). katso tarvittaessa apua projektin MockitoDemo testeistä!
     */
    @Test
    public void metodiAloitaAsiointiNollaaEdellisenOstoksenTiedot() {
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(2);

        kauppa.aloitaAsiointi();
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 0);
    }

    /**
     * varmistettava, että kauppa pyytää uuden viitenumeron jokaiselle
     * maksutapahtumalle.
     */
    @Test
    public void kauppaPyytaaUudenViitenumeronJokaiselleMaksutapahtumalle() {
        when(viite.uusi()).
                thenReturn(42).
                thenReturn(43).
                thenReturn(44);

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("pekka", "12345");
        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 5);

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", 43, "12345", "33333-44455", 3);

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", 44, "12345", "33333-44455", 5);
    }

}
