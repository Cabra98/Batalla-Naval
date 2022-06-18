public class ModoFacil implements ModoDisparo{

    public ModoFacil(){}
    public void disparo(Tablero tablero, Jugador jugador){
        int flag = 0;

        int[][] tabla = tablero.getTabla();

        for(int i=0; i<Main.tamanioMatriz; i++){
            for(int j=0; j<Main.tamanioMatriz; j++){

                if(tabla[i][j] == 2 || tabla[i][j] == 0){

                    tablero.recibirDisparo(i,j);
                    if(tabla[i][j] == 2){jugador.setModoDisparo(new DisparoCostados());
                    }
                    flag = 1;

                    break;
                }

            }
            if (flag==1){
                break;
            }
        }
    }

}