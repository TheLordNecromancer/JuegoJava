/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batalla;

/**
 *
 * @author thlor
 */
public abstract class Villano extends Personaje {
    
    // Atributos
    
    // Metodos
    
    public Villano(){
        
    }
    
    // Metodos Abstractos
    
    @Override
    public abstract void atacar();
    
    @Override
    public abstract void calcularDanoRecibido();
    
}
