/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batalla;

/**
 *
 * @author thlor
 */
public class Mago extends Heroe {
    
    private int mana;
    private int poderMagico;
    private static final int COSTO_MANA = 30;

    public Mago() {
        super();
        claseHeroe = "Mago";
        mana = 0;
        poderMagico = 0;
    }

    @Override
    public String habilidadEspecial(Personaje objetivo) {
        if (mana >= COSTO_MANA) {
            mana -= COSTO_MANA;
            
            String tipoDanioElemental = "DIVINO";
            String tipoDanioFisico = "CONTUNDENTE";
            
            int poder = calcularDanioElementalFisico(ataque, objetivo, tipoDanioElemental, tipoDanioFisico);
            objetivo.recibirDanio(poder);
            
            
            String msg = "*** " + nombre + " lanza [ORBE DIVINO] sobre " + objetivo.getNombre();
            msg += "  ->  Dano magico: " + poder;
            msg += "  |  HP " + objetivo.getNombre() + ": " + objetivo.getVida() + "/" + objetivo.getVidaMaxima();
            msg += "  [Mana restante: " + mana + "]";
            return msg;
        } else {
            return atacar(objetivo) + "  [Sin mana, ataque fisico]";
        }
    }

    @Override
    public String toString() {
        String msg = super.toString();
        msg += " | Mana: " + mana + " PoderMagico: " + poderMagico;
        return msg;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setPoderMagico(int poderMagico) {
        this.poderMagico = poderMagico;
    }

    public int getMana() {
        return mana;
    }

    public int getPoderMagico() {
        return poderMagico;
    }
}
