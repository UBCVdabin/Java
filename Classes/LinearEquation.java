package Classes;

public class LinearEquation {
    private double a, b, c, d, e, f;
    private double slope, x, y;

    public LinearEquation(double _a, double _b, double _c, double _d, double _e, double _f) {
        this.a = _a;
        this.b = _b;
        this.c = _c;
        this.d = _d;
        this.e = _e;
        this.f = _f;
        
        slope = b * c - a * d;
        x = ( d * e - b * f ) / (a * d - b * c );
        y = ( a * f - e * c ) / ( a * d - b * c );
    }

    public boolean isSolvable() {
        if (slope == 0) {
            return false;
        }
        return true;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
}
