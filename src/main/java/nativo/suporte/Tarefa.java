package nativo.suporte;

public class Tarefa implements Runnable{
    public static int CONTADOR = 0;
    @Override
    public void run() {
        CONTADOR++;
        System.out.println("Thread -> " + Thread.currentThread().getName() + " - Contador: " + CONTADOR);
    }
}
