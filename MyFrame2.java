import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyFrame2 extends JFrame implements Observer {
    JButton [][] button = new JButton[Main.tamanioMatriz][Main.tamanioMatriz];
    JLabel nombrehumano = new JLabel();
    JLabel cantidadTurnos = new JLabel();
    JLabel cantidadAciertos = new JLabel();
    JLabel cantidadErrores = new JLabel();
    JLabel eficiencia = new JLabel();
    private Juego juego;

    MyFrame2(Juego juego){
        this.juego=juego;
        juego.register(this);
        setTitle("Batalla Naval - !Agiles");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(750,750);
        setVisible(true);
        nombrehumano.setText(juego.getHumano().getNombre());
        nombrehumano.setBounds(550, 50, 200, 50);
        nombrehumano.setFont(new Font("Comic Sans", Font.BOLD, 16));
        cantidadTurnos.setBounds(550, 100, 200, 50);
        cantidadTurnos.setFont(new Font("Comic Sans", Font.BOLD, 16));
        cantidadAciertos.setBounds(550, 150, 200, 50);
        cantidadAciertos.setFont(new Font("Comic Sans", Font.BOLD, 16));
        cantidadErrores.setBounds(550, 200, 200, 50);
        cantidadErrores.setFont(new Font("Comic Sans", Font.BOLD, 16));
        eficiencia.setBounds(550, 250, 200, 50);
        eficiencia.setFont(new Font("Comic Sans", Font.BOLD, 16));
        add(nombrehumano);
        add(cantidadTurnos);
        add(cantidadAciertos);
        add(cantidadErrores);
        add(eficiencia);

        for(int j = 0; j < Main.tamanioMatriz; j++){
            final int fila = j;
            for (int i = 0; i< Main.tamanioMatriz; i++){
                JButton boton = new JButton();
                button[j][i] = boton;
                final int columna = i;
                button[j][i].setBounds((50+i*50), (50+50*j), 25, 25);
                add(button[j][i]);
                button[j][i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if(juego.getMaquina().getTablero().recibirDisparo(fila, columna)) {
                            button[fila][columna].setBackground(Color.RED);
                            juego.getHumano().setCantaciertos();
                            juego.getHumano().setnumturno();
                            juego.getHumano().setEficiencia();
                        }
                        else if(!juego.getMaquina().getTablero().recibirDisparo(fila, columna)){
                            button[fila][columna].setBackground(Color.BLUE);
                            juego.getHumano().setCantfallas();
                            juego.getHumano().setnumturno();
                            juego.getHumano().setEficiencia();
                        }
                        button[fila][columna].setEnabled(false);
                        juego.getMaquina().disparar(juego.getHumano().getTablero());
                        if(juego.getHumano().getTablero().contenido(juego.getHumano().getTablero().getUltimoY(), juego.getHumano().getTablero().getUltimoX()) == 3){
                            juego.getMaquina().setCantaciertos();
                            juego.getMaquina().setnumturno();
                            juego.getMaquina().setEficiencia();
                        }
                        else if(juego.getHumano().getTablero().contenido(juego.getHumano().getTablero().getUltimoY(), juego.getHumano().getTablero().getUltimoX()) == 1){
                            juego.getMaquina().setCantfallas();
                            juego.getMaquina().setnumturno();
                            juego.getMaquina().setEficiencia();
                        }
                        juego.notifyObserver();

                        if(juego.getHumano().getnumturno()>9 && !(juego.getMaquina().getModoDisparo().equals("Costado")) && (juego.getHumano().geteficiencia()> juego.getMaquina().geteficiencia())){
                            if(juego.getMaquina().getDificultad().equals("Facil")){
                                juego.getMaquina().setModoDisparo(new ModoMedio());
                                juego.getMaquina().setDificultad("Media");
                            }
                            else if(juego.getMaquina().getDificultad().equals("Media")){
                                juego.getMaquina().setModoDisparo(new ModoDificil());
                                juego.getMaquina().setDificultad("Dificil");
                            }
                        }

                    }
                });
            }
        }

    }

    public void update(){
        cantidadTurnos.setText("Turno N° " + (int) juego.getHumano().getnumturno());
        cantidadAciertos.setText("Cantidad de aciertos: " + (int) juego.getHumano().getcantaciertos());
        cantidadErrores.setText("Cantidad de fallas: " + (int) juego.getHumano().getcantfallas());
        eficiencia.setText("Eficiencia: " + juego.getHumano().geteficiencia() + "%");
        if(juego.getMaquina().getTablero().isTerminado() || juego.getHumano().getTablero().isTerminado()){
            this.setVisible(false);
        }
    }
}
