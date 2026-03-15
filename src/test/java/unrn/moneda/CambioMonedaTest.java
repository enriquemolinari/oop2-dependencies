package unrn.moneda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CambioMonedaTest {

    @Test
    public void convertirDolaresAPesosArgentinos() {
        var conversor = new CambioMoneda();
        var monto = conversor.convertir(
                100, Moneda.DOLAR, Moneda.PESO);

        // PROBLEMAS de este test:
        // 1. Necesita internet — sin conexión, falla
        // 2. Es lento — hace llamadas HTTP reales
        // 3. La tasa USD→ARS cambia todos los días
        // 4. No puedo verificar que la comisión se calculó bien
        //    porque el resultado depende de una tasa que no controlo

        // ¿Qué assert pongo?
        // No sé cuánto está el dólar hoy...
        assertNotNull(monto);
        assertTrue(monto > 0);
    }
}

