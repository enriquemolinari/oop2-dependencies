package unrn.moneda;

import java.util.Map;

public record ValorCambio(String base_code, Map<String, Double> rates) {
    Double cambio(String tipoMoneda) {
        return rates.get(tipoMoneda);
    }
}
