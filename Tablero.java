public class Tablero {
    private int[][] tabla;

                                                                    //0 -> AGUA
    public Tablero(){                                               //1 -> AGUA CON DISPARO
        reinicio();                                                 //2 -> BARCO
    }                                                               //3 -> BARCO CON DISPARO

    public void colocarBarco(int i, int j){

    }

    public boolean recibirDisparo(int i, int j){            //cambia el contenido del tablero, no se consideran
        if(tabla[i][j]==0){                                 //barcos enteros sino pedazos de barcos
            tabla[i][j]=1;
            return true;
        }
        if(tabla[i][j]==1){
            return false;
        }
        if(tabla[i][j]==2){
            tabla[i][j]=3;
            return true;
        }
        if(tabla[i][j]==3){
            return false;
        }
        return false;
    }

    public void reinicio(){
        for(int i=0; i<5;i++){                                          //0 -> AGUA
            for(int j=0; j<5; j++){                                     //1 -> AGUA CON DISPARO
                tabla[i][j]=0;                                          //2 -> BARCO
            }                                                           //3 -> BARCO CON DISPARO
        }
    }

    public boolean isTerminado(){
        int b =0;
        for(int i=0; i<5;i++){
            for(int j=0; j<5; j++){
                if(tabla[i][j]==3){
                    b++;
                }
            }
        }
        if(b==8){
            return true;
        }
        else
            return false;
    }


    public int[][] getTabla(){

        return tabla;
    }

}
