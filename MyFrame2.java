import javax.swing.*;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame2 extends JFrame {
    JButton diffacil = new JButton();
    JButton difmedia = new JButton();
    JButton difdificil = new JButton();

    JLabel titulodificultad = new JLabel("Seleccione la dificultad");

    MyFrame2(){
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
                setVisible(false);
            }
        });

        difmedia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dificultad = difmedia.getText();
                setVisible(false);
                new MyFrame3();
            }
        });

        difdificil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.dificultad = difdificil.getText();
                setVisible(false);
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(600,600);
        setVisible(true);
        add(titulodificultad);
        add(diffacil);
        add(difmedia);
        add(difdificil);
        difdificil.setVisible(false);
    }
    void mostrarPantalla(){
        setVisible(true);
    }
}
