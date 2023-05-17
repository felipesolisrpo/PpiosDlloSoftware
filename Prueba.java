import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.util.Date;

public class Prueba {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SeguimientoSueno seguimientoSueno = new SeguimientoSueno();
        
    
        // Crear la interfaz
        JFrame frame = new JFrame("Seguimiento del sueño");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Crear los componentes
        JLabel label1 = new JLabel("Bienvenido a la aplicación de seguimiento del sueño");
        JLabel label2 = new JLabel("Hola! ¿Cuál es tu nombre?");
        JTextField textField = new JTextField(20);
        JButton button1 = new JButton("Comenzar seguimiento");
        JButton button2 = new JButton("Detener seguimiento");  
        button2.setEnabled(false);
        JLabel label3 = new JLabel("Ingresa una calificación para la calidad de tu sueño (de 1 a 10)");
        JTextField textField2 = new JTextField(5);
        JLabel label4 = new JLabel("¿Cuántos años tienes?");
        JTextField textField3 = new JTextField(5);
        JLabel label5 = new JLabel("¿Cuánto tiempo tardas en dormirte? (en minutos)");
        JTextField textField4 = new JTextField(5);
        JLabel label6 = new JLabel("¿Realizaste ejercicio antes de dormir? (si/no)");
        JComboBox<String> comboBox = new JComboBox<String>(new String[]{"si", "no"});
        JLabel label7 = new JLabel("¿Cuánta cafeína consumiste antes de dormir? (en miligramos)");
        JTextField textField5 = new JTextField(5);
        JLabel label8 = new JLabel("Recomendaciones");
        JTextArea textArea = new JTextArea(10, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        // Agregar los componentes al panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(label1);
        panel.add(label2);
        panel.add(textField);
        panel.add(button1);
        panel.add(button2);
        panel.add(label3);
        panel.add(textField2);
        panel.add(label4);
        panel.add(textField3);
        panel.add(label5);
        panel.add(textField4);
        panel.add(label6);
        panel.add(comboBox);
        panel.add(label7);
        panel.add(textField5);
        panel.add(label8);
        panel.add(scrollPane);
        
        // Agregar el panel al frame
        frame.add(panel);
        
        // Mostrar la interfaz
        frame.setVisible(true);
        
        button1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Obtener el nombre del usuario del campo de texto
        textArea.setText("");
        String nombre = textField.getText();
        // Verificar que el nombre no contenga números
        if (nombre.matches(".*\\d.*")) {
            JOptionPane.showMessageDialog(null, "Error: el nombre no debe contener números", "Error de entrada", JOptionPane.ERROR_MESSAGE);
            textField.setText("");
            button2.setEnabled(false); // Deshabilitar el botón "Detener seguimiento"
            return;
        }
        // Mostrar un mensaje de confirmación
        JOptionPane.showMessageDialog(frame, "Hola " + nombre + ", estás list@ para comenzar el seguimiento? Presiona Enter para iniciar.");

            // Habilitar el botón "Detener seguimiento"
            button2.setEnabled(true);
            
            // Deshabilitar el botón "Comenzar seguimiento"
            button1.setEnabled(false);
            
            // Obtener la hora de inicio del seguimiento
            Date horaInicio = new Date();
            
            // Mostrar mensaje de inicio del seguimiento
            textArea.append("Inicio del seguimiento: " + horaInicio + "\n");
            
            // Habilitar los campos para ingresar la información del sueño
            textField2.setEditable(true);
            textField3.setEditable(true);
            textField4.setEditable(true);
            comboBox.setEnabled(true);
            textField5.setEditable(true);
        }
    });
Date horaInicio = new Date();
// Agregar un escuchador de eventos al botón "Detener seguimiento"
button2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Obtener la hora de fin del seguimiento
        //Date horaFin = new Date();
    
        Date horaFin = new Date();
        // Calcular la duración del seguimiento en minutos
         long duracion = (horaFin.getTime() - horaInicio.getTime() ) / 60000;
        
        // Mostrar mensaje de fin del seguimiento y duración del mismo
        textArea.append("Fin del seguimiento: " + horaFin + "\n");
        textArea.append("Duración del seguimiento: " + duracion + " minutos \n");
        // Verificar el nombre
        String nombre = textField.getText();
        if (nombre.matches(".*\\d.*")) {
            JOptionPane.showMessageDialog(null, "Error: el nombre no debe contener números", "Error de entrada", JOptionPane.ERROR_MESSAGE);
            return; // no hacer los cálculos
        }
        
        // Verificar la calificación del sueño
        int calificacionSueno;
        try {
            calificacionSueno = Integer.parseInt(textField2.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error: la calificación del sueño debe ser un número entero", "Error de entrada", JOptionPane.ERROR_MESSAGE);
            return; // no hacer los cálculos
        }
        try {
            calificacionSueno = Integer.parseInt(textField2.getText());
            if(calificacionSueno<1 || calificacionSueno>10){
                JOptionPane.showMessageDialog(null,"Error: la calificacion del sueño debe estar entre 1 y 10", "Error de entrada",JOptionPane.ERROR_MESSAGE);
            return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error: la calificación del sueño debe ser un número entero", "Error de entrada", JOptionPane.ERROR_MESSAGE);
            return; // no hacer los cálculos
        }
        // Verificar la edad
        int edad;
        try {
            edad = Integer.parseInt(textField3.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error: la edad debe ser un número entero", "Error de entrada", JOptionPane.ERROR_MESSAGE);
            return; // no hacer los cálculos
        }
        
        // Verificar el tiempo que tarda el usuario en dormirse
        int tiempoDormir;
        try {
            tiempoDormir = Integer.parseInt(textField4.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error: el tiempo que tarda en dormirse debe ser un número entero", "Error de entrada", JOptionPane.ERROR_MESSAGE);
            return; // no hacer los cálculos
        }
        
        // Obtener si el usuario realizó ejercicio antes de dormir del combobox
        boolean hizoEjercicio = comboBox.getSelectedItem().equals("si");
        
        // Verificar la cantidad de cafeína consumida por el usuario
        int cantidadCafeina;
        try {
            cantidadCafeina = Integer.parseInt(textField5.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error: la cantidad de cafeína debe ser un número entero", "Error de entrada", JOptionPane.ERROR_MESSAGE);
            return; // no hacer los cálculos
        }
        
        // Calcular las recomendaciones
        String recomendaciones = seguimientoSueno.generarRecomendaciones(calificacionSueno, edad, tiempoDormir, hizoEjercicio, cantidadCafeina);
        
        // Mostrar las recomendaciones en el textArea
        textArea.setText("Inicio del seguimiento: " + horaInicio + "\n"+"\n"+"Fin del seguimiento: " + horaFin + "\n"+"\n"+"Duración del seguimiento: " + duracion + " minutos \n\n"+ "Recomendaciones: \n"+recomendaciones);

        
        // Habilitar el botón "Comenzar seguimiento" y deshabilitar el botón "Detener seguimiento"
        button1.setEnabled(true);
        button2.setEnabled(false);
    }
});

    // Hacer visible el frame
    frame.setVisible(true);
}
}