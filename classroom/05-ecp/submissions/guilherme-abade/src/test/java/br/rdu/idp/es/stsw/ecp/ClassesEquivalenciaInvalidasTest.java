package br.rdu.idp.es.stsw.ecp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ClassesEquivalenciaInvalidasTest {

    private final PoliticaReservaLaboratorio politica = new PoliticaReservaLaboratorio();

    @ParameterizedTest(name = "estudantes={0}, duracao={1}, antecedencia={2}")
    @CsvSource({
        "0, 2, 10",
        "61, 2, 10",
        "30, 0, 10",
        "30, 5, 10",
        "30, 2, -1",
        "30, 2, 31"
    })
    void rejeitaUmaEntradaNumericaInvalidaPorVez(
            int estudantes, int duracao, int diasAntecedencia) {
        assertEquals(DecisaoReserva.DADOS_INVALIDOS,
                politica.avaliar(estudantes, duracao, diasAntecedencia, TipoSolicitante.PROFESSOR));
    }

    @Test
    void rejeitaSolicitanteNulo() {
        assertEquals(DecisaoReserva.DADOS_INVALIDOS, politica.avaliar(30, 2, 10, null));
    }
}
