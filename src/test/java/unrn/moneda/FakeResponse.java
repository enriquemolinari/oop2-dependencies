package unrn.moneda;

import javax.net.ssl.SSLSession;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class FakeResponse<T> implements HttpResponse<T> {
    @Override
    public int statusCode() {
        return 0;
    }

    @Override
    public HttpRequest request() {
        return null;
    }

    @Override
    public Optional<HttpResponse<T>> previousResponse() {
        return Optional.empty();
    }

    @Override
    public HttpHeaders headers() {
        return null;
    }

    @Override
    public T body() {
        return (T) fakeJsonResponse();
    }

    @Override
    public Optional<SSLSession> sslSession() {
        return Optional.empty();
    }

    @Override
    public URI uri() {
        return null;
    }

    @Override
    public HttpClient.Version version() {
        return null;
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
