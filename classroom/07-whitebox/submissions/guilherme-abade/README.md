# Teste caixa branca — desconto

`DiscountCalculator` soma 10% para compras a partir de 100, 5% para clientes premium, 15% para cupom válido em compras a partir de 200 e 20% para Black Friday ou cliente premium com compra a partir de 300. O desconto final é limitado a 40%.

As decisões do método são D1: valor ≥ 100; D2: premium; D3: cupom válido `&&` valor ≥ 200; D4: Black Friday `||` (premium `&&` valor ≥ 300); D5: desconto > 40. Em D3, as condições atômicas são cupom válido e valor ≥ 200. Em D4, são Black Friday, premium e valor ≥ 300. O Java usa short-circuit: a segunda parte de `&&` ou `||` pode deixar de ser avaliada.

| Critério | Testes | Demonstração |
| --- | ---: | --- |
| Instruções | 1 | Executa todos os acréscimos e aplica o teto. |
| Decisões | 2 | Faz D1–D5 assumirem verdadeiro e falso. |
| Condições | 4 | S1–S4 exercitam os dois valores de cada condição atômica de D3 e D4. |
| Condições e decisões | 4 | S1–S4 exercitam condições atômicas e os dois resultados de D1–D5. |
| Caminhos | 7 | Casos representativos abaixo. |

| Caminho | Premium | Valor | Cupom | Black Friday | Desconto |
| --- | --- | ---: | --- | --- | ---: |
| Sem desconto | F | 50 | F | F | 0 |
| Valor mínimo | F | 150 | F | F | 10 |
| Apenas premium | V | 50 | F | F | 5 |
| Cupom válido | F | 250 | V | F | 25 |
| Black Friday | F | 50 | F | V | 20 |
| Premium e valor alto | V | 350 | F | F | 35 |
| Atinge o teto | V | 350 | V | F | 40 |

São 18 execuções de teste no total. O JaCoCo mostra instruções, linhas e branches; não fornece porcentagem direta de cobertura de condições nem de caminhos. Esses critérios são demonstrados pelos casos acima.

Na pasta desta submissão, execute `mvn test` para rodar os testes ou `mvn verify` para gerar o relatório em `target/site/jacoco/index.html`.
