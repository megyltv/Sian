package Vista;

import Vista.Academia.JInternalFrameAcademy;
import Vista.Calificacion.JInternalFrameConsultaCalificacion;
import Vista.Calificacion.JInternalFrameIngresaCalificacion;
import Vista.Inscripcion.JInternalFrameNuevaInscripcion;
import Vista.Registro.JInternalFrameConsultaRegistro;
import Vista.Registro.JInternalFrameNuevoRegistro;
import Vista.Reporte.JInternalFrameGeneraReporte;
import java.awt.Color;
import javax.swing.JDesktopPane;

public class frmPrincipal extends javax.swing.JFrame{
    JInternalFrameNuevoRegistro internalFramenNuevoRegistro;
    JInternalFrameConsultaRegistro internalFrameConsultaRegistro;
    JInternalFrameNuevaInscripcion internalFrameNuevaInscripcion;
    JInternalFrameIngresaCalificacion internalFrameIngresaCalificacion;
    JInternalFrameConsultaCalificacion internalFrameConsultaCalificacion;
    JInternalFrameGeneraReporte internalFrameGeneraReporte;
    JInternalFrameAcademy internalFrameAcademia;
    JDesktopPane dp=new JDesktopPane();
    public frmPrincipal() {
        initComponents();
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
        menuCalificacion = new javax.swing.JMenu();
        itemNuevaCalif = new javax.swing.JMenuItem();
        itemConsultarCal = new javax.swing.JMenuItem();
        menuReporte = new javax.swing.JMenu();
        itemReporte = new javax.swing.JMenuItem();
        menuAcademia = new javax.swing.JMenu();
        itemReporte1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logopeqM.jpg"))); // NOI18N

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap(1097, Short.MAX_VALUE)
                .addComponent(lblIcono)
                .addGap(19, 19, 19))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblIcono)
                .addContainerGap(569, Short.MAX_VALUE))
        );

        lblBarra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.jpg"))); // NOI18N

        menuRegistro.setText("Registro de Estudiantes");

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

        menuAcademia.setText("Academia Bíblica");

        itemReporte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemReporte1ActionPerformed(evt);
            }
        });
        menuAcademia.add(itemReporte1);

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
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
        internalFramenNuevoRegistro.pack();
        pnlPrincipal.add(internalFramenNuevoRegistro);
        internalFramenNuevoRegistro.show();
    }//GEN-LAST:event_itemNuevoEActionPerformed

    private void itemActualizarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemActualizarEActionPerformed
        internalFrameConsultaRegistro = new JInternalFrameConsultaRegistro();
        internalFrameConsultaRegistro.pack();
        pnlPrincipal.add(internalFrameConsultaRegistro);
        internalFrameConsultaRegistro.show();
    }//GEN-LAST:event_itemActualizarEActionPerformed

    private void itemInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemInscripcionActionPerformed
        internalFrameNuevaInscripcion = new JInternalFrameNuevaInscripcion();
        internalFrameNuevaInscripcion.pack();
        pnlPrincipal.add(internalFrameNuevaInscripcion);
        internalFrameNuevaInscripcion.show();
    }//GEN-LAST:event_itemInscripcionActionPerformed

    private void itemNuevaCalifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevaCalifActionPerformed
        internalFrameIngresaCalificacion = new JInternalFrameIngresaCalificacion();
        internalFrameIngresaCalificacion.pack();
        pnlPrincipal.add(internalFrameIngresaCalificacion);
        internalFrameIngresaCalificacion.show();
        
    }//GEN-LAST:event_itemNuevaCalifActionPerformed

    private void itemConsultarCalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConsultarCalActionPerformed
       internalFrameConsultaCalificacion = new JInternalFrameConsultaCalificacion();
       internalFrameConsultaCalificacion.pack();
       pnlPrincipal.add(internalFrameConsultaCalificacion);
       internalFrameConsultaCalificacion.show();
               
    }//GEN-LAST:event_itemConsultarCalActionPerformed

    private void itemReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReporteActionPerformed
       internalFrameGeneraReporte = new JInternalFrameGeneraReporte();
       internalFrameGeneraReporte.pack();
       pnlPrincipal.add(internalFrameGeneraReporte);
       internalFrameGeneraReporte.show();
    }//GEN-LAST:event_itemReporteActionPerformed

    private void itemReporte1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReporte1ActionPerformed
       internalFrameAcademia = new JInternalFrameAcademy();
       internalFrameAcademia.pack();
       pnlPrincipal.add(internalFrameAcademia);
       internalFrameAcademia.show();
    }//GEN-LAST:event_itemReporte1ActionPerformed

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
