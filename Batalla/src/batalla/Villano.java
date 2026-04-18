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
    protected String claseVillano;
    
    // Metodos
    
        // Constructor
    
    public Villano(){
        
    }
    
    // Metodos Abstractos
    @Override
    public final String getTipo() {
        return "Villano - " + claseVillano;
    }

    public String getClaseVillano() {
        return claseVillano;
    }
}
