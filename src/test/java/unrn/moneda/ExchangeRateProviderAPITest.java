package unrn.moneda;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockserver.integration.ClientAndServer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class ExchangeRateProviderAPITest {
    static final String URL_LOCALHOST = "http://localhost:1080/";
    static final String PATH_USD = "/USD";
    private ClientAndServer mockServer;

    @BeforeEach
    public void startMockServer() {
        mockServer = startClientAndServer(1080);
    }

    @Test
    public void consultoPorRateOk() {
        //https://open.er-api.com/v6/latest/USD
        mockServer.when(request().withPath(PATH_USD)).respond(response().withBody(fakeJsonResponse()));
        var r = new ExchangeRateProvider(URL_LOCALHOST);
        var cambio = r.valorDeCambio(Moneda.DOLAR.codigo(), Moneda.PESO.codigo());
        assertEquals(1110D, cambio, 0.01);
    }

    @Test
    public void servicioNoRespondeJsonEsperado() {
        mockServer.when(request().withPath(PATH_USD)).respond(response().withBody(""));
        var r = new ExchangeRateProvider(URL_LOCALHOST);
        assertThrows(RuntimeException.class, () -> r.valorDeCambio(Moneda.DOLAR.codigo(), Moneda.PESO.codigo()));
    }

    @Test
    public void servicioNoContieneCambioAPesos() {
        mockServer.when(request().withPath(PATH_USD)).respond(response().withBody(badJsonResponse()));
        var r = new ExchangeRateProvider(URL_LOCALHOST);
        assertThrows(RuntimeException.class, () -> r.valorDeCambio(Moneda.DOLAR.codigo(), Moneda.PESO.codigo()));
    }


    @AfterEach
    public void stopMockServer() {
        mockServer.stop();
    }

    //no tiene ARS
    private String badJsonResponse() {
        return "{\n" +
                "  \"result\": \"success\",\n" +
                "  \"base_code\": \"USD\",\n" +
                "  \"rates\": {\n" +
                "    \"USD\": 1,\n" +
                "    \"XOF\": 570.969452,\n" +
                "    \"ZWG\": 25.4502,\n" +
                "    \"ZWL\": 25.4502\n" +
                "  }\n" +
                "}";
    }

    private String fakeJsonResponse() {
        return "{\n" +
                "  \"result\": \"success\",\n" +
                "  \"base_code\": \"USD\",\n" +
                "  \"rates\": {\n" +
                "    \"USD\": 1,\n" +
                "    \"ARS\": 1110,\n" +
                "    \"XOF\": 570.969452,\n" +
                "    \"ZWG\": 25.4502,\n" +
                "    \"ZWL\": 25.4502\n" +
                "  }\n" +
                "}";
    }
}
