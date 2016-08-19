/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Registro;

import Controlador.Registro.ControladorRegistroPreguntas;
import Controlador.Registro.ControladorRegistroUsuario;
import Entidades.Estudiante;
import Entidades.Preguntas;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import soporte.botonListener;
import soporte.metodosSoporte;

public class JInternalFrameConsultaRegistro extends javax.swing.JInternalFrame {

    Estudiante consulta_estudiante, actualizar_estudiante;
    Preguntas pregunta_estudiante, actualizar_pregunta; 
    metodosSoporte soporte;
    
    boolean estado;
    int cedula,idEstudiante;
    ControladorRegistroUsuario controlador;
    ControladorRegistroPreguntas controladorPreguntas;
    botonListener list;
    
    public JInternalFrameConsultaRegistro() {
        initComponents();
        soporte=new metodosSoporte();
        Habilitar(false);
        txtCedula.setEnabled(true);
        
        list = new botonListener();

        botones();
    }
    
    public void botones(){
        list.Listener(ButtonSi1, txtRazon1, true);
        list.Listener(ButtonNo1, txtRazon1, false);
        list.Listener(ButtonSi2, txtRazon2, true);
        list.Listener(ButtonNo2, txtRazon2, false);
        list.Listener(ButtonSi3, txtRazon31, true);
        list.Listener(ButtonSi3, txtRazon32, true);
        list.Listener(ButtonNo3, txtRazon31, false);
        list.Listener(ButtonNo3, txtRazon32, false);
        list.Listener(ButtonSi4, txtRazon4, true);
        list.Listener(ButtonNo4, txtRazon4, false);
        list.Listener(ButtonSi5, txtRazon5, true);
        list.Listener(ButtonNo5, txtRazon5, false);
        list.Listener(ButtonSi6, txtRazon6, false);
        list.Listener(ButtonNo6, txtRazon6, true);
        list.Listener(ButtonSi7, txtRazon7, false);
        list.Listener(ButtonNo7, txtRazon7, true);
    }

    public void limpiar(){
        txtApellido.setText("");
        txtCedula.setText("");
        txtCelular.setText("");
        txtConyuge.setText("");
        txtCorreo.setText("");
        txtNombre.setText("");
        txtNombreE.setText("");
        txtProfesion.setText("");
        txtRazon1.setText("");
        txtRazon2.setText("");
        txtRazon31.setText("");
        txtRazon32.setText("");
        txtRazon4.setText("");
        txtRazon5.setText("");
        txtRazon6.setText("");
        txtRazon7.setText("");
        txtSector.setText("");
        txtTelefono.setText("");
        txtTelfE.setText("");
        txthijos.setText("");
        jDateChooser1.setCalendar(null);
        limpiarOpciones();
    }
    
    public void limpiarOpciones(){
        ComboBoxCivil.setSelectedIndex(0);
        ComboBoxInstruccion.setSelectedItem(0);
        RadioButtonSi.setSelected(false);
        RadioButtonNo.setSelected(false);
        ButtonNo1.setSelected(false);
        ButtonNo2.setSelected(false);
        ButtonNo3.setSelected(false);
        ButtonNo4.setSelected(false);
        ButtonNo5.setSelected(false);
        ButtonNo6.setSelected(false);
        ButtonNo7.setSelected(false);
        ButtonSi1.setSelected(false);
        ButtonSi2.setSelected(false);
        ButtonSi3.setSelected(false);
        ButtonSi4.setSelected(false);
        ButtonSi5.setSelected(false);
        ButtonSi6.setSelected(false);
        ButtonSi7.setSelected(false);    
    }
    
    public void Habilitar(boolean estado){
        txtApellido.setEnabled(estado);
        txtCedula.setEnabled(estado);
        txtCelular.setEnabled(estado);
        txtConyuge.setEnabled(estado);
        txtCorreo.setEnabled(estado);
        txtNombre.setEnabled(estado);
        txtNombreE.setEnabled(estado);
        txtProfesion.setEnabled(estado);
        txtRazon1.setEnabled(estado);
        txtRazon2.setEnabled(estado);
        txtRazon31.setEnabled(estado);
        txtRazon32.setEnabled(estado);
        txtRazon4.setEnabled(estado);
        txtRazon5.setEnabled(estado);
        txtRazon6.setEnabled(estado);
        txtRazon7.setEnabled(estado);
        txtSector.setEnabled(estado);
        txtTelefono.setEnabled(estado);
        txtTelfE.setEnabled(estado);
        txthijos.setEnabled(estado);
        jDateChooser1.setEnabled(estado);
    }
    
    public void setConsultaEstudiante(){
        if(consulta_estudiante.getNombres()!=null){
            txtNombre.setText(consulta_estudiante.getNombres());
        }else{
            txtNombre.setText("");
        }
        if(consulta_estudiante.getNombres()!=null){
            txtApellido.setText(consulta_estudiante.getApellidos()); 
        }else{
            txtApellido.setText("");
        }
        if(consulta_estudiante.getProfesion()!=null){
            txtProfesion.setText(consulta_estudiante.getProfesion());
        }else{
            txtProfesion.setText("");
        }
        if(consulta_estudiante.getNombcony()!=null){
            txtConyuge.setText(consulta_estudiante.getNombcony());
        }else{
            txtConyuge.setText("");
        }
        if(consulta_estudiante.getCorreo()!=null){
            txtCorreo.setText(consulta_estudiante.getCorreo());
        }else{
            txtCorreo.setText("");
        }
        if(consulta_estudiante.getCorreo()!=null){
            txtNombreE.setText(consulta_estudiante.getNombemerg());
        }else{
            txtNombreE.setText("");
        }
        if(consulta_estudiante.getCorreo()!=null){
            txtSector.setText(consulta_estudiante.getSector());
        }else{
            txtSector.setText("");
        }
        
        //Comprobar que no sea null 
        if(consulta_estudiante.getTelefono()!=0){
            txtTelefono.setText(consulta_estudiante.getTelefono().toString());
            System.out.println(consulta_estudiante.getTelefono().toString());
        }else if(consulta_estudiante.getTelefono().toString().equals("0")) {
            txtTelefono.setText("");
        }
        if(consulta_estudiante.getTelfemerg()!=0){
            txtTelfE.setText(consulta_estudiante.getTelfemerg().toString());
        }else{
            txtTelfE.setText("");
        }
        if(consulta_estudiante.getHijos()!=0){
            txthijos.setText(consulta_estudiante.getHijos().toString());
        }else{
            txthijos.setText("");
        }
        if(consulta_estudiante.getCelular()!=0){
            txtCelular.setText(consulta_estudiante.getCelular().toString());
        }else{
            txtCelular.setText(""); 
        }
        
        jDateChooser1.setDate(consulta_estudiante.getFechanac());
        ComboBoxCivil.setSelectedItem(consulta_estudiante.getEstadocivil());
        ComboBoxInstruccion.setSelectedItem(consulta_estudiante.getNivelinst());  
        try {
            if(consulta_estudiante.getCreycony()==1){RadioButtonSi.setSelected(true);} 
            else if(consulta_estudiante.getCreycony()==0){RadioButtonSi.setSelected(true);}
            else if(consulta_estudiante.getCreycony()==2){RadioButtonSi.setSelected(false);}
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void setPreguntasEstudiante(){
        if(pregunta_estudiante.getOpcion1()==1){
            ButtonSi1.setSelected(true);
        }else if(pregunta_estudiante.getOpcion1()==0){
            ButtonNo1.setSelected(true);
        }
        if(pregunta_estudiante.getOpcion2()==1){
            ButtonSi2.setSelected(true);
        }else if(pregunta_estudiante.getOpcion2()==0){
            ButtonNo2.setSelected(true);
        }
        if(pregunta_estudiante.getOpcion3()==1){
            ButtonSi3.setSelected(true);
        }else if(pregunta_estudiante.getOpcion3()==0){
            ButtonNo3.setSelected(true);
        }
        if(pregunta_estudiante.getOpcion4()==1){
            ButtonSi4.setSelected(true);
        }else if(pregunta_estudiante.getOpcion4()==0){
            ButtonNo4.setSelected(true);
        }
        if(pregunta_estudiante.getOpcion5()==1){
            ButtonSi5.setSelected(true);
        }else if(pregunta_estudiante.getOpcion5()==0){
            ButtonNo5.setSelected(true);
        }
        if(pregunta_estudiante.getOpcion6()==1){
            ButtonSi6.setSelected(true);
        }else if(pregunta_estudiante.getOpcion6()==0){
            ButtonNo6.setSelected(true);
        }
        if(pregunta_estudiante.getOpcion7()==1){
            ButtonSi7.setSelected(true);
        }else if(pregunta_estudiante.getOpcion7()==0){
            ButtonNo7.setSelected(true);
        }
    }   
    //Obtencion de datos de actualizar
    public void editEstudiante(){
        actualizar_estudiante.setIdestudiante(consulta_estudiante.getIdestudiante());
        try {
            actualizar_estudiante.setCedula(Integer.parseInt(txtCedula.getText().trim()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingresar Cédula");
        }
        
        if(txtNombre.getText()!=""){
            actualizar_estudiante.setNombres((txtNombre.getText()));
        }else{
            actualizar_estudiante.setNombres(" ");
        }
        if(txtApellido.getText()!=""){
            actualizar_estudiante.setApellidos((txtApellido.getText()));
        }else{
            actualizar_estudiante.setApellidos(" ");
        }
        actualizar_estudiante.setFechanac((jDateChooser1.getDate()));
        
        if(txtTelefono.getText().isEmpty()){
            actualizar_estudiante.setTelefono(0);
        }else{
            actualizar_estudiante.setTelefono(Integer.parseInt(txtTelefono.getText().trim())); 
        }
        if(txtCelular.getText().isEmpty()){
            actualizar_estudiante.setCelular(0);
        }else{
            actualizar_estudiante.setCelular(Integer.parseInt(txtCelular.getText().trim()));
        }
        
        if(txtCorreo.getText()!=""){
            actualizar_estudiante.setCorreo((txtCorreo.getText().trim()));
        }else{
            actualizar_estudiante.setCorreo(" ");
        }

        actualizar_estudiante.setNivelinst(((String)ComboBoxInstruccion.getSelectedItem()));
        if(txtProfesion.getText()!=""){
            actualizar_estudiante.setProfesion((txtProfesion.getText()));
        }else{
            actualizar_estudiante.setProfesion(" ");
        }
        if(txtSector.getText()!=""){
            actualizar_estudiante.setSector((txtSector.getText()));
        }else{
            actualizar_estudiante.setSector(" ");
        }
        
        actualizar_estudiante.setEstadocivil((String)ComboBoxCivil.getSelectedItem());
        if(txtConyuge.getText()!=""){
            actualizar_estudiante.setNombcony((txtConyuge.getText()));
        }else{
            actualizar_estudiante.setNombcony(" ");
        }
        // Si == 1, No == 0, Ninguno=2 
        if (RadioButtonSi.isSelected()){ actualizar_estudiante.setCreycony(1); }
        else if (RadioButtonNo.isSelected()){ actualizar_estudiante.setCreycony(0); }
        else{ actualizar_estudiante.setCreycony(2); }
        
        if(txthijos.getText().isEmpty()){ actualizar_estudiante.setHijos(0); }
        else{ actualizar_estudiante.setHijos(Integer.parseInt(txthijos.getText())); }
        
        if(txtNombreE.getText()!=""){ actualizar_estudiante.setNombemerg((txtNombreE.getText())); }
        else{ actualizar_estudiante.setNombemerg(" "); }
        
        if(txtTelfE.getText().isEmpty()){ actualizar_estudiante.setTelfemerg(0); }
        else{ actualizar_estudiante.setTelfemerg((Integer.parseInt(txtTelfE.getText()))); }
    }
    
    public void editPreguntas(){
        actualizar_pregunta.setIdestudiante(actualizar_estudiante);
        actualizar_pregunta.setIdpreguntas(pregunta_estudiante.getIdpreguntas());
        
        if (ButtonSi1.isSelected()){ actualizar_pregunta.setOpcion1(1);} else if (ButtonNo1.isSelected()) { actualizar_pregunta.setOpcion1(0);} else {actualizar_pregunta.setOpcion1(0);}
        if(txtRazon1.getText()!=""){
            actualizar_pregunta.setRespuesta1(txtRazon1.getText());
        }else{
            actualizar_pregunta.setRespuesta1("");
        }
             
        if (ButtonSi2.isSelected()){ actualizar_pregunta.setOpcion2(1); txtRazon2.setEnabled(true);} else if (ButtonNo2.isSelected()) { actualizar_pregunta.setOpcion2(0);} else {actualizar_pregunta.setOpcion2(0);}
        if(txtRazon1.getText()!=""){
            actualizar_pregunta.setRespuesta2(txtRazon2.getText());
        }else{
            actualizar_pregunta.setRespuesta2("");
        }
               
        if (ButtonSi3.isSelected()){ actualizar_pregunta.setOpcion3(1); txtRazon31.setEnabled(true);txtRazon32.setEnabled(true);} else if (ButtonNo3.isSelected()){actualizar_pregunta.setOpcion3(0);
        }else {actualizar_pregunta.setOpcion3(0);}
        if(txtRazon31.getText()!=""){
            actualizar_pregunta.setRespuesta31(txtRazon31.getText());
        }else{
            actualizar_pregunta.setRespuesta31("");
        }
        if(txtRazon32.getText()!=""){
            actualizar_pregunta.setRespuesta32(txtRazon32.getText());
        }else{
            actualizar_pregunta.setRespuesta32("");
        }
        
        if (ButtonSi4.isSelected()){ actualizar_pregunta.setOpcion4(1); txtRazon4.setEnabled(true);} else if (ButtonNo4.isSelected()) { actualizar_pregunta.setOpcion4(0); }else {actualizar_pregunta.setOpcion4(0);}
        if(txtRazon4.getText()!=""){
            actualizar_pregunta.setRespuesta4(txtRazon4.getText());
        }else{
            actualizar_pregunta.setRespuesta4("");
        }

        if (ButtonSi5.isSelected()){ actualizar_pregunta.setOpcion5(1); txtRazon5.setEnabled(true);} else if (ButtonNo5.isSelected()) { actualizar_pregunta.setOpcion5(0); } else {actualizar_pregunta.setOpcion5(0);}
        if(txtRazon5.getText()!=""){
            actualizar_pregunta.setRespuesta5(txtRazon5.getText());
        }else{
            actualizar_pregunta.setRespuesta5("");
        }    

        if (ButtonSi6.isSelected()){ actualizar_pregunta.setOpcion6(1); } else if (ButtonNo6.isSelected()) { actualizar_pregunta.setOpcion6(0); txtRazon6.setEnabled(false);} else {actualizar_pregunta.setOpcion6(0);}
        if(txtRazon6.getText()!=""){
            actualizar_pregunta.setRespuesta6(txtRazon6.getText());
        }else{
            actualizar_pregunta.setRespuesta6("");
        } 
        
        if (ButtonSi7.isSelected()){ actualizar_pregunta.setOpcion7(1); } else if (ButtonNo7.isSelected()) { actualizar_pregunta.setOpcion7(0); txtRazon7.setEnabled(false);} else {actualizar_pregunta.setOpcion7(0);}
        if(txtRazon7.getText()!=""){
            actualizar_pregunta.setRespuesta7(txtRazon7.getText());
        }else{
            actualizar_pregunta.setRespuesta7("");
        }
    }
    
    public boolean validarDatos(){
        return sinCamposVacios()
                && soporte.validacionCedula(txtCedula.getText().trim());
    }
    
    public boolean sinCamposVacios(){
        return cedulaLlena() && nombreLleno() && apellidoLleno();
    }
    
    private boolean cedulaLlena(){
        if(txtCedula.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Ingrese cedula del estudiante");
            return false;
        }
        else{
            return true;
        }  
    }
    
    private boolean nombreLleno(){
        if(txtNombre.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Ingrese nombre del estudiante");
            return false;
        }
        else{
            return true;
        }  
    }
    
    private boolean apellidoLleno(){
        if(txtApellido.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Ingrese apellido del estudiante");
            return false;
        }
        else{
            return true;
        }  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        pnlEclesiast = new javax.swing.JPanel();
        lbl1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ButtonNo1 = new javax.swing.JRadioButton();
        ButtonSi1 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txtRazon1 = new javax.swing.JTextField();
        ButtonSi2 = new javax.swing.JRadioButton();
        ButtonNo2 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        txtRazon2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ButtonSi3 = new javax.swing.JRadioButton();
        ButtonNo3 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txtRazon31 = new javax.swing.JTextField();
        txtRazon32 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ButtonSi4 = new javax.swing.JRadioButton();
        ButtonNo4 = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        txtRazon4 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ButtonSi5 = new javax.swing.JRadioButton();
        ButtonNo5 = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        txtRazon5 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        ButtonSi6 = new javax.swing.JRadioButton();
        ButtonNo6 = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        txtRazon6 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        ButtonSi7 = new javax.swing.JRadioButton();
        ButtonNo7 = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        txtRazon7 = new javax.swing.JTextField();
        btnNueva = new javax.swing.JButton();
        pnlPersonal = new javax.swing.JPanel();
        lblEstado = new javax.swing.JLabel();
        RadioButtonNo = new javax.swing.JRadioButton();
        lblConyuge = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblCreyente = new javax.swing.JLabel();
        lblHijos = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        btnActualizar = new javax.swing.JButton();
        lblEmergencia = new javax.swing.JLabel();
        lblNombreE = new javax.swing.JLabel();
        lblTelefE = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        lblCedula = new javax.swing.JLabel();
        txtProfesion = new javax.swing.JTextField();
        lblNombres = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        txtSector = new javax.swing.JTextField();
        txtConyuge = new javax.swing.JTextField();
        lblNacimiento = new javax.swing.JLabel();
        txthijos = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtNombreE = new javax.swing.JTextField();
        lblCelular = new javax.swing.JLabel();
        txtTelfE = new javax.swing.JTextField();
        lblInstruccion = new javax.swing.JLabel();
        ComboBoxInstruccion = new javax.swing.JComboBox<>();
        lblProfesion = new javax.swing.JLabel();
        ComboBoxCivil = new javax.swing.JComboBox<>();
        lblSector = new javax.swing.JLabel();
        RadioButtonSi = new javax.swing.JRadioButton();
        btnConsultar = new javax.swing.JButton();
        btnGuardar2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1168, 647));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1168, 620));

        pnlEclesiast.setBackground(new java.awt.Color(255, 255, 255));
        pnlEclesiast.setBorder(javax.swing.BorderFactory.createTitledBorder("Información Eclesiástica"));
        pnlEclesiast.setPreferredSize(new java.awt.Dimension(580, 628));

        lbl1.setText("1. ¿Ha recibido a Jesús en su corazón como Salvador personal?");

        jLabel1.setText("2. Antes de esta iglesia, ¿asistías a alguna otra?");

        ButtonNo1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(ButtonNo1);
        ButtonNo1.setText("No");

        ButtonSi1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(ButtonSi1);
        ButtonSi1.setText("Si");

        jLabel2.setText("Fecha");

        txtRazon1.setEnabled(false);

        ButtonSi2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(ButtonSi2);
        ButtonSi2.setText("Si");

        ButtonNo2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(ButtonNo2);
        ButtonNo2.setText("No");

        jLabel3.setText("¿A cual?");

        txtRazon2.setEnabled(false);

        jLabel4.setText("3. ¿Ha sido bautizado en una Iglesia Cristiana Evangélica?");

        ButtonSi3.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup3.add(ButtonSi3);
        ButtonSi3.setText("Si");

        ButtonNo3.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup3.add(ButtonNo3);
        ButtonNo3.setText("No");

        jLabel5.setText("¿Cuándo?");

        txtRazon31.setEnabled(false);

        txtRazon32.setEnabled(false);

        jLabel7.setText("¿Dónde?");

        jLabel8.setText("4. ¿Asiste a un discipulado?");

        ButtonSi4.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup4.add(ButtonSi4);
        ButtonSi4.setText("Si");

        ButtonNo4.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup4.add(ButtonNo4);
        ButtonNo4.setText("No");

        jLabel9.setText("¿Cuál es su discipulador?");

        txtRazon4.setEnabled(false);

        jLabel10.setText("5. ¿Estás sirviendo en un ministerio de la IAN?");

        ButtonSi5.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup5.add(ButtonSi5);
        ButtonSi5.setText("Si");

        ButtonNo5.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup5.add(ButtonNo5);
        ButtonNo5.setText("No");

        jLabel11.setText("¿Cuál?");

        txtRazon5.setEnabled(false);

        jLabel12.setText("6. ¿Ha asistido al Encuentro de Sanidad de la IAN?");

        ButtonSi6.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup6.add(ButtonSi6);
        ButtonSi6.setText("Si");

        ButtonNo6.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup6.add(ButtonNo6);
        ButtonNo6.setText("No");

        jLabel13.setText("¿Por qué?");

        txtRazon6.setEnabled(false);

        jLabel14.setText("7. ¿Ha asistido al Encuentro de Libertad de la IAN?");

        ButtonSi7.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup7.add(ButtonSi7);
        ButtonSi7.setText("Si");

        ButtonNo7.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup7.add(ButtonNo7);
        ButtonNo7.setText("No");

        jLabel15.setText("¿Por qué?");

        txtRazon7.setEnabled(false);

        btnNueva.setText("Nuevo");
        btnNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlEclesiastLayout = new javax.swing.GroupLayout(pnlEclesiast);
        pnlEclesiast.setLayout(pnlEclesiastLayout);
        pnlEclesiastLayout.setHorizontalGroup(
            pnlEclesiastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEclesiastLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEclesiastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl1)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addGroup(pnlEclesiastLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnlEclesiastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlEclesiastLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(32, 32, 32)
                                .addComponent(txtRazon7))
                            .addGroup(pnlEclesiastLayout.createSequentialGroup()
                                .addGroup(pnlEclesiastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlEclesiastLayout.createSequentialGroup()
                                        .addComponent(ButtonSi3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ButtonNo3))
                                    .addGroup(pnlEclesiastLayout.createSequentialGroup()
                                        .addComponent(ButtonSi4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ButtonNo4)))
                                .addGap(81, 81, 81)
                                .addGroup(pnlEclesiastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlEclesiastLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtRazon4))
                                    .addGroup(pnlEclesiastLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtRazon31, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtRazon32))))
                            .addGroup(pnlEclesiastLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(32, 32, 32)
                                .addComponent(txtRazon6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEclesiastLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txtRazon5, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEclesiastLayout.createSequentialGroup()
                                .addComponent(ButtonSi2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ButtonNo2)
                                .addGap(77, 77, 77)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                                .addComponent(txtRazon2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlEclesiastLayout.createSequentialGroup()
                                .addComponent(ButtonSi1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ButtonNo1)
                                .addGap(75, 75, 75)
                                .addComponent(jLabel2)
                                .addGap(41, 41, 41)
                                .addComponent(txtRazon1))
                            .addGroup(pnlEclesiastLayout.createSequentialGroup()
                                .addGroup(pnlEclesiastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlEclesiastLayout.createSequentialGroup()
                                        .addComponent(ButtonSi7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ButtonNo7))
                                    .addGroup(pnlEclesiastLayout.createSequentialGroup()
                                        .addComponent(ButtonSi6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ButtonNo6))
                                    .addGroup(pnlEclesiastLayout.createSequentialGroup()
                                        .addComponent(ButtonSi5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ButtonNo5)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEclesiastLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNueva)))
                .addContainerGap())
        );
        pnlEclesiastLayout.setVerticalGroup(
            pnlEclesiastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEclesiastLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEclesiastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonSi1)
                    .addComponent(ButtonNo1)
                    .addComponent(jLabel2)
                    .addComponent(txtRazon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEclesiastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonSi2)
                    .addComponent(ButtonNo2)
                    .addComponent(jLabel3)
                    .addComponent(txtRazon2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEclesiastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRazon31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(ButtonNo3)
                    .addComponent(ButtonSi3)
                    .addComponent(txtRazon32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEclesiastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonNo4)
                    .addComponent(ButtonSi4)
                    .addComponent(jLabel9)
                    .addComponent(txtRazon4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEclesiastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonSi5)
                    .addComponent(ButtonNo5)
                    .addComponent(jLabel11)
                    .addComponent(txtRazon5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEclesiastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonSi6)
                    .addComponent(ButtonNo6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEclesiastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtRazon6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEclesiastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonSi7)
                    .addComponent(ButtonNo7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEclesiastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtRazon7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNueva)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPersonal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPersonal.setBorder(javax.swing.BorderFactory.createTitledBorder("Información Personal"));
        pnlPersonal.setPreferredSize(new java.awt.Dimension(558, 590));

        lblEstado.setText("Estado Civil:");

        RadioButtonNo.setBackground(new java.awt.Color(255, 255, 255));
        RadioButtonNo.setText("No");

        lblConyuge.setText("Nombre del Cónyuge:");

        lblCreyente.setText("Creyente:");

        lblHijos.setText("Número de Hijos:");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        lblEmergencia.setText("En caso de emergencia contactar a:");

        lblNombreE.setText("Nombre:");

        lblTelefE.setText("Teléfono:");

        lblCorreo.setText("Correo Electrónico:");

        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });
        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularKeyTyped(evt);
            }
        });

        lblCedula.setText("Cédula:");

        lblNombres.setText("Nombres:");

        lblApellido.setText("Apellidos:");

        txtSector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSectorActionPerformed(evt);
            }
        });

        lblNacimiento.setText("Fecha de Nacimiento:");

        txthijos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txthijosKeyTyped(evt);
            }
        });

        lblTelefono.setText("Teléfono:");

        txtNombreE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreEActionPerformed(evt);
            }
        });

        lblCelular.setText("Celular:");

        txtTelfE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelfEKeyTyped(evt);
            }
        });

        lblInstruccion.setText("Nivel de Instrucción:");

        ComboBoxInstruccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Primaria", "Secundaria", "Superior" }));
        ComboBoxInstruccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxInstruccionActionPerformed(evt);
            }
        });

        lblProfesion.setText("Profesión u Ocupación:");

        ComboBoxCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Soltero", "Casado", "Divorciado", "Separado", "Viudo", "Unión de Hecho" }));

        lblSector.setText("Sector donde vive:");

        RadioButtonSi.setBackground(new java.awt.Color(255, 255, 255));
        RadioButtonSi.setText("Si");

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnGuardar2.setText("Guardar");
        btnGuardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPersonalLayout = new javax.swing.GroupLayout(pnlPersonal);
        pnlPersonal.setLayout(pnlPersonalLayout);
        pnlPersonalLayout.setHorizontalGroup(
            pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPersonalLayout.createSequentialGroup()
                        .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlPersonalLayout.createSequentialGroup()
                                .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblProfesion)
                                    .addComponent(lblSector)
                                    .addComponent(lblInstruccion)
                                    .addComponent(lblEstado))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ComboBoxInstruccion, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ComboBoxCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSector, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlPersonalLayout.createSequentialGroup()
                                .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTelefono)
                                    .addGroup(pnlPersonalLayout.createSequentialGroup()
                                        .addGap(80, 80, 80)
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(lblCelular)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlPersonalLayout.createSequentialGroup()
                                .addComponent(lblCorreo)
                                .addGap(29, 29, 29)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlPersonalLayout.createSequentialGroup()
                        .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPersonalLayout.createSequentialGroup()
                                .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblConyuge)
                                    .addComponent(lblHijos))
                                .addGap(18, 18, 18)
                                .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txthijos, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlPersonalLayout.createSequentialGroup()
                                        .addComponent(txtConyuge, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(62, 62, 62)
                                        .addComponent(lblCreyente)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(RadioButtonSi)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(RadioButtonNo))))
                            .addGroup(pnlPersonalLayout.createSequentialGroup()
                                .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlPersonalLayout.createSequentialGroup()
                                        .addComponent(lblNombres)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPersonalLayout.createSequentialGroup()
                                        .addComponent(lblCedula)
                                        .addGap(47, 47, 47)))
                                .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                    .addComponent(txtCedula))
                                .addGap(18, 18, 18)
                                .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlPersonalLayout.createSequentialGroup()
                                        .addComponent(lblApellido)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPersonalLayout.createSequentialGroup()
                                        .addComponent(btnConsultar)
                                        .addGap(45, 45, 45))))
                            .addComponent(lblEmergencia)
                            .addGroup(pnlPersonalLayout.createSequentialGroup()
                                .addComponent(lblNacimiento)
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPersonalLayout.createSequentialGroup()
                        .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreE)
                            .addComponent(lblTelefE))
                        .addGap(29, 29, 29)
                        .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNombreE)
                            .addComponent(txtTelfE, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardar2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(70, 70, 70))))
        );
        pnlPersonalLayout.setVerticalGroup(
            pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombres)
                    .addComponent(lblApellido)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNacimiento)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(lblCelular)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInstruccion)
                    .addComponent(ComboBoxInstruccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblProfesion)
                    .addComponent(txtProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSector)
                    .addComponent(txtSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado)
                    .addComponent(ComboBoxCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConyuge)
                    .addComponent(txtConyuge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCreyente)
                    .addComponent(RadioButtonSi)
                    .addComponent(RadioButtonNo))
                .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlPersonalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txthijos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHijos))
                        .addGap(18, 18, 18)
                        .addComponent(lblEmergencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombreE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelefE)
                            .addComponent(txtTelfE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlPersonalLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardar2)))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlEclesiast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                    .addComponent(pnlEclesiast, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1158, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
        );

        jPanel2.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularActionPerformed

    private void txtSectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSectorActionPerformed

    private void txtNombreEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreEActionPerformed

    private void ComboBoxInstruccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxInstruccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxInstruccionActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        try{
            consulta_estudiante = new Estudiante();
            pregunta_estudiante = new Preguntas();
            
            //Setear cedula para consulta
            consulta_estudiante.setCedula(Integer.parseInt(txtCedula.getText()));
            cedula=Integer.parseInt(txtCedula.getText());
            
            //Consultar estudiante por cedula
            controlador = new ControladorRegistroUsuario();
            controladorPreguntas = new ControladorRegistroPreguntas();
            consulta_estudiante=controlador.consultarCedula(cedula);
            
            //Consulta Preguntas
            pregunta_estudiante= controladorPreguntas.consultarCedulaPreguntas(consulta_estudiante);
            System.out.println(txtCedula.getText());
            
            //Seteo de datos
            if(consulta_estudiante!=null){
                setConsultaEstudiante();
                setPreguntasEstudiante();
            }
        }
        catch(Exception e){
              //JOptionPane.showMessageDialog(null, e.getMessage()+e.getStackTrace());
              JOptionPane.showMessageDialog(null, "No se encuentra registrado");
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnGuardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar2ActionPerformed
        try{
            //Instancia de objetos
            actualizar_estudiante = new Estudiante();
            actualizar_pregunta = new Preguntas();
            controlador = new ControladorRegistroUsuario();
            
            //Seteo de datos para editar
            editEstudiante();
            editPreguntas();
            if (validarDatos()) {
            //Actualizacion de datos
                controlador.editarEstudiante(actualizar_estudiante);
                controladorPreguntas.editarPregunta(actualizar_pregunta);
                JOptionPane.showMessageDialog(null,"Estudiante Actualizado");
            }
        }catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"No se puede Actualizar \n");
            e.printStackTrace(System.out);
        }
    }//GEN-LAST:event_btnGuardar2ActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        Habilitar(true);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaActionPerformed
        limpiar();
        Habilitar(false);
        txtCedula.setEnabled(true);        
    }//GEN-LAST:event_btnNuevaActionPerformed

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        soporte.soloNumeros(evt);
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        soporte.soloNumeros(evt);
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyTyped
        soporte.soloNumeros(evt);
    }//GEN-LAST:event_txtCelularKeyTyped

    private void txthijosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txthijosKeyTyped
        soporte.soloNumeros(evt);
    }//GEN-LAST:event_txthijosKeyTyped

    private void txtTelfEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelfEKeyTyped
        soporte.soloNumeros(evt);
    }//GEN-LAST:event_txtTelfEKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ButtonNo1;
    private javax.swing.JRadioButton ButtonNo2;
    private javax.swing.JRadioButton ButtonNo3;
    private javax.swing.JRadioButton ButtonNo4;
    private javax.swing.JRadioButton ButtonNo5;
    private javax.swing.JRadioButton ButtonNo6;
    private javax.swing.JRadioButton ButtonNo7;
    private javax.swing.JRadioButton ButtonSi1;
    private javax.swing.JRadioButton ButtonSi2;
    private javax.swing.JRadioButton ButtonSi3;
    private javax.swing.JRadioButton ButtonSi4;
    private javax.swing.JRadioButton ButtonSi5;
    private javax.swing.JRadioButton ButtonSi6;
    private javax.swing.JRadioButton ButtonSi7;
    private javax.swing.JComboBox<String> ComboBoxCivil;
    private javax.swing.JComboBox<String> ComboBoxInstruccion;
    private javax.swing.JRadioButton RadioButtonNo;
    private javax.swing.JRadioButton RadioButtonSi;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnGuardar2;
    private javax.swing.JButton btnNueva;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblConyuge;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblCreyente;
    private javax.swing.JLabel lblEmergencia;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblHijos;
    private javax.swing.JLabel lblInstruccion;
    private javax.swing.JLabel lblNacimiento;
    private javax.swing.JLabel lblNombreE;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblProfesion;
    private javax.swing.JLabel lblSector;
    private javax.swing.JLabel lblTelefE;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JPanel pnlEclesiast;
    private javax.swing.JPanel pnlPersonal;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtConyuge;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreE;
    private javax.swing.JTextField txtProfesion;
    private javax.swing.JTextField txtRazon1;
    private javax.swing.JTextField txtRazon2;
    private javax.swing.JTextField txtRazon31;
    private javax.swing.JTextField txtRazon32;
    private javax.swing.JTextField txtRazon4;
    private javax.swing.JTextField txtRazon5;
    private javax.swing.JTextField txtRazon6;
    private javax.swing.JTextField txtRazon7;
    private javax.swing.JTextField txtSector;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelfE;
    private javax.swing.JTextField txthijos;
    // End of variables declaration//GEN-END:variables
}
