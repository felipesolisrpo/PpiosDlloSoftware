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
        
        // Crear un objeto de la clase Date para registrar la hora de inicio y de fin del seguimiento
        Date horaInicio = null;
        Date horaFin = null;
        button1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Obtener el nombre del usuario del campo de texto
        String nombre = textField.getText();
        
        // Mostrar un mensaje de confirmación
        JOptionPane.showMessageDialog(frame, "Hola " + nombre + ", estás list@ para comenzar el seguimiento? Presiona Enter para iniciar.");

        // Crear un objeto de la clase Date para registrar la hora de inicio del seguimiento
        //horaInicio = new Date();

        // Deshabilitar el botón "Comenzar seguimiento" y habilitar el botón "Detener seguimiento"
        button1.setEnabled(false);
        button2.setEnabled(true);
    }
});

// Agregar un escuchador de eventos al botón "Detener seguimiento"
button2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Obtener la hora de fin del seguimiento
        //horaFin = new Date();
        
        // Calcular la duración del seguimiento en minutos
        //long duracionSeguimiento = (horaFin.getTime() - horaInicio.getTime()) / (1000 * 60);
        
        // Obtener la calificación del sueño del usuario del campo de texto
        int calificacionSueno = Integer.parseInt(textField2.getText());
        
        // Obtener la edad del usuario del campo de texto
        int edad = Integer.parseInt(textField3.getText());
        
        // Obtener el tiempo que tarda el usuario en dormirse del campo de texto
        int tiempoDormir = Integer.parseInt(textField4.getText());
        
        // Obtener si el usuario realizó ejercicio antes de dormir del combobox
        boolean hizoEjercicio = comboBox.getSelectedItem().equals("si") ? true : false;
        
        // Obtener la cantidad de cafeína consumida por el usuario del campo de texto
        int cantidadCafeina = Integer.parseInt(textField5.getText());
        
        // Calcular las recomendaciones
        String recomendaciones = seguimientoSueno.generarRecomendaciones(calificacionSueno, edad, tiempoDormir, hizoEjercicio, cantidadCafeina);
        
        // Mostrar las recomendaciones en el textArea
        textArea.setText(recomendaciones);
        
        // Mostrar un mensaje de despedida
        //JOptionPane.showMessageDialog(frame, "Gracias por utilizar la aplicación de seguimiento del sueño. El seguimiento duró " + duracionSeguimiento + " minutos.");
        
        // Habilitar el botón "Comenzar seguimiento" y deshabilitar el botón "Detener seguimiento"
        button1.setEnabled(true);
        button2.setEnabled(false);
    }
});

    // Hacer visible el frame
    frame.setVisible(true);
}
}