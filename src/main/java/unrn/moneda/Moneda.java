package unrn.moneda;

public enum Moneda {
    DOLAR("USD"),
    EURO("EUR"),
    PESO("ARS");

    private final String codigo;

    Moneda(String codigo) {
        this.codigo = codigo;
    }

    public String codigo() {
        return codigo;
    }
}
