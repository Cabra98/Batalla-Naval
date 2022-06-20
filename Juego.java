import java.util.ArrayList;

public class Juego implements Subject{


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

