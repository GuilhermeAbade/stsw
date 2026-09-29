# Análise de valores limite em missões de drones

Esta submissão testa a regra de autorização de missões com quatro variações de
Boundary Value Analysis (BVA). A missão é `AUTORIZADA` somente quando bateria,
vento e carga estão dentro dos limites inclusivos abaixo; caso contrário, é
`NEGADA`.

| Entrada | Limites aceitos | Valor nominal |
|---|---:|---:|
| Bateria (%) | 30 a 100 | 70 |
| Vento (km/h) | 0 a 40 | 20 |
| Carga (kg) | 1 a 8 | 4 |

No **BVA normal**, há um caso com todos os valores nominais e quatro fronteiras
válidas por entrada (`min`, `min + 1`, `max - 1`, `max`), mantendo as outras duas
entradas nominais: `1 + 4 × 3 = 13` casos autorizados. As fronteiras verificam
se os limites inclusivos são aceitos corretamente.

O **BVA robusto** acrescenta `min - 1` e `max + 1` a cada entrada analisada:
`1 + 6 × 3 = 19` casos, sendo 13 autorizados e 6 negados. Os valores externos
verificam se a regra rejeita entradas logo além dos limites.

O **worst-case** combina os cinco valores válidos das três entradas:
`5 × 5 × 5 = 125` casos autorizados. O **robust worst-case** combina os sete
valores válidos e inválidos de cada entrada: `7 × 7 × 7 = 343` casos, sendo
125 autorizados e 218 negados. Essas combinações verificam também a interação
entre fronteiras de entradas diferentes. Os resultados esperados nos testes
usam os limites do enunciado, sem depender das constantes da implementação.

No diretório desta submissão, execute:

```bash
mvn test
mvn verify
```

O segundo comando gera o relatório de cobertura JaCoCo em
`target/site/jacoco/index.html`.
