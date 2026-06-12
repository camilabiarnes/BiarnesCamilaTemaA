package com.ulp;
import java.util.ArrayList;
import java.util.List;

public abstract class Personaje extends ElementoJuego {
  protected int energia;
    protected int vidas;
    protected int capacidadOfensiva;
    protected int ancho;
    protected int alto;
    protected String textura;
    protected List<String> habilidadesEspeciales;
    protected List<String> habilidadesNormales;

    public Personaje(int x, int y, int energia, int vidas, int capacidadOfensiva, int ancho, int alto, String textura) {
        super(x, y);
        this.energia = energia;
        this.vidas = vidas;
        this.capacidadOfensiva = capacidadOfensiva;
        this.ancho = ancho;
        this.alto = alto;
        this.textura = textura;
        this.habilidadesEspeciales = new ArrayList<>();
        this.habilidadesNormales = new ArrayList<>();
    }

    public int getEnergia() { return energia; }
    public void setEnergia(int energia) { this.energia = energia; }
    public int getVidas() { return vidas; }
    public void setVidas(int vidas) { this.vidas = vidas; }
    public int getCapacidadOfensiva() { return capacidadOfensiva; }

    public void caminar(int nuevoX, int nuevoY) { this.x = nuevoX; this.y = nuevoY; }
    public void correr(int nuevoX, int nuevoY) { this.x = nuevoX * 2; this.y = nuevoY * 2; }
    public void saltar() { this.y += 5; }
}

class Mochila {
    private int capacidad;
    private List<ObjetoMovil> items;

    public Mochila(int capacidadInicial) {
        this.capacidad = capacidadInicial;
        this.items = new ArrayList<>();
    }

    public boolean guardarItem(ObjetoMovil item) {
        if (items.size() < capacidad) {
            items.add(item);
            return true;
        }
        return false;
    }

    public ObjetoMovil obtenerItem(int indice) {
        if (indice >= 0 && indice < items.size()) {
            return items.get(indice);
        }
        return null;
    }

    public void removerItem(ObjetoMovil item) {
        items.remove(item);
    }

    public void ampliarCapacidad(int cantidad) {
        this.capacidad += cantidad;
    }

    public int getCapacidad() { return capacidad; }
    public List<ObjetoMovil> getItems() { return items; }
}

class Casco {
    private int defensa;
    public Casco(int defensa) { this.defensa = defensa; }
    public int getDefensa() { return defensa; }
}

class Bracero {
    private int defensa;
    public Bracero(int defensa) { this.defensa = defensa; }
    public int getDefensa() { return defensa; }
}

class CubrePierna {
    private int defensa;
    public CubrePierna(int defensa) { this.defensa = defensa; }
    public int getDefensa() { return defensa; }
}

class Armadura {
    private Casco casco;
    private List<Bracero> braceros = new ArrayList<>();
    private List<CubrePierna> cubrePiernas = new ArrayList<>();
    private int duracion = 100;

    public Armadura(Casco casco) { this.casco = casco; }

    public void agregarBracero(Bracero b) { if (braceros.size() < 2) braceros.add(b); }
    public void agregarCubrePierna(CubrePierna c) { if (cubrePiernas.size() < 2) cubrePiernas.add(c); }

    public int calcularDefensaTotal() {
        int total = (casco != null) ? casco.getDefensa() : 0;
        for (Bracero b : braceros) total += b.getDefensa();
        for (CubrePierna c : cubrePiernas) total += c.getDefensa();
        return total;
    }

    public int getDuracion() { return duracion; }
    public void reducirDuracion(int cantidad) { this.duracion -= cantidad; }
}

class Heroe extends Personaje {
    private Mochila mochila;
    private Armadura armadura;
    private Arma armaEquipada;
    private List<Proyectil> reservaProyectiles = new ArrayList<>();

    public Heroe(int x, int y, int energia, int vidas, int capacidadOfensiva, int ancho, int alto, String textura) {
        super(x, y, energia, vidas, capacidadOfensiva, ancho, alto, textura);
        this.mochila = new Mochila(3);
    }

    public Mochila getMochila() { return mochila; }
    public void equiparArma(Arma a) { this.armaEquipada = a; }

    public void equiparArmadura(Armadura armadura) { this.armadura = armadura; }

    public void curarVida(int cantidad) {
        this.energia += cantidad;
        System.out.println("Héroe curado. Energía actual: " + this.energia);
    }

    public void recuperarProyectilesSueltos(List<Proyectil> proyectiles) {
        this.reservaProyectiles.addAll(proyectiles);
    }

    public void atacar(EnemigoComun enemigo) {
        int dañoTotal = this.capacidadOfensiva;
        if (armaEquipada != null && !armaEquipada.estaDestruida()) {
            dañoTotal += armaEquipada.getFactorPotenciador();
            armaEquipada.usar(this);
        }
        System.out.println("Héroe inflige " + dañoTotal + " de daño.");
        enemigo.recibirDanio(dañoTotal);
    }

    public void recibirDanio(int danio) {
        int defensa = 0;
        if (armadura != null) {
            defensa = armadura.calcularDefensaTotal();
            armadura.reducirDuracion(10);
            if (armadura.getDuracion() <= 0) {
                System.out.println("La armadura se ha destruido por completo.");
                this.armadura = null;
            }
        }
        int danioFinal = Math.max(0, danio - defensa);
        this.energia -= danioFinal;
        if (this.energia <= 0) {
            this.vidas--;
            this.energia = 100;
        }
    }
}

class EnemigoComun extends Personaje {
    public EnemigoComun(int x, int y, int energia, int vidas, int capacidadOfensiva, int ancho, int alto, String textura) {
        super(x, y, energia, vidas, capacidadOfensiva, ancho, alto, textura);
    }

    public void recibirDanio(int danio) {
        this.energia -= danio;
        if (this.energia <= 0) {
            this.energia = 0;
            morir();
        }
    }

    private void morir() {
        System.out.println("Enemigo derrotado. Moviendo fuera de escena.");
        this.x = -1;
        this.y = -1;
    }
}

class JefeFinal extends EnemigoComun {
    private int cantidadEvoluciones;
    private int potenciaSuperpoder;
    private boolean vuela;

    public JefeFinal(int x, int y, int energia, int vidas, int capacidadOfensiva, int ancho, int alto, String textura, int cantidadEvoluciones, int potenciaSuperpoder, boolean vuela) {
        super(x, y, energia, vidas, capacidadOfensiva, ancho, alto, textura);
        this.cantidadEvoluciones = cantidadEvoluciones;
        this.potenciaSuperpoder = potenciaSuperpoder;
        this.vuela = vuela;
    }

    public void lanzarSuperpoder(Heroe heroe) {
        System.out.println("¡El Jefe Final lanza un superpoder con potencia: " + potenciaSuperpoder + "!");
        heroe.recibirDanio(this.potenciaSuperpoder);
    }
}