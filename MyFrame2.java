import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame2 extends JFrame {
    MyFrame2(){
        setTitle("Batalla Naval - !Agiles");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(650,650);
        setVisible(true);
    }

    for(int j = 1; j <= Main.tamanioMatriz; j++){
        for (int i = 1; i<= Main.tamanioMatriz; i++){
            JButton button = new JButton();
            button.setBounds((i*50), (50*j), 25, 25);
            add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button.setEnabled(false);
                    button.setBackground(Color.GREEN);
                }
            });
        }
    }

}
