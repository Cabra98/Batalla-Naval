import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame2 extends JFrame {
    JButton [][] button = new JButton[Main.tamanioMatriz][Main.tamanioMatriz];

    MyFrame2(Juego juego){
        setTitle("Batalla Naval - !Agiles");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(650,650);
        setVisible(true);

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
                        if(juego.getMaquina().getTablero().recibirDisparo(fila, columna)) button[fila][columna].setBackground(Color.RED);
                        else button[fila][columna].setBackground(Color.BLUE);
                        button[fila][columna].setEnabled(false);
                    }
                });
            }
        }
    }
}
