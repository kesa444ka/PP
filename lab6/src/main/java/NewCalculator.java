// Адаптер для OldCalculator
class NewCalculator implements CalculatorTarget {
    private final OldCalculator oldCalculator;

    public NewCalculator(OldCalculator oldCalculator) {
        this.oldCalculator = oldCalculator;
    }

    @Override
    public int sum(int a, int b) {
        return oldCalculator.add(a, b);
    }

    @Override
    public int subtractAndDouble(int a, int b) {
        return 2 * oldCalculator.subtract(a, b);
    }

    @Override
    public int multiplyAndSquare(int a, int b) {
        int product = oldCalculator.multiply(a, b);
        return product * product;
    }
}