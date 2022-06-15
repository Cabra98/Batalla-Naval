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
    JTextField nombre = new JTextField(30);
    JButton botonsiguiente = new JButton();
    JButton diffacil = new JButton();
    JButton difmedia = new JButton();
    JButton difdificil = new JButton();
    JLabel titulodificultad = new JLabel("Seleccione la dificultad");
    int tamanioMatriz = 10;
    MyFrame1(){
        pantallaInicial();
        setTitle("Batalla Naval - !Agiles");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(600,600);
        setVisible(true);

    }

    public void pantallaInicial(){
        titulonombre.setFont(new Font("Comic Sans", Font.BOLD, 25));
        titulonombre.setBounds(200, 50, 500, 100);
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

        diffacil.setText("Fácil");
        difmedia.setText("Media");
        difdificil.setText("Difícil");

        titulodificultad.setBounds(150, 0, 500, 100);
        diffacil.setBounds(200, 100, 150, 75);
        difmedia.setBounds(200, 200, 150, 75);
        difdificil.setBounds(200, 300, 150, 75);

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
        add(titulodificultad);
        add(diffacil);
        add(difmedia);
        add(difdificil);
    }

    public void seleccionarBarcos(){
        for(int j = 1; j <= tamanioMatriz; j++ ){
            for (int i=1; i<=tamanioMatriz; i++){
                JButton button = new JButton();
                button.setBounds((i*50), (50*j), 25, 25);
                //button.setName("button " + i + " " + j);
                System.out.println(button.getName());
                add(button);
            }
        }
    }
}
