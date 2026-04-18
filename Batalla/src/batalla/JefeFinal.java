/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batalla;

/**
 *
 * @author thlor
 */

// Que mejor que JefeFinal sea una clase final

public class JefeFinal extends Villano {
    // Atributos
    private String nombreHabilidad;
    
    // Metodos
    
        // Constructor
    public JefeFinal() {
        super();
        claseVillano = "Jefe Final";
        nombreHabilidad = "";
    }
        // Habilidad Especial
    
    @Override
    public String habilidadEspecial(Personaje objetivo) {
        int curacion = vidaMaxima / 10;
        if (curacion < 1) {
            curacion = 1;
        }

        int danioBase = (int) (ataque * 1.8);
        
        String tipoDanioElemental="OSCURO";
        String tipoDanioFisico= "CONTUNDENTE";
        
        int danioAplicado = calcularDanioElementalFisico(danioBase, objetivo, tipoDanioElemental, tipoDanioFisico);
        
        if (danioAplicado < 0) {
            danioAplicado = 0;
        }
        objetivo.recibirDanio(danioAplicado);

        vida += curacion;

        String msg = "*** " + nombre + " usa [" + nombreHabilidad.toUpperCase() + "] sobre " + objetivo.getNombre();
        msg += "  ->  Dano: " + danioAplicado + " (ignora mitad defensa)";
        msg += "  |  HP " + objetivo.getNombre() + ": " + objetivo.getVida() + "/" + objetivo.getVidaMaxima();
        msg += "\n   " + nombre + " Ha Recuperado " + curacion + " HP | HP: " + vida + "/" + vidaMaxima;
        return msg;
    }
    
        // toString
    
    @Override
    public String toString() {
        String msg = super.toString();
        msg += " | Habilidad: " + nombreHabilidad;
        return msg;
    }
    
        // Getter
    public String getNombreHabilidad() {
        return nombreHabilidad;
    }
        // Setter 
    public void setNombreHabilidad(String nombreHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
    }
    
    
    
    
}
