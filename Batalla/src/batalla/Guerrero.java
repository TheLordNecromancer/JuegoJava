/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batalla;

/**
 *
 * @author thlor
 */
public class Guerrero extends Heroe {
    
    // Atributos
    
    private final double MULTIPLICADOR_DANIO = 2;
    
    // Metodos
    
    public Guerrero() {
        super();
        claseHeroe = "Guerrero";
        
    }
    
    @Override
    public String habilidadEspecial(Personaje objetivo) {
        int danio = (int) (ataque * MULTIPLICADOR_DANIO);
        
        String tipoDanioElemental = "VACIO";
        String tipoDanioFisico = "CORTANTE";
        
        danio = calcularDanioElementalFisico(danio, objetivo, tipoDanioElemental, tipoDanioFisico);
        
        String msg = "*** " + nombre + " usa [CASTIGAR LA DEFENSA] sobre " + objetivo.getNombre();
        msg += "  ->  Dano: " + danio;
        msg += "  |  HP " + objetivo.getNombre() + ": " + objetivo.getVida() + "/" + objetivo.getVidaMaxima();
        return msg;
    }
}
