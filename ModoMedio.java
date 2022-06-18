
import java.util.Random;

public class ModoMedio implements ModoDisparo{

    public ModoMedio(){}

    public void disparo(Tablero tablero, Jugador jugador){

        int[][] tabla = tablero.getTabla();
        int[][] posTiro = new int[2][1];

        int flag = 0;

        while(flag == 0){

            int y = (int) (Math.random()*10);
            int x = (int) (Math.random()*10);

            if(tabla[y][x] == 2 || tabla[y][x] == 0  || tabla[y][x] == 4){
                tablero.recibirDisparo(y,x);
                flag = 1;

                if(tabla[y][x] == 2){
                    posTiro[0][0]=y;
                    posTiro[1][0]=x;
                    jugador.setModoDisparo(new DisparoCostados());
                    tablero.setUltimoTiro(posTiro);
                }
            }

        }
    }


}

