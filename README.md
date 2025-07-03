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

---
_Threads virtuais_ são ótimas para aplicações com muitas operações de I/O (entrada/saída), como requisições de rede ou acesso a bancos de dados. Elas permitem que a aplicação lide com muitas requisições simultâneas de forma eficiente, sem sobrecarregar o sistema.

No entanto, threads virtuais podem não ser a melhor opção para tarefas que exigem muito poder de processamento da CPU, como cálculos complexos ou algoritmos de inteligência artificial. Nesses casos, threads tradicionais podem ser mais eficientes, pois têm acesso direto aos recursos do sistema operacional.

Em resumo:

*Use threads virtuais quando:*

- A aplicação tem muitas operações de I/O.
- É necessário lidar com muitas requisições simultâneas.
- A escalabilidade é importante.

*Não use threads virtuais quando:*

- A aplicação tem muitas tarefas que exigem muito poder de processamento da CPU.
- A compatibilidade com versões antigas do Java é uma preocupação.



----- 
# Teste
# 📊 Resumo da Execução

| Métrica         | Valor     |
|-----------------|-----------|
| Total           | `9.7608s` |
| Mais lenta      | `6.1024s` |
| Mais rápida     | `1.2188s` |
| Média           | `3.7828s` |
| Requisições/s   | `4.0980`  |

---

# ⏱️ Histograma do Tempo de Resposta

| Faixa de Tempo (s) | Requisições | Gráfico                             |
|--------------------|-------------|-------------------------------------|
| `1.219`            | 1           | `■■■`                               |
| `1.707`            | 9           | `■■■■■■■■■■■■■■■■■■■■■■■■■■■■`      |
| `2.196`            | 0           |                                     |
| `2.684`            | 5           | `■■■■■■■■■■■■■■■`                  |
| `3.172`            | 0           |                                     |
| `3.661`            | 2           | `■■■■■■`                            |
| `4.149`            | 2           | `■■■■■■`                            |
| `4.637`            | 0           |                                     |
| `5.126`            | 13          | `■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■` |
| `5.614`            | 0           |                                     |
| `6.102`            | 8           | `■■■■■■■■■■■■■■■■■■■■■■■■■`        |

---

# 📈 Distribuição de Latência

| Percentil | Tempo (s)   |
|-----------|-------------|
| 10%       | `1.2209`    |
| 25%       | `2.4415`    |
| 50%       | `4.8769`    |
| 75%       | `4.8826`    |
| 90%       | `6.1005`    |
| 95%       | `6.1022`    |
| 0%        | `0.0000`    |



------

# 📊 Resumo da Execução

| Métrica         | Valor     |
|-----------------|-----------|
| Total           | `2.6473s` |
| Mais lenta      | `1.4169s` |
| Mais rápida     | `1.2270s` |
| Média           | `1.3222s` |
| Requisições/s   | `15.1099` |

---

# ⏱️ Histograma do Tempo de Resposta

| Faixa de Tempo (s) | Requisições | Gráfico                            |
|--------------------|-------------|------------------------------------|
| `1.227`            | 1           | `■■`                               |
| `1.246`            | 19          | `■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■`   |
| `1.265` → `1.398`  | 0           |                                    |
| `1.417`            | 20          | `■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■`  |

---

# 📈 Distribuição de Latência

| Percentil | Tempo (s)   |
|-----------|-------------|
| 10%       | `1.2312`    |
| 25%       | `1.2331`    |
| 50%       | `1.4088`    |
| 75%       | `1.4121`    |
| 90%       | `1.4134`    |
| 95%       | `1.4158`    |
| 0%        | `0.0000`    |



# ⚖️ Comparativo: Platform Thread vs Virtual Thread com Limite de 5 Threads

> Ambos os testes foram realizados com:
> - 40 requisições (`-n 40`)
> - 20 requisições simultâneas (`-c 20`)
> - Limite interno de **5 threads** na aplicação

## 📊 Resultados

| Métrica              | Platform Thread     | Virtual Thread     |
|----------------------|---------------------|--------------------|
| Tempo Total          | `9.7608s`           | `2.6473s`          |
| Requisições/segundo  | `4.0980`            | `15.1099`          |
| Mais Rápida          | `1.2188s`           | `1.2270s`          |
| Mais Lenta           | `6.1024s`           | `1.4169s`          |
| Tempo Médio          | `3.7828s`           | `1.3222s`          |

---

## 🧠 Conclusão

Mesmo com um limite rígido de **5 threads na aplicação**, o desempenho das **Virtual Threads** foi notavelmente superior:

- 🕒 **Tempo total 3,6x menor**, com finalização mais rápida de todas as requisições.
- 📈 **Taxa de throughput quase 4x maior**, o que significa melhor escalabilidade mesmo sob pressão.
- 💡 **Distribuição de latência muito mais uniforme**, sem grandes picos como no modelo com Platform Threads.

Isso evidencia que **Virtual Threads gerenciam bloqueios de forma mais eficiente**, especialmente em cenários com tarefas I/O-bound ou latência de rede, mesmo em contextos com restrições de thread física.

As Virtual Threads trazem uma nova era para concorrência em Java, oferecendo leveza e paralelismo com uma pegada muito mais próxima da programação síncrona. 🚀
