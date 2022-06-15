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
    MyFrame1(){
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
                setVisible(false);
                new MyFrame2();
            }
        });

        setTitle("Batalla Naval - !Agiles");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(600,600);
        setVisible(true);
        panel.add(nombre);
        add(panel);
        add(botonsiguiente);
        add(titulonombre);
    }
}
