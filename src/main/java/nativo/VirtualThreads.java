package nativo;

import nativo.suporte.Tarefa;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreads {
    public static void main(String[] args) {
        Instant inicio = Instant.now();

        // try with resources encerra/fecha os recursos mesmo que ocorra uma exception. Para itens que implementam a interface java.lang.AutoCloseable ou java.io.Closeable
        try (ExecutorService e = Executors.newVirtualThreadPerTaskExecutor()) {

            int tamanho = 10000;

            for (int i = 0; i <= tamanho; i++) {
                e.execute(new Tarefa());
            }

        }
        Instant termino = Instant.now();
        System.out.println("Duração: " + Duration.between(inicio, termino).toMillis() + "ms");
        System.out.println("Contador: " + Tarefa.CONTADOR);
    }
}