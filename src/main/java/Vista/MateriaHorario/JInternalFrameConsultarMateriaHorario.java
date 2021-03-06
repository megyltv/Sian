/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.MateriaHorario;

import Vista.Materia.*;
import Controlador.Materia.ControladorCrudMateria;
import Controlador.MateriaHorario.ControladorCrudMateriaHorario;
import Entidades.Horario;
import Entidades.HorarioMateria;
import Entidades.Materia;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JInternalFrameConsultarMateriaHorario extends javax.swing.JInternalFrame {

    Materia materiaConsulta=new Materia();
    Horario horarioCrear = new Horario();
    
    HorarioMateria horarioMateria = new HorarioMateria();
    List<HorarioMateria> lstHorarios;
    
    ControladorCrudMateria controladorMateria = new ControladorCrudMateria();
    ControladorCrudMateriaHorario controladorHorarioMateria = new ControladorCrudMateriaHorario();
    
    DefaultTableModel modelo;
    Object []horario = new Object[4];
  
    //Constructor
    public JInternalFrameConsultarMateriaHorario() {
        initComponents();
        habilitarDeshabilitar(false);
        btnGuardar.setEnabled(false);
        crearTabla();
    }
    
    public void crearTabla(){
        try{
            modelo = new DefaultTableModel();
            dgHorarios.setModel(modelo);
            modelo.addColumn("Id");
            modelo.addColumn("Día");
            modelo.addColumn("Hora de Inicio");
            modelo.addColumn("Hora de Finalización");  
            ocultarColumnas();
        }catch(Exception e){
            System.out.println("No se puede crear tabla");
        }   
    }
    
    public void ocultarColumnas(){
        dgHorarios.getColumnModel().getColumn(0).setMaxWidth(0);
        dgHorarios.getColumnModel().getColumn(0).setMinWidth(0);
        dgHorarios.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    //Mètodo para habilitar y deshabilitar cuadros de textos
    public void habilitarDeshabilitar (boolean estado){
        txtMateria.setEnabled(estado);
        txtHorario.setEnabled(estado);
        activo.setEnabled(estado);
        inactivo.setEnabled(estado);
    }
    
    //Método para llenar los campos de la interfaz con los datos obtenidos de la busqueda
    public void setDatosMateriaConsulta(){
        if(materiaConsulta.getMateria()!=null){
            txtMateria.setText(materiaConsulta.getMateria());

            crearTabla();
            for(HorarioMateria hm:lstHorarios){
                System.out.println(Integer.parseInt(hm.getIdhorario().toString().substring(29, 31).trim()));
                horarioCrear=controladorHorarioMateria.consultarHorario(Integer.parseInt(hm.getIdhorario().toString().substring(29, 31).trim()));
                               
                System.out.println("Entro4");
                System.out.println(hm.getIdhorario().toString()+" "+horarioCrear.getIdhorario());
                horario[0]=horarioCrear.getIdhorario();
                horario[1]=horarioCrear.getDia();
                horario[2]=horarioCrear.getHoraInicio();
                horario[3]=horarioCrear.getHoraFin();
                modelo.addRow(horario);
            }
        }else{
            txtMateria.setText("");
        }
    }
       
    //Método para obtener los datos actualizados de la interfaz
     public void setDatosHorarioMateriaActualizado (){
         try {
            horarioMateria.setIdhorario(horarioCrear);
            horarioMateria.setIdmateria(materiaConsulta);
            if(activo.isSelected()){
                horarioMateria.setEstado(1);
            }else if(inactivo.isSelected()){
                horarioMateria.setEstado(0);
            }
         }
         catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Verifique los datos Actualizados");
         }
     }
    
     public boolean validarDatos(){
        boolean bandera; 
        if(!txtMateria.getText().equals("") && !txtHorario.getText().equals("")){
            bandera=true;
        }else{
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblFechaInicio = new javax.swing.JLabel();
        txtMateria = new javax.swing.JTextField();
        txtHorario = new javax.swing.JTextField();
        lblFechaInicio1 = new javax.swing.JLabel();
        activo = new javax.swing.JRadioButton();
        inactivo = new javax.swing.JRadioButton();
        lblImagPeq = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtParamBusqMateria = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dgHorarios = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createCompoundBorder());
        setPreferredSize(new java.awt.Dimension(1168, 647));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1168, 620));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo Materia-Horario"));

        jLabel1.setText("Materia Escogida:");

        lblFechaInicio.setText("Horario Escogido:");

        txtMateria.setName(""); // NOI18N
        txtMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMateriaActionPerformed(evt);
            }
        });

        txtHorario.setName(""); // NOI18N

        lblFechaInicio1.setText("Estado:");

        buttonGroup1.add(activo);
        activo.setLabel("Activo");
        activo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activoActionPerformed(evt);
            }
        });

        buttonGroup1.add(inactivo);
        inactivo.setLabel("Inactivo");
        inactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inactivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(32, 32, 32)
                        .addComponent(txtMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(lblFechaInicio1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblFechaInicio)
                        .addGap(33, 33, 33)
                        .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(inactivo)
                        .addContainerGap(18, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(activo)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaInicio1)
                    .addComponent(activo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFechaInicio)
                        .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(inactivo))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        lblImagPeq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logopeq.jpg"))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Parámetro de Búsqueda"));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel3.setText("Ingrese el nombre de la Materia:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtParamBusqMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtParamBusqMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(56, 56, 56))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        btnActualizar.setLabel("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnGuardar.setLabel("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnActualizar)
                .addGap(43, 43, 43)
                .addComponent(btnGuardar)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        dgHorarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        dgHorarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dgHorariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dgHorarios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(lblImagPeq)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(416, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 151, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(228, 228, 228))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblImagPeq)))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(149, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleDescription("");

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
    //Mètodo consultar 
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try{
            materiaConsulta.setMateria(txtParamBusqMateria.getText().toUpperCase());
            materiaConsulta = controladorMateria.consultarMateriaPorNombre(txtParamBusqMateria.getText().toUpperCase());
            lstHorarios = controladorHorarioMateria.consultarListaHorariosPorMateria(materiaConsulta); 
            System.out.println(txtParamBusqMateria.getText());
                  
            if(materiaConsulta!=null){  
                if(!lstHorarios.isEmpty()){
                    System.out.println("Entro");
                    setDatosMateriaConsulta();
                   
                }else{
                    JOptionPane.showMessageDialog(null, "No se encuentra registrados horarios");
                }
            }
            txtParamBusqMateria.setText("");
            habilitarDeshabilitar(false);
            btnGuardar.setEnabled(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se encuentra registrada");
        }
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMateriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMateriaActionPerformed

    private void activoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_activoActionPerformed

    private void inactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inactivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inactivoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        habilitarDeshabilitar(true);
        btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try{
            //Llamada al metodo validar antes de que se guarden los datos
            if(validarDatos()){
                setDatosHorarioMateriaActualizado();
                controladorHorarioMateria.editarHorarioMateria(horarioMateria);
                JOptionPane.showMessageDialog(null,"Asignación actualizada");
                habilitarDeshabilitar(false);
                btnGuardar.setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(null,"Revise que se encuentren todos los datos");
            }

        }
        catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"No se puede actualizar \n"+e);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void dgHorariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dgHorariosMouseClicked
        int fila = dgHorarios.rowAtPoint(evt.getPoint());
        horarioCrear.setIdhorario(Integer.parseInt(dgHorarios.getValueAt(fila, 0).toString()));
        txtHorario.setText(dgHorarios.getValueAt(fila, 1).toString()+ ": "+dgHorarios.getValueAt(fila, 2).toString()
                            + " - "+dgHorarios.getValueAt(fila, 3).toString());
        
        horarioMateria=controladorHorarioMateria.consultarHorarioMateria(materiaConsulta, horarioCrear);
        if(horarioMateria.getEstado()==1){
            activo.setSelected(true);
        } else if(horarioMateria.getEstado()==0){
            inactivo.setSelected(true);
        }
    }//GEN-LAST:event_dgHorariosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton activo;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTable dgHorarios;
    private javax.swing.JRadioButton inactivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblFechaInicio1;
    private javax.swing.JLabel lblImagPeq;
    private javax.swing.JTextField txtHorario;
    private javax.swing.JTextField txtMateria;
    private javax.swing.JTextField txtParamBusqMateria;
    // End of variables declaration//GEN-END:variables
}
