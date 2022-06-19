public class Juego implements Runnable, Subject{

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
        if (dif.equals("Fácil")) {
            maquina.setModoDisparo(new ModoFacil());
            maquina.setDificultad("Facil");
        }
        else if (dif.equals("Media")) {
            maquina.setDificultad("Media");
            maquina.setModoDisparo(new ModoMedio());
        }
        else if (dif.equals("Dificil")) {
            maquina.setModoDisparo(new ModoDificil());
            maquina.setDificultad("Dificil");
        }
    }

    public void run(){

        boolean ganaHumano = false;
        boolean ganaMaquina = false;

        while (!ganaHumano && !ganaMaquina) {
            while (humano.getTurno()) {
                System.out.println(".");
            }

            ganaHumano = maquina.getTablero().isTerminado();

            maquina.setTurno(true);
            maquina.disparar(humano.getTablero());
            notifyObserver();
            ganaMaquina = humano.getTablero().isTerminado();

            humano.setTurno(true);

        }

        if(ganaHumano) {

        System.out.println("GANASTE");

    }
        else {

            System.out.println("perdiste");
    }

}

    public Jugador getMaquina(){
        return maquina;
    }

    public Jugador getHumano(){
        return humano;
    }

    @Override
    public void register() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void notifyObserver() {

    }
}
