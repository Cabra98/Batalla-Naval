import org.junit.Test;
import static org.junit.Assert.*;

public class Test {

    /*@Test
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
    }*/

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

    @Test
    public void testDificultadMaquina() {

        Jugador maquina = new Jugador(1);
        String dificultad = "Media";
        maquina.setDificultad(dificultad);
        assertEquals("Media", maquina.getDificultad());
    }

    @Test
    public void testDificultadHumano() {
        Jugador maquina = new Jugador(1);
        ModoMedio modoMedio = new ModoMedio();
        maquina.setModoDisparo(modoMedio);
        assertEquals("Media", maquina.getModoDisparo());
    }

    @Test
    public void constructor() {
        Juego juego=new Juego();
        assertNotNull(juego.getMaquina());
        assertNotNull(juego.getHumano());
    }
    
}
