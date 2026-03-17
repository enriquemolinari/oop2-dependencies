package unrn.moneda;

public class CambioMoneda {

    private final RateProvider rateProvider;

    public CambioMoneda(RateProvider rateProvider) {
        this.rateProvider = rateProvider;
    }

    public double convertir(double montoAConvertir, Moneda monedaOrigen,
                                Moneda monedaDestino) {
        double valorDeCambio = this.rateProvider.valorDeCambio(monedaOrigen.codigo(), monedaDestino.codigo());

        double comision = calcularComision(montoAConvertir);
        double montoNeto = montoAConvertir - comision;
        double montoConvertido = montoNeto * valorDeCambio;

        return montoConvertido;
    }

    private double calcularComision(double monto) {
        if (monto > 10000) {
            return monto * 0.01; // 1%
        } else if (monto > 1000) {
            return monto * 0.03; // 3%
        }
        return monto * 0.05; // 5%
    }
}

