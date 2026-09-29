package br.rdu.idp.es.stsw.whitebox;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StatementCoverageTest {

    @Test
    void executaTodosOsAcrescimosEOTeto() {
        DiscountCalculator calculator = new DiscountCalculator();

        assertEquals(40, calculator.calculateDiscount(true, 350, true, true));
    }
}
