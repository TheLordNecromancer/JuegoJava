/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batalla;

/**
 *
 * @author thlor
 */
public class Arquero extends Heroe {
    // Atributos 
    
    private int flechas;
    
        public Arquero() {
        super();
        claseHeroe = "Arquero";
        flechas = 9;
    }
        
   @Override
    public String habilidadEspecial(Personaje objetivo) {
        int danioPorFlecha;
        if (flechas >= 3) {
            flechas -= 3;
            
            String tipoDanioElemental = "VACIO";
            String tipoDanioFisico = "PERFORANTE";
            
            danioPorFlecha = calcularDanioElementalFisico(ataque, objetivo, tipoDanioElemental, tipoDanioFisico);
            if (danioPorFlecha < 1) {
                danioPorFlecha = 1;
            }
            
            String msg = "*** " + nombre + " usa [LLUVIA DE FLECHAS] sobre " + objetivo.getNombre() + ":\n";
            for (int i = 1; i <= 3; i++) {
                objetivo.recibirDanio(danioPorFlecha);
                msg += "   Flecha " + i + ": " + danioPorFlecha + " dano";
                if (!objetivo.estaVivo()) {
                    msg += "  -> DERROTADO!\n";
                    break;
                } else {
                    msg += "  (HP restante: " + objetivo.getVida() + ")\n";
                }
            }
            msg += "   HP final " + objetivo.getNombre() + ": " + objetivo.getVida() + "/" + objetivo.getVidaMaxima();
            msg += "  [Flechas restantes: " + flechas + "]";
            return msg;
        } else {
            return atacar(objetivo) + "  [Sin flechas, ataque normal]";
        }
    }
    
        // toString
    @Override
    public String toString() {
        String msg = super.toString();
        msg += " | Flechas: " + flechas;
        return msg;
    }
    
    
        // Getter
    public int getFlechas() {
        return flechas;
    }
    
        // Setter
    
    public void setFlechas(int flechas) {
        this.flechas = flechas;
    }
}
