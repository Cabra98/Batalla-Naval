
public class Jugador {
    private String nombre;
    private Tablero tablero;
    private ModoDisparo modoDisparo;
    private boolean turno;


    public Jugador(){
        nombre= "";
        tablero= new Tablero();
        modoDisparo= null;
        turno = true;
    }

    public Jugador(int maquina){
        nombre= "Maquina 5000";
        tablero= new Tablero();
        modoDisparo = new ModoFacil();  //Esto en realidad tiene que crear el objeto con la dificultad que nos pida el usuario
        tablero.colocarAutomatico();
        turno = false;

    }

    public void setNombre(String n){
        nombre= n;
    }

    public boolean perdio(){
        return tablero.isTerminado();
    }


    public void disparar(Tablero tablero){ //Para disparar hay que pasarle el tablero del contrincante

    if(modoDisparo != null){ //Disapara la maquina
        modoDisparo.disparo(tablero, this);
    }
    }

    public Tablero getTablero(){
        return tablero;
    }

    public void setModoDisparo(ModoDisparo modo){
        modoDisparo = modo;

    }

    public void setTurno(boolean t){
        turno = t;
    }

    public boolean getTurno(){
        return turno;
    }
}
