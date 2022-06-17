import javax.swing.*;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame1 extends JFrame{
    JLabel titulonombre = new JLabel("Ingrese su nombre");
    JPanel panel = new JPanel();
    JTextField nombre = new JTextField("",30);
    JButton botonsiguiente = new JButton();
    JLabel nombrenoseleccionado = new JLabel("Debe ingresar un nombre correcto");
    JButton diffacil = new JButton();
    JButton difmedia = new JButton();
    JButton difdificil = new JButton();
    JLabel titulodificultad = new JLabel("Seleccione la dificultad");
    JLabel tituloseleccionarbarcos = new JLabel("Seleccione las posiciones de sus barcos");
    JLabel subtituloseleccion = new JLabel("Seleccione la posición del buque (5 celdas)");
    int cantPosiciones = 0;

    MyFrame1(){
        pantallaInicial();
        setTitle("Batalla Naval - !Agiles");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(600,600);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void pantallaInicial(){
        titulonombre.setFont(new Font("Comic Sans", Font.BOLD, 25));
        titulonombre.setBounds(200, 50, 500, 100);
        panel.setBounds(40, 200, 500, 100);
        botonsiguiente.setBounds(200, 300, 150, 75);
        botonsiguiente.setFont(new Font("Comic Sans", Font.BOLD, 16));
        botonsiguiente.setText("Siguiente");
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
    }

    public void seleccionarDificultad(){
        titulodificultad.setFont(new Font("Comic Sans", Font.BOLD, 25));

        diffacil.setFont(new Font("Comic Sans", Font.BOLD, 16));
        difmedia.setFont(new Font("Comic Sans", Font.BOLD, 16));
        difdificil.setFont(new Font("Comic Sans", Font.BOLD, 16));

        diffacil.setText("Fácil");
        difmedia.setText("Media");
        difdificil.setText("Difícil");

        titulodificultad.setBounds(150, 30, 500, 100);
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

        tituloseleccionarbarcos.setFont(new Font("Comic Sans", Font.BOLD, 16));
        tituloseleccionarbarcos.setBounds(150, 0, 500, 25);

        subtituloseleccion.setFont(new Font("Comic Sans", Font.ITALIC, 14));

        subtituloseleccion.setBounds(50,25,500,20);

        add(tituloseleccionarbarcos);

        add(subtituloseleccion);

        for(int j = 1; j <= Main.tamanioMatriz; j++ ){
            for (int i = 1; i<= Main.tamanioMatriz; i++){
                JButton button = new JButton();
                button.setBounds((i*50), (50*j), 25, 25);
                add(button);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
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
            if(cantPosiciones == 1) return true;
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

}
