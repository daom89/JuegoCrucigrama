import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JuegoCrucigrama {

    /**
     * @param args the command line arguments
     *
     */
    static Partida Juego;
    static Jugador Jugador;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a cucigrama");
        System.out.println("------------------------");
        System.out.println();

        System.out.println("Hola Jugador Ingresa tu nombre: ");
        Jugador = new Jugador(sc.next(),0);
        nuevoJuego();
    }

    public static void nuevoJuego (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nuevo Juego: ");
        System.out.println("Selecciona la Dificultad: 1 => Facil, 2 => Normal, 3 => Dificil ");
        Partida.Nivel Dificultad;

        switch (sc.nextInt()){
            case 1:
                Dificultad = Partida.Nivel.FACIL;
                break;
            case 3:
                Dificultad = Partida.Nivel.DIFICIL;
                break;
            default:
                Dificultad = Partida.Nivel.NORMAL;
        }
        Juego = new Partida(Jugador, Dificultad);
        menuJuego();
    }

    public static void menuJuego(){
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("");
            Juego.getTableroPartida().imprimir();
            System.out.println("");

            System.out.println("1) Ingresar Palabra Encontrada");
            System.out.println("2) Ver Palabras Encontradas");
            System.out.println("3) Puntaje Total Jugador");
            System.out.println("4) Salir");

            try{
                String Value = sc.next();
                opcion = Integer.parseInt(Value);
            }catch (Exception $ime){
                System.out.println("Opcion No Valida");
                opcion = 0;
            }

            switch (opcion){
                case 1:
                    System.out.println("Ingrese palabra encontrada:");
                    String palabra = sc.next();
                    Juego.getTableroPartida().verificarPalabra(palabra);
                    opcion = juegoTerminado ();
                    break;
                case 2:
                    Juego.getTableroPartida().verPalabrasEncontradas();
                    break;
                case 3:
                    System.out.println("Tu Puntaje es: "+Juego.getPlayer().getPuntaje());
                    break;
                case 4:
                    System.out.println("Juego Terminado, Tu puntaje fue: "+Juego.getPlayer().getPuntaje());
                    break;
            }

        }while (opcion != 4);
    }

    public static int juegoTerminado (){
        Scanner sc = new Scanner(System.in);
        if(Juego.getTableroPartida().juegoCompletado()){
            System.out.println("Felicitaciones has encontrado todas las palabras..");
            System.out.println("Desea iniciar un nuevo juego? 1 => Si, 2 => No");
            if(sc.nextInt() == 1){
                nuevoJuego();
                System.err.println("Tu puntaje fue de: "+Juego.getPlayer().getPuntaje());
                System.exit(0);
            }else{
                System.err.println("Tu puntaje fue de: "+Juego.getPlayer().getPuntaje());
                System.out.println("Juego Terminado");
                return 4;
            }
        }
        return 0;
    }

}
