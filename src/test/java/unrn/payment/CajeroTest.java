package unrn.payment;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CajeroTest {

    @Test
    public void test01() {
        var cajero = new Cajero(List.of(new Producto(100d),
                new Producto(10d),
                new Producto(200d)));
        var ticket = cajero.cobrar(new TarjetaCredito("123545487"));
        assertEquals(310d, ticket.monto(), 0.01);
    }
}
