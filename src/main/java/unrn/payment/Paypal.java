package unrn.payment;

public class Paypal implements PagoOnline {
    private String url;

    public Paypal(String url) {
        this.url = url;
    }

    @Override
    public void cobrar(double monto, TarjetaCredito tarjeta) {
        // consumir servicio de paypal y cobrar
        // si algo sale mal, RuntimeException
    }
}
