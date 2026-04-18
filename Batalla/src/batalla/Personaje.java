/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batalla;

/**
 *
 * @author thlor
 */
public abstract class Personaje {
    // Atributos
    
    protected String nombre;
    protected int nivel;
    protected int hp;
    protected int ataque;
    protected int defensa;
    
    // Metodos
    
        // Constructor que inicializa atributos
    
    public Personaje() {
        nombre = "";
        nivel = 0;
        hp = 0;
        ataque = 0;
        defensa = 0;
    }
    
        // Getters 

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getHp() {
        return hp;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }
    
        // Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
    
        // Metodos abstractos
    
    public abstract void atacar();
    
    public abstract void calcularDanoRecibido();
    
    
}
