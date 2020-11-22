import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainView extends JPanel {
    private ArrayList<Shape> shapeList;

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapeList) {

            shape.draw(g);
        }
    }

    MainView(ArrayList<Shape> shapeList) {
        this.shapeList = shapeList;
    }
}
