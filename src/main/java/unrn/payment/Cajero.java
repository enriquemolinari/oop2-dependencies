package unrn.payment;

import java.time.LocalDateTime;
import java.util.List;

public class Cajero {
    private List<Producto> productos;
    private Paypal paypal = new Paypal("https://paypal.com/v1/cobrar");

    public Cajero(List<Producto> productos) {
        this.productos = productos;
    }

    public double montoTotal() {
        var precioTotal = 0;
        for (Producto producto : productos) {
            precioTotal += producto.precio();
        }
        return precioTotal;
    }

    public Ticket cobrar(TarjetaCredito tarjeta) {
        var total = this.montoTotal();
        this.paypal.cobrar(total, tarjeta);
        return new Ticket(LocalDateTime.now(), total);
    }
}
