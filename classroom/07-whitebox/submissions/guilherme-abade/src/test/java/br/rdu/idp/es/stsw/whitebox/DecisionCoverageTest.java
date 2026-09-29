package br.rdu.idp.es.stsw.whitebox;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DecisionCoverageTest {

    private final DiscountCalculator calculator = new DiscountCalculator();

    @Test
    void todasAsDecisoesVerdadeiras() {
        assertEquals(40, calculator.calculateDiscount(true, 350, true, true));
    }

    @Test
    void todasAsDecisoesFalsas() {
        assertEquals(0, calculator.calculateDiscount(false, 50, false, false));
    }
}
