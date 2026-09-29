package br.rdu.idp.es.stsw.ecp;

public class PoliticaReservaLaboratorio {

    public DecisaoReserva avaliar(
            int estudantes, int duracao, int diasAntecedencia, TipoSolicitante solicitante) {
        if (estudantes < 1 || estudantes > 60
                || duracao < 1 || duracao > 4
                || diasAntecedencia < 0 || diasAntecedencia > 30
                || solicitante == null) {
            return DecisaoReserva.DADOS_INVALIDOS;
        }

        if (solicitante == TipoSolicitante.MONITOR && diasAntecedencia <= 1) {
            return DecisaoReserva.RECUSADA;
        }

        if (estudantes >= 41 && duracao == 4) {
            return DecisaoReserva.LISTA_DE_ESPERA;
        }

        return DecisaoReserva.CONFIRMADA;
    }
}
