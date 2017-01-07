/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soporte;

import java.awt.event.KeyEvent;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class metodosSoporte {
    public void soloNumeros(java.awt.event.KeyEvent evt){
        char c=evt.getKeyChar();
        if(!(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
            evt.consume();
        }
    }
    
    public boolean validacionCedula(String cedula){
        if (cedula.length() > 10 || cedula.length() < 10
                || !Pattern.matches("[0-9]+", cedula)) {
            return false;
        }
        else{
            char numerosCI [] = new char [10];
            cedula.getChars(0, 10, numerosCI, 0);
            return luhn(charsANumeros(numerosCI));
        }
    }
    
    private static int[] charsANumeros(char[] chars) {
        int [] numeros = new int [chars.length];
        for (int i = 0; i < numeros.length; i++) {
                numeros[i] = (int) (chars[i]) - 48;
            }
        return numeros;
    }
    
    private static boolean luhn(int numeros[]){
        int numVerificacion = numeros[numeros.length - 1];
        int suma = 0;

        for (int i = 0; i < numeros.length - 1; i+=2) {
            numeros[i] = numeros[i]*2;
            if(numeros[i] > 9){
                numeros[i] -= 9;
            }
        }

        for (int i = 0; i < numeros.length - 1; i++) {
            suma += numeros[i];
        }

        int resultado = 10 - suma%10;
        resultado = (resultado < 10)? resultado : 0;

        return (resultado == numVerificacion);
    }
    
    public void validacionCorreo(){
        
    }
}
