
public class Jugador {
    private String nombre;
    private Tablero tablero;
    private ModoDisparo modoDisparo;


    public Jugador(){
        nombre= "";
        tablero= new Tablero();
        modoDisparo= null;
    }

    public Jugador(int maquina){
        nombre= "Maquina 5000";
        tablero= new Tablero();
        modoDisparo = new ModoFacil();  //Esto en realidad tiene que crear el objeto con la dificultad que nos pida el usuario
        tablero.colocarAutomatico();


    }

    public void setNombre(String n){
        nombre= n;
    }

    public boolean perdio(){
        return tablero.isTerminado();
    }


    public void disparar(Tablero tablero, int i, int j){ //Para disparar hay que pasarle el tablero del contrincante
    if(modoDisparo != null){ //Disapara la maquina
        modoDisparo.disparo(tablero, this);
    }else{ //Dispara el jugador

        tablero.recibirDisparo(i,j);
    }
    }

    public Tablero getTablero(){
        return tablero;
    }

    public void setModoDisparo(ModoDisparo modo){
        modoDisparo = modo;

    }
}
