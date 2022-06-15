import javax.swing.JFrame;
import javax.swing.JButton;

public class MyFrame3 extends JFrame {

    MyFrame3(){
        int tamanioMatriz = 10;

        for(int j = 1; j <= tamanioMatriz; j++ ){
            for (int i=1; i<=tamanioMatriz; i++){
                JButton button = new JButton();
                button.setBounds((i*50), (50*j), 25, 25);
                add(button);
            }
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(600,600);
        setVisible(true);

    }

    void mostrarPantalla(){
        setVisible(true);
    }

}
