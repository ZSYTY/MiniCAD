import java.awt.*;

public abstract class Shape {
    private Color color;
    private double scale = 1;

    abstract public Point getPosition();
    abstract public Point getSize();
    abstract public void setPosition(Point position);
    abstract public void setSize(Point size);
    abstract public void draw(Graphics g);
    abstract public boolean checkIn(Point p);

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public double getScale() {
        return scale;
    }

    public void enlarge() {
        scale += 0.1;
    }

    public void reduce() {
        scale -= 0.1;
        if (scale < 0) {
            scale = 0;
        }
    }
}
