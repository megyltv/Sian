/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soporte;

import Vista.Registro.JInternalFrameNuevoRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class botonListener {
    JRadioButton btn;
    JTextField txtRazon;
    
    public botonListener(){
        txtRazon = new JTextField();
    }
    
    public void Listener(JRadioButton btn, JTextField txt, boolean opcion){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                     txt.setEnabled(opcion);
        }});
    }
}
