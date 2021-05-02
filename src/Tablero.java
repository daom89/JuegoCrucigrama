import java.util.ArrayList;
import java.util.Arrays;

public class Tablero {

    private Jugador gamer;
    private ArrayList<Palabra> palabrasJuego;
    private ArrayList<Palabra> palabrasEncontradas;
    private int dimension = 6;
    private char[][] espacio; //Matiz de la cuadricula

    public Tablero() {
    }

    public Tablero(Jugador gamer, ArrayList<Palabra> palabrasJuego, int dimension) {
        this.gamer = gamer;
        this.palabrasJuego = palabrasJuego;
        this.palabrasEncontradas = new ArrayList<Palabra>();
        this.dimension = dimension;
        this.espacio = new char[dimension][dimension];

        cargarPalabras();
        rellenar();
    }

    public Jugador getGamer() {
        return gamer;
    }

    public void setGamer(Jugador gamer) {
        this.gamer = gamer;
    }

    public ArrayList<Palabra> getPalabrasJuego() {
        return palabrasJuego;
    }

    public void setPalabrasJuego(ArrayList<Palabra> palabrasJuego) {
        this.palabrasJuego = palabrasJuego;
    }

    public ArrayList<Palabra> getPalabrasEncontradas() {
        return palabrasEncontradas;
    }

    public void setPalabrasEncontradas(ArrayList<Palabra> palabrasEncontradas) {
        this.palabrasEncontradas = palabrasEncontradas;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public char[][] getEspacio() {
        return espacio;
    }

    public void setEspacio(char[][] espacio) {
        this.espacio = espacio;
    }

    @Override
    public String toString() {
        return "Tablero{" +
                "gamer=" + gamer +
                ", palabrasJuego=" + palabrasJuego +
                ", palabrasEncontradas=" + palabrasEncontradas +
                ", dimension=" + dimension +
                ", espacio=" + Arrays.toString(espacio) +
                '}';
    }

    public void cargarPalabras() {
        for (Palabra palabra: this.palabrasJuego) {
            int count = 0;
            int x = palabra.getX();
            int y = palabra.getY();
            int longPalabra = palabra.getTexto().length();

            switch (palabra.getDireccion()){
                case ESCALONADA:
                    for (int i = x; i < (x + longPalabra); i++){
                        this.espacio [i][y] = palabra.getTexto().charAt(count);
                        count++; y++;
                    }
                    break;
                case HORIZONTAL:
                    for (int i = y; i < (y + longPalabra); i++){
                        this.espacio [x][i] = palabra.getTexto().charAt(count);
                        count++;
                    }
                    break;
                case VERTICAL:
                    for (int i = x; i < (x + longPalabra); i++){
                        this.espacio [i][y] = palabra.getTexto().charAt(count);
                        count++;
                    }
                    break;
            }

        }
    }

    public void rellenar(){
        for (int filas = 0; filas < this.dimension; filas++) {
            for (int columnas = 0; columnas < this.dimension; columnas++) {
                if(this.espacio [filas][columnas] == '\u0000'){ //NULL
                    this.espacio [filas][columnas] = (char) (int) (Math.random() * (90 - 65) + 65);
                }
            }
        }
    }

    public void imprimir (){
        for (char[] letras : this.espacio) {
            System.out.println("-------------------------------");
            for (int i = 0; i < this.dimension; i++) {
                System.out.print(letras[i] + " | ");
            }
            System.out.println("");
        }
    }

    public void verificarPalabra (String texto){
        if(Palabra.searchPalabraInArray(palabrasEncontradas, texto) == null){
            Palabra tmpPalabra = Palabra.searchPalabraInArray(palabrasJuego, texto);
            if( tmpPalabra != null){
                palabrasEncontradas.add(tmpPalabra);
                gamer.setPuntaje(gamer.getPuntaje()+1);
                System.out.println("Muy bien palabra encontrada...");
            }else{
                System.out.println("Esta palabra no esta en el tablero...");
            }
        }else{
            System.out.println("Esta palabra ya la encontraste...");
        }
    }

    public boolean juegoCompletado(){
        int incompleto = 0;
        for (Palabra palabraTablero: this.palabrasJuego) {
            if(!palabrasEncontradas.contains(palabraTablero)){
                incompleto++;
            }
        }
        return incompleto <= 0;
    }

    public void verPalabrasEncontradas (){
        System.out.println("Has encontrado las siguientes palabras: ");
        for (Palabra palabra : this.palabrasEncontradas) {
            System.out.println(palabra.getTexto());
        }
    }

}
