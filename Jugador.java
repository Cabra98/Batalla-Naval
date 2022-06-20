import static java.lang.Math.round;

public class Jugador {
    private String nombre;
    private Tablero tablero;
    private ModoDisparo modoDisparo;
    private boolean turno;
    private int xIni;
    private int yIni;
    private int x;
    private int y;
    private int cambio=3;
    private String dificultad;
    private float numturno = 0;
    private float cantaciertos = 0;
    private int cantfallas = 0;
    private float eficiencia = 0;

    public Jugador(){
        nombre= "";
        tablero= new Tablero();
        modoDisparo= null;
        turno = true;
    }

    public Jugador(int maquina){
        nombre= "Maquina 500";
        tablero= new Tablero();
        modoDisparo = new ModoFacil();
        tablero.colocarAutomatico();
        turno = false;
    }


    public void setDificultad(String dif){
        dificultad=dif;
    }
    public String getDificultad(){
        return dificultad;
    }
    public String getModoDisparo(){return modoDisparo.getModo();}

    public void setCambio(int i){
        cambio=i;
    }

    public int getCambio() {
        return cambio;
    }


    public void setXIni(int x){
        xIni = x;
    }
    public void setYIni(int y){
        yIni = y;
    }
    public int getxIni(){
        return xIni;
    }
    public int getyIni(){
        return yIni;
    }



    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getx(){
        return x;
    }
    public int gety(){
        return y;
    }


    public void setNombre(String n){
        nombre= n;
    }

    public boolean perdio(){
        return tablero.isTerminado();
    }


    public void disparar(Tablero tablero){
        if(modoDisparo != null){
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
    public String getNombre(){return nombre;}

    public float getnumturno(){
        return numturno;
    }

    public void setnumturno(){
        numturno++;
    }

    public float getcantaciertos(){
        return cantaciertos;
    }

    public float getcantfallas(){
        return cantfallas;
    }

    public float geteficiencia(){
        return eficiencia;
    }

    public void setCantaciertos(){
        cantaciertos++;
    }

    public void setCantfallas(){
        cantfallas++;
    }

    public void setEficiencia(){
        eficiencia =round((getcantaciertos()/getnumturno())*10000)/100;
    }
}

