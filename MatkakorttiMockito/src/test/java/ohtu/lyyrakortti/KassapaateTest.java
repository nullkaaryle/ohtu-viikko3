package ohtu.lyyrakortti;

import ohtu.matkakortti.*;
import org.junit.*;
import static org.mockito.Mockito.*;

/**
 * Testien tarvitsemat kortit tulee luoda mockitolla.
 */
public class KassapaateTest {

    Kassapaate kassa;
    Matkakortti kortti;

    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = mock(Matkakortti.class);
    }

    /**
     * Jos kortilla on riittävästi rahaa, kassapäätteen metodin ostaLounas
     * kutsuminen varmistaa kortin saldon ja velottaa summan kortilta. Testi
     * ottaa siis kantaa ainoastaan siihen miten kassapääte kutsuu matkakortin
     * metodeja. Matkakortin saldoa ei erikseen tarkasteta, sillä oletuksena on,
     * että matkakortin omat testit varmistavat kortin toiminnan.
     */
    @Test
    public void kortiltaVelotetaanHintaJosRahaaOn() {
        when(kortti.getSaldo()).thenReturn(10);
        kassa.ostaLounas(kortti);

        verify(kortti, times(1)).getSaldo();
        verify(kortti).osta(eq(Kassapaate.HINTA));
    }

    /**
     * Jos kortilla ei ole riittävästi rahaa, kassapäätteen metodin ostaLounas
     * kutsuminen varmistaa kortin saldon mutta ei velota kortilta rahaa.
     */
    @Test
    public void kortiltaEiVelotetaJosRahaEiRiita() {
        when(kortti.getSaldo()).thenReturn(4);
        kassa.ostaLounas(kortti);

        verify(kortti, times(1)).getSaldo();
        verify(kortti, times(0)).osta(anyInt());
    }

    /**
     * Kassapäätteen metodin lataa kutsu lisää matkakortille ladattavan
     * rahamäärän käyttäen kortin metodia lataa jos ladattava summa on
     * positiivinen.
     */
    @Test
    public void kortilleVoiLadataPositiivisenSumman() {
        kassa.lataa(kortti, 5);

        verify(kortti, times(1)).lataa(5);
    }

    /**
     * Kassapäätteen metodin lataa kutsu ei tee matkakortille mitään jos
     * ladattava summa on negatiivinen.
     */
    @Test
    public void kortilleEiVoiLadataNegatiivistaSummaa() {
        kassa.lataa(kortti, -5);

        verify(kortti, times(0)).lataa(anyInt());
    }

}
