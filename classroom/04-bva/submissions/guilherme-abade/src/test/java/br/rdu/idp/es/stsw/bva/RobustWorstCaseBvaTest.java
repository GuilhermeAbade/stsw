package br.rdu.idp.es.stsw.bva;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RobustWorstCaseBvaTest {

    // 7 valores por entrada: 7 x 7 x 7 = 343 casos (125 autorizadas, 218 negadas).
    static Stream<Arguments> combinacoesRobustas() {
        int[] baterias = {29, 30, 31, 70, 99, 100, 101};
        int[] ventos = {-1, 0, 1, 20, 39, 40, 41};
        int[] cargas = {0, 1, 2, 4, 7, 8, 9};
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
    @MethodSource("combinacoesRobustas")
    void decideTodaCombinacaoRobusta(int bateria, int vento, int carga) {
        // Os limites vêm do enunciado, independentemente das constantes da classe testada.
        boolean dentroDosLimites = bateria >= 30 && bateria <= 100
                && vento >= 0 && vento <= 40
                && carga >= 1 && carga <= 8;
        String esperado = dentroDosLimites ? "AUTORIZADA" : "NEGADA";

        assertEquals(esperado, DroneMissionPolicy.evaluate(bateria, vento, carga));
    }
}
