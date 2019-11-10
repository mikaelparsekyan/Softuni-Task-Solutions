package shapes.models;

import shapes.Shape;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    private Double getHeight() {
        return height;
    }

    private void setHeight(Double height) {
        this.height = height;
    }

    private Double getWidth() {
        return width;
    }

    private void setWidth(Double width) {
        this.width = width;
    }

    @Override
    public Double calculatePerimeter() {
        return (2 * height) + (2 * width);
    }

    @Override
    public Double calculateArea() {
        return height * width   ;
    }
}
