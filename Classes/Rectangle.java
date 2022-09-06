package Classes;

public class Rectangle {
    private double width, height;


    public Rectangle() {
        width = 1;
        height = 1;
    }
    public Rectangle(double _width, double _height) {
        this.width = _width;
        this.height = _height;
    }
    
    public double getHeight() {
        return height;
    }
    public double getWidth() {
        return width;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public void setWidth(double width) {
        this.width = width;
    }

    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return (this.width + this.height) * 2;
    }
}
