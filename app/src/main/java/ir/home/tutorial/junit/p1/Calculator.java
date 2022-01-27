package ir.home.tutorial.junit.p1;

public class Calculator {
    public int divide(int i, int j) {
        if (j == 0)
            throw new ArithmeticException("Divide by zero");
        return i / j;
    }
}
