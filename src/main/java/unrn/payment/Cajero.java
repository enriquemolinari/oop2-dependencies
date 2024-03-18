package unrn.payment;

import java.time.LocalDateTime;
import java.util.List;

public class Cajero {
    private List<Producto> productos;
    private PagoOnline pagoOnline;

    public Cajero(List<Producto> productos, PagoOnline pagoOnline) {
        this.productos = productos;
        this.pagoOnline = pagoOnline;
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
        this.pagoOnline.cobrar(total, tarjeta);
        return new Ticket(LocalDateTime.now(), total);
    }
}
