package Vista;

import Vista.Periodo.JInternalFrameNuevoPeriodo;
import Vista.Calificacion.JInternalFrameConsultaCalificacion;
import Vista.Calificacion.JInternalFrameIngresaCalificacion;
import Vista.Horario.JInternalFrameConsultarHorario;
import Vista.Horario.JInternalFrameNuevoHorario;
import Vista.Inscripcion.JInternalFrameNuevaInscripcion;
import Vista.Materia.JInternalFrameConsultarMateria;
import Vista.Materia.JInternalFrameNuevaMateria;
import Vista.MateriaHorario.JInternalFrameConsultarMateriaHorario;
import Vista.MateriaHorario.JInternalFrameNuevaMateriaHorario;
import Vista.Periodo.JInternalFrameConsultarPeriodo;
import Vista.Registro.JInternalFrameConsultaRegistro;
import Vista.Registro.JInternalFrameNuevoRegistro;
import Vista.Reporte.JInternalFrameGeneraReporte;
import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class frmPrincipal extends javax.swing.JFrame{
    JInternalFrameNuevoRegistro internalFramenNuevoRegistro;
    JInternalFrameConsultaRegistro internalFrameConsultaRegistro;
    JInternalFrameNuevaInscripcion internalFrameNuevaInscripcion;
    JInternalFrameIngresaCalificacion internalFrameIngresaCalificacion;
    JInternalFrameConsultaCalificacion internalFrameConsultaCalificacion;
    JInternalFrameGeneraReporte internalFrameGeneraReporte;
    JInternalFrameNuevoPeriodo internalFrameNuevoPeriodo;
    JInternalFrameConsultarPeriodo internalFrameConsultarPeriodo;
<<<<<<< HEAD
    JInternalFrameNuevoHorario internalFrameNuevoHorario;
    JInternalFrameConsultarHorario internalFrameConsultarHorario;
    
    
=======
    JInternalFrameNuevaMateria internalFrameNuevaMateria;
    JInternalFrameConsultarMateria internalFrameConsultarMateria;
    JInternalFrameNuevaMateriaHorario internalFrameNuevaMateriaHorario;
    JInternalFrameConsultarMateriaHorario internalFrameConsultaMateriaHorario;
>>>>>>> master
    JDesktopPane dp=new JDesktopPane();
    
    
    public frmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);
        this.getContentPane().add(dp);
        pnlPrincipal.setBackground(Color.white);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        lblIcono = new javax.swing.JLabel();
        lblBarra = new javax.swing.JLabel();
        MenuBarPrincipal = new javax.swing.JMenuBar();
        menuRegistro = new javax.swing.JMenu();
        itemNuevoE = new javax.swing.JMenuItem();
        itemActualizarE = new javax.swing.JMenuItem();
        menuInscripcion = new javax.swing.JMenu();
        itemInscripcion = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuCalificacion = new javax.swing.JMenu();
        itemNuevaCalif = new javax.swing.JMenuItem();
        itemConsultarCal = new javax.swing.JMenuItem();
        menuReporte = new javax.swing.JMenu();
        itemReporte = new javax.swing.JMenuItem();
        menuAcademia = new javax.swing.JMenu();
        itemNuevoPeriodo = new javax.swing.JMenuItem();
        itemConsultarPeriodo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemNuevoHorario = new javax.swing.JMenuItem();
        itemConsultarHorario = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        itemNuevaMateria = new javax.swing.JMenuItem();
        itemConsultarMateria = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        itemNuevoHorarioMateria = new javax.swing.JMenuItem();
        itemConsultarHorarioMateria = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipal.setPreferredSize(new java.awt.Dimension(1168, 647));
        pnlPrincipal.setRequestFocusEnabled(false);

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconoTransparente.png"))); // NOI18N

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap(1095, Short.MAX_VALUE)
                .addComponent(lblIcono)
                .addGap(26, 26, 26))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap(574, Short.MAX_VALUE)
                .addComponent(lblIcono)
                .addGap(24, 24, 24))
        );

        lblBarra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.jpg"))); // NOI18N

        menuRegistro.setText("Estudiantes");

        itemNuevoE.setText("Nuevo estudiante");
        itemNuevoE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoEActionPerformed(evt);
            }
        });
        menuRegistro.add(itemNuevoE);

        itemActualizarE.setText("Consulltar/Actualizar estudiante");
        itemActualizarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemActualizarEActionPerformed(evt);
            }
        });
        menuRegistro.add(itemActualizarE);

        MenuBarPrincipal.add(menuRegistro);

        menuInscripcion.setText("Inscripción");

        itemInscripcion.setText("Nueva inscripción");
        itemInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemInscripcionActionPerformed(evt);
            }
        });
        menuInscripcion.add(itemInscripcion);

        jMenuItem2.setText("Consultar/Actualizar inscripcion");
        menuInscripcion.add(jMenuItem2);

        MenuBarPrincipal.add(menuInscripcion);

        menuCalificacion.setText("Calificaciones");

        itemNuevaCalif.setText("Ingresar calificaciones");
        itemNuevaCalif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevaCalifActionPerformed(evt);
            }
        });
        menuCalificacion.add(itemNuevaCalif);

        itemConsultarCal.setText("Consultar/Actualizar Calificaciones");
        itemConsultarCal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConsultarCalActionPerformed(evt);
            }
        });
        menuCalificacion.add(itemConsultarCal);

        MenuBarPrincipal.add(menuCalificacion);

        menuReporte.setText("Reporte");

        itemReporte.setText("Generar reporte");
        itemReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemReporteActionPerformed(evt);
            }
        });
        menuReporte.add(itemReporte);

        MenuBarPrincipal.add(menuReporte);

        menuAcademia.setText("Periodo Académico");

        itemNuevoPeriodo.setText("Crear nuevo periodo");
        itemNuevoPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoPeriodoActionPerformed(evt);
            }
        });
        menuAcademia.add(itemNuevoPeriodo);

        itemConsultarPeriodo.setText("Consultar/Actualizar periodo");
        itemConsultarPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConsultarPeriodoActionPerformed(evt);
            }
        });
        menuAcademia.add(itemConsultarPeriodo);
        menuAcademia.add(jSeparator1);

        itemNuevoHorario.setText("Crear nuevo horario");
        itemNuevoHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoHorarioActionPerformed(evt);
            }
        });
        menuAcademia.add(itemNuevoHorario);

<<<<<<< HEAD
        jMenuItem3.setText("Consultar/Actualizar horario");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuAcademia.add(jMenuItem3);
=======
        itemConsultarHorario.setText("Consultar/Actualizar horario");
        menuAcademia.add(itemConsultarHorario);
>>>>>>> master
        menuAcademia.add(jSeparator2);

        itemNuevaMateria.setText("Crear nueva materia");
        itemNuevaMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevaMateriaActionPerformed(evt);
            }
        });
        menuAcademia.add(itemNuevaMateria);

        itemConsultarMateria.setText("Consultar/Actualizar materia");
        itemConsultarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConsultarMateriaActionPerformed(evt);
            }
        });
        menuAcademia.add(itemConsultarMateria);
        menuAcademia.add(jSeparator3);

        itemNuevoHorarioMateria.setText("Asignación horario a materia");
        itemNuevoHorarioMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoHorarioMateriaActionPerformed(evt);
            }
        });
        menuAcademia.add(itemNuevoHorarioMateria);

        itemConsultarHorarioMateria.setText("Consultar/Actualizar horario de materia");
        itemConsultarHorarioMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConsultarHorarioMateriaActionPerformed(evt);
            }
        });
        menuAcademia.add(itemConsultarHorarioMateria);

        MenuBarPrincipal.add(menuAcademia);

        setJMenuBar(MenuBarPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(lblBarra)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblBarra))
        );

        pnlPrincipal.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemNuevoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoEActionPerformed
       
        internalFramenNuevoRegistro =new JInternalFrameNuevoRegistro();
        mostrarVentana(internalFramenNuevoRegistro);
        
    }//GEN-LAST:event_itemNuevoEActionPerformed

    private void itemActualizarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemActualizarEActionPerformed
        internalFrameConsultaRegistro = new JInternalFrameConsultaRegistro();
        mostrarVentana(internalFrameConsultaRegistro);
    }//GEN-LAST:event_itemActualizarEActionPerformed

    private void itemInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemInscripcionActionPerformed
        internalFrameNuevaInscripcion = new JInternalFrameNuevaInscripcion();
        mostrarVentana(internalFrameNuevaInscripcion);
    }//GEN-LAST:event_itemInscripcionActionPerformed

    private void itemNuevaCalifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevaCalifActionPerformed
        internalFrameIngresaCalificacion = new JInternalFrameIngresaCalificacion();
        mostrarVentana(internalFrameIngresaCalificacion);
        
    }//GEN-LAST:event_itemNuevaCalifActionPerformed

    private void itemConsultarCalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConsultarCalActionPerformed
       internalFrameConsultaCalificacion = new JInternalFrameConsultaCalificacion();
        mostrarVentana(internalFrameConsultaCalificacion);
               
    }//GEN-LAST:event_itemConsultarCalActionPerformed

    private void itemReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReporteActionPerformed
       internalFrameGeneraReporte = new JInternalFrameGeneraReporte();
        mostrarVentana(internalFrameGeneraReporte);
    }//GEN-LAST:event_itemReporteActionPerformed
    //Mètodos para mostrar las vistas crear periodo
    private void itemNuevoPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoPeriodoActionPerformed
       internalFrameNuevoPeriodo = new JInternalFrameNuevoPeriodo();
        mostrarVentana(internalFrameNuevoPeriodo); 
    }//GEN-LAST:event_itemNuevoPeriodoActionPerformed
    //Mètodos para mostrar las vistas crear periodo
    private void itemConsultarPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConsultarPeriodoActionPerformed
        internalFrameConsultarPeriodo = new JInternalFrameConsultarPeriodo();
        mostrarVentana(internalFrameConsultarPeriodo); 
    }//GEN-LAST:event_itemConsultarPeriodoActionPerformed

<<<<<<< HEAD
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
         internalFrameNuevoHorario = new JInternalFrameNuevoHorario();
        mostrarVentana(internalFrameNuevoHorario); 
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        internalFrameConsultarHorario = new JInternalFrameConsultarHorario();
        mostrarVentana(internalFrameConsultarHorario);
    }//GEN-LAST:event_jMenuItem3ActionPerformed
=======
    private void itemNuevoHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoHorarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemNuevoHorarioActionPerformed

    private void itemNuevaMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevaMateriaActionPerformed
        internalFrameNuevaMateria = new JInternalFrameNuevaMateria();
        mostrarVentana(internalFrameNuevaMateria);
    }//GEN-LAST:event_itemNuevaMateriaActionPerformed

    private void itemConsultarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConsultarMateriaActionPerformed
        internalFrameConsultarMateria = new JInternalFrameConsultarMateria();
        mostrarVentana(internalFrameConsultarMateria);
    }//GEN-LAST:event_itemConsultarMateriaActionPerformed

    private void itemNuevoHorarioMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoHorarioMateriaActionPerformed
        internalFrameNuevaMateriaHorario = new JInternalFrameNuevaMateriaHorario();
        mostrarVentana(internalFrameNuevaMateriaHorario);
    }//GEN-LAST:event_itemNuevoHorarioMateriaActionPerformed

    private void itemConsultarHorarioMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConsultarHorarioMateriaActionPerformed
        internalFrameConsultaMateriaHorario = new JInternalFrameConsultarMateriaHorario();
        mostrarVentana(internalFrameConsultaMateriaHorario);
    }//GEN-LAST:event_itemConsultarHorarioMateriaActionPerformed
>>>>>>> master
    
    private void mostrarVentana(JInternalFrame frame ){
        pnlPrincipal.removeAll();
        frame.pack();
        pnlPrincipal.add(frame);
        frame.show();
    }
    public static void main(String args[]){
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
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBarPrincipal;
    private javax.swing.JMenuItem itemActualizarE;
    private javax.swing.JMenuItem itemConsultarCal;
    private javax.swing.JMenuItem itemConsultarHorario;
    private javax.swing.JMenuItem itemConsultarHorarioMateria;
    private javax.swing.JMenuItem itemConsultarMateria;
    private javax.swing.JMenuItem itemConsultarPeriodo;
    private javax.swing.JMenuItem itemInscripcion;
    private javax.swing.JMenuItem itemNuevaCalif;
    private javax.swing.JMenuItem itemNuevaMateria;
    private javax.swing.JMenuItem itemNuevoE;
    private javax.swing.JMenuItem itemNuevoHorario;
    private javax.swing.JMenuItem itemNuevoHorarioMateria;
    private javax.swing.JMenuItem itemNuevoPeriodo;
    private javax.swing.JMenuItem itemReporte;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JLabel lblBarra;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JMenu menuAcademia;
    private javax.swing.JMenu menuCalificacion;
    private javax.swing.JMenu menuInscripcion;
    private javax.swing.JMenu menuRegistro;
    private javax.swing.JMenu menuReporte;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
