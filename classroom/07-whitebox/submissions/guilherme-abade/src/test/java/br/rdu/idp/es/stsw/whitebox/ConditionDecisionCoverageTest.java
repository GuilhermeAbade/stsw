package br.rdu.idp.es.stsw.whitebox;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ConditionDecisionCoverageTest {

    @ParameterizedTest(name = "{0}")
    @CsvSource({
        "S1, true, 50, true, false, 5",
        "S2, true, 350, true, false, 40",
        "S3, false, 150, false, false, 10",
        "S4, false, 250, false, true, 30"
    })
    void cobreCondicoesEDecisoes(String caso, boolean premiumCustomer, int purchaseAmount,
                                boolean couponValid, boolean blackFriday, int expectedDiscount) {
        DiscountCalculator calculator = new DiscountCalculator();

        assertEquals(expectedDiscount,
                calculator.calculateDiscount(premiumCustomer, purchaseAmount, couponValid, blackFriday), caso);
    }
}
