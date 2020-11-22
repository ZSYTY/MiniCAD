import java.awt.*;

public class Rectangle extends Shape {
    Point p1 = new Point(), p2 = new Point();

    @Override
    public Point getPosition() {
        return p1;
    }

    @Override
    public Point getSize() {
        return new Point(p2.x - p1.x, p2.y - p1.y);
    }

    @Override
    public void setPosition(Point position) {
        p2 = new Point(position.x + p2.x - p1.x, position.y + p2.y - p1.y);
        p1 = (Point)position.clone();
    }

    @Override
    public void setSize(Point size) {
        p2 = new Point(p1.x + size.x, p1.y + size.y);
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(getPosition().x, getPosition().y, (int)(getSize().x * getScale()), (int)(getSize().y * getScale()));
    }

    @Override
    public boolean checkIn(Point p) {
        Point position = getPosition();
        Point size = getSize();
        return p.x >= position.x && p.x <= position.x + size.x * getScale() && p.y >= position.y && p.y <= position.y + size.y * getScale();
    }
}
