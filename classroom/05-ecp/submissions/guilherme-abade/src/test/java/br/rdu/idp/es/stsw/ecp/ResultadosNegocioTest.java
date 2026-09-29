package br.rdu.idp.es.stsw.ecp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ResultadosNegocioTest {

    private final PoliticaReservaLaboratorio politica = new PoliticaReservaLaboratorio();

    @Test
    void recusaSolicitacaoUrgenteDeMonitor() {
        assertEquals(DecisaoReserva.RECUSADA,
                politica.avaliar(30, 2, 1, TipoSolicitante.MONITOR));
    }

    @Test
    void colocaTurmaGrandeDeQuatroHorasNaListaDeEspera() {
        assertEquals(DecisaoReserva.LISTA_DE_ESPERA,
                politica.avaliar(50, 4, 10, TipoSolicitante.PROFESSOR));
    }

    @Test
    void recusaMonitorUrgenteMesmoComTurmaGrandeDeQuatroHoras() {
        assertEquals(DecisaoReserva.RECUSADA,
                politica.avaliar(50, 4, 1, TipoSolicitante.MONITOR));
    }
}
