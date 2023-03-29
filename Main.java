import java.util.Scanner;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SeguimientoSueno seguimientoSueno = new SeguimientoSueno();
        
        System.out.println("Bienvenido a la aplicación de seguimiento del sueño");
        System.out.println("Hola! ¿Cuál es tu nombre?");
        String nombre = scanner.next();
        System.out.println(nombre + ", ¿estás listo para comenzar?");
        System.out.println("Presiona Enter para iniciar el seguimiento");
        scanner.nextLine();
        scanner.nextLine(); 
        seguimientoSueno.iniciarSeguimiento();
        
        System.out.println("Presiona Enter para detener el seguimiento");
        scanner.nextLine(); 
        seguimientoSueno.detenerSeguimiento();
        
        System.out.println("Ingresa una calificación para la calidad de tu sueño           (de 1 a 10)");
        int calidad = scanner.nextInt();
        seguimientoSueno.establecerCalidadSueno(calidad);
        // Nuevas preguntas
        System.out.println("¿Cuántos años tienes?");
        int edad = scanner.nextInt();
        System.out.println("¿Cuánto tiempo tardas en dormirte? (en minutos)");
        int tiempoDormir = scanner.nextInt();
        System.out.println("¿Realizaste ejercicio antes de dormir? (si/no)");
        String hizoEjercicio = scanner.next();
        System.out.println("¿Cuánta cafeína consumiste antes de dormir? (en miligramos)");
        int cafeina = scanner.nextInt();
      
        System.out.println("");
        System.out.println("---------------RECOMENDACIONES---------------");
        if (tiempoDormir > 30) {
          System.out.println("");
          System.out.println("Es recomendable establecer una rutina para dormir              a la misma hora cada noche");
        }
        if (hizoEjercicio.equals("si") && cafeina > 200) {
          System.out.println("");
          System.out.println("Es recomendable no realizar ejercicio ni consumir cafeína antes de dormir");
        } 
        else if (hizoEjercicio.equals("si")) {
          System.out.println("");
          System.out.println("Es recomendable no realizar ejercicio antes de dormir");
        } 
        else if (cafeina > 200) {
          System.out.println("");
          System.out.println("Es recomendable no consumir cafeína antes de dormir");
        }
          // Nuevas recomendaciones
        if (edad < 18 && seguimientoSueno.obtenerDuracionSueno() < 9) {
          System.out.println("");          
          System.out.println("Es recomendable dormir al menos 9 horas para tu                edad");
        }
        if (edad >= 18 && seguimientoSueno.obtenerDuracionSueno() < 7) {
          System.out.println("");
          System.out.println("Es recomendable dormir al menos 7 horas para tu                edad");
        }
        if (edad >=30 && seguimientoSueno.obtenerDuracionSueno() < 8) {
          System.out.println("");
          System.out.println("Es recomendable dormir al menos 8 horas para tu                edad");
        }
        if (tiempoDormir > 30) {
          System.out.println("");
          System.out.println("Es recomendable establecer una rutina para dormir a la misma hora cada noche");
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
        double porcentajeDormido = (double)                                              seguimientoSueno.obtenerDuracionSueno() / 8 * 100;
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
        
        seguimientoSueno.imprimirResumenSueno();
    }
}

class SeguimientoSueno {
    private Date horaInicio;
    private Date horaFin;
    private int calidadSueno;

    public void iniciarSeguimiento() {
        horaInicio = new Date();
    }

    public void detenerSeguimiento() {
        horaFin = new Date();
    }

    public void establecerCalidadSueno(int calidad) {
        calidadSueno = calidad;
    }

    public int obtenerDuracionSueno() {
        if (horaInicio != null && horaFin != null) {
            long diferencia = horaFin.getTime() - horaInicio.getTime();
            return (int) (diferencia / (1000 * 60 * 60));
        } else {
            return 0;
        }
    }

    public int obtenerCalidadSueno() {
        return calidadSueno;
    }

    public String calcularEtapaSueno() {
        return determinarEtapaSueno(horaInicio, horaFin, obtenerDuracionSueno());
    }

    public double calcularPorcentajeDormido() {
        return (double) obtenerDuracionSueno() / 8 * 100;
    }

    private static String determinarEtapaSueno(Date horaInicio, Date horaDespertar, int duracionSueno) {
        long tiempoSueno = horaDespertar.getTime() - horaInicio.getTime();
        int tiempoTranscurrido = (int) (tiempoSueno / (1000 * 60)); // en minutos
        int tiempoDespierto = tiempoTranscurrido - duracionSueno;
        int tiempoREM = duracionSueno / 4;
        int tiempoNREM = duracionSueno - tiempoREM;
        int tiempoN1 = tiempoNREM / 3;
        int tiempoN2 = tiempoNREM - tiempoN1;
        int tiempoN3 = tiempoN2 / 2;
        int tiempoN4 = tiempoNREM - tiempoN1 - tiempoN2 - tiempoN3;
        int tiempoDespiertoInicial = tiempoTranscurrido - duracionSueno - tiempoDespierto;

        if (tiempoDespierto < tiempoREM) {
            return "REM";
        } 
        else if (tiempoDespierto < tiempoN1 + tiempoREM) {
            return "Sueño ligero";
        } 
        else if (tiempoDespierto < tiempoN2 + tiempoN1 + tiempoREM) {
            return "sueño intermedio";
        } 
        else if (tiempoDespierto < tiempoN3 + tiempoN2 + tiempoN1 + tiempoREM) {
            return "Sueño profundo";
        } 
        else if (tiempoDespierto < tiempoN4 + tiempoN3 + tiempoN2 + tiempoN1 +           tiempoREM) {
            return "Sueño muy profundo";
        } 
        else if (tiempoDespierto < tiempoDespiertoInicial + tiempoDespierto) {
            return "Despierto";
        } 
        else {
            return "No se puede determinar la etapa del sueño.";
        }
    }

    public void imprimirResumenSueno() {
      System.out.println("");
      System.out.println("---------------RESULTADOS---------------");
      System.out.println("");
      System.out.println("Dormiste durante " + obtenerDuracionSueno() + " horas.");
      System.out.println("");
      System.out.println("Te despertaste durante la etapa de " +                         calcularEtapaSueno() );
      System.out.println("");
      System.out.println("La calidad de tu sueño fue calificada como " +                 calidadSueno + " de 5.");
    }
}