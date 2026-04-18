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
    
    protected String claseHeroe;
    // Metodos
    
        // Constructor
    public Heroe(){
        
    }
    
        // Implementación metodos abstractos
    @Override
    public final String getTipo() {
        return "Heroe - " + claseHeroe;
    }

    public String getClaseHeroe() {
        return claseHeroe;
    }
}
