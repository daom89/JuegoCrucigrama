import java.util.ArrayList;

class Palabra {

    public enum Direccion { HORIZONTAL, VERTICAL, ESCALONADA }

    private String texto; //DIEGO
    private int x; // 3 Horizontal
    private int y; // 3 Vertical
    private Direccion direccion; //Direccion.ESCALONADA
    private boolean invertida; //FALSE

    public Palabra() {

    }

    public Palabra(String texto, int x, int y, Direccion direccion, boolean invertida) {
        this.texto = texto;
        this.x = x;
        this.y = y;
        this.direccion = direccion;
        this.invertida = invertida;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public boolean isInvertida() {
        return invertida;
    }

    public void setInvertida(boolean invertida) {
        this.invertida = invertida;
    }

    public static Palabra searchPalabraInArray(ArrayList<Palabra> arrPalabra, String texto){
        for (Palabra tmpPalabra: arrPalabra) {
            if (tmpPalabra.texto.equalsIgnoreCase(texto)) {
                return tmpPalabra;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Palabra{" +
                "texto='" + texto + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", escalonada=" + direccion +
                ", invertida=" + invertida +
                '}';
    }
}
