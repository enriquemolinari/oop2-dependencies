package unrn.moneda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CambioMonedaTest {

    @Test
    public void fakesDeJdkHttpClient() {
        var fakeHttpClient = new FakeHttpClient();
        var conversor = new CambioMoneda(new ExchangeRateProvider("http://localhost/bla/usd", fakeHttpClient));
        var monto = conversor.convertir(
                100, Moneda.DOLAR, Moneda.PESO);

        assertEquals(105450, monto, 0.01);

    }

    @Test
    public void convertirMontoBajo() {
        var conversor = new CambioMoneda(new FakeRateProvider());
        var monto = conversor.convertir(
                100, Moneda.DOLAR, Moneda.PESO);

        assertEquals(135375.0, monto, 0.01);
    }

    @Test
    public void convertirMontoMedio() {
        var conversor = new CambioMoneda(new FakeRateProvider());
        var monto = conversor.convertir(
                2500, Moneda.DOLAR, Moneda.PESO);
        assertEquals(3455625, monto, 0.01);
    }

    @Test
    public void convertirMontoAlto() {
        var conversor = new CambioMoneda(new FakeRateProvider());
        var monto = conversor.convertir(
                12500, Moneda.DOLAR, Moneda.PESO);
        assertEquals(17634375, monto, 0.01);
    }

}

