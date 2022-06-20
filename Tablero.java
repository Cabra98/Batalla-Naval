import static org.junit.Assert.*;
import java.util.Random;
import org.junit.Test;

public class Tablero {

    private int[][] tabla = new int[Main.tamanioMatriz][Main.tamanioMatriz];
    private int ultimoY;
    private int ultimoX;


    //0 -> AGUA
    public Tablero(){                                               //1 -> AGUA CON DISPARO
        reinicio();                                                 //2 -> BARCO
    }                                                               //3 -> BARCO CON DISPARO

    public int getUltimoY(){
        return ultimoY;
    }
    public int getUltimoX(){
        return ultimoX;
    }

    public int contenido(int i, int j){
        return tabla[i][j];
    }
    public void colocarBarco(int i, int j){
        tabla[i][j] = 2;
    }

    public boolean recibirDisparo(int i, int j){
        if(tabla[i][j]==0){
            tabla[i][j]=1;
            ultimoX=j;
            ultimoY=i;
            return false;
        }
        else if(tabla[i][j]==2){
            tabla[i][j]=3;
            ultimoX=j;
            ultimoY=i;
            return true;
        }
        else{
            return false;
        }
    }

    public void reinicio(){
        for(int i=0; i<Main.tamanioMatriz;i++){                                          //0 -> AGUA
            for(int j=0; j<Main.tamanioMatriz; j++){                                     //1 -> AGUA CON DISPARO
                tabla[i][j]=0;                                                           //2 -> BARCO
            }                                                                            //3 -> BARCO CON DISPARO

        }
    }

    public boolean isTerminado(){
        int b =0;
        for(int i=0; i<Main.tamanioMatriz;i++){
            for(int j=0; j<Main.tamanioMatriz; j++){
                if(tabla[i][j]==3){
                    b++;
                }
            }
        }
        if(b==16){
            return true;
        }
        else
            return false;
    }

    public int[][] getTabla(){

        return tabla;
    }

    public void colocarAutomatico(){
        boolean UltimoBarco = false;
        Random random = new Random();
        int[][] field = new int[Main.tamanioMatriz][Main.tamanioMatriz];

        for (int i = 5; i > 0; i--) {

            if(i==1){
                i = 2;
                UltimoBarco = true;
            }
            //System.out.println("Placing ship with length: " + i);
            //start point of the ship and direction
            int x = random.nextInt(field.length);
            int y = random.nextInt(field.length);
            boolean vertical = random.nextBoolean();

            // Correct start point so that the ship could fit in the field
            if (vertical) {
                if (y + i > Main.tamanioMatriz) {
                    y -= i;
                }
            } else if (x + i > Main.tamanioMatriz) {
                x -= i;
            }
            //System.out.println("Start point: " + x + ", " + y + "; dir: " + (vertical ? "VERTICAL" : "HORIZONTAL"));

            boolean isFree = true;
            // Check for free space
            if (vertical) {
                for (int m = y; m < y + i; m++) {
                    if (field[m][x] != 0) {
                        isFree = false;
                        break;
                    }
                }
            } else {
                for (int n = x; n < x + i; n++) {
                    if (field[y][n] != 0) {
                        isFree = false;
                        break;
                    }
                }
            }

            if (!isFree) {
                i++;
                continue;
            }

            if (vertical) {
                for (int m = Math.max(0, x - 1); m < Math.min(Main.tamanioMatriz, x + 2); m++) {
                    for (int n = Math.max(0, y - 1); n < Math.min(Main.tamanioMatriz, y + i + 1); n++) {
                        field[n][m] = 9;
                    }
                }
            } else {
                for (int m = Math.max(0, y - 1); m < Math.min(Main.tamanioMatriz, y + 2); m++) {
                    for (int n = Math.max(0, x - 1); n < Math.min(Main.tamanioMatriz, x + i + 1); n++) {
                        field[m][n] = 9;
                    }
                }
            }

            // Fill in the ship cells
            for (int j = 0; j < i; j++) {
                field[y][x] = i;
                if (vertical) {
                    y++;
                } else {
                    x++;
                }
            }
            if(UltimoBarco == true){
                break;
                //i = 1;
                //UltimoBarco = false;
            }
        }


        for (int i = 0; i < Main.tamanioMatriz; i++) {
            for (int j = 0; j < Main.tamanioMatriz; j++) {
                tabla[i][j] = field[i][j] == 0 || field[i][j] == 9 ? 0 : 2;

            }

        }
    }

    public boolean celdapermitida(int f, int c){
        if(tabla[f][c] == 4) return false;
        else return true;
    }

    public void llenarcuatro(){
        for (int k=0;k<Main.tamanioMatriz;k++){
            for(int l=0;l<Main.tamanioMatriz;l++){
                if(tabla[k][l] == 2){
                    verificaralrededor(k,l);
                }
            }
        }
    }

    public void limpiarcuatro(){
        for (int k=0;k<Main.tamanioMatriz;k++){
            for(int l=0;l<Main.tamanioMatriz;l++){
                if(tabla[k][l] == 4){
                    tabla[k][l] = 0;
                }
            }
        }
    }

    public void verificaralrededor(int k, int l){
        if(k>0 && tabla[k-1][l] == 0) tabla[k-1][l] = 4;
        if(k<Main.tamanioMatriz-1 && tabla[k+1][l] == 0) tabla[k+1][l] = 4;
        if(l>0 && tabla[k][l-1] == 0) tabla[k][l-1] = 4;
        if(l<Main.tamanioMatriz-1 && tabla[k][l+1] == 0) tabla[k][l+1] = 4;
    }

    @Test
    public void testllenar4(){
        Tablero tablero = new Tablero();
        tablero.colocarBarco(3, 3);
        tablero.colocarBarco(3, 2);
        tablero.colocarBarco(3, 1);
        tablero.colocarBarco(3, 0);
        verificaralrededor(3, 3);
        verificaralrededor(3, 2);
        verificaralrededor(3, 1);
        verificaralrededor(3, 0);
        System.out.println(tablero.contenido(2, 0));
        assertTrue(tablero.contenido(2, 0) == 4);
        assertTrue(tablero.contenido(2, 1) == 4);
        assertTrue(tablero.contenido(2, 2) == 4);
        assertTrue(tablero.contenido(2, 3) == 4);
        assertTrue(tablero.contenido(4, 0) == 4);
        assertTrue(tablero.contenido(4, 1) == 4);
        assertTrue(tablero.contenido(4, 2) == 4);
        assertTrue(tablero.contenido(4, 3) == 4);
        assertTrue(tablero.contenido(3, 4) == 4);
    }

    @Test
    public void testDisparoAcierto(){

        Tablero tablero = new Tablero();
        tablero.colocarBarco(0,0);
        assertTrue(tablero.recibirDisparo(0,0));

    }

    @Test
    public void testDisparoErrado(){

        Tablero tablero = new Tablero();
        assertFalse(tablero.recibirDisparo(0,0));

    }


    @Test
    public void testreiniciar(){

        Tablero tablero = new Tablero();
        tablero.colocarBarco(0,0);   //Se coloca un 2 en es posicion
        tablero.reinicio();
        assertTrue(tablero.contenido(0,0) == 0);  //Chequea si se puso en 0 en la posicion del barco que pusimos recien

    }


    @Test
    public void testUbicacionBarcoMaquina(){

        Tablero tablero = new Tablero();
        tablero.colocarAutomatico();

        int pedazoBarco = 0;
        for (int i=0;i<Main.tamanioMatriz;i++){
            for(int j=0;j<Main.tamanioMatriz;j++){
                if(tablero.contenido(i,j) == 2){
                    pedazoBarco++;
                }
            }
        }
        assertTrue(pedazoBarco==16);

    }


    @Test
    public void testJuegoTerminado(){

        Tablero tablero = new Tablero();

        for (int i=0;i<2;i++){
            for(int j=0;j<8;j++){
                tablero.colocarBarco(i,j);
                tablero.recibirDisparo(i,j);
            }
        }
        assertTrue(tablero.isTerminado());

    }

}