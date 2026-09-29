package br.rdu.idp.es.stsw.bva;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NormalBvaTest {

    // 1 nominal + 4 fronteiras válidas para cada uma das 3 entradas = 13 casos.
    @ParameterizedTest(name = "bateria={0}, vento={1}, carga={2}")
    @CsvSource({
        "70, 20, 4",
        "30, 20, 4", "31, 20, 4", "99, 20, 4", "100, 20, 4",
        "70, 0, 4", "70, 1, 4", "70, 39, 4", "70, 40, 4",
        "70, 20, 1", "70, 20, 2", "70, 20, 7", "70, 20, 8"
    })
    void autorizaValoresNominaisEDeFronteira(int bateria, int vento, int carga) {
        assertEquals("AUTORIZADA", DroneMissionPolicy.evaluate(bateria, vento, carga));
    }
}
