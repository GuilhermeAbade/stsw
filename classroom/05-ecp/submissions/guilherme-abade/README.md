# Classes de equivalência em reservas de laboratório

Esta atividade usa representantes de classes de equivalência para testar a
política de reservas. Quando uma entrada é analisada isoladamente, as demais
usam os valores nominais: 30 estudantes, 2 horas, 10 dias e `PROFESSOR`.

| ID | Entrada | Classe | Tipo | Representante | Resultado |
|---|---|---|---|---|---|
| E1 | Estudantes | Menos de 1 | Inválida | 0 | `DADOS_INVALIDOS` |
| E2 | Estudantes | 1 a 20 (pequena) | Válida | 10 | `CONFIRMADA` |
| E3 | Estudantes | 21 a 40 (regular) | Válida | 30 | `CONFIRMADA` |
| E4 | Estudantes | 41 a 60 (grande) | Válida | 50 | `CONFIRMADA` |
| E5 | Estudantes | Mais de 60 | Inválida | 61 | `DADOS_INVALIDOS` |
| E6 | Duração | Menos de 1 hora | Inválida | 0 | `DADOS_INVALIDOS` |
| E7 | Duração | 1 a 3 horas | Válida | 2 | `CONFIRMADA` |
| E8 | Duração | 4 horas | Válida | 4 | `CONFIRMADA` |
| E9 | Duração | Mais de 4 horas | Inválida | 5 | `DADOS_INVALIDOS` |
| E10 | Antecedência | Menos de 0 dias | Inválida | -1 | `DADOS_INVALIDOS` |
| E11 | Antecedência | 0 a 1 dia (urgente) | Válida | 1 | `CONFIRMADA` |
| E12 | Antecedência | 2 a 30 dias | Válida | 10 | `CONFIRMADA` |
| E13 | Antecedência | Mais de 30 dias | Inválida | 31 | `DADOS_INVALIDOS` |
| E14 | Solicitante | Professor | Válida | `PROFESSOR` | `CONFIRMADA` |
| E15 | Solicitante | Monitor | Válida | `MONITOR` | `CONFIRMADA` |
| E16 | Solicitante | Nulo | Inválida | `null` | `DADOS_INVALIDOS` |

As faixas de estudantes seguem as categorias do enunciado. A duração de 4
horas fica separada de 1 a 3 porque pode levar à lista de espera; urgência e
tipo de solicitante ficam separados porque sua combinação pode causar recusa.
Não repetimos todos os valores de uma faixa nem o produto de todas as classes,
pois isso acrescentaria casos com o mesmo comportamento sem distinguir regras.

Com entradas válidas, `MONITOR` e 1 dia de antecedência resultam em `RECUSADA`;
50 estudantes e 4 horas resultam em `LISTA_DE_ESPERA`. Quando as duas condições
ocorrem juntas, prevalece `RECUSADA`. Uma combinação nominal é `CONFIRMADA`, e
cada classe inválida produz `DADOS_INVALIDOS`.

A API recebe `TipoSolicitante` como enum: strings vazias e códigos textuais
desconhecidos não chegam diretamente ao método. `null` é tratado como inválido.

No diretório desta submissão, execute:

```bash
mvn test
mvn verify
```

O relatório JaCoCo fica em `target/site/jacoco/index.html`.
