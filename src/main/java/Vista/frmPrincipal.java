package Vista;

import java.awt.Color;
import javax.swing.JDesktopPane;

public class frmPrincipal extends javax.swing.JFrame{
    JGenericInternalFrame internalFrame;
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
        lblBarra = new javax.swing.JLabel();
        lblIcono = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1103, Short.MAX_VALUE)
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 591, Short.MAX_VALUE)
        );

        lblBarra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.jpg"))); // NOI18N

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logopeqM.jpg"))); // NOI18N

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
        menuInscripcion.add(itemInscripcion);

        MenuBarPrincipal.add(menuInscripcion);

        menuCalificacion.setText("Calificaciones");

        itemNuevaCalif.setText("Ingresar calificaciones");
        menuCalificacion.add(itemNuevaCalif);

        itemConsultarCal.setText("Consultar/Actualizar Calificaciones");
        menuCalificacion.add(itemConsultarCal);

        MenuBarPrincipal.add(menuCalificacion);

        menuReporte.setText("Reporte");

        itemReporte.setText("Generar reporte");
        menuReporte.add(itemReporte);

        MenuBarPrincipal.add(menuReporte);

        menuAcademia.setText("Academia Bíblica");
        MenuBarPrincipal.add(menuAcademia);

        setJMenuBar(MenuBarPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIcono))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(lblBarra)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIcono)
                    .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(lblBarra))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemNuevoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoEActionPerformed
        internalFrame=new JGenericInternalFrame("itemNuevoE");
        internalFrame.pack();
        dp.add(internalFrame);
        
    }//GEN-LAST:event_itemNuevoEActionPerformed

    private void itemActualizarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemActualizarEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemActualizarEActionPerformed

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
