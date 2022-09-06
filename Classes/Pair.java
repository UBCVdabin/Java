package Classes;

public class Pair {
    private Point2D p1, p2;

    public Pair() {
    }

    public Pair(Point2D p1, Point2D p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point2D getP1() {
        return p1;
    }
    public Point2D getP2() {
        return p2;
    }

    public void setP1(Point2D p1) {
        this.p1 = p1;
    }
    public void setP2(Point2D p2) {
        this.p2 = p2;
    }

    public double getDistance() {
        double diff_X = p2.getX() - p1.getX();
        double diff_Y = p2.getY() - p1.getY();
        return Math.sqrt(Math.pow(diff_X, 2) + Math.pow(diff_Y, 2));
    }
}
