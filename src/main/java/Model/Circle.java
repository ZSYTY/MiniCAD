import java.awt.*;

public class Circle extends Shape {
    private Point position, size;

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public Point getSize() {
        return size;
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public void setSize(Point size) {
        this.size = size;
    }

    @Override
    public void draw(Graphics g) {
        g.drawOval(position.x, position.y, (int)(size.x * getScale()), (int)(size.y * getScale()));
    }

    @Override
    public boolean checkIn(Point p) {
        return p.x >= position.x && p.x <= position.x + size.x  * getScale() && p.y >= position.y && p.y <= position.y + size.y * getScale();
    }
//
//    Circle(Point o, int d) {
//        this.o = (Point) o.clone();
//        this.d = d;
//    }

}
