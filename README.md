# Threads Virtuais no Java 21
Projeto criado para medir o tempo de resposta da API usando threads de plataforma (SO) X threads virtuais.

## Habilitando as threads virtuais
Recurso disponível a partir da versão 21 do java

No arquivo `apllication.properties`:
```
spring.threads.virtual.enabled=true
```

## Testes
### Threads SO
100 requisições com 20 requisições em paralelo:

```
miqueias@miqueias:~$ hey -n 100 -c 20 http://localhost:8080/virtual

Summary:
Total:	20.0191 secs
Slowest:	4.0056 secs
Fastest:	2.0022 secs
Average:	3.8035 secs
Requests/sec:	4.9952

Latency distribution:
  10% in 4.0021 secs
  25% in 4.0029 secs
  50% in 4.0034 secs
  75% in 4.0040 secs
  90% in 4.0045 secs
  95% in 4.0048 secs
  99% in 4.0056 secs
```

### Threads Virtuais
100 requisições com 20 requisições em paralelo:

```
miqueias@miqueias:~$ hey -n 100 -c 20 http://localhost:8080/virtual

Summary:
  Total:	10.1537 secs
  Slowest:	2.1231 secs
  Fastest:	2.0041 secs
  Average:	2.0303 secs
  Requests/sec:	9.8486

Latency distribution:
  10% in 2.0053 secs
  25% in 2.0060 secs
  50% in 2.0089 secs
  75% in 2.0123 secs
  90% in 2.1195 secs
  95% in 2.1201 secs
  99% in 2.1231 secs
```

## Referências
- [Conheça o poder das Virtual Threads com Java e Spring Boot!](https://www.youtube.com/watch?v=a8gMokxIt4Q)
- [Java Virtual Thread: Conceito e quando (ou não) usar](https://medium.com/@boschtechbr/java-virtual-thread-conceito-e-quando-ou-n%C3%A3o-usar-7c56238e951d)
