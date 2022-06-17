public class Jugador implements ModoDisparo{
    private String nombre;
    private Tablero tablero;

    public Jugador(){
        nombre= "T-800";
        tablero= new Tablero();
    }

    public void setNombre(String n){
        nombre= n;
    }

    public boolean perdio(){
        return tablero.isTerminado();
    }

    public void disparar(int i, int j){

    }
}
