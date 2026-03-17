package unrn.moneda;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateProvider implements RateProvider {
    private String apiUrl;

    public ExchangeRateProvider(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    @Override
    public double valorDeCambio(String monedaBase,
                                String monedaDestino) {
        String url = apiUrl + monedaBase;

        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(
                    request, HttpResponse.BodyHandlers.ofString());

            String respuestaEnJson = response.body();
            return extraerValorDeCambio(respuestaEnJson, monedaDestino);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error al obtener tasa de cambio", e);
        }
    }

    private double extraerValorDeCambio(String json, String moneda) {
        Gson gson = new Gson();
        var data = gson.fromJson(json, ValoresDeCambio.class);
        Double tasa = data.cambio(moneda);
        if (tasa != null) {
            return tasa;
        }
        throw new RuntimeException(
                "Moneda '" + moneda + "' no encontrada en respuesta");
    }
}
