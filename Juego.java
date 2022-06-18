public class Juego implements Runnable {

    private Jugador humano;
    private Jugador maquina;

    public Juego() {
        humano = new Jugador();
        maquina = new Jugador(1); //Un constructor distinto
    }

    public void setNombreHumano(String n) {
        humano.setNombre(n);
    }

    public void setDificultad(String dif) {
        if (dif.equals("Fácil")) maquina.setModoDisparo(new ModoFacil());
        else if (dif.equals("Media")) maquina.setModoDisparo(new ModoMedio());
        else if (dif.equals("Media")) maquina.setModoDisparo(new ModoDificil());
    }

    public void run(){

        boolean ganaHumano = false;
        boolean ganaMaquina = false;

        while ((!ganaHumano || !ganaMaquina)) {
            while (humano.getTurno()== true) {
                System.out.println("A");

            }


            ganaHumano = maquina.getTablero().isTerminado();

            //Deshabilitar toda la interfaz para el usuario mientras dispara la maquina

            maquina.setTurno(true);  //Simbolico
            maquina.disparar(humano.getTablero());

            ganaMaquina = humano.getTablero().isTerminado();

            maquina.setTurno(false);  //Simbolico
            humano.setTurno(true);
            break;
        }

        if(ganaHumano) {

        //Rodrigo mostrando la panza

    }else

    {

        //Derrota
    }

}






    public Jugador getMaquina(){
        return maquina;
    }

    public Jugador getHumano(){
        return humano;
    }
}
