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
    
        // Enteros
    protected int vidaMaxima;
    protected int vida;
    protected int nivel;
    protected int ataque;
    protected int defensa;
    
        // String
    
            // Detalles
    protected String nombre;
    
            // Debilidad
    protected String debilidadElemental; // Elemento OSCURO, DIVINO, VACIO
    protected String neutralElemental; 
    protected String resistenciaElemental;
    protected String debilidadFisica; // Tipos CONTUNDENTE, CORTANTE, PERFORANTE
    protected String neutralFisica;
    protected String resistenciaFisica;
    
    // Metodos
    
        // Constructor
    public Personaje(){
        vidaMaxima = 0;
        vida = 0;
        nivel = 0;
        ataque = 0;
        defensa = 0;
        
        nombre = "";
        debilidadElemental = "";
        resistenciaElemental = "";
        debilidadFisica = "";
        resistenciaFisica = "";      
    }
    
        // Finales
    
    public final boolean estaVivo(){
        boolean estaVivo = (vida>0);
        return estaVivo;
    }
    
    public final void recibirDanio(int danio){
        int danioRecibido = danio- danio*(defensa/100);
        if (danioRecibido<0)
            danioRecibido=0;
        vida -= danioRecibido;
        if(vida<0)
            vida=0;
    }
    
    public final void recibirDanioVerdadero(int danio){
        vida -= danio;
        if (vida<0)
            vida=0;
    }
    
    public final String atacar(Personaje objetivo){
        int danioAplicado = ataque - ataque*(objetivo.getDefensa()/100);
        if (danioAplicado<0)
            danioAplicado=0;
        
        objetivo.recibirDanio(ataque);
        String msg = nombre + " ataca a " + objetivo.getNombre();
        msg += "  ->  Daño: " + danioAplicado;
        msg += "  |  HP " + objetivo.getNombre() + ": " + objetivo.getVida() + "/" + objetivo.getVidaMaxima();
        return msg;
   }
    
    public final String atacar(Personaje objetivo, String danioElemental, String danioFisico) {
        int danioAplicado = calcularDanioElementalFisico(ataque, objetivo, danioElemental, danioFisico);
        danioAplicado = danioAplicado - danioAplicado*(objetivo.getDefensa()/100);
        if (danioAplicado<0)
            danioAplicado=0;
        
        objetivo.recibirDanio(danioAplicado);
        String msg = nombre + " ataca a " + objetivo.getNombre();
        msg += "  ->  Daño: " + danioAplicado;
        msg += "  |  HP " + objetivo.getNombre() + ": " + objetivo.getVida() + "/" + objetivo.getVidaMaxima();
        return msg;
    }
    
    public final void calcularDanio(int danio){
        recibirDanio(danio);
    }
    public final int calcularDanioElementalFisico(int danio, Personaje objetivo, String dE, String dF) {
        if (dF.equals(objetivo.getDebilidadFisica()) && dE.equals(objetivo.getDebilidadElemental())) {
            danio *= 4;
            return danio;
        } else if(dF.equals(objetivo.getDebilidadFisica()) && dE.equals(objetivo.getNeutralElemental())) {
            danio *= 1.5;
            return danio;
        } else if(dF.equals(objetivo.getDebilidadFisica()) && dE.equals(objetivo.getResistenciaElemental())){
            danio *= 1;
            return danio;
        } else if(dF.equals(objetivo.getNeutralFisica()) && dE.equals(objetivo.getDebilidadElemental())){
            danio *= 1.5;
            return danio;
        } else if(dF.equals(objetivo.getNeutralFisica()) && dE.equals(objetivo.getNeutralElemental())){
            danio *= 1;
            return danio;
        } else if(dF.equals(objetivo.getNeutralFisica()) && dE.equals(objetivo.getResistenciaElemental())){
            danio *= 0.5;
            return danio;
        } else if(dF.equals(objetivo.getResistenciaFisica()) && dE.equals(objetivo.getDebilidadElemental())){
            danio *= 0.75;
            return danio;
        } else if(dF.equals(objetivo.getResistenciaFisica()) && dE.equals(objetivo.getNeutralElemental())){
            danio *= 0.5;
            return danio;
        } else if(dF.equals(objetivo.getResistenciaFisica()) && dE.equals(objetivo.getResistenciaElemental())){
            danio *= 0.25;
            return danio;
        }
        return danio;
    }
    
        // Abstractos 
    
    public abstract String habilidadEspecial(Personaje objetivo);

    public abstract String getTipo();
    
        // Getters

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int getVida() {
        return vida;
    }

    public int getNivel() {
        return nivel;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDebilidadElemental() {
        return debilidadElemental;
    }

    public String getNeutralElemental() {
        return neutralElemental;
    }

    public String getResistenciaElemental() {
        return resistenciaElemental;
    }

    public String getDebilidadFisica() {
        return debilidadFisica;
    }

    public String getNeutralFisica() {
        return neutralFisica;
    }

    public String getResistenciaFisica() {
        return resistenciaFisica;
    }
    
        // Setters

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDebilidadElemental(String debilidadElemental) {
        debilidadElemental = debilidadElemental.toUpperCase();
        this.debilidadElemental = debilidadElemental;
    }

    public void setNeutralElemental(String neutralElemental) {
        neutralElemental = neutralElemental.toUpperCase();
        this.neutralElemental = neutralElemental;
    }

    public void setResistenciaElemental(String resistenciaElemental) {
        resistenciaElemental = resistenciaElemental.toUpperCase();
        this.resistenciaElemental = resistenciaElemental;
    }

    public void setDebilidadFisica(String debilidadFisica) {
        debilidadFisica = debilidadFisica.toUpperCase();
        this.debilidadFisica = debilidadFisica;
    }

    public void setNeutralFisica(String neutralFisica) {
        neutralFisica = neutralFisica.toUpperCase();
        this.neutralFisica = neutralFisica;
    }

    public void setResistenciaFisica(String resistenciaFisica) {
        resistenciaFisica = resistenciaFisica.toUpperCase();
        this.resistenciaFisica = resistenciaFisica;
    }
    
    // to String 
    
    @Override
    public String toString() {
        String estado = "";
        if (estaVivo()) {
            estado = "[VIVO]";
        } else {
            estado = "[CAIDO]";
        }
        String msg = nombre + " (Nv." + nivel + ") ";
        msg += "HP:" + vida + "/" + vidaMaxima + " ";
        msg += "ATK:" + ataque + " DEF:" + defensa + " ";
        msg += estado + " [" + getTipo() + "]";
        return msg;
    }
}
