public class Jugador {

    public String nombres;
    public int puntaje = 0;

    public Jugador() {

    }

    public Jugador(String nombres, int puntaje) {
        this.nombres = nombres;
        this.puntaje = puntaje;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public String toString() {
        return "Datos del Jugador: \n" +
                "nombres='" + nombres + '\'' +
                ", puntaje=" + puntaje;
    }
}
