/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Calificacion;

import Controlador.Calificacion.ControladorCrudInscripcion;
import Controlador.Materia.ControladorCrudMateria;
import Controlador.MateriaHorario.ControladorCrudMateriaHorario;
import Controlador.Periodo.ControladorCrudPeriodo;
import Entidades.Horario;
import Entidades.HorarioMateria;
import Entidades.Inscripcion;
import Entidades.Materia;
import Entidades.Periodo;
import Vista.Registro.*;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JInternalFrameIngresaCalificacion extends javax.swing.JInternalFrame {

    Periodo periodo = new Periodo();
    ControladorCrudPeriodo controladorPeriodo;
    
    Materia materia = new Materia();
    ControladorCrudMateria controladorMateria;
    
    Horario horario = new Horario();
    HorarioMateria horarioMateria;
    ControladorCrudMateriaHorario controladorHorarioMateria;
    
    List<Periodo> lstPeriodo;
    List<Materia> lstMateria;
    List<Horario> lstHorario;
    List<Inscripcion> lstInscripcion;
    
    //List<Inscripcion> lstInscripcion;
    ControladorCrudInscripcion controladorInscripcion;
    
    DefaultTableModel modelo;
    Object []calificacion = new Object[6];
    
    public JInternalFrameIngresaCalificacion() {
        initComponents();
        cargarDatosPeriodo();
        cargarDatosMateria();
        cargarDatosHorario();
        crearTabla();
    }
    
    public void crearTabla(){
        try{
            modelo = new DefaultTableModel();
            dgCalificacion.setModel(modelo);
            modelo.addColumn("Id");
            modelo.addColumn("Periodo");
            modelo.addColumn("MateriaHorario");
            modelo.addColumn("Observacion");
            modelo.addColumn("Alumno");
            modelo.addColumn("Nota");
            ocultarColumnas();
        }catch(Exception e){
            System.out.println("No se puede crear tabla");
        }   
    }
    
    public void ocultarColumnas(){
        for(int i=0; i<4;i++){
            dgCalificacion.getColumnModel().getColumn(i).setMaxWidth(0);
            dgCalificacion.getColumnModel().getColumn(i).setMinWidth(0);
            dgCalificacion.getColumnModel().getColumn(i).setPreferredWidth(0);
        }  
    }
    
    //Cargar datos de periodo en combobox
    public void cargarDatosPeriodo(){
        try{
            controladorPeriodo = new ControladorCrudPeriodo();
            lstPeriodo=controladorPeriodo.consultarListaPeriodos();
        
            for(Periodo p: lstPeriodo){
                cmbPeriodoBuscado.addItem(p.getPeriodo());
            }  
        }catch(Exception e){
            System.out.println(e);
        }    
    }
    
    //Cargar datos de materia en combobox
    public void cargarDatosMateria(){
        try{
            controladorMateria = new ControladorCrudMateria();
            lstMateria = controladorMateria.consultarListaMaterias();

            for(Materia m: lstMateria){
                cmbCursoBuscado.addItem(m.getMateria());
            }
        }catch(Exception e){
            System.out.println(e);
        }   
    }
    
    //Cargar datos de horario en combobox
    public void cargarDatosHorario(){
        try{
            controladorHorarioMateria = new ControladorCrudMateriaHorario();
            lstHorario = controladorHorarioMateria.consultarListaHorarios();

            for(Horario h : lstHorario){
                cmbHorarioBuscado.addItem(h.getDia()+" "+h.getHoraInicio()+ " "+ h.getHoraFin());
            }
        }catch(Exception e){
            System.out.println(e);
        } 
    }
    
    public void obtencionDatosCombos(){
        try{
            //Periodo
            periodo=controladorPeriodo.consultarPeriodoPorNombre(cmbPeriodoBuscado.getSelectedItem().toString());
            System.out.println(periodo.getPeriodo());

            //Materia
            materia=controladorMateria.consultarMateriaPorNombre(cmbCursoBuscado.getSelectedItem().toString());
            System.out.println(materia.getMateria());

            //Horario
            StringTokenizer hor=new StringTokenizer(cmbHorarioBuscado.getSelectedItem().toString());
            String dia=hor.nextElement().toString();
            String horaInicio=hor.nextElement().toString();
            String horaFin=hor.nextElement().toString();
            //horario=controladorHorarioMateria.consultarHorarioCompleto(dia, horaInicio, horaFin);
            System.out.println(horario.getDia());
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Seleccione lo solicitado");
        }    
    }
    
    public void mostrarDatos(){
        String nombreEstudiante;
        if(lstInscripcion.isEmpty()){
            JOptionPane.showMessageDialog(null, "No se encuentran registrados estudiantes");
        }else{
            crearTabla();
            for(Inscripcion i:lstInscripcion){
                calificacion[0]=i.getIdinscripcion();
                calificacion[1]=i.getIdperiodo();
                calificacion[2]=i.getIdmateriahorario();
                calificacion[3]=i.getObservacion();
                nombreEstudiante=i.getIdestudiante().getNombres()+" "+i.getIdestudiante().getApellidos();
                calificacion[4]=nombreEstudiante;
                if(i.getCalificacion().doubleValue()==0.0){
                    calificacion[5]="";
                } 
                modelo.addRow(calificacion);
            }
        }
    }
    
    public void obtencionDatosCalificacion(){
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        pnlCabecReporte = new javax.swing.JPanel();
        lblBuscar = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmbPeriodoBuscado = new javax.swing.JComboBox<>();
        cmbCursoBuscado = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbHorarioBuscado = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        dgCalificacion = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createCompoundBorder());
        setPreferredSize(new java.awt.Dimension(1168, 647));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1168, 620));

        pnlCabecReporte.setBackground(new java.awt.Color(255, 255, 255));
        pnlCabecReporte.setBorder(javax.swing.BorderFactory.createTitledBorder("Curso"));

        lblBuscar.setText("Periodo:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("Curso:");

        cmbPeriodoBuscado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        cmbPeriodoBuscado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbPeriodoBuscadoMouseClicked(evt);
            }
        });

        cmbCursoBuscado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));

        jLabel2.setText("Horario");

        cmbHorarioBuscado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));

        javax.swing.GroupLayout pnlCabecReporteLayout = new javax.swing.GroupLayout(pnlCabecReporte);
        pnlCabecReporte.setLayout(pnlCabecReporteLayout);
        pnlCabecReporteLayout.setHorizontalGroup(
            pnlCabecReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCabecReporteLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(pnlCabecReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBuscar)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(37, 37, 37)
                .addGroup(pnlCabecReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCabecReporteLayout.createSequentialGroup()
                        .addComponent(cmbCursoBuscado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(134, 134, 134))
                    .addGroup(pnlCabecReporteLayout.createSequentialGroup()
                        .addComponent(cmbPeriodoBuscado, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlCabecReporteLayout.createSequentialGroup()
                        .addComponent(cmbHorarioBuscado, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                        .addComponent(btnBuscar)
                        .addGap(45, 45, 45))))
        );
        pnlCabecReporteLayout.setVerticalGroup(
            pnlCabecReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCabecReporteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCabecReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscar)
                    .addComponent(cmbPeriodoBuscado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCabecReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbCursoBuscado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCabecReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbHorarioBuscado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dgCalificacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        dgCalificacion.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(dgCalificacion);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148)
                .addComponent(btnGuardar)
                .addGap(51, 51, 51))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(pnlCabecReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(pnlCabecReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
        );

        jPanel2.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        horarioMateria = new HorarioMateria();
        try{
            //Obtencion de datos a buscar
            obtencionDatosCombos();
            
            //Consultar idhorarioMateria
            controladorHorarioMateria = new ControladorCrudMateriaHorario();
            horarioMateria = controladorHorarioMateria.consultarHorarioMateria(materia, horario);
                    
            //Consultar Inscripcion
            controladorInscripcion=new ControladorCrudInscripcion();
            lstInscripcion=controladorInscripcion.consultarListaMaterias(periodo, horarioMateria);
            
            mostrarDatos();
            
        }catch(Exception e){
            Logger.getLogger(JInternalFrameIngresaCalificacion.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cmbPeriodoBuscadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbPeriodoBuscadoMouseClicked

    }//GEN-LAST:event_cmbPeriodoBuscadoMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try{
            for(Inscripcion i: lstInscripcion){
                
            }
        }catch(Exception e){
            Logger.getLogger(JInternalFrameIngresaCalificacion.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbCursoBuscado;
    private javax.swing.JComboBox<String> cmbHorarioBuscado;
    private javax.swing.JComboBox<String> cmbPeriodoBuscado;
    private javax.swing.JTable dgCalificacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JPanel pnlCabecReporte;
    // End of variables declaration//GEN-END:variables
}
