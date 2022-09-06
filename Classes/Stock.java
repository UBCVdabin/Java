package Classes;

public class Stock {
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    public Stock(String _symbol, String _name, double _previousClosingPrice, double _currentPrice) {
        this.symbol = _symbol;
        this.name = _name;
        this.previousClosingPrice = _previousClosingPrice;
        this.currentPrice = _currentPrice;
    }

    public String getSymbol() {
        return symbol;
    }
    public String getName() {
        return name;
    }
    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }
    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPreviousClosingPrice(double previousClosingPrice) {
        this.previousClosingPrice = previousClosingPrice;
    }
    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getChangePercent() {
        return this.currentPrice - this.previousClosingPrice;
    }
}
