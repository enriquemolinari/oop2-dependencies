package unrn.payment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    private final LocalDateTime fechaDeCompra;
    private final double montoTotal;

    public Ticket(LocalDateTime fechaDeCompra, double montoTotal) {
        this.fechaDeCompra = fechaDeCompra;
        this.montoTotal = montoTotal;
    }

    public double monto() {
        return this.montoTotal;
    }

    public String fechaDeCompra() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return this.fechaDeCompra.format(formatter);
    }
}
