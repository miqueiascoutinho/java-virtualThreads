package nativo;

import nativo.suporte.Tarefa;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PlatformThread {
    public static void main(String[] args) {
        int tamanho = 10000;
        Instant inicio = Instant.now();

        try (ExecutorService e = Executors.newFixedThreadPool(tamanho)){
            for(int i = 0; i <= tamanho;i++){
                var tarefa = new Tarefa();
                e.execute(tarefa);
            }
        }

        Instant termino = Instant.now();
        System.out.println("Duração: " + Duration.between(inicio, termino).toMillis() + "ms");
    }
}
