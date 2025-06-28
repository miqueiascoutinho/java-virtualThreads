package br.com.miqueias.virtualThread;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/virtual")
public class Controller {
    @GetMapping
    public ResponseEntity<Status> virtual() throws InterruptedException {
        System.out.println("Thread -> " + Thread.currentThread().getName());
        Thread.sleep(2000L);
        return ResponseEntity.ok(new Status());
    }
}
record Status(LocalDateTime time, String status){
    public Status(){
        this(LocalDateTime.now(), "OK");
    }
}
