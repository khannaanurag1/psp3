package org.example.productservice3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("1+2 = 3")
    void Test_AddTwoIntegers_ReturnsInteger() {
        //Arrange
        Calculator calculator = new Calculator();

        //Act
        int result = calculator.add(1,2);

        //Assert
        assert(3==result);
    }

    //First of all show by just running and it fails with exception
    //then show up assertthrows and how to use it.
    @Test
    @DisplayName("1/0 results in arithmetic exception")
    void Test_DivideByZero_ResultsInArithmeticException() {
        Calculator calculator = new Calculator();
        assertThrows(ArithmeticException.class, () -> calculator.divide(1,0));
    }
}