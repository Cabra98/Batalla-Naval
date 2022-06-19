
import java.util.Random;

public class ModoMedio implements ModoDisparo{

    public ModoMedio(){}

    public void disparo(Tablero tablero, Jugador jugador){

        int flag = 0;

        while(flag == 0){

            int y = (int) (Math.random()*10);
            int x = (int) (Math.random()*10);

            if(tablero.contenido(y,x) == 2 || tablero.contenido(y,x)== 0  || tablero.contenido(y,x) == 4){
                tablero.recibirDisparo(y,x);
                flag = 1;

                if(tablero.contenido(y,x) == 3){
                    jugador.setYIni(y);
                    jugador.setXIni(x);
                    jugador.setModoDisparo(new DisparoCostados());

                }
            }
        }
        jugador.setTurno(false);
    }


}

