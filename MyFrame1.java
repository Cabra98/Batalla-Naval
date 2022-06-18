import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame1 extends JFrame{
    JLabel titulonombre = new JLabel("Ingrese su nombre");
    JPanel panel = new JPanel();

    JTextField nombre = new JTextField("",30);
    JButton botonsiguiente = new JButton("Siguiente");
    JLabel nombrenoseleccionado = new JLabel("Debe ingresar un nombre correcto");
    JButton diffacil = new JButton("Fácil");
    JButton difmedia = new JButton("Media");
    JButton difdificil = new JButton("Difícil");
    JLabel titulodificultad = new JLabel("Seleccione la dificultad");
    JLabel tituloseleccionarbarcos = new JLabel("Seleccione las posiciones de sus barcos");
    JLabel subtituloseleccion = new JLabel("Seleccione la posición del buque (5 celdas)");
    JButton botoncomenzar = new JButton("Comenzar");
    int cantPosiciones = 0;
    int tablero[][] = new int[10][10];


    JTextField nombre = new JTextField(30);
    JButton botonsiguiente = new JButton();
    JButton diffacil = new JButton();
    JButton difmedia = new JButton();
    JButton difdificil = new JButton();
    JLabel titulodificultad = new JLabel("Seleccione la dificultad");

    int tamanioMatriz = 5;

    MyFrame1(){
        pantallaInicial();
        setTitle("Batalla Naval - !Agiles");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(650,650);
        setLocationRelativeTo(null);
        setSize(600,600);

        setVisible(true);

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
                Main.nombreasignado = nombre.getText();
            }
        });

        panel.setBounds(50, 200, 500, 100);
        botonsiguiente.setBounds(200, 300, 150, 75);
        botonsiguiente.setFont(new Font("Comic Sans", Font.BOLD, 16));
        botonsiguiente.setText("Siguiente");
        botonsiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.nombreasignado = nombre.getText();
                titulonombre.setVisible(false);
                panel.setVisible(false);
                botonsiguiente.setVisible(false);
                seleccionarDificultad();
            }
        });
        panel.add(nombre);
        add(panel);
        add(botonsiguiente);
        add(titulonombre);
    }

    public void seleccionarDificultad(){
        titulodificultad.setFont(new Font("Comic Sans", Font.BOLD, 25));
        titulodificultad.setBounds(200, 50, 500, 100);

        diffacil.setFont(new Font("Comic Sans", Font.BOLD, 16));
        difmedia.setFont(new Font("Comic Sans", Font.BOLD, 16));
        difdificil.setFont(new Font("Comic Sans", Font.BOLD, 16));


        titulodificultad.setBounds(150, 30, 500, 100);

        diffacil.setText("Fácil");
        difmedia.setText("Media");
        difdificil.setText("Difícil");

        titulodificultad.setBounds(150, 0, 500, 100);
        diffacil.setBounds(200, 100, 150, 75);
        difmedia.setBounds(200, 200, 150, 75);
        difdificil.setBounds(200, 300, 150, 75);


        add(titulodificultad);
        add(diffacil);
        add(difmedia);
        add(difdificil);


        diffacil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dificultad = diffacil.getText();
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
                Main.dificultad = difmedia.getText();
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
                Main.dificultad = difdificil.getText();
                titulodificultad.setVisible(false);
                diffacil.setVisible(false);
                difmedia.setVisible(false);
                difdificil.setVisible(false);
                seleccionarBarcos();
            }
        });

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

        for(int j = 1; j <= Main.tamanioMatriz; j++ ){
            final int fila = j-1;
            for (int i = 1; i<= Main.tamanioMatriz; i++){
                final int columna = i-1;
                JButton button = new JButton();
                button.setBounds((i*50), (50*j), 25, 25);
                add(button);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tablero[fila][columna] = 2;
                        button.setEnabled(false);
                        button.setBackground(Color.GREEN);
                        if(barcoposicionado()){
                            cambiarSubtitulo();
                            cantPosiciones=0;
                        }
                        else cantPosiciones++;
                    }
                });
            }
        }

        setVisible(true);
    }

    public boolean barcoposicionado(){
        if(subtituloseleccion.getText().equals("Seleccione la posición del buque (5 celdas)")){
            if(cantPosiciones == 4) return true;
            else return false;
        }
        else if(subtituloseleccion.getText().equals("Seleccione la posición del submarino (4 celdas)")){
            if(cantPosiciones == 3) return true;
            else return false;
        }
        else if(subtituloseleccion.getText().equals("Seleccione la posición del crucero (3 celdas)")){
            if(cantPosiciones == 2) return true;
            else return false;
        }
        else if(subtituloseleccion.getText().equals("Seleccione la posición del primer pesquero (2 celdas)")){
            if(cantPosiciones == 1) return true;
            else return false;
        }
        else if(subtituloseleccion.getText().equals("Seleccione la posición del segundo pesquero (2 celdas)")){
            if(cantPosiciones == 1) {
                botoncomenzar.setVisible(true);
                botoncomenzar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new MyFrame2();
                        botoncomenzar.setEnabled(false);
                        for(int k = 0; k< Main.tamanioMatriz; k++){
                            for(int l = 0; l< Main.tamanioMatriz; l++){
                                System.out.print(tablero[k][l]);
                            }
                            System.out.println("\n");
                        }
                    }
                });
                return true;
            }
            else return false;
        }
        else return false;
    }

    public void cambiarSubtitulo(){
        if(subtituloseleccion.getText() == "Seleccione la posición del buque (5 celdas)") subtituloseleccion.setText("Seleccione la posición del submarino (4 celdas)");
        else if(subtituloseleccion.getText() == "Seleccione la posición del submarino (4 celdas)") subtituloseleccion.setText("Seleccione la posición del crucero (3 celdas)");
        else if(subtituloseleccion.getText() == "Seleccione la posición del crucero (3 celdas)") subtituloseleccion.setText("Seleccione la posición del primer pesquero (2 celdas)");
        else if(subtituloseleccion.getText() == "Seleccione la posición del primer pesquero (2 celdas)") subtituloseleccion.setText("Seleccione la posición del segundo pesquero (2 celdas)");
    }


        add(titulodificultad);
        add(diffacil);
        add(difmedia);
        add(difdificil);
    }

    public void seleccionarBarcos(){
        this.setVisible(false);
        for(int j = 1; j <= tamanioMatriz; j++ ){
            for (int i=1; i<=tamanioMatriz; i++){

                JButton button = new JButton();
                button.setBounds((i*50), (50*j), 25, 25);
                //button.setName("button " + i + " " + j);
                System.out.println(button.getName());
                add(button);
            }
        }
        this.setVisible(true);
    }
}
