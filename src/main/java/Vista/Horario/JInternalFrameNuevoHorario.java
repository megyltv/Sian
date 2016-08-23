/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Horario;


import Controlador.Periodo.ControladorCrudPeriodo;
import Entidades.Periodo;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;



/**
 *
 * @author Megan
 */
public class JInternalFrameNuevoHorario extends javax.swing.JInternalFrame {
    //Inicializacion de las variables 
    Periodo nuevoPeriodo= new Periodo();
    /**
     * Creates new form JInternalFrameNuevoRegistro
     */
    //Constructor
    public JInternalFrameNuevoHorario() {
        initComponents();
    }

    
    //Metodo para obtener los datos ingresados en la interfaz
    public void setDatosPeriodo() 
            {
                try {
            nuevoPeriodo.setPeriodo(txtPeriodo.getText().trim());
            nuevoPeriodo.setFechainicio(dateFechaInicioPeriodo.getDate());
            nuevoPeriodo.setFechafin(dateFechaFinPeriodo.getDate());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Verifique que los campos Nombre del periodo, Fecha de inicio y fin esten correctos");
        }
            }
    
    //Método para limpiar el formulario despues de que se guarda el periodo
     public void limpiar(){
        txtPeriodo.setText("");
        dateFechaFinPeriodo.setCalendar(null);
        dateFechaInicioPeriodo.setCalendar(null);
    }
    //Método para validar los datos ingresados
    public boolean validarDatosPeriodo()
    {
        boolean bandera=false; 
        if ((dateFechaInicioPeriodo.getDate()!=null)&&(dateFechaFinPeriodo.getDate()!=null)&&(dateFechaFinPeriodo.getDate().compareTo(dateFechaInicioPeriodo.getDate())==1)){
            bandera=true;
        }
        if(txtPeriodo.getText().equals(""))
        {
            bandera=false;
        }
        
        
        return bandera; 
    }
     
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPeriodo = new javax.swing.JTextField();
        lblFechaInicio = new javax.swing.JLabel();
        btnGuardarP = new javax.swing.JButton();
        jComboBoxDias = new javax.swing.JComboBox<>();
        lblImagPeq = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createCompoundBorder());
        setPreferredSize(new java.awt.Dimension(1168, 647));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1168, 620));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Nuevo Horario"));

        jLabel1.setText("Dia:");

        txtPeriodo.setName(""); // NOI18N

        lblFechaInicio.setText("Hora:");

        btnGuardarP.setLabel("Guardar");
        btnGuardarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPActionPerformed(evt);
            }
        });

        jComboBoxDias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes ", "Martes", "Miercoles", "Jueves ", "Viernes ", "Sábado ", "Domingo" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardarP)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblFechaInicio))
                        .addGap(104, 104, 104)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPeriodo, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(jComboBoxDias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)))
                .addContainerGap(297, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaInicio)
                    .addComponent(txtPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnGuardarP)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblImagPeq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logopeq.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(lblImagPeq))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(401, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblImagPeq)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(362, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Método para elboton guardar
    private void btnGuardarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPActionPerformed
        //Llamado al metodo para obtener los datos de la interfaz
        setDatosPeriodo();
        //instancio el controlador de los metodos crud
         ControladorCrudPeriodo controlador = new ControladorCrudPeriodo();
        try {
            //llamo al metodo crear del controlador crud
            if(validarDatosPeriodo())
            {
            controlador.crearPeriodo(nuevoPeriodo);  
            JOptionPane.showMessageDialog(null,"Periodo Creado");
            limpiar();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Verifique la información ingresada");
            }
        } catch (Exception ex) {
            Logger.getLogger(JInternalFrameNuevoHorario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarP;
    private javax.swing.JComboBox<String> jComboBoxDias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblImagPeq;
    private javax.swing.JTextField txtPeriodo;
    // End of variables declaration//GEN-END:variables
}
