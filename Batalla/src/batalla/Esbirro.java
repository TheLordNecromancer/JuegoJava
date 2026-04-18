/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batalla;

/**
 *
 * @author thlor
 */
public class Esbirro extends Villano {
    // Atributos
    private int velocidadAtaque;
    
    // Metodos
    
        // Constructor
    public Esbirro() {
        super();
        claseVillano = "Esbirro";
        velocidadAtaque = 0;
    }
    
        // Habilidad Esta habilidad recupera la vida del jefe, por lo que necesita de atributo del jefe villano
    
    public String habilidadEspecial(Personaje objetivo) {
        int danioEnviado = ataque + velocidadAtaque + (objetivo.getDefensa()/2);

        if (danioEnviado < 0) {
            danioEnviado = 0;
        }
        objetivo.recibirDanio(danioEnviado);
        
        String msg = "*** " + nombre + " usa [LIMPIANDO EL CAMINO DE MI SEÑOR] sobre " + objetivo.getNombre();
        msg += "  ->  Dano : " + danioEnviado;
        msg += "  |  HP " + objetivo.getNombre() + ": " + objetivo.getVida() + "/" + objetivo.getVidaMaxima();
        return msg;
    }
    
    public String habilidadEspecial(Personaje objetivo, Personaje curado) {
        int danioEnviado = ataque + velocidadAtaque + (objetivo.getDefensa()/2);

        if (danioEnviado < 0) {
            danioEnviado = 0;
        }
        objetivo.recibirDanio(danioEnviado);
        
        int vidaCurado = curado.getVida() + danioEnviado;
        
        if ((vidaCurado+curado.getVida())>curado.getVidaMaxima()){
            curado.setVida(curado.getVidaMaxima());
        } 
        
        String msg = "*** " + nombre + " usa [DESEO ABRIR EL CAMINO DE MI SEÑOR] sobre " + objetivo.getNombre();
        msg += "  ->  Dano : " + danioEnviado;
        msg += "  |  HP " + objetivo.getNombre() + ": " + objetivo.getVida() + "/" + objetivo.getVidaMaxima();
        msg += "\n" + curado.getNombre() + " Ha Recuperado " + vidaCurado + " HP | HP: " + curado.getVida() + "/" + curado.getVidaMaxima();
        return msg;
    }

    // Extiende el toString del padre agregando el atributo propio
    @Override
    public String toString() {
        String msg = super.toString();
        msg += " | VelocidadAtaque: " + velocidadAtaque;
        return msg;
    }

    public void setVelocidadAtaque(int velocidadAtaque) {
        this.velocidadAtaque = velocidadAtaque;
    }

    public int getVelocidadAtaque() {
        return velocidadAtaque;
    }
}
