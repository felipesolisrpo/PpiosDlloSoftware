import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Persistencia {

    private static final String FILE_PATH = "resultados.txt";

    public static void guardarResultados(SeguimientoSueno seguimientoSueno, int edad, int tiempoDormir, String hizoEjercicio, int cafeina) {

        try {
            FileWriter writer = new FileWriter(FILE_PATH, true);

            // Obtener fecha y hora actual
            Date fechaActual = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String fechaHoraActual = formatter.format(fechaActual);

            // Escribir resultados en el archivo
            writer.write("Fecha y hora: " + fechaHoraActual + "\n");
            writer.write("Duración del sueño: " + seguimientoSueno.obtenerDuracionSueno() + " horas\n");
            writer.write("Edad: " + edad + " años\n");
            writer.write("Tiempo para dormirse: " + tiempoDormir + " minutos\n");
            writer.write("Hizo ejercicio antes de dormir: " + hizoEjercicio + "\n");
            writer.write("Consumió cafeína antes de dormir: " + cafeina + " mg\n");
            writer.write("--------------------------------------------------\n\n");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}