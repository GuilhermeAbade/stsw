# Tabela de decisão para reembolso de viagem

Esta submissão aplica tabela de decisão à política de reembolso. As condições
são: **D** = documentação completa, **P** = enviado no prazo, **A** = viagem
autorizada e **H** = valor alto. `V` significa verdadeiro e `F`, falso.

## Tabela completa

As quatro condições booleanas formam `2⁴ = 16` combinações, enumeradas na
ordem D, P, A, H. Há 12 recusas, 3 revisões manuais e 1 aprovação.

| Regra | D | P | A | H | Decisão |
|---|:---:|:---:|:---:|:---:|---|
| R1 | F | F | F | F | `RECUSADO` |
| R2 | F | F | F | V | `RECUSADO` |
| R3 | F | F | V | F | `RECUSADO` |
| R4 | F | F | V | V | `RECUSADO` |
| R5 | F | V | F | F | `RECUSADO` |
| R6 | F | V | F | V | `RECUSADO` |
| R7 | F | V | V | F | `RECUSADO` |
| R8 | F | V | V | V | `RECUSADO` |
| R9 | V | F | F | F | `RECUSADO` |
| R10 | V | F | F | V | `RECUSADO` |
| R11 | V | F | V | F | `REVISAO_MANUAL` |
| R12 | V | F | V | V | `REVISAO_MANUAL` |
| R13 | V | V | F | F | `RECUSADO` |
| R14 | V | V | F | V | `RECUSADO` |
| R15 | V | V | V | F | `APROVADO` |
| R16 | V | V | V | V | `REVISAO_MANUAL` |

## Tabela consolidada

`-` indica que a condição é indiferente naquele contexto. As cinco colunas
abaixo cobrem as 16 regras sem misturar as duas prioridades de recusa.

| Coluna | D | P | A | H | Decisão | Regras agrupadas | Teste |
|---|:---:|:---:|:---:|:---:|---|---|---|
| C1 | - | - | F | - | `RECUSADO` | R1, R2, R5, R6, R9, R10, R13, R14 | R14: V, V, F, V |
| C2 | F | - | V | - | `RECUSADO` | R3, R4, R7, R8 | R7: F, V, V, F |
| C3 | V | - | V | V | `REVISAO_MANUAL` | R12, R16 | R16: V, V, V, V |
| C4 | V | F | V | F | `REVISAO_MANUAL` | R11 | R11: V, F, V, F |
| C5 | V | V | V | F | `APROVADO` | R15 | R15: V, V, V, F |

Cada coluna consolidada tem um teste com os valores mostrados na última coluna.
Assim, cinco testes representam as 16 regras completas.

No diretório desta submissão, execute:

```bash
mvn test
mvn verify
```

O relatório JaCoCo fica em `target/site/jacoco/index.html`.
