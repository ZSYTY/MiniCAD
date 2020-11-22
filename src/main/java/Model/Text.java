import java.awt.*;

public class Text extends Shape {
    private String content;
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
        g.setFont(new Font(null, Font.PLAIN, (int)(size.y * getScale())));
        g.drawString(content, position.x, (int)(position.y + size.y * getScale()));
    }

    @Override
    public boolean checkIn(Point p) {
        return p.x >= position.x && p.x <= position.x + size.x * getScale() && p.y >= position.y && p.y <= position.y + size.y * getScale();
    }

    Text(String content) {
        this.content = content;
    }
}
