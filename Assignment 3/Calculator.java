public class Calculator {
    static int calculationCount = 0; // static variable shared by all objects

    // Overloaded add methods
    int add(int a, int b) {
        calculationCount++;
        return a + b;
    }

    double add(double a, double b) {
        calculationCount++;
        return a + b;
    }

    int add(int a, int b, int c) {
        calculationCount++;
        return a + b + c;
    }

    static void showCount() {
        System.out.println("Total calculations performed: " + calculationCount);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("Sum of two integers: " + calc.add(10, 20));
        System.out.println("Sum of two decimals: " + calc.add(5.5, 4.3));
        System.out.println("Sum of three integers: " + calc.add(1, 2, 3));

        Calculator.showCount();
    }
}
