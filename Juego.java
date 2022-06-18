public class Juego {

    private Jugador humano;
    private Jugador maquina;

    public Juego(){
        humano = new Jugador();
        maquina = new Jugador( 1); //Un constructor distinto
    }

    public void setNombreHumano(String n){
        humano.setNombre(n);
    }

    public void inicio(){}
}
