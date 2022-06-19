
public class ModoFacil implements ModoDisparo{

    public ModoFacil(){}
    public void disparo(Tablero tablero, Jugador jugador){
        int flag = 0;

        int[][] tabla = tablero.getTabla();

        for(int i=0; i<Main.tamanioMatriz; i++){
            for(int j=0; j<Main.tamanioMatriz; j++){

                if(tabla[i][j] == 2 || tabla[i][j] == 0  || tabla[i][j] == 4){
                    tablero.recibirDisparo(i,j);
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
                    flag = 1;

                    break;
                }

            }
            if (flag==1){
                break;
            }
        }
        jugador.setTurno(false);
    }

}

