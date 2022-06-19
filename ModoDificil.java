
public class ModoDificil implements ModoDisparo{
    @Override
    public void disparo(Tablero tablero, Jugador jugador) {

        int[][] tabla = tablero.getTabla();

        int flag = 0;

        while(flag == 0){

            int i = (int) (Math.random()*10);
            int j = (int) (Math.random()*10);

            if(tabla[i][j] == 2 || tabla[i][j] == 0 ){
                tablero.recibirDisparo(i,j);
                flag = 1;

                if(tabla[i][j] == 2){
                    jugador.setXIni(j);
                    jugador.setYIni(i);
                    if(tabla[i-1][j]!=1 && tabla[i-1][j]!=3 && i>0){
                        jugador.setX(j);
                        jugador.setY(i-1);
                        jugador.setCambio(3);
                    }
                    else if(tabla[i][j+1]!=1 && tabla[i][j+1]!=3 && j<9){
                        jugador.setX(j+1);
                        jugador.setY(i);
                        jugador.setCambio(2);
                    }
                    else if(tabla[i+1][j]!=1 && tabla[i+1][j]!=3 && i<9){
                        jugador.setX(j);
                        jugador.setY(i+1);
                        jugador.setCambio(1);
                    }
                    else if(tabla[i][j-1]!=1 && tabla[i][j-1]!=3 && j>0){
                        jugador.setX(j-1);
                        jugador.setY(i);
                        jugador.setCambio(0);
                    }

                    jugador.setModoDisparo(new DisparoCostados());
                }
            }

        }
        jugador.setTurno(false);
    }
}

