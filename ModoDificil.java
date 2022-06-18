public class ModoDificil implements ModoDisparo{
    @Override
    public void disparo(Tablero tablero, Jugador jugador) {

        int[][] tabla = tablero.getTabla();

        int flag = 0;

        while(flag == 0){

            int y = (int) (Math.random()*10);
            int x = (int) (Math.random()*10);

            if(tabla[y][x] == 2 || tabla[y][x] == 0){
                tablero.recibirDisparo(y,x);
                flag = 1;

                if(tabla[y][x] == 2){jugador.setModoDisparo(new DisparoCostados());}
            }

        }

    }
}
