package unrn.payment;

public interface PagoOnline {
    void cobrar(double monto, TarjetaCredito tarjeta);
}
