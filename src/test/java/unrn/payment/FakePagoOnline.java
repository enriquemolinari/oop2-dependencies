package unrn.payment;

class FakePagoOnline implements PagoOnline {
    private boolean invacado = false;

    @Override
    public void cobrar(double monto, TarjetaCredito tarjeta) {
        this.invacado = true;
    }

    public boolean fueInvocado() {
        return this.invacado;
    }
}

