/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batalla;

import javax.swing.JOptionPane;

/**
 *
 * @author thlor
 */
public class IO {
    // Atributos
    
    // Metodos
    
    public static void mostrar(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public static void mostrar(char msg){
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public static int leerEntero(String msg) {
        int entero = Integer.parseInt(JOptionPane.showInputDialog(msg));
        return entero;
    }
    
    public static double leerReal(String msg) {
        Double real = Double.parseDouble(JOptionPane.showInputDialog(msg));
        return real;
    }
    
    public static String leerCadena(String msg){
        String cadena = JOptionPane.showInputDialog(msg);
        return cadena;
    }
    
    public static char leerCaracter(String msg){
        return JOptionPane.showInputDialog(msg).trim().toUpperCase().charAt(0);
    }
    
}
