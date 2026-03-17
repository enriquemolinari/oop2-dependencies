package unrn.moneda;

public interface RateProvider {
    double valorDeCambio(String monedaBase,
                         String monedaDestino);
}
