package br.rdu.idp.es.stsw.ecp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ClassesEquivalenciaValidasTest {

    private final PoliticaReservaLaboratorio politica = new PoliticaReservaLaboratorio();

    @ParameterizedTest(name = "estudantes={0}, duracao={1}, antecedencia={2}, solicitante={3}")
    @CsvSource({
        "30, 2, 10, PROFESSOR",
        "10, 2, 10, PROFESSOR",
        "50, 2, 10, PROFESSOR",
        "30, 4, 10, PROFESSOR",
        "30, 2, 1, PROFESSOR",
        "30, 2, 10, MONITOR"
    })
    void confirmaRepresentantesValidos(
            int estudantes, int duracao, int diasAntecedencia, TipoSolicitante solicitante) {
        assertEquals(DecisaoReserva.CONFIRMADA,
                politica.avaliar(estudantes, duracao, diasAntecedencia, solicitante));
    }
}
