public class CalculateUKT {
    private UktCalculateStrategy strategy;

    public CalculateUKT() {
    }

    public CalculateUKT(UktCalculateStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(UktCalculateStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculate(DataUKT data) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy belum diatur");
        }
        return strategy.calculateUkt(data);
    }
}