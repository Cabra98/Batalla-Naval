
public class DisparoCostados implements ModoDisparo {
    String modo;
    public DisparoCostados() {
        modo="Costado";
    }

    public String getModo(){return modo;}

    public void disparo(Tablero tablero, Jugador jugador) {
        tablero.recibirDisparo(jugador.gety(), jugador.getx());

        if (tablero.contenido(jugador.gety(), jugador.getx()) == 1) {
            if(jugador.getCambio()==3 ){
                if(jugador.getxIni()<9) {
                    jugador.setY(jugador.getyIni());
                    jugador.setX(jugador.getxIni() + 1);
                    jugador.setCambio(2);
                }
                else{
                    jugador.setCambio(2);
                    jugador.disparar(tablero);
                }

            }
            else if(jugador.getCambio()==2){
                if(jugador.getyIni()<9) {
                    jugador.setY(jugador.getyIni() + 1);
                    jugador.setX(jugador.getxIni());
                    jugador.setCambio(1);
                }
                else{
                    jugador.setCambio(1);
                    jugador.disparar(tablero);
                }
            }
            else if(jugador.getCambio()==1){
                if(jugador.getxIni()>0) {
                    jugador.setY(jugador.getyIni());
                    jugador.setX(jugador.getxIni() - 1);
                    jugador.setCambio(0);
                }
                else{
                    jugador.setCambio(0);
                    jugador.disparar(tablero);
                }
            }
            else if(jugador.getCambio()==0) {
                jugador.setCambio(3);
                if (jugador.getDificultad().equals("Facil")) {
                    jugador.setModoDisparo(new ModoFacil());
                } else if (jugador.getDificultad().equals("Media")) {
                    jugador.setModoDisparo(new ModoMedio());
                } else {
                    jugador.setModoDisparo(new ModoDificil());
                    llenarcuatro(tablero);
                }
            }

            jugador.setTurno(false);
        }
        else if(tablero.contenido(jugador.gety(), jugador.getx()) == 3){
            if(jugador.getCambio()==3){
                if(jugador.gety()>0) {
                    jugador.setY(jugador.gety() - 1);
                    jugador.setX(jugador.getx());
                }
                else{
                    jugador.setY(jugador.getyIni()+1);
                    jugador.setCambio(1);
                }
            }
            else if(jugador.getCambio()==2){
                if(jugador.getx()<9) {
                    jugador.setY(jugador.gety());
                    jugador.setX(jugador.getx() + 1);
                }
                else{
                    jugador.setX(jugador.getxIni()-1);
                    jugador.setCambio(0);
                }
            }
            else if(jugador.getCambio()==1) {
                if(jugador.gety()<9) {
                    jugador.setY(jugador.gety() + 1);
                    jugador.setX(jugador.getx());
                }
                else{
                    jugador.setCambio(3);
                    if (jugador.getDificultad().equals("Facil")) {
                        jugador.setModoDisparo(new ModoFacil());
                    } else if (jugador.getDificultad().equals("Media")) {
                        jugador.setModoDisparo(new ModoMedio());
                    } else {
                        jugador.setModoDisparo(new ModoDificil());
                        llenarcuatro(tablero);
                    }
                }
            }
            else if(jugador.getCambio()==0) {
                if(jugador.getx()>0) {
                    jugador.setY(jugador.gety());
                    jugador.setX(jugador.getx() - 1);
                }
                else{
                    jugador.setCambio(3);
                    if (jugador.getDificultad().equals("Facil")) {
                        jugador.setModoDisparo(new ModoFacil());
                    } else if (jugador.getDificultad().equals("Media")) {
                        jugador.setModoDisparo(new ModoMedio());
                    } else {
                        jugador.setModoDisparo(new ModoDificil());
                        llenarcuatro(tablero);
                    }
                }
            }

    }

    }
    public void llenarcuatro(Tablero tablero){
        for (int k=0;k<Main.tamanioMatriz;k++){
            for(int l=0;l<Main.tamanioMatriz;l++){
                if(tablero.contenido(k,l) == 3){
                    tablero.verificaralrededor(k,l);
                }
            }
        }
    }
}


