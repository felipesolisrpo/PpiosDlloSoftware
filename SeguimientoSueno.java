import java.util.Date;

public class SeguimientoSueno {
   Date horaInicio;
     Date horaFin;
    private int calidadSueno;

    public void iniciarSeguimiento() {
        horaInicio = new Date();
        System.out.println("Iniciando seguimiento del sueño...");
        System.out.println("Hora de inicio: " + horaInicio.toString());
    }

    public void detenerSeguimiento() {
        horaFin = new Date();
        System.out.println("Deteniendo seguimiento del sueño...");
        System.out.println("Hora de fin: " + horaFin.toString());
    }

    public void establecerCalidadSueno(int calidad) {
        calidadSueno = calidad;
    }

    public int obtenerDuracionSueno() {
        long duracion = horaFin.getTime() - horaInicio.getTime();
        int duracionHoras = (int) (duracion / (60 * 60 * 1000));
        return duracionHoras;
    }
   public String generarRecomendaciones(int calificacionSueno, int edad, int tiempoDormir, boolean hizoEjercicio, int cantidadCafeina) {
    SeguimientoSueno seg1 = new SeguimientoSueno();
        String recomendaciones = "";
        int cafeina=cantidadCafeina;
    if (calificacionSueno < 3) {
        recomendaciones += "Debe buscar la ayuda de un profesional para mejorar su sueño.\n";
    } else if (calificacionSueno == 3) {
        recomendaciones += "Es recomendable que mejore la calidad de su sueño, trate de dormir más y en un lugar tranquilo.\n";
    } else {
        recomendaciones += "Ha tenido un buen sueño, pero puede mejorar su calidad durmiendo más horas en un ambiente tranquilo.\n";
    }
    if (edad > 60 && tiempoDormir < 7) {
        recomendaciones += "Siendo una persona mayor, se recomienda dormir al menos 7 horas diarias para mantener una buena salud.\n";
    }
    if (hizoEjercicio) {
        recomendaciones += "Ha hecho ejercicio antes de dormir, lo cual podria afectar en su ciclo de sueño, trate de hacerlo con algunas horas de antes de ir a dormir.\n";
    }else{
        recomendaciones+= "no ha hecho ejercicio antes de dormir lo cual es bueno para evitar una alteracion del ciclo, sin embargo debe mantener una rutina de ejercicio ya que es benificiosa para su salud \n";
    }
    if (cantidadCafeina > 3) {
        recomendaciones += "Ha consumido demasiada cafeína, lo que puede afectar su sueño. Trate de limitar su consumo de cafeína.\n";
    }
    if (edad < 18 && seg1.obtenerDuracionSueno() < 9) {
        recomendaciones +="es recomendable dormir al menos 9 horas para tu edad. \n";
        }
        if (tiempoDormir > 30) {
            recomendaciones += "Es recomendable establecer una rutina para dormir a la misma hora cada noche. \n";
        }

          if (cafeina > 200) {
            recomendaciones +="Es recomendable no consumir cafeína antes de dormir. \n";
        }
    
    return recomendaciones;
}
    public void imprimirResumenSueno() {
        System.out.println("");
        System.out.println("---------------RESUMEN DEL SUEÑO---------------");
        System.out.println("Duración del sueño: " + obtenerDuracionSueno() + " horas");
        System.out.println("Calidad del sueño (de 1 a 5): " + calidadSueno);
    }
}
