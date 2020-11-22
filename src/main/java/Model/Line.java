import java.awt.*;

public class  Line extends Shape {
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
        g.drawLine(p1.x, p1.y, p2.x, p2.y);
    }

    @Override
    public boolean checkIn(Point p) {
        int MinX = Math.min(p1.x, p2.x);
        int MinY = Math.min(p1.y, p2.y);
        int MaxX = Math.max(p1.x, p2.x);
        int MaxY = Math.max(p1.y, p2.y);
        return p.x >= MinX && p.x <= MaxX && p.y >= MinY && p.y <= MaxY;
    }
}
