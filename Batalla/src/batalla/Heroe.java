/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batalla;

/**
 *
 * @author thlor
 */
public abstract class Heroe extends Personaje {
    
    // Atributos
    
    
    // Metodos
    
        // Constructor
    public Heroe(){
        
    }

    // Metodos Abstractos
    @Override
    public abstract void atacar();
    
    @Override
    public abstract void calcularDanoRecibido();
    
}
