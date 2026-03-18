package unrn.moneda;

import java.net.http.HttpClient;

public class Main {
    public static void main(String[] args) {
        try (var realHttpClient = HttpClient.newHttpClient()) {
            var conversor = new CambioMoneda(new ExchangeRateProvider("https://open.er-api.com/v6/latest/USD", realHttpClient));
            var monto = conversor.convertir(
                    100, Moneda.DOLAR, Moneda.PESO);
        }
    }
}
