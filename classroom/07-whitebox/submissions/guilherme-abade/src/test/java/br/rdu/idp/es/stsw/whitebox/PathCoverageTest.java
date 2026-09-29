package br.rdu.idp.es.stsw.whitebox;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PathCoverageTest {

    @ParameterizedTest(name = "{0}")
    @CsvSource({
        "semDesconto, false, 50, false, false, 0",
        "valorMinimo, false, 150, false, false, 10",
        "apenasPremium, true, 50, false, false, 5",
        "cupomValido, false, 250, true, false, 25",
        "blackFriday, false, 50, false, true, 20",
        "premiumEValorAlto, true, 350, false, false, 35",
        "atingeOTeto, true, 350, true, false, 40"
    })
    void percorreCaminhoRepresentativo(String caminho, boolean premiumCustomer, int purchaseAmount,
                                       boolean couponValid, boolean blackFriday, int expectedDiscount) {
        DiscountCalculator calculator = new DiscountCalculator();

        assertEquals(expectedDiscount,
                calculator.calculateDiscount(premiumCustomer, purchaseAmount, couponValid, blackFriday), caminho);
    }
}
