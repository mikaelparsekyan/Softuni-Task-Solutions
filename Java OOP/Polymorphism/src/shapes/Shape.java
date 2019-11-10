package shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    private Double getPerimeter() {
        return perimeter;
    }

    private void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    private Double getArea() {
        return area;
    }

    private void setArea(Double area) {
        this.area = area;
    }

    public abstract Double calculatePerimeter();

    public abstract Double calculateArea();
}
