package PracticaClase;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class AlumnosFrame extends javax.swing.JFrame {
    private ArrayList <Alumno> lista = new ArrayList <>();
    private Alumno alumnoG;
    private String nombreFichero = "pera.txt";
    private DefaultTableModel dtm ;
    private JDAlumno jda = null;
    //constructor
    public AlumnosFrame() {
        initComponents();
        dtm = (DefaultTableModel) alumnosTable.getModel();
        setTitle("Ejercicio de ficheros objetos serializables ");
        
        File fichero = new File(nombreFichero);
        if (fichero.exists()) {
            cargarArrayList(fichero);  // carga lo que hay en el fichero
        } else {
            cargaInicial();             // carga datos iniciales si no hay fichero
        }
        cargarTabla(lista);
        
        //guarda automaticamente al cerrar
        addWindowListener (new java.awt.event.WindowAdapter(){
            @Override
            public void windowClosing(java.awt.event.WindowEvent e){
                guardarArraylist(new File (nombreFichero));
                System.exit(0);
            }
        });
    }
    
    //metodo cargarArrayList
    private void cargarArrayList (File f1){
        try (FileInputStream fis = new FileInputStream(f1); ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList) {
                lista = (ArrayList<Alumno>) obj;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado, se creará uno nuevo al guardar.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        /*FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream(f1);
            ois = new ObjectInputStream  (fis);
            lista.clear();
            Object al;
            while ((al = ois.readObject()) != null) {
                if (al instanceof Alumno){
                    lista.add((Alumno) al);
                }
            }
        }catch(FileNotFoundException e ){
            e.printStackTrace();
        }catch(IOException a ){
            a.printStackTrace();
        } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
        }finally{
            try{
                ois.close();
                fis.close();
                
            }catch(IOException e ){
                e.printStackTrace();
            }
        }*/
    }
    //metodo para cargar en la tabla 
    private void cargarTabla(ArrayList <Alumno> listaLeer){
        if (dtm.getRowCount()== 0){
            for (Alumno al : listaLeer) {
            dtm.addRow(new Object[]{((Alumno) al).getExp(), ((Alumno) al).getNombre(), ((Alumno) al).getNota(), ((Alumno) al).getIngreso()});
            }
        }else{
            dtm.setRowCount(0);
            for (Alumno al : listaLeer) {
                dtm.addRow(new Object[]{((Alumno) al).getExp(), ((Alumno) al).getNombre(), ((Alumno) al).getNota(), ((Alumno) al).getIngreso()});
            }
        }
    }
    //metodo guardarArraylist
    private void guardarArraylist (File f1){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream(f1);
            oos = new ObjectOutputStream  (fos);
            /*for (Alumno ao : lista ){
                oos.writeObject(ao);
            }*/
            oos.writeObject(lista);//de esta forma nosotros vamos a añadir un solo objeto 
        }catch(FileNotFoundException e ){
            e.printStackTrace();
        }catch(IOException a ){
            a.printStackTrace();
        }finally{
            try{
                fos.close();
                oos.close();
            }catch(IOException e ){
                e.printStackTrace();
            }
        }
        
    }
    private void cargaInicial(){
        lista.add(new Alumno(1, "Carlos", 8.5, LocalDate.of(2022, Month.MARCH, 10)));
        lista.add(new Alumno(2, "Paco", 7.75, LocalDate.now()));
        lista.add(new Alumno(3, "Pablo", 6.75, LocalDate.of(2023, 12, 24)));
        lista.add(new Alumno(4, "Eric", 8, LocalDate.of(2024, 2, 12)));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        alumnosTable = new javax.swing.JTable();
        altaBt = new javax.swing.JButton();
        bajaBt = new javax.swing.JButton();
        modificatBt = new javax.swing.JButton();
        guardarFBt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        alumnosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Expediente", "Nombre", "Nota", "FechaIngreso "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        alumnosTable.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(alumnosTable);
        alumnosTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        altaBt.setText("alta");
        altaBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaBtActionPerformed(evt);
            }
        });

        bajaBt.setText("baja");
        bajaBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajaBtActionPerformed(evt);
            }
        });

        modificatBt.setText("modificar");
        modificatBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificatBtActionPerformed(evt);
            }
        });

        guardarFBt.setText("guardarFichero");
        guardarFBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarFBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(altaBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bajaBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modificatBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(guardarFBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(312, 312, 312))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(altaBt)
                        .addGap(36, 36, 36)
                        .addComponent(bajaBt)
                        .addGap(26, 26, 26)
                        .addComponent(modificatBt)
                        .addGap(33, 33, 33)
                        .addComponent(guardarFBt)))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /*
        el boton alta va a dar de alta a una nueva persona e insertar el nuevo registro en la tabla 
    */
    private void altaBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaBtActionPerformed
        jda = new JDAlumno(this,"Alta",alumnoG);
        jda.setVisible(true);
        if (jda.isConfirmado()) {
            try {
                //introducimos datos del nuevo alumno
                /*
                lista.isEmpty() ? 1 : --> esto es como un if else ya que pregunta si esta vacio le va a poner 1 porque si no empezaria con -1
                y nos saltaria la exception IndexOutOfBounds ya que nos estamos saliendo del rango de nuestro ArrayList 
                */
                int exp =lista.isEmpty() ? 1 : lista.get(lista.size()-1).getExp() + 1; 
                String nombre = jda.getNombre();
                double nota = jda.getNota();
                LocalDate fechaIngreso = jda.getFechaIngreso();
                Alumno nuevo = new Alumno(exp, nombre, nota, fechaIngreso);
                //añadimos a la lista 
                lista.add(nuevo);
                //añadimos en la tabla de nuestro proyecto
                dtm.addRow(new Object[]{exp, nombre, nota, fechaIngreso});
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al introducir los datos: ");
            }
        }
        
    }//GEN-LAST:event_altaBtActionPerformed
    /*
        vamos a realizar el boton dar de baja , en el que vamos a seleccionar en nuestra tabla 
        y cuando le de al boton eliminar se eliminara el alumno de la tabla 
    */
    private void bajaBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajaBtActionPerformed
        int fila = alumnosTable.getSelectedRow();
        if (fila != -1){
            Object alumnoEliminado = dtm.getValueAt(fila, 0); // esto nos da el dato pero en objeto 
            System.out.println((int)alumnoEliminado);
            lista.removeIf( alumno -> alumno.getExp() == (int) alumnoEliminado);
           
            for(Alumno a : lista ){
                System.out.println(a);
            }
            dtm.removeRow(fila);
            JOptionPane.showMessageDialog(null,"Se ha eliminado correctamente ");
        }else{
            JOptionPane.showMessageDialog(null,"No se ha seleccionado ninguna fila de la tabla ");
        }
    }//GEN-LAST:event_bajaBtActionPerformed
    /*
        vamos a comprobar que tenga un alumno seleccionado en nuestra tabla y despues vamos a preguntar que datos quiere 
        modificar de la fila seleccionada 
    */
    private void modificatBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificatBtActionPerformed
        int fila = alumnosTable.getSelectedRow();
        if (fila != -1) {
            Alumno alumnoGuardar = new Alumno ((int)dtm.getValueAt(fila, 0),(String)dtm.getValueAt(fila, 1),(double)dtm.getValueAt(fila, 2),(LocalDate)dtm.getValueAt(fila, 3));
            JDAlumno dialog = new JDAlumno(this, alumnoGuardar.getNombre(),alumnoGuardar.getNota(),alumnoGuardar.getIngreso());
            dialog.setVisible(true);
            if (dialog.isConfirmado()) {
                try {
                    int exp = (int)dtm.getValueAt(fila, 0);
                    String nombre = dialog.getNombre();
                    double nota = dialog.getNota();
                    LocalDate fechaIngreso = dialog.getFechaIngreso();

                    Alumno alumnoModificado = new Alumno(exp, nombre, nota, fechaIngreso);

                    lista.set(fila , alumnoModificado);
                    cargarTabla(lista);
                    JOptionPane.showMessageDialog(this, "Alumno modificado correctamente .");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al intentar modificar el alumno  ");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila de la tabla ");
        }
    }//GEN-LAST:event_modificatBtActionPerformed
    private void guardarFBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarFBtActionPerformed
        int guardarFichero = JOptionPane.showConfirmDialog(null, "¿Deseas guardar los datos ?" );
        if (guardarFichero == JOptionPane.YES_OPTION){
            guardarArraylist(new File (nombreFichero));
        }else{
            JOptionPane.showMessageDialog(null, "No se han guardado los cambios ");
        }
    }//GEN-LAST:event_guardarFBtActionPerformed
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlumnosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlumnosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlumnosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlumnosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlumnosFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton altaBt;
    private javax.swing.JTable alumnosTable;
    private javax.swing.JButton bajaBt;
    private javax.swing.JButton guardarFBt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificatBt;
    // End of variables declaration//GEN-END:variables
}
