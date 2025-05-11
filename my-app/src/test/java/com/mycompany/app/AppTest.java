package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    private static final double DELTA = 1e-8;

    @Test
    public void testAverage_ZeroCases() {
        Sqrt s = new Sqrt(0);
        assertEquals(2.5, s.average(0.0, 5.0), DELTA);
        assertEquals(-2.5, s.average(-5.0, 0.0), DELTA);
    }

    @Test
    public void testIter_SimpleCase() {
        Sqrt s = new Sqrt(4.0);
        double result = s.iter(1.0, 4.0);
        assertEquals(2.0, result, DELTA);
    }

    @Test
    public void testAverage_PositiveNumbers() {
        Sqrt s = new Sqrt(0);
        assertEquals(4.5, s.average(4.0, 5.0), DELTA);
    }


    @Test
    public void testImprove_NegativeGuess() {
        Sqrt s = new Sqrt(16.0);
        double improved = s.improve(-4.0, 16.0);
        assertEquals(-4.0, improved, DELTA);
    }


    @Test
    public void testIter_FromExtremeGuess() {
        Sqrt s = new Sqrt(25.0);
        double result = s.iter(1000.0, 25.0);
        assertEquals(5.0, result, DELTA);
    }

    @Test
    public void testCalc_One() {
        Sqrt s = new Sqrt(1.0);
        assertEquals(1.0, s.calc(), DELTA);
    }

    @Test
    public void testGood_DeltaBoundary() {
        Sqrt s = new Sqrt(0);
        double criticalValue = Math.sqrt(s.delta);
        assertFalse(s.good(criticalValue, 0.0));
    }

    @Test
    public void testImprove_NaNHandling() {
        Sqrt s = new Sqrt(Double.NaN);
        double result = s.improve(1.0, Double.NaN);
        assertTrue(Double.isNaN(result));
    }

    @Test
    public void testGood_ZeroGuessNonZeroX() {
        Sqrt s = new Sqrt(0.0001);
        assertFalse(s.good(0.0, 0.0001));
    }

    @Test
    public void testIter_NegativeTarget() {
        Sqrt s = new Sqrt(-1.0);
        assertThrows(StackOverflowError.class, () -> s.iter(1.0, -1.0));
    }

}