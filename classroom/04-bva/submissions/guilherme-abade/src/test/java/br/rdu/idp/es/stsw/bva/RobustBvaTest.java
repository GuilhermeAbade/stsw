package br.rdu.idp.es.stsw.bva;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RobustBvaTest {

    // 1 nominal + 6 variações por entrada = 19 casos (13 autorizadas, 6 negadas).
    @ParameterizedTest(name = "bateria={0}, vento={1}, carga={2} -> {3}")
    @CsvSource({
        "70, 20, 4, AUTORIZADA",
        "29, 20, 4, NEGADA", "30, 20, 4, AUTORIZADA",
        "31, 20, 4, AUTORIZADA", "99, 20, 4, AUTORIZADA",
        "100, 20, 4, AUTORIZADA", "101, 20, 4, NEGADA",
        "70, -1, 4, NEGADA", "70, 0, 4, AUTORIZADA",
        "70, 1, 4, AUTORIZADA", "70, 39, 4, AUTORIZADA",
        "70, 40, 4, AUTORIZADA", "70, 41, 4, NEGADA",
        "70, 20, 0, NEGADA", "70, 20, 1, AUTORIZADA",
        "70, 20, 2, AUTORIZADA", "70, 20, 7, AUTORIZADA",
        "70, 20, 8, AUTORIZADA", "70, 20, 9, NEGADA"
    })
    void decideValoresDentroEForaDosLimites(
            int bateria, int vento, int carga, String esperado) {
        assertEquals(esperado, DroneMissionPolicy.evaluate(bateria, vento, carga));
    }
}
