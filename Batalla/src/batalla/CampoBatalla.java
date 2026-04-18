/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batalla;

/**
 *
 * @author thlor
 */
public class CampoBatalla {
    
    private Personaje[] equipoJugador;
    private Personaje[] equipoCPU;
    private String nombreBandoJugador;
    private String nombreBandoCPU;

    public CampoBatalla() {
        equipoJugador = new Personaje[5];
        equipoCPU = new Personaje[5];
        nombreBandoJugador = "";
        nombreBandoCPU = "";
    }

    // ── Inicio ────────────────────────────────────────────────────────────────
    public void iniciar() {
        elegirBando();
        armarEquipoJugador();
        armarEquipoCPU();
        mostrarEquipos();
        ejecutarBatalla();
    }

    // ── Paso 1: elegir bando ──────────────────────────────────────────────────
    private void elegirBando() {
        String menu = "=== HEROES VS VILLANOS ===\n\n"
                + "Elige tu bando:\n"
                + "1) Heroes\n"
                + "2) Villanos";
        int opcion = 0;
        while (opcion < 1 || opcion > 2) {
            IO.mostrar(menu);
            opcion = IO.leerEntero("Ingresa 1 o 2:");
        }
        if (opcion == 1) {
            nombreBandoJugador = "Heroes";
            nombreBandoCPU = "Villanos";
        } else {
            nombreBandoJugador = "Villanos";
            nombreBandoCPU = "Heroes";
        }
    }

    // ── Paso 2: el jugador arma su equipo ─────────────────────────────────────
    private void armarEquipoJugador() {
        IO.mostrar("=== ARMA TU EQUIPO DE " + nombreBandoJugador.toUpperCase() + " ===\n"
                + "Elegiras 5 personajes uno por uno.");
        for (int i = 0; i < 5; i++) {
            IO.mostrar("--- Personaje " + (i + 1) + " de 5 ---");
            Personaje p = null;
            if (nombreBandoJugador.equals("Heroes")) {
                p = elegirHeroe();
            } else {
                p = elegirVillano();
            }
            String nombre = IO.leerCadena("Nombre para este personaje:");
            p.setNombre(nombre);
            equipoJugador[i] = p;
            IO.mostrar("Personaje creado:\n  " + p.toString());
        }
    }

    private Personaje elegirHeroe() {
        String menu = "Tipo de heroe:\n"
                + "1) Guerrero  - alto ataque y defensa\n"
                + "2) Mago      - alto dano magico\n"
                + "3) Arquero   - ataques rapidos multiples";
        int opcion = 0;
        while (opcion < 1 || opcion > 3) {
            IO.mostrar(menu);
            opcion = IO.leerEntero("Ingresa 1, 2 o 3:");
        }
        if (opcion == 1) {
            Guerrero g = new Guerrero();
            g.setNivel(10);
            g.setVida(230);
            g.setAtaque(78);
            g.setDefensa(28);
            g.setDebilidadElemental("");
            g.setNeutralElemental("");
            g.setResistenciaElemental("");
            g.setDebilidadFisica("");
            g.setNeutralFisica("");
            g.setResistenciaFisica("");
            
            return g;
        } else if (opcion == 2) {
            Mago m = new Mago();
            m.setNivel(10);
            m.setVida(170);
            m.setAtaque(52);
            m.setDefensa(11);
            m.setMana(180);
            m.setPoderMagico(130);
            m.setDebilidadElemental("");
            m.setNeutralElemental("");
            m.setResistenciaElemental("");
            m.setDebilidadFisica("");
            m.setNeutralFisica("");
            m.setResistenciaFisica("");
            return m;
        } else {
            Arquero a = new Arquero();
            a.setNivel(10);
            a.setVida(195);
            a.setAtaque(78);
            a.setDefensa(20);
            a.setFlechas(18);
            a.setDebilidadElemental("");
            a.setNeutralElemental("");
            a.setResistenciaElemental("");
            a.setDebilidadFisica("");
            a.setNeutralFisica("");
            a.setResistenciaFisica("");
            return a;
        }
    }

    private Personaje elegirVillano() {
        String menu = "Tipo de villano:\n"
                + "1) Jefe Final - alta vida y habilidades especiales\n"
                + "2) Esbirro    - rapido y furtivo";
        int opcion = 0;
        while (opcion < 1 || opcion > 2) {
            IO.mostrar(menu);
            opcion = IO.leerEntero("Ingresa 1 o 2:");
        }
        if (opcion == 1) {
            JefeFinal j = new JefeFinal();
            j.setNivel(14);
            j.setVida(430);
            j.setAtaque(92);
            j.setDefensa(29);
            j.setNombreHabilidad(IO.leerCadena("Nombre de su habilidad especial:"));
            return j;
        } else {
            Esbirro e = new Esbirro();
            e.setNivel(6);
            e.setVida(130);
            e.setAtaque(70);
            e.setDefensa(10);
            e.setVelocidadAtaque(15);
            return e;
        }
    }

    // ── Paso 3: CPU arma el equipo contrario ──────────────────────────────────
    private void armarEquipoCPU() {
        if (nombreBandoCPU.equals("Villanos")) {
            JefeFinal j1 = new JefeFinal();
            j1.setNombre("Sauron");
            j1.setNivel(15);
            j1.setVida(450);
            j1.setAtaque(95);
            j1.setDefensa(30);
            j1.setNombreHabilidad("Golpe Definitivo");
            j1.setDebilidadElemental("");
            j1.setNeutralElemental("");
            j1.setResistenciaElemental("");
            j1.setDebilidadFisica("");
            j1.setNeutralFisica("");
            j1.setResistenciaFisica("");
            equipoCPU[0] = j1;

            JefeFinal j2 = new JefeFinal();
            j2.setNombre("Thanos");
            j2.setNivel(14);
            j2.setVida(420);
            j2.setAtaque(90);
            j2.setDefensa(28);
            j2.setNombreHabilidad("Punio del Infinito");
            j2.setDebilidadElemental("");
            j2.setNeutralElemental("");
            j2.setResistenciaElemental("");
            j2.setDebilidadFisica("");
            j2.setNeutralFisica("");
            j2.setResistenciaFisica("");
            equipoCPU[1] = j2;

            Esbirro e1 = new Esbirro();
            e1.setNombre("Uruk");
            e1.setNivel(5);
            e1.setVida(130);
            e1.setAtaque(70);
            e1.setDefensa(10);
            e1.setVelocidadAtaque(15);
            e1.setDebilidadElemental("");
            e1.setNeutralElemental("");
            e1.setResistenciaElemental("");
            e1.setDebilidadFisica("");
            e1.setNeutralFisica("");
            e1.setResistenciaFisica("");
            equipoCPU[2] = e1;

            Esbirro e2 = new Esbirro();
            e2.setNombre("Orc");
            e2.setNivel(5);
            e2.setVida(120);
            e2.setAtaque(65);
            e2.setDefensa(9);
            e2.setVelocidadAtaque(12);
            e2.setDebilidadElemental("");
            e2.setNeutralElemental("");
            e2.setResistenciaElemental("");
            e2.setDebilidadFisica("");
            e2.setNeutralFisica("");
            e2.setResistenciaFisica("");
            equipoCPU[3] = e2;

            Esbirro e3 = new Esbirro();
            e3.setNombre("Goblin");
            e3.setNivel(4);
            e3.setVida(110);
            e3.setAtaque(60);
            e3.setDefensa(8);
            e3.setVelocidadAtaque(10);
            e3.setDebilidadElemental("");
            e3.setNeutralElemental("");
            e3.setResistenciaElemental("");
            e3.setDebilidadFisica("");
            e3.setNeutralFisica("");
            e3.setResistenciaFisica("");
            equipoCPU[4] = e3;

        } else {
            Guerrero g1 = new Guerrero();
            g1.setNombre("Thor");
            g1.setNivel(10);
            g1.setVida(250);
            g1.setAtaque(80);
            g1.setDefensa(30);
            g1.setDebilidadElemental("");
            g1.setNeutralElemental("");
            g1.setResistenciaElemental("");
            g1.setDebilidadFisica("");
            g1.setNeutralFisica("");
            g1.setResistenciaFisica("");
            equipoCPU[0] = g1;

            Guerrero g2 = new Guerrero();
            g2.setNombre("Ares");
            g2.setNivel(8);
            g2.setVida(230);
            g2.setAtaque(75);
            g2.setDefensa(28);
            g2.setDebilidadElemental("");
            g2.setNeutralElemental("");
            g2.setResistenciaElemental("");
            g2.setDebilidadFisica("");
            g2.setNeutralFisica("");
            g2.setResistenciaFisica("");
            equipoCPU[1] = g2;

            Mago m1 = new Mago();
            m1.setNombre("Gandalf");
            m1.setNivel(12);
            m1.setVida(180);
            m1.setAtaque(55);
            m1.setDefensa(12);
            m1.setMana(180);
            m1.setPoderMagico(140);
            m1.setDebilidadElemental("");
            m1.setNeutralElemental("");
            m1.setResistenciaElemental("");
            m1.setDebilidadFisica("");
            m1.setNeutralFisica("");
            m1.setResistenciaFisica("");
            equipoCPU[2] = m1;

            Mago m2 = new Mago();
            m2.setNombre("Merlin");
            m2.setNivel(9);
            m2.setVida(165);
            m2.setAtaque(50);
            m2.setDefensa(10);
            m2.setMana(180);
            m2.setPoderMagico(120);
            m2.setDebilidadElemental("");
            m2.setNeutralElemental("");
            m2.setResistenciaElemental("");
            m2.setDebilidadFisica("");
            m2.setNeutralFisica("");
            m2.setResistenciaFisica("");
            equipoCPU[3] = m2;

            Arquero a1 = new Arquero();
            a1.setNombre("Legolas");
            a1.setNivel(11);
            a1.setVida(195);
            a1.setAtaque(78);
            a1.setDefensa(20);
            a1.setFlechas(18);
            a1.setDebilidadElemental("");
            a1.setNeutralElemental("");
            a1.setResistenciaElemental("");
            a1.setDebilidadFisica("");
            a1.setNeutralFisica("");
            a1.setResistenciaFisica("");
            equipoCPU[4] = a1;
        }
    }

    // ── Paso 4: mostrar equipos antes de empezar ──────────────────────────────
    private void mostrarEquipos() {
        String msg = "=== TU EQUIPO (" + nombreBandoJugador.toUpperCase() + ") ===\n";
        for (int i = 0; i < equipoJugador.length; i++) {
            msg += "  " + equipoJugador[i].toString() + "\n";
        }
        msg += "\n=== EQUIPO CPU (" + nombreBandoCPU.toUpperCase() + ") ===\n";
        for (int i = 0; i < equipoCPU.length; i++) {
            msg += "  " + equipoCPU[i].toString() + "\n";
        }
        IO.mostrar(msg);
    }

    // ── Batalla principal ─────────────────────────────────────────────────────
    private void ejecutarBatalla() {
        int turno = 1;
        while (hayVivos(equipoJugador) && hayVivos(equipoCPU)) {
            IO.mostrar("============================================\n"
                    + "              TURNO " + turno + "\n"
                    + "============================================");
            turnoJugador();
            if (hayVivos(equipoCPU)) {
                turnoCPU();
            }
            mostrarEstadoTurno(turno);
            turno++;
        }
        mostrarResultado();
    }

    // ── Turno del jugador: cada personaje vivo actua ──────────────────────────
    private void turnoJugador() {
        IO.mostrar("--- Tu turno (" + nombreBandoJugador + ") ---");
        for (int i = 0; i < equipoJugador.length; i++) {
            if (equipoJugador[i].estaVivo() && hayVivos(equipoCPU)) {
                accionPersonaje(equipoJugador[i]);
            }
        }
    }

    private void accionPersonaje(Personaje atacante) {
        // Estado actual
        String estado = "Tu personaje activo:\n  " + atacante.toString() + "\n\n";
        estado += "Enemigos vivos:\n";
        for (int i = 0; i < equipoCPU.length; i++) {
            if (equipoCPU[i].estaVivo()) {
                estado += "  " + equipoCPU[i].toString() + "\n";
            }
        }
        IO.mostrar(estado);

        // Elegir accion
        String menuAccion = atacante.getNombre() + ", elige accion:\n"
                + "1) Ataque normal\n"
                + "2) Habilidad especial";
        int accion = 0;
        while (accion < 1 || accion > 2) {
            IO.mostrar(menuAccion);
            accion = IO.leerEntero("Ingresa 1 o 2:");
        }

        // Elegir objetivo
        Personaje objetivo = elegirObjetivoJugador();

        // Ejecutar y mostrar resultado
        String resultado = "";
        if (accion == 1) {
            resultado = atacante.atacar(objetivo);
        } else {
            resultado = atacante.habilidadEspecial(objetivo);
        }
        if (!objetivo.estaVivo()) {
            resultado += "\n  >> " + objetivo.getNombre() + " ha sido DERROTADO!";
        }
        IO.mostrar(resultado);
    }

    private Personaje elegirObjetivoJugador() {
        int[] indicesVivos = new int[5];
        int contador = 0;
        String menu = "Elige tu objetivo:\n";
        for (int i = 0; i < equipoCPU.length; i++) {
            if (equipoCPU[i].estaVivo()) {
                indicesVivos[contador] = i;
                contador++;
                menu += "  " + contador + ") " + equipoCPU[i].getNombre()
                        + "  HP: " + equipoCPU[i].getVida() + "/" + equipoCPU[i].getVidaMaxima() + "\n";
            }
        }
        int opcion = 0;
        while (opcion < 1 || opcion > contador) {
            IO.mostrar(menu);
            opcion = IO.leerEntero("Ingresa un numero del 1 al " + contador + ":");
        }
        return equipoCPU[indicesVivos[opcion - 1]];
    }

    // ── Turno del CPU: ataca automaticamente ──────────────────────────────────
    private void turnoCPU() {
        String log = "--- Turno CPU (" + nombreBandoCPU + ") ---\n";
        for (int i = 0; i < equipoCPU.length; i++) {
            if (equipoCPU[i].estaVivo() && hayVivos(equipoJugador)) {
                Personaje objetivo = elegirObjetivoCPU();
                if (objetivo != null) {
                    int azar = (int) (Math.random() * 10);
                    if (azar < 3) {
                        log += equipoCPU[i].habilidadEspecial(objetivo) + "\n";
                    } else {
                        log += equipoCPU[i].atacar(objetivo) + "\n";
                    }
                    if (!objetivo.estaVivo()) {
                        log += "  >> " + objetivo.getNombre() + " ha sido DERROTADO!\n";
                    }
                }
            }
        }
        IO.mostrar(log);
    }

    private Personaje elegirObjetivoCPU() {
        int vivos = contarVivos(equipoJugador);
        if (vivos == 0) {
            return null;
        }
        int[] indicesVivos = new int[vivos];
        int idx = 0;
        for (int i = 0; i < equipoJugador.length; i++) {
            if (equipoJugador[i].estaVivo()) {
                indicesVivos[idx] = i;
                idx++;
            }
        }
        int elegido = (int) (Math.random() * vivos);
        return equipoJugador[indicesVivos[elegido]];
    }

    // ── Resumen del turno ─────────────────────────────────────────────────────
    private void mostrarEstadoTurno(int turno) {
        String msg = "--- Estado tras el turno " + turno + " ---\n";
        msg += "Tu equipo vivo : " + contarVivos(equipoJugador) + "/5\n";
        msg += "CPU vivo       : " + contarVivos(equipoCPU) + "/5\n";
        IO.mostrar(msg);
    }

    // ── Resultado final ───────────────────────────────────────────────────────
    private void mostrarResultado() {
        String ganador = "";
        String perdedor = "";
        if (hayVivos(equipoJugador)) {
            ganador = nombreBandoJugador + " (TU)";
            perdedor = nombreBandoCPU + " (CPU)";
        } else {
            ganador = nombreBandoCPU + " (CPU)";
            perdedor = nombreBandoJugador + " (TU)";
        }

        String msg = "============================================\n"
                + "          FIN DE LA BATALLA\n"
                + "============================================\n\n"
                + "GANADOR : " + ganador + "\n"
                + "PERDEDOR: " + perdedor + "\n\n";

        msg += "=== Estado final - Tu equipo ===\n";
        for (int i = 0; i < equipoJugador.length; i++) {
            msg += "  " + equipoJugador[i].toString() + "\n";
        }
        msg += "\n=== Estado final - CPU ===\n";
        for (int i = 0; i < equipoCPU.length; i++) {
            msg += "  " + equipoCPU[i].toString() + "\n";
        }
        IO.mostrar(msg);
    }

    // ── Utilidades ────────────────────────────────────────────────────────────
    private boolean hayVivos(Personaje[] equipo) {
        boolean vivo = false;
        for (int i = 0; i < equipo.length; i++) {
            if (equipo[i].estaVivo()) {
                vivo = true;
            }
        }
        return vivo;
    }

    private int contarVivos(Personaje[] equipo) {
        int count = 0;
        for (int i = 0; i < equipo.length; i++) {
            if (equipo[i].estaVivo()) {
                count++;
            }
        }
        return count;
    }
}
