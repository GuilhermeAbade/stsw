package br.rdu.idp.es.stsw.decisiontable;

public class PoliticaReembolsoViagem {

    public DecisaoReembolso avaliar(boolean documentacaoCompleta,
            boolean enviadoNoPrazo, boolean viagemAutorizada, boolean valorAlto) {
        if (!viagemAutorizada) {
            return DecisaoReembolso.RECUSADO;
        }

        if (!documentacaoCompleta) {
            return DecisaoReembolso.RECUSADO;
        }

        if (valorAlto) {
            return DecisaoReembolso.REVISAO_MANUAL;
        }

        if (!enviadoNoPrazo) {
            return DecisaoReembolso.REVISAO_MANUAL;
        }

        return DecisaoReembolso.APROVADO;
    }
}
