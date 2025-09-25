package PracticaClase;

import java.awt.*;
import java.time.LocalDate;
import javax.swing.*;

public class AltaAlumnoDialog extends JDialog {
    private JTextField nombreField;
    private JTextField notaField;
    private JTextField fechaField;
    private boolean confirmado = false;
    
    public AltaAlumnoDialog (Frame p){
        super (p , "Alta Alumno" , true);// true -> diálogo modal (bloquea el frame padre)
        
        //campos 
        nombreField = new JTextField(15);
        notaField = new JTextField(5);
        fechaField = new JTextField(10);
        
        JPanel panel = new JPanel (new GridLayout(0,2,5,5));
        panel.add(new JLabel("Nombre: "));
        panel.add(nombreField);
        panel.add(new JLabel("Nota: "));
        panel.add(notaField);
        panel.add(new JLabel("Fecha ingreso (yyyy-MM-dd): "));
        panel.add(fechaField);
        
        //botones 
        JButton aceptarBtn = new JButton ("Aceptar");
        JButton cancelarBtn = new JButton ("Cancelar");
         aceptarBtn.addActionListener(e -> {
            confirmado = true;
            dispose();
        });
        cancelarBtn.addActionListener(e -> dispose());

        JPanel botones = new JPanel();
        botones.add(aceptarBtn);
        botones.add(cancelarBtn);

        // Layout
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(botones, BorderLayout.SOUTH);

        pack();// ajusta el tamaño del diálogo automáticamente según su contenido
        setLocationRelativeTo(p);// centra el diálogo respecto al frame padre
    }

    public AltaAlumnoDialog(Frame p, String nombre,double nota , LocalDate fecha ) {
        super(p, "Alta Alumno", true);// true -> diálogo modal (bloquea el frame padre)

        //campos 
        nombreField = new JTextField(nombre);
        notaField = new JTextField(String.valueOf(nota));
        fechaField = new JTextField(String.valueOf(fecha));

        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        panel.add(new JLabel("Nombre: "));
        panel.add(nombreField);
        panel.add(new JLabel("Nota: "));
        panel.add(notaField);
        panel.add(new JLabel("Fecha ingreso (yyyy-MM-dd): "));
        panel.add(fechaField);

        //botones 
        JButton aceptarBtn = new JButton("Aceptar");
        JButton cancelarBtn = new JButton("Cancelar");
        aceptarBtn.addActionListener(e -> {
            confirmado = true;
            dispose();
        });
        cancelarBtn.addActionListener(e -> dispose());

        JPanel botones = new JPanel();
        botones.add(aceptarBtn);
        botones.add(cancelarBtn);

        // Layout
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(botones, BorderLayout.SOUTH);

        pack();// ajusta el tamaño del diálogo automáticamente según su contenido
        setLocationRelativeTo(p);// centra el diálogo respecto al frame padre
    }
    // Saber si se pulsó "Aceptar"
    public boolean isConfirmado() {
        return confirmado;
    }

    // Getters para obtener los valores
    public String getNombre() {
        return nombreField.getText().trim();
    }

    public double getNota() {
        return Double.parseDouble(notaField.getText().trim());
    }

    public LocalDate getFechaIngreso() {
        return LocalDate.parse(fechaField.getText().trim());
    }
        
    
}
