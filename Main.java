public class Main {
    static int tamanioMatriz = 10;

    public static void main(String[] args) {
        Juego juego=new Juego();
        MyFrame1 ventana=new MyFrame1(juego);
        //Thread jueguito = new Thread(juego);
        juego.register(ventana);
        //jueguito.start();
    }
}