
public class Jugador {
    private String nombre;
    private Tablero tablero;
    private ModoDisparo modoDisparo;


    public Jugador(){
        nombre= "T-800";
        tablero= new Tablero();
        modoDisparo= null;
    }

    public Jugador(int maquina){
        nombre= "Maquina-Ayarde-5000";
        tablero= new Tablero();
        modoDisparo = new ModoFacil();  //Esto en realidad tiene que crear el objeto con la dificultad que nos pida el usuario
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
