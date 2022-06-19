import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame1 extends JFrame implements Observer{
    JLabel titulonombre = new JLabel("Ingrese su nombre");
    JPanel panel = new JPanel();
    JTextField nombre = new JTextField("",30);
    JButton botonsiguiente = new JButton("Siguiente");
    JLabel nombrenoseleccionado = new JLabel("Debe ingresar un nombre correcto");
    JButton diffacil = new JButton("Facil");
    JButton difmedia = new JButton("Media");
    JButton difdificil = new JButton("Dificil");
    JLabel titulodificultad = new JLabel("Seleccione la dificultad");
    JLabel tituloseleccionarbarcos = new JLabel("Seleccione las posiciones de sus barcos");
    JLabel subtituloseleccion = new JLabel("Seleccione la posición del buque (5 celdas)");
    JButton botoncomenzar = new JButton("Comenzar");
    int cantPosiciones = 0;
    JLabel nombremaquina = new JLabel();
    JLabel cantidadTurnos = new JLabel();
    JLabel cantidadAciertos = new JLabel();
    JLabel cantidadErrores = new JLabel();
    JLabel eficiencia = new JLabel();
    JButton [][] button = new JButton[Main.tamanioMatriz][Main.tamanioMatriz];
    private Juego juego;
    JLabel partidaterminada = new JLabel();

    MyFrame1(Juego juego){
        this.juego=juego;
        pantallaInicial();
        setTitle("Batalla Naval - !Agiles");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(750,750);
        setLocationRelativeTo(null);
        setVisible(true);
        nombremaquina.setText(juego.getMaquina().getNombre());
        nombremaquina.setBounds(550, 50, 200, 50);
        nombremaquina.setFont(new Font("Comic Sans", Font.BOLD, 16));
        cantidadTurnos.setBounds(550, 100, 200, 50);
        cantidadTurnos.setFont(new Font("Comic Sans", Font.BOLD, 16));
        cantidadAciertos.setBounds(550, 150, 200, 50);
        cantidadAciertos.setFont(new Font("Comic Sans", Font.BOLD, 16));
        cantidadErrores.setBounds(550, 200, 200, 50);
        cantidadErrores.setFont(new Font("Comic Sans", Font.BOLD, 16));
        eficiencia.setBounds(550, 250, 200, 50);
        eficiencia.setFont(new Font("Comic Sans", Font.BOLD, 16));
        partidaterminada.setBounds(250, 150, 500, 500);
        partidaterminada.setFont(new Font("Comic Sans", Font.BOLD, 30));
        add(partidaterminada); partidaterminada.setVisible(false);



    }

    public void pantallaInicial(){
        titulonombre.setFont(new Font("Comic Sans", Font.BOLD, 25));
        titulonombre.setBounds(200, 50, 500, 100);
        panel.setBounds(40, 200, 500, 100);
        botonsiguiente.setBounds(200, 300, 150, 75);
        botonsiguiente.setFont(new Font("Comic Sans", Font.BOLD, 16));
        nombrenoseleccionado.setFont(new Font("Comic Sans", Font.BOLD, 16));
        nombrenoseleccionado.setForeground(Color.red);
        nombrenoseleccionado.setBounds(150, 350, 500, 100);
        nombrenoseleccionado.setVisible(false);

        panel.add(nombre);
        add(panel);
        add(botonsiguiente);
        add(titulonombre);
        add(nombrenoseleccionado);

        botonsiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nombre.getText().equals("")) nombrenoseleccionado.setVisible(true);
                else{
                    titulonombre.setVisible(false);
                    panel.setVisible(false);
                    botonsiguiente.setVisible(false);
                    nombrenoseleccionado.setVisible(false);
                    seleccionarDificultad();
                }
                juego.setNombreHumano(nombre.getText());
            }
        });

    }

    public void seleccionarDificultad(){
        setVisible(false);
        titulodificultad.setFont(new Font("Comic Sans", Font.BOLD, 25));

        diffacil.setFont(new Font("Comic Sans", Font.BOLD, 16));
        difmedia.setFont(new Font("Comic Sans", Font.BOLD, 16));
        difdificil.setFont(new Font("Comic Sans", Font.BOLD, 16));

        titulodificultad.setBounds(150, 30, 500, 100);
        diffacil.setBounds(200, 150, 150, 75);
        difmedia.setBounds(200, 250, 150, 75);
        difdificil.setBounds(200, 350, 150, 75);

        add(titulodificultad);
        add(diffacil);
        add(difmedia);
        add(difdificil);

        diffacil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                juego.setDificultad(diffacil.getText());
                titulodificultad.setVisible(false);
                diffacil.setVisible(false);
                difmedia.setVisible(false);
                difdificil.setVisible(false);
                seleccionarBarcos();

            }
        });

        difmedia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                juego.setDificultad(difmedia.getText());
                titulodificultad.setVisible(false);
                diffacil.setVisible(false);
                difmedia.setVisible(false);
                difdificil.setVisible(false);
                seleccionarBarcos();
            }
        });

        difdificil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                juego.setDificultad(difdificil.getText());
                titulodificultad.setVisible(false);
                diffacil.setVisible(false);
                difmedia.setVisible(false);
                difdificil.setVisible(false);
                seleccionarBarcos();
            }
        });
        setVisible(true);
    }

    public void seleccionarBarcos(){
        setVisible(false);

        tituloseleccionarbarcos.setBounds(150, 0, 500, 25);
        botoncomenzar.setBounds(450, 550, 150, 50);
        subtituloseleccion.setBounds(50,25,500,20);

        subtituloseleccion.setFont(new Font("Comic Sans", Font.ITALIC, 14));
        tituloseleccionarbarcos.setFont(new Font("Comic Sans", Font.BOLD, 16));
        botoncomenzar.setFont(new Font("Comic Sans", Font.BOLD, 16));
        botoncomenzar.setVisible(false);

        add(tituloseleccionarbarcos);
        add(subtituloseleccion);
        add(botoncomenzar);

        for(int j = 0; j < Main.tamanioMatriz; j++ ){
            final int fila = j;
            for (int i = 0; i< Main.tamanioMatriz; i++){
                final int columna = i;
                JButton boton = new JButton();
                button[j][i] = boton;
                button[j][i].setBounds((50+i*50), (50+50*j), 25, 25);
                add(button[j][i]);
                button[j][i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(juego.getHumano().getTablero().celdapermitida(fila, columna)){
                            juego.getHumano().getTablero().colocarBarco(fila, columna);
                            button[fila][columna].setEnabled(false);
                            button[fila][columna].setBackground(Color.GREEN);
                            if(barcoposicionado() == 2){
                                juego.getHumano().getTablero().llenarcuatro();
                                cambiarSubtitulo();
                                cantPosiciones=0;
                            }
                            else cantPosiciones++;
                        }
                    }
                });
            }
        }

        setVisible(true);
    }

    public int barcoposicionado(){
        if(subtituloseleccion.getText().equals("Seleccione la posición del buque (5 celdas)")){
            if(cantPosiciones == 4) return 2;
            else if (cantPosiciones == 0) return 0;
            else return 1;
        }
        else if(subtituloseleccion.getText().equals("Seleccione la posición del submarino (4 celdas)")){
            if(cantPosiciones == 3) return 2;
            else if (cantPosiciones == 0) return 0;
            else return 1;
        }
        else if(subtituloseleccion.getText().equals("Seleccione la posición del crucero (3 celdas)")){
            if(cantPosiciones == 2) return 2;
            else if (cantPosiciones == 0) return 0;
            else return 1;
        }
        else if(subtituloseleccion.getText().equals("Seleccione la posición del primer pesquero (2 celdas)")){
            if(cantPosiciones == 1) return 2;
            else if (cantPosiciones == 0) return 0;
            else return 1;
        }
        else if(subtituloseleccion.getText().equals("Seleccione la posición del segundo pesquero (2 celdas)")){
            if(cantPosiciones == 1) {
                botoncomenzar.setVisible(true);
                botoncomenzar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        add(nombremaquina);
                        nombremaquina.setVisible(true);
                        add(cantidadTurnos);
                        add(cantidadAciertos);
                        add(cantidadErrores);
                        add(eficiencia);
                        juego.getHumano().getTablero().limpiarcuatro();

                        new MyFrame2(juego);
                        botoncomenzar.setEnabled(false);
                        bloquearbotones();
                    }
                });
                return 2;
            }
            else if (cantPosiciones == 0) return 0;
        }
        return 0;
    }

    public void cambiarSubtitulo(){
        if(subtituloseleccion.getText() == "Seleccione la posición del buque (5 celdas)") subtituloseleccion.setText("Seleccione la posición del submarino (4 celdas)");
        else if(subtituloseleccion.getText() == "Seleccione la posición del submarino (4 celdas)") subtituloseleccion.setText("Seleccione la posición del crucero (3 celdas)");
        else if(subtituloseleccion.getText() == "Seleccione la posición del crucero (3 celdas)") subtituloseleccion.setText("Seleccione la posición del primer pesquero (2 celdas)");
        else if(subtituloseleccion.getText() == "Seleccione la posición del primer pesquero (2 celdas)") subtituloseleccion.setText("Seleccione la posición del segundo pesquero (2 celdas)");
    }

    public void update(){
        if(juego.getHumano().getTablero().contenido(juego.getHumano().getTablero().getUltimoY(), juego.getHumano().getTablero().getUltimoX()) == 3){
            button[juego.getHumano().getTablero().getUltimoY()][juego.getHumano().getTablero().getUltimoX()].setBackground(Color.red);}
        else if(juego.getHumano().getTablero().contenido(juego.getHumano().getTablero().getUltimoY(), juego.getHumano().getTablero().getUltimoX()) == 1){
            button[juego.getHumano().getTablero().getUltimoY()][juego.getHumano().getTablero().getUltimoX()].setBackground(Color.blue);
        }
        cantidadTurnos.setText("Turno N° " + (int) juego.getMaquina().getnumturno());
        cantidadAciertos.setText("Cantidad de aciertos: " + (int) juego.getMaquina().getcantaciertos());
        cantidadErrores.setText("Cantidad de fallas: " + (int) juego.getMaquina().getcantfallas());
        eficiencia.setText("Eficiencia: " + juego.getMaquina().geteficiencia() + "%");
        if (juego.getHumano().getTablero().isTerminado()) {
            partidafinalizada();
            partidaterminada.setText("Perdiste :(");
            partidaterminada.setVisible(true);
        } else if (juego.getMaquina().getTablero().isTerminado()) {
            partidafinalizada();
            partidaterminada.setText("Ganaste!!!! :)");
            partidaterminada.setVisible(true);

        }
    }

    public void bloquearbotones(){
        for (int i = 0; i<Main.tamanioMatriz; i++){
            for(int j = 0; j<Main.tamanioMatriz; j++){
                button[i][j].setEnabled(false);
            }
        }
    }

    public void partidafinalizada(){
        setVisible(false);
        for(int i=0; i<Main.tamanioMatriz; i++){
            for(int j=0; j<Main.tamanioMatriz;j++){
                button[i][j].setVisible(false);
            }
        }
        botoncomenzar.setVisible(false);
        tituloseleccionarbarcos.setVisible(false);
        subtituloseleccion.setVisible(false);
        nombremaquina.setVisible(false);
        cantidadErrores.setVisible(false);
        cantidadAciertos.setVisible(false);
        cantidadTurnos.setVisible(false);
        eficiencia.setVisible(false);
        setVisible(true);
    }
}