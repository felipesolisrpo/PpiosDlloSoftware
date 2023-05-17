import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Date;
import javax.swing.*;

public class Main {
    public static int getCalidad(String cal) {
        int calidad = 0;
        try {
            calidad = Integer.parseInt(cal);
            if(calidad<1 || calidad>10){
                JOptionPane.showMessageDialog(null,"Error: la calificacion del sueño debe estar entre 1 y 10", "Error de entrada",JOptionPane.ERROR_MESSAGE);
                return 0;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error: la calificación del sueño debe ser un número entero", "Error de entrada", JOptionPane.ERROR_MESSAGE);
            return 0; // no hacer los cálculos
        }
        return calidad;
    }
    public static int getEdad(String ed) {
        int edad = -1;
        try {
            edad = Integer.parseInt(ed);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error: la edad debe ser un número entero", "Error de entrada", JOptionPane.ERROR_MESSAGE);
            return -1; // no hacer los cálculos
        }
        return edad;
    }
    public static int getDormir(String dor) {
        int dormir = -1;
        try {
            dormir = Integer.parseInt(dor);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error: el tiempo debe ser un número entero", "Error de entrada", JOptionPane.ERROR_MESSAGE);
            return -1; // no hacer los cálculos
        }
        return dormir;
    }
    public static String getEjercicio(String ej) {
        if(ej.equals("si")){
            return ej;
        } else if(ej.equals("no")){
            return ej;
        } else {
            JOptionPane.showMessageDialog(null,"Error: debe ser 'si/no'", "Error de entrada",JOptionPane.ERROR_MESSAGE);
            return "na";
        }
    }
    public static int getCafeina(String caf) {
        int cafeina = -1;
        try {
            cafeina = Integer.parseInt(caf);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error: la cafeina debe ser un número entero", "Error de entrada", JOptionPane.ERROR_MESSAGE);
            return -1; // no hacer los cálculos
        }
        return cafeina;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SeguimientoSueno seguimientoSueno = new SeguimientoSueno();

        System.out.println("Bienvenido a la aplicación de seguimiento del sueño");
        System.out.println("Hola! ¿Cuál es tu nombre?");
        String nombre = scanner.nextLine();
        System.out.println(nombre + ", ¿estás list@ para comenzar?");
        System.out.println("Presiona Enter para iniciar el seguimiento");
        scanner.nextLine();
        scanner.nextLine();
        seguimientoSueno.iniciarSeguimiento();

        System.out.println("Presiona Enter para detener el seguimiento");
        scanner.nextLine();
        seguimientoSueno.detenerSeguimiento();

        System.out.println("Ingresa una calificación para la calidad de tu sueño (de 1 a 10)");
        String calidadS = scanner.nextLine();
        int calidad = getCalidad(calidadS);
        while (calidad == 0) {
            System.out.println("Ingresa una calificación para la calidad de tu sueño (de 1 a 10)");
            calidadS = scanner.nextLine();
            calidad = getCalidad(calidadS);
        }
        seguimientoSueno.establecerCalidadSueno(calidad);

        // Nuevas preguntas
        System.out.println("¿Cuántos años tienes?");
        String edadS = scanner.nextLine();
        int edad = getEdad(edadS);
        while (edad == -1) {
            System.out.println("¿Cuántos años tienes?");
            edadS = scanner.nextLine();
            edad = getCalidad(calidadS);
        }
        System.out.println("¿Cuánto tiempo tardas en dormirte? (en minutos)");
        String tiempoDormirS = scanner.nextLine();
        int tiempoDormir = getDormir(tiempoDormirS);
        while (tiempoDormir == -1) {
            System.out.println("¿Cuánto tiempo tardas en dormirte? (en minutos)");
            tiempoDormirS = scanner.nextLine();
            tiempoDormir = getCalidad(calidadS);
        }
        System.out.println("¿Realizaste ejercicio antes de dormir? (si/no)");
        String hizoEjercicioS = scanner.nextLine();
        String hizoEjercicio = getEjercicio(hizoEjercicioS);
        while (hizoEjercicio == "na") {
            System.out.println("¿Realizaste ejercicio antes de dormir? (si/no)");
            hizoEjercicioS = scanner.nextLine();
            hizoEjercicio = getEjercicio(hizoEjercicioS);
        }
        System.out.println("¿Cuánta cafeína consumiste antes de dormir? (en miligramos)");
        String cafeinaS = scanner.nextLine();
        int cafeina = getCafeina(cafeinaS);
        while (cafeina == -1) {
            System.out.println("¿Cuánta cafeína consumiste antes de dormir? (en miligramos)");
            cafeinaS = scanner.nextLine();
            cafeina = getCafeina(cafeinaS);
        }
        // Bloque a separar Recomendaciones (new class procesamiento)
        System.out.println("");
        System.out.println("---------------RECOMENDACIONES---------------");

        // Nuevas recomendaciones
        if (edad > 18 && edad <=30 && seguimientoSueno.obtenerDuracionSueno() < 7) {
            System.out.println("");
            System.out.println("Es recomendable dormir al menos 7 horas para tu edad");
        }
        if (edad > 30 && seguimientoSueno.obtenerDuracionSueno() < 8) {
            System.out.println("");
            System.out.println("Es recomendable dormir al menos 8 horas para tu edad");
        }
        if (tiempoDormir > 30) {
            System.out.println("");System.out.println("Es recomendable establecer una rutina para dormir a la misma hora cada noche");
        }
        if (hizoEjercicio.equals("si") && cafeina > 200) {
          System.out.println("");
          System.out.println("Es recomendable no realizar ejercicio ni consumir cafeína antes de dormir");
        } else if (hizoEjercicio.equals("si")) {
          System.out.println("");
          System.out.println("Es recomendable no realizar ejercicio antes de dormir");
        } else if (cafeina > 200) {
          System.out.println("");
          System.out.println("Es recomendable no consumir cafeína antes de dormir");
        }
        double porcentajeDormido = (double) seguimientoSueno.obtenerDuracionSueno() / 8 * 100;
        int calidadSueno = 0;
        
        if (calidad >= 8 && porcentajeDormido >= 85) {
            calidadSueno = 5;
        } else if (calidad >= 6 && porcentajeDormido >= 75) {
            calidadSueno = 4;
        } else if (calidad >= 4 && porcentajeDormido >= 65) {
            calidadSueno = 3;
        } else if (calidad >= 2 && porcentajeDormido >= 55) {
            calidadSueno = 2;
        } else {
            calidadSueno = 1;
        }

        seguimientoSueno.establecerCalidadSueno(calidadSueno);
        Persistencia.guardarResultados(seguimientoSueno, edad, tiempoDormir, hizoEjercicio, cafeina);
    }
}