package br.rdu.idp.es.stsw.decisiontable;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TabelaDecisaoConsolidadaTest {

    private final PoliticaReembolsoViagem politica = new PoliticaReembolsoViagem();

    @ParameterizedTest(name = "{0}: D={1}, P={2}, A={3}, H={4} -> {5}")
    @CsvSource({
        "C1, true, true, false, true, RECUSADO",
        "C2, false, true, true, false, RECUSADO",
        "C3, true, true, true, true, REVISAO_MANUAL",
        "C4, true, false, true, false, REVISAO_MANUAL",
        "C5, true, true, true, false, APROVADO"
    })
    void aplicaRegraConsolidada(String coluna, boolean documentacaoCompleta,
            boolean enviadoNoPrazo, boolean viagemAutorizada, boolean valorAlto,
            DecisaoReembolso esperado) {
        assertEquals(esperado, politica.avaliar(documentacaoCompleta, enviadoNoPrazo,
                viagemAutorizada, valorAlto), coluna);
    }
}
