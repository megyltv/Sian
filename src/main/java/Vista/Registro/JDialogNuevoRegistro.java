package Vista.Registro;

import java.awt.Color;

public class JDialogNuevoRegistro extends javax.swing.JDialog {

    public JDialogNuevoRegistro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.getContentPane().setBackground(Color.white);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPersonal = new javax.swing.JPanel();
        lblEstado = new javax.swing.JLabel();
        RadioButtonNo = new javax.swing.JRadioButton();
        lblConyuge = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblCreyente = new javax.swing.JLabel();
        lblHijos = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        btnGuardar = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        pnlPersonal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPersonal.setBorder(javax.swing.BorderFactory.createTitledBorder("Información Personal"));

        lblEstado.setText("Estado Civil:");

        RadioButtonNo.setBackground(new java.awt.Color(255, 255, 255));
        RadioButtonNo.setText("No");

        lblConyuge.setText("Nombre del Cónyuge:");

        lblCreyente.setText("Creyente:");

        lblHijos.setText("Número de Hijos:");

        btnGuardar.setText("Guardar");

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

        ComboBoxInstruccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBoxInstruccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxInstruccionActionPerformed(evt);
            }
        });

        lblProfesion.setText("Profesión u Ocupación:");

        ComboBoxCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                        .addComponent(lblTelefE)
                        .addGap(29, 29, 29)
                        .addComponent(txtTelfE, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar)
                        .addGap(70, 70, 70))
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
                                .addComponent(lblApellido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblEmergencia)
                            .addComponent(lblNombreE)
                            .addGroup(pnlPersonalLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(txtNombreE, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPersonalLayout.createSequentialGroup()
                                .addComponent(lblNacimiento)
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(txtTelfE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar))
                .addContainerGap())
        );

        pnlEclesiast.setBackground(new java.awt.Color(255, 255, 255));
        pnlEclesiast.setBorder(javax.swing.BorderFactory.createTitledBorder("Información Eclesiástica"));

        lbl1.setText("1. ¿Ha recibido a Jesús en su corazón como Salvador personal?");

        jLabel1.setText("2. Antes de esta iglesia, ¿asistías a alguna otra?");

        ButtonNo1.setBackground(new java.awt.Color(255, 255, 255));
        ButtonNo1.setText("No");

        ButtonSi1.setBackground(new java.awt.Color(255, 255, 255));
        ButtonSi1.setText("Si");

        jLabel2.setText("Fecha");

        ButtonSi2.setBackground(new java.awt.Color(255, 255, 255));
        ButtonSi2.setText("Si");

        ButtonNo2.setBackground(new java.awt.Color(255, 255, 255));
        ButtonNo2.setText("No");

        jLabel3.setText("¿A cual?");

        jLabel4.setText("3. ¿Ha sido bautizado en una Iglesia Cristiana Evangélica?");

        ButtonSi3.setBackground(new java.awt.Color(255, 255, 255));
        ButtonSi3.setText("Si");

        ButtonNo3.setBackground(new java.awt.Color(255, 255, 255));
        ButtonNo3.setText("No");

        jLabel5.setText("¿Cuándo?");

        jLabel7.setText("¿Dónde?");

        jLabel8.setText("4. ¿Asiste a un discipulado?");

        ButtonSi4.setBackground(new java.awt.Color(255, 255, 255));
        ButtonSi4.setText("Si");

        ButtonNo4.setBackground(new java.awt.Color(255, 255, 255));
        ButtonNo4.setText("No");

        jLabel9.setText("¿Cuál es su discipulador?");

        jLabel10.setText("5. ¿Estás sirviendo en un ministerio de la IAN?");

        ButtonSi5.setBackground(new java.awt.Color(255, 255, 255));
        ButtonSi5.setText("Si");

        ButtonNo5.setBackground(new java.awt.Color(255, 255, 255));
        ButtonNo5.setText("No");

        jLabel11.setText("¿Cuál?");

        jLabel12.setText("6. ¿Ha asistido al Encuentro de Sanidad de la IAN?");

        ButtonSi6.setBackground(new java.awt.Color(255, 255, 255));
        ButtonSi6.setText("Si");

        ButtonNo6.setBackground(new java.awt.Color(255, 255, 255));
        ButtonNo6.setText("No");

        jLabel13.setText("¿Por qué?");

        jLabel14.setText("7. ¿Ha asistido al Encuentro de Libertad de la IAN?");

        ButtonSi7.setBackground(new java.awt.Color(255, 255, 255));
        ButtonSi7.setText("Si");

        ButtonNo7.setBackground(new java.awt.Color(255, 255, 255));
        ButtonNo7.setText("No");

        jLabel15.setText("¿Por qué?");

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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
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
                                .addGap(0, 0, Short.MAX_VALUE)))))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlEclesiast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlEclesiast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(JDialogNuevoRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogNuevoRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogNuevoRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogNuevoRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogNuevoRegistro dialog = new JDialogNuevoRegistro(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

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
