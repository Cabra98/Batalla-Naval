import java.util.ArrayList;

public class Juego implements Runnable, Subject{


    private Jugador humano;
    private Jugador maquina;
    private ArrayList observers;



    public Juego() {
        observers=new ArrayList();
        humano = new Jugador();
        maquina = new Jugador(1);
    }

    public void setNombreHumano(String n) {
        humano.setNombre(n);
    }


    public void setDificultad(String dif) {
        if (dif.equals("Facil")) {
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

            if(humano.getnumturno()>9 && !(maquina.getModoDisparo().equals("Costado")) && (humano.geteficiencia()> maquina.geteficiencia())){
                if(maquina.getDificultad().equals("Facil")){
                    maquina.setModoDisparo(new ModoMedio());
                    maquina.setDificultad("Media");
                }
                else if(maquina.getDificultad().equals("Media")){
                    maquina.setModoDisparo(new ModoDificil());
                    maquina.setDificultad("Dificil");
                }
            }


            while (humano.getTurno()) {
                System.out.print(".");
            }
            humano.setnumturno();
            if(maquina.getTablero().contenido(maquina.getTablero().getUltimoY(), maquina.getTablero().getUltimoX()) == 3) {
                humano.setCantaciertos();
                humano.setEficiencia();
            }

            else if(maquina.getTablero().contenido(maquina.getTablero().getUltimoY(), maquina.getTablero().getUltimoX()) == 1){
                humano.setCantfallas();
                humano.setEficiencia();
            }

            notifyObserver();

            ganaHumano = maquina.getTablero().isTerminado();

            maquina.setTurno(true);
            maquina.disparar(humano.getTablero());
            maquina.setnumturno();

            if(humano.getTablero().contenido(humano.getTablero().getUltimoY(), humano.getTablero().getUltimoX()) == 3) {
                maquina.setCantaciertos();
            }

            else if(humano.getTablero().contenido(humano.getTablero().getUltimoY(), humano.getTablero().getUltimoX()) == 1){
                maquina.setCantfallas();
            }

            maquina.setEficiencia();
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
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void remove(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for(int i=0;i<observers.size();i++){
            Observer observer=(Observer) observers.get(i);
            observer.update();
        }
    }
}

