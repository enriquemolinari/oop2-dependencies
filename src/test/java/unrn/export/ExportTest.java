package unrn.export;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExportTest {
    @Test
    public void test01() throws IOException {
        var e = new Export(new Users().all());
        FileWriter writer = new FileWriter(new File("/home/enrique/u.txt"));
        e.export(writer);
        writer.close();
        //mejore porque puedo parametrizar el path y lo que voy a exportar
        //pero todavia tengo que linear con un archivo en disco para assertar el test
        //¿ assert ?
    }
}
