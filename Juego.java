public class Juego {

    private Jugador humano;
    private Jugador maquina;

    public Juego(){
        humano = new Jugador();
        maquina = new Jugador( 1); //Un constructor distinto
    }

    public void setNombreHumano(String n){
        humano.setNombre(n);
    }

    public void setDificultad(String dif){
        if(dif.equals("Fácil")) maquina.setModoDisparo(new ModoFacil());
        else if(dif.equals("Media")) maquina.setModoDisparo(new ModoMedio());
        else if(dif.equals("Media")) maquina.setModoDisparo(new ModoDificil());
    }

    public void inicio(){}

    public Jugador getMaquina(){
        return maquina;
    }

    public Jugador getHumano(){
        return humano;
    }
}