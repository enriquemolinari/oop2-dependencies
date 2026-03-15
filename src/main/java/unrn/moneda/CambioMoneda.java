package unrn.moneda;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CambioMoneda {

    private final String apiUrl = "https://open.er-api.com/v6/latest/";

    public double convertir(double montoAConvertir, Moneda monedaOrigen,
                                Moneda monedaDestino) {

        double valorDeCambio = obtenerTasa(monedaOrigen.codigo(), monedaDestino.codigo());

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

    private double obtenerTasa(String monedaBase,
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
        var data = gson.fromJson(json, ValorCambio.class);
        Double tasa = data.cambio(moneda);
        if (tasa != null) {
            return tasa;
        }
        throw new RuntimeException(
                "Moneda '" + moneda + "' no encontrada en respuesta");
    }
}

