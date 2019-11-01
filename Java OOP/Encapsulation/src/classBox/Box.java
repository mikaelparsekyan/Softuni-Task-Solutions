package classBox;

public class Box {
    private double length;
    private double width;
    private double height;

    private double surfaceArea;
    private double lateralSurfaceArea;
    private double volume;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);

        this.calculate();
    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    private void calculate() {
        this.calculateSurfaceArea();
        this.calculateLateralSurfaceArea();
        this.calculateVolume();
    }

    public double calculateSurfaceArea() {
        double lengthByWidth = length * width;
        double lengthByHeight = length * height;
        double heightByWidth = height * width;
        this.surfaceArea = 2 * (lengthByWidth + lengthByHeight + heightByWidth);
        return this.surfaceArea;
    }

    public double calculateLateralSurfaceArea() {
        double lengthByHeight = length * height;
        double heightByWidth = height * width;
        this.lateralSurfaceArea = 2 * (lengthByHeight + heightByWidth);
        return this.lateralSurfaceArea;
    }

    public double calculateVolume() {
        this.volume = this.length * this.height * this.width;
        return this.volume;
    }

}
