package Vista.Registro;

import Controlador.Registro.ControladorRegistroUsuario;
import Entidades.Estudiante;
import Entidades.Preguntas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class JInternalFrameNuevoRegistro extends javax.swing.JInternalFrame {

    Estudiante nuevo_estudiante;
    Preguntas pregunta;
            
    public JInternalFrameNuevoRegistro() {
        initComponents();
        habilitarPreguntas();
        //Habilitacion de botones si o no
        ButtonSi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                     JInternalFrameNuevoRegistro.this.txtRazon1.setEnabled(true);
        }});
        ButtonNo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                     JInternalFrameNuevoRegistro.this.txtRazon1.setEnabled(false);
        }});
    }
    
    public void limpiar(){
        txtApellido.setText("");
        txtCedula.setText("");
        txtCelular.setText("");
        txtConyuge.setText("");
        txtCorreo.setText("");
        txtNombre.setText("");
        txtNombreE.setText("");
        txtProofesion.setText("");
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
    
    public void habilitarPreguntas(){
        ButtonNo1.setEnabled(true);
        ButtonNo2.setEnabled(true);
        ButtonNo3.setEnabled(true);
        ButtonNo4.setEnabled(true);
        ButtonNo5.setEnabled(true);
        ButtonNo6.setEnabled(true);
        ButtonNo7.setEnabled(true);
        ButtonSi1.setEnabled(true);
        ButtonSi2.setEnabled(true);
        ButtonSi3.setEnabled(true);
        ButtonSi4.setEnabled(true);
        ButtonSi5.setEnabled(true);
        ButtonSi6.setEnabled(true);
        ButtonSi7.setEnabled(true);
    }
    
    public void setDatosEstudiante(){
        nuevo_estudiante = new Estudiante();
        try {
            nuevo_estudiante.setCedula(Integer.parseInt(txtCedula.getText().trim()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingresar Cédula");
        }
        
        if(txtNombre.getText()!=""){
            nuevo_estudiante.setNombres((txtNombre.getText()));
        }else{
            nuevo_estudiante.setNombres(" ");
        }
        if(txtApellido.getText()!=""){
            nuevo_estudiante.setApellidos((txtApellido.getText()));
        }else{
            nuevo_estudiante.setApellidos(" ");
        }
        nuevo_estudiante.setFechanac((jDateChooser1.getDate()));
        
        if(txtTelefono.getText().isEmpty()){
            nuevo_estudiante.setTelefono(0);
        }else{
            nuevo_estudiante.setTelefono(Integer.parseInt(txtTelefono.getText().trim())); 
        }
        if(txtCelular.getText().isEmpty()){
            nuevo_estudiante.setCelular(0);
        }else{
            nuevo_estudiante.setCelular(Integer.parseInt(txtCelular.getText().trim()));
        }
        
        if(txtCorreo.getText()!=""){
            nuevo_estudiante.setCorreo((txtCorreo.getText().trim()));
        }else{
            nuevo_estudiante.setCorreo(" ");
        }
        if(txtCorreo.getText()!=""){
            nuevo_estudiante.setCorreo((txtCorreo.getText().trim()));
        }else{
            nuevo_estudiante.setCorreo(" ");
        }
        nuevo_estudiante.setNivelinst(((String)ComboBoxInstruccion.getSelectedItem()));
        if(txtProofesion.getText()!=""){
            nuevo_estudiante.setProfesion((txtProofesion.getText()));
        }else{
            nuevo_estudiante.setProfesion(" ");
        }
        if(txtSector.getText()!=""){
            nuevo_estudiante.setSector((txtSector.getText()));
        }else{
            nuevo_estudiante.setSector(" ");
        }
        
        nuevo_estudiante.setEstadocivil((String)ComboBoxCivil.getSelectedItem());
        if(txtConyuge.getText()!=""){
            nuevo_estudiante.setNombcony((txtConyuge.getText()));
        }else{
            nuevo_estudiante.setNombcony(" ");
        }
        // Si == 1, No == 0, Ninguno=3 
        if (RadioButtonSi.isSelected())
        {
            nuevo_estudiante.setCreycony(1);
           
        }
        else if (RadioButtonNo.isSelected())
        {
            nuevo_estudiante.setCreycony(0);
        }
        else{
            nuevo_estudiante.setCreycony(2);
        }
        
        if(txthijos.getText().isEmpty()){
            nuevo_estudiante.setHijos(0);
        }else{
            nuevo_estudiante.setHijos(Integer.parseInt(txthijos.getText()));
        }
        
        if(txtNombreE.getText()!=""){
            nuevo_estudiante.setNombemerg((txtNombreE.getText()));
        }else{
            nuevo_estudiante.setNombemerg(" ");
        }
        if(txtTelfE.getText().isEmpty()){
            nuevo_estudiante.setTelfemerg(0);
        }else{
            nuevo_estudiante.setTelfemerg((Integer.parseInt(txtTelfE.getText())));
        }
    }
    
    public void setPreguntas(){
        pregunta= new Preguntas();
        pregunta.setIdestudiante(nuevo_estudiante);
        

        if (ButtonSi1.isSelected()){ pregunta.setOpcion1(1);} else if (ButtonNo1.isSelected()) { pregunta.setOpcion1(0);} else {pregunta.setOpcion1(0);}
        if(txtRazon1.getText()!=""){
            pregunta.setRespuesta1(txtRazon1.getText());
        }else{
            pregunta.setRespuesta1("");
        }
             
        if (ButtonSi2.isSelected()){ pregunta.setOpcion2(1); txtRazon2.setEnabled(true);} else if (ButtonNo2.isSelected()) { pregunta.setOpcion2(0);} else {pregunta.setOpcion1(0);}
        if(txtRazon1.getText()!=""){
            pregunta.setRespuesta2(txtRazon2.getText());
        }else{
            pregunta.setRespuesta2("");
        }
               
        if (ButtonSi3.isSelected()){ pregunta.setOpcion3(1); txtRazon31.setEnabled(true);txtRazon32.setEnabled(true);} else if (ButtonNo3.isSelected()){pregunta.setOpcion3(0);}else {pregunta.setOpcion1(0);}
        if(txtRazon31.getText()!=""){
            pregunta.setRespuesta31(txtRazon31.getText());
        }else{
            pregunta.setRespuesta31("");
        }
        if(txtRazon32.getText()!=""){
            pregunta.setRespuesta32(txtRazon32.getText());
        }else{
            pregunta.setRespuesta32("");
        }
        
        if (ButtonSi4.isSelected()){ pregunta.setOpcion4(1); txtRazon4.setEnabled(true);} else if (ButtonNo4.isSelected()) { pregunta.setOpcion4(0); }else {pregunta.setOpcion1(0);}
        if(txtRazon4.getText()!=""){
            pregunta.setRespuesta4(txtRazon4.getText());
        }else{
            pregunta.setRespuesta4("");
        }

        if (ButtonSi5.isSelected()){ pregunta.setOpcion5(1); txtRazon5.setEnabled(true);} else if (ButtonNo5.isSelected()) { pregunta.setOpcion5(0); } else {pregunta.setOpcion1(0);}
        if(txtRazon5.getText()!=""){
            pregunta.setRespuesta5(txtRazon5.getText());
        }else{
            pregunta.setRespuesta5("");
        }    

        if (ButtonSi6.isSelected()){ pregunta.setOpcion6(1); } else if (ButtonNo6.isSelected()) { pregunta.setOpcion6(0); txtRazon6.setEnabled(false);} else {pregunta.setOpcion1(0);}
        if(txtRazon6.getText()!=""){
            pregunta.setRespuesta6(txtRazon6.getText());
        }else{
            pregunta.setRespuesta6("");
        } 
        
        if (ButtonSi7.isSelected()){ pregunta.setOpcion7(1); } else if (ButtonNo7.isSelected()) { pregunta.setOpcion7(0); txtRazon7.setEnabled(false);} else {pregunta.setOpcion1(0);}
        if(txtRazon7.getText()!=""){
            pregunta.setRespuesta7(txtRazon7.getText());
        }else{
            pregunta.setRespuesta7("");
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
        btnGuardar = new javax.swing.JButton();
        pnlPersonal = new javax.swing.JPanel();
        lblEstado = new javax.swing.JLabel();
        RadioButtonNo = new javax.swing.JRadioButton();
        lblConyuge = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblCreyente = new javax.swing.JLabel();
        lblHijos = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
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
        txtProofesion = new javax.swing.JTextField();
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
        ButtonNo1.setEnabled(false);

        ButtonSi1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(ButtonSi1);
        ButtonSi1.setText("Si");

        jLabel2.setText("Fecha");

        txtRazon1.setEnabled(false);

        ButtonSi2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(ButtonSi2);
        ButtonSi2.setText("Si");
        ButtonSi2.setEnabled(false);

        ButtonNo2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(ButtonNo2);
        ButtonNo2.setText("No");
        ButtonNo2.setEnabled(false);

        jLabel3.setText("¿A cual?");

        txtRazon2.setEnabled(false);

        jLabel4.setText("3. ¿Ha sido bautizado en una Iglesia Cristiana Evangélica?");

        ButtonSi3.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup3.add(ButtonSi3);
        ButtonSi3.setText("Si");
        ButtonSi3.setEnabled(false);

        ButtonNo3.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup3.add(ButtonNo3);
        ButtonNo3.setText("No");
        ButtonNo3.setEnabled(false);

        jLabel5.setText("¿Cuándo?");

        txtRazon31.setEnabled(false);

        txtRazon32.setEnabled(false);

        jLabel7.setText("¿Dónde?");

        jLabel8.setText("4. ¿Asiste a un discipulado?");

        ButtonSi4.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup4.add(ButtonSi4);
        ButtonSi4.setText("Si");
        ButtonSi4.setEnabled(false);

        ButtonNo4.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup4.add(ButtonNo4);
        ButtonNo4.setText("No");
        ButtonNo4.setEnabled(false);

        jLabel9.setText("¿Cuál es su discipulador?");

        txtRazon4.setEnabled(false);

        jLabel10.setText("5. ¿Estás sirviendo en un ministerio de la IAN?");

        ButtonSi5.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup5.add(ButtonSi5);
        ButtonSi5.setText("Si");
        ButtonSi5.setEnabled(false);

        ButtonNo5.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup5.add(ButtonNo5);
        ButtonNo5.setText("No");
        ButtonNo5.setEnabled(false);

        jLabel11.setText("¿Cuál?");

        txtRazon5.setEnabled(false);

        jLabel12.setText("6. ¿Ha asistido al Encuentro de Sanidad de la IAN?");

        ButtonSi6.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup6.add(ButtonSi6);
        ButtonSi6.setText("Si");
        ButtonSi6.setEnabled(false);

        ButtonNo6.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup6.add(ButtonNo6);
        ButtonNo6.setText("No");
        ButtonNo6.setEnabled(false);

        jLabel13.setText("¿Por qué?");

        txtRazon6.setEnabled(false);

        jLabel14.setText("7. ¿Ha asistido al Encuentro de Libertad de la IAN?");

        ButtonSi7.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup7.add(ButtonSi7);
        ButtonSi7.setText("Si");
        ButtonSi7.setEnabled(false);

        ButtonNo7.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup7.add(ButtonNo7);
        ButtonNo7.setText("No");
        ButtonNo7.setEnabled(false);

        jLabel15.setText("¿Por qué?");

        txtRazon7.setEnabled(false);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
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
                        .addComponent(btnGuardar)))
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
                .addComponent(btnGuardar)
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

        lblEmergencia.setText("En caso de emergencia contactar a:");

        lblNombreE.setText("Nombre:");

        lblTelefE.setText("Teléfono:");

        lblCorreo.setText("Correo Electrónico:");

        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
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

        lblTelefono.setText("Teléfono:");

        txtNombreE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreEActionPerformed(evt);
            }
        });

        lblCelular.setText("Celular:");

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
                                    .addComponent(txtProofesion, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addComponent(lblApellido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblEmergencia)
                            .addGroup(pnlPersonalLayout.createSequentialGroup()
                                .addComponent(lblNacimiento)
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(lblNombreE)
                            .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtNombreE, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlPersonalLayout.createSequentialGroup()
                                    .addComponent(lblTelefE)
                                    .addGap(29, 29, 29)
                                    .addComponent(txtTelfE, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(28, Short.MAX_VALUE))))
        );
        pnlPersonalLayout.setVerticalGroup(
            pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(txtProofesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txthijos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHijos))
                .addGap(18, 18, 18)
                .addComponent(lblEmergencia)
                .addGap(18, 18, 18)
                .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreE)
                    .addComponent(txtNombreE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefE)
                    .addComponent(txtTelfE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(122, Short.MAX_VALUE))
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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        setDatosEstudiante();
        
        ControladorRegistroUsuario controlador = new ControladorRegistroUsuario();
        try {
            controlador.crearEstudiante(nuevo_estudiante);  
            setPreguntas();
            controlador.crearPreguntas(pregunta);
            JOptionPane.showMessageDialog(null,"Estudiante Registrado");
            
            //limpiar();
        } catch (Exception ex) {
            Logger.getLogger(JInternalFrameNuevoRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_btnGuardarActionPerformed


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
    private javax.swing.JButton btnGuardar;
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
    private javax.swing.JTextField txtProofesion;
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
