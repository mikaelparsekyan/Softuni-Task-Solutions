package pointInRectangle;

public class Rectangle {
    private Point bottomLeftPoint;
    private Point topRightPoint;

    public Rectangle(Point bottomLeftPoint, Point topRightPoint) {
        this.bottomLeftPoint = bottomLeftPoint;
        this.topRightPoint = topRightPoint;
    }

    public boolean contains(Point p) {
        int pX = p.getX();
        int pY = p.getY();

        int bottomLeftX = bottomLeftPoint.getX();
        int bottomLeftY = bottomLeftPoint.getY();

        int topRightX = topRightPoint.getX();
        int topRightY = topRightPoint.getY();

        return pX >= bottomLeftX && pX <= topRightX &&
                pY >= bottomLeftY && pY <= topRightY;
    }
}
