
public class ModoFacil implements ModoDisparo{

    public ModoFacil(){}
    public void disparo(Tablero tablero, Jugador jugador){
        int flag = 0;



        for(int i=0; i<Main.tamanioMatriz; i++){
            for(int j=0; j<Main.tamanioMatriz; j++){

                if(tablero.contenido(i,j)== 2 || tablero.contenido(i,j) == 0  || tablero.contenido(i,j) == 4){
                    tablero.recibirDisparo(i,j);
                    if(tablero.contenido(i,j) == 3){
                        jugador.setXIni(j);
                        jugador.setYIni(i);
                        if(i>0 && tablero.contenido(i-1,j)!=1 && tablero.contenido(i-1,j)!=3 ){
                            jugador.setX(j);
                            jugador.setY(i-1);
                            jugador.setCambio(3);
                        }
                        else if(j<9 && tablero.contenido(i,j+1)!=1 && tablero.contenido(i,j+1)!=3  ){
                            jugador.setX(j+1);
                            jugador.setY(i);
                            jugador.setCambio(2);
                        }
                        else if(i<9 && tablero.contenido(i+1,j)!=1 && tablero.contenido(i+1,j)!=3 ){
                            jugador.setX(j);
                            jugador.setY(i+1);
                            jugador.setCambio(1);
                        }
                        else if(j>0 && tablero.contenido(i,j-1)!=1 && tablero.contenido(i,j-1)!=3 ){
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
