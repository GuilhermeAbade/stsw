package br.rdu.idp.es.stsw.bva;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WorstCaseBvaTest {

    // 5 valores válidos por entrada: 5 x 5 x 5 = 125 casos.
    static Stream<Arguments> combinacoesValidas() {
        int[] baterias = {30, 31, 70, 99, 100};
        int[] ventos = {0, 1, 20, 39, 40};
        int[] cargas = {1, 2, 4, 7, 8};
        List<Arguments> casos = new ArrayList<>();

        for (int bateria : baterias) {
            for (int vento : ventos) {
                for (int carga : cargas) {
                    casos.add(Arguments.of(bateria, vento, carga));
                }
            }
        }
        return casos.stream();
    }

    @ParameterizedTest(name = "bateria={0}, vento={1}, carga={2}")
    @MethodSource("combinacoesValidas")
    void autorizaTodaCombinacaoValida(int bateria, int vento, int carga) {
        assertEquals("AUTORIZADA", DroneMissionPolicy.evaluate(bateria, vento, carga));
    }
}
