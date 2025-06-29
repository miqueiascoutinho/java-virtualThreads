package br.com.miqueias.virtualThread;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/virtual")
public class Controller {
    @GetMapping
    public ResponseEntity<Status> virtual() throws InterruptedException {
        Instant inicio = Instant.now();

        Thread.sleep(200L);
        var result = new Status();
        Instant fim = Instant.now();
        System.out.println("Thread -> " + Thread.currentThread().getName() + " - Duração: " + Duration.between(inicio, fim).toMillis() + "ms");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/thread")
    public ResponseEntity<Status> virtualThreadComTimeout(@RequestParam Long timeout) throws InterruptedException {
        Instant inicio = Instant.now();
        Thread.sleep(timeout);
        var result = new Status();
        Instant fim = Instant.now();
        System.out.println("Thread -> " + Thread.currentThread().getName() + " - Duração: " + Duration.between(inicio, fim).toMillis() + "ms");
        return ResponseEntity.ok(result);
    }
}
record Status(LocalDateTime time, String status){
    public Status(){
        this(LocalDateTime.now(), "OK");
    }
}
