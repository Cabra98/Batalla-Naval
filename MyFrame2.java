import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame2 extends JFrame {
    MyFrame2(Juego juego){
        setTitle("Batalla Naval - !Agiles");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(650,650);
        setVisible(true);

        for(int j = 1; j <= Main.tamanioMatriz; j++){
            final int fila = j-1;
            for (int i = 1; i<= Main.tamanioMatriz; i++){
                final int columna = i-1;
                JButton button = new JButton();
                button.setBounds((i*50), (50*j), 25, 25);
                add(button);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(juego.getMaquina().getTablero().recibirDisparo(fila, columna)) button.setBackground(Color.RED);
                        else button.setBackground(Color.BLUE);
                        button.setEnabled(false);
                    }
                });
            }
        }
    }
}