package Vista;

import Vista.Periodo.JInternalFrameNuevoPeriodo;
import Vista.Calificacion.JInternalFrameConsultaCalificacion;
import Vista.Calificacion.JInternalFrameIngresaCalificacion;
import Vista.Inscripcion.JInternalFrameNuevaInscripcion;
import Vista.Materia.JInternalFrameConsultarMateria;
import Vista.Materia.JInternalFrameNuevaMateria;
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
    JInternalFrameNuevaMateria internalFrameNuevaMateria;
    JInternalFrameConsultarMateria internalFrameConsultarMateria;
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
        itemReporte1 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

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

        itemReporte1.setText("Crear nuevo periodo");
        itemReporte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemReporte1ActionPerformed(evt);
            }
        });
        menuAcademia.add(itemReporte1);

        jMenuItem1.setText("Consultar/Actualizar periodo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuAcademia.add(jMenuItem1);
        menuAcademia.add(jSeparator1);

        jMenuItem4.setText("Crear nuevo horario");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuAcademia.add(jMenuItem4);

        jMenuItem3.setText("Consultar/Actualizar horario");
        menuAcademia.add(jMenuItem3);
        menuAcademia.add(jSeparator2);

        jMenuItem5.setText("Crear nueva materia");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuAcademia.add(jMenuItem5);

        jMenuItem6.setText("Consultar/Actualizar materia");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menuAcademia.add(jMenuItem6);
        menuAcademia.add(jSeparator3);

        jMenuItem7.setText("Asignación horario a materia");
        menuAcademia.add(jMenuItem7);

        jMenuItem8.setText("Consultar/Actualizar horaria a materia");
        menuAcademia.add(jMenuItem8);

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
    private void itemReporte1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReporte1ActionPerformed
       internalFrameNuevoPeriodo = new JInternalFrameNuevoPeriodo();
        mostrarVentana(internalFrameNuevoPeriodo); 
    }//GEN-LAST:event_itemReporte1ActionPerformed
    //Mètodos para mostrar las vistas crear periodo
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        internalFrameConsultarPeriodo = new JInternalFrameConsultarPeriodo();
        mostrarVentana(internalFrameConsultarPeriodo); 
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        internalFrameNuevaMateria = new JInternalFrameNuevaMateria();
        mostrarVentana(internalFrameNuevaMateria);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        internalFrameConsultarMateria = new JInternalFrameConsultarMateria();
        mostrarVentana(internalFrameConsultarMateria);
    }//GEN-LAST:event_jMenuItem6ActionPerformed
    
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
    private javax.swing.JMenuItem itemInscripcion;
    private javax.swing.JMenuItem itemNuevaCalif;
    private javax.swing.JMenuItem itemNuevoE;
    private javax.swing.JMenuItem itemReporte;
    private javax.swing.JMenuItem itemReporte1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
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
