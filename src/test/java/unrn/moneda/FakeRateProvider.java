package unrn.moneda;

public class FakeRateProvider implements RateProvider {
    @Override
    public double valorDeCambio(String monedaBase, String monedaDestino) {
        return 1425;
    }
}
