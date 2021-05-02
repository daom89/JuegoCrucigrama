import java.util.ArrayList;
import java.util.Collections;

public class Partida {

    public enum Nivel { FACIL, NORMAL, DIFICIL }
    private Tablero TableroPartida;
    private Jugador Player;
    private Nivel Dificultad;

    private ArrayList<Palabra> bancoPalabras = new ArrayList<Palabra>();

    public Partida() {
    }

    public Partida(Jugador player, Nivel Dificultad) {
        this.Dificultad = Dificultad;
        this.Player = player;
        crearJuego();
    }

    public Tablero getTableroPartida() {
        return TableroPartida;
    }

    public void setTableroPartida(Tablero tableroPartida) {
        this.TableroPartida = tableroPartida;
    }

    public Jugador getPlayer() {
        return Player;
    }

    public void setPlayer(Jugador player) {
        this.Player = player;
    }

    public Nivel getDificultad() {
        return Dificultad;
    }

    public void setDificultad(Nivel dificultad) {
        Dificultad = dificultad;
    }

    public ArrayList<Palabra> getBancoPalabras() {
        return bancoPalabras;
    }

    public void setBancoPalabras(ArrayList<Palabra> bancoPalabras) {
        this.bancoPalabras = bancoPalabras;
    }

    public void crearJuego(){
        loadBancoPalabras();
        this.TableroPartida = new Tablero(Player, getRandomPalabras(),8);
    }

    private ArrayList<Palabra> getRandomPalabras(){
        Collections.shuffle(this.bancoPalabras); //Desordenamos el Array de Banco de Preguntas
        switch (this.Dificultad){
            case FACIL:
                return new ArrayList<Palabra>(this.bancoPalabras.subList(0, 2));
            case NORMAL:
                return new ArrayList<Palabra>(this.bancoPalabras.subList(0, 4));
            default:
                return this.bancoPalabras;
        }
    }

    private void loadBancoPalabras(){
        bancoPalabras.add(new Palabra("ARRAY", 2, 1, Palabra.Direccion.ESCALONADA, false));
        bancoPalabras.add(new Palabra("JAVA", 0, 6, Palabra.Direccion.VERTICAL, false));
        bancoPalabras.add(new Palabra("CLASE", 1, 5, Palabra.Direccion.VERTICAL, false));
        bancoPalabras.add(new Palabra("HOLA", 0, 3, Palabra.Direccion.ESCALONADA, false));
        bancoPalabras.add(new Palabra("POO", 0, 4, Palabra.Direccion.VERTICAL, false));
        bancoPalabras.add(new Palabra("MUNDO", 1, 0, Palabra.Direccion.HORIZONTAL, false));
        bancoPalabras.add(new Palabra("MATRIZ", 1, 7, Palabra.Direccion.VERTICAL, false));
        bancoPalabras.add(new Palabra("DATO", 3, 1, Palabra.Direccion.ESCALONADA, false));
        bancoPalabras.add(new Palabra("HERENCIA", 7, 0, Palabra.Direccion.HORIZONTAL, false));

    }

}
