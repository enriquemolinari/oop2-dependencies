package unrn.payment;

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
        return  precioTotal;
    }
    public void cobrar(TarjetaCredito tarjeta) {
        this.paypal.cobrar(this.montoTotal(), tarjeta);
    }
}
