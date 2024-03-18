package unrn.payment;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CajeroTest {

    @Test
    public void test01() {
        var fake = new FakePagoOnline();
        var cajero = new Cajero(List.of(new Producto(100d),
                new Producto(10d),
                new Producto(200d)), fake);
        var ticket = cajero.cobrar(new TarjetaCredito("123545487"));
        assertEquals(310d, ticket.monto(), 0.01);
        assertTrue(fake.fueInvocado());
    }

    @Test
    public void test02() { //Using mockito
        var fake = mock(PagoOnline.class);
        var cajero = new Cajero(List.of(new Producto(100d),
                new Producto(10d),
                new Producto(200d)), fake);
        TarjetaCredito tarjeta = new TarjetaCredito("123545487");
        var ticket = cajero.cobrar(tarjeta);
        assertEquals(310d, ticket.monto(), 0.01);
        verify(fake).cobrar(anyDouble(), any());
        verify(fake).cobrar(310d, tarjeta);
    }
}
