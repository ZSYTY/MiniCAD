import java.awt.*;
import java.util.ArrayList;

public class Model {
    private ArrayList<Shape> shapeList;

    private StateType state;
    private int choosingIndex;
    private Point startPoint;

    Model() {
        shapeList = new ArrayList<Shape>();
    }

    public ArrayList<Shape> getShapeList() {
        return shapeList;
    }

    public void setState(StateType newState) {
        state = newState;
    }

    public void choose(Point p) {
        choosingIndex = -1;
        for (int i = 0; i < shapeList.size(); i++) {
            if (shapeList.get(i).checkIn(p)) {
                choosingIndex = i;
                setState(StateType.CHOOSING);
                break;
            }
        }
    }

    public void startDraw(Point p) {
        startPoint = p;
    }

    public void endDraw(Point p, String content) {
        Point size = new Point(p.x - startPoint.x, p.y - startPoint.y);
        if (state != StateType.DRAW_LINE && state != StateType.CHOOSING) {
            if (size.x < 0) {
                startPoint.x += size.x;
                size.x *= -1;
            }
            if (size.y < 0) {
                startPoint.y += size.y;
                size.y *= -1;
            }
        }
        System.out.println(size);
        switch (state) {
            case DRAW_LINE:
                Line line = new Line();
                line.setPosition(startPoint);
                line.setSize(size);
                shapeList.add(line);
                break;
            case DRAW_RECTANGLE:
                Rectangle rectangle = new Rectangle();
                rectangle.setPosition(startPoint);
                rectangle.setSize(size);
                shapeList.add(rectangle);
                break;
            case DRAW_CIRCLE:
                Circle circle = new Circle();
                circle.setPosition(startPoint);
                circle.setSize(size);
                shapeList.add(circle);
                break;
            case DRAW_TEXT:
                Text text = new Text(content);
                text.setPosition(startPoint);
                text.setSize(size);
                shapeList.add(text);
                break;
            case CHOOSING:
                if (choosingIndex >= 0 && choosingIndex < shapeList.size()) {
                    Point originPosition = shapeList.get(choosingIndex).getPosition();
                    shapeList.get(choosingIndex).setPosition(new Point(originPosition.x + size.x, originPosition.y + size
                    .y));
                }
                break;
        }
    }

    public void enlarge() {

    }

    public void reduce() {

    }

}
