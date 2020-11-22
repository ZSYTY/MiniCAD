import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements MouseListener, KeyListener {
    private Model model;
    private ItemView itemView;
    private MainView mainView;

    public Controller() {
        model = new Model();
        itemView = new ItemView();

        itemView.addActionListener(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setState(StateType.DRAW_LINE);
            }
        });

        itemView.addActionListener(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setState(StateType.DRAW_CIRCLE);
            }
        });

        itemView.addActionListener(2, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setState(StateType.DRAW_RECTANGLE);
            }
        });

        itemView.addActionListener(3, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setState(StateType.DRAW_TEXT);
            }
        });

        mainView = new MainView(model.getShapeList());
        mainView.addMouseListener(this);
        mainView.setBackground(Color.WHITE);
    }

    public JPanel getItemView() {
        return itemView;
    }

    public JPanel getMainView() {
        return mainView;
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        JFrame display = new JFrame();
        display.add(controller.getItemView(), BorderLayout.NORTH);
        display.add(controller.getMainView(), BorderLayout.CENTER);
        display.setTitle("MiniCAD");
        display.setSize(1024, 768);
        display.setLocationRelativeTo(null); // Center the display
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // choose
        System.out.println("clicked");
        model.choose(e.getPoint());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("pressed");
        model.startDraw(e.getPoint());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("released");
        model.endDraw(e.getPoint(), itemView.getText());
        mainView.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_KP_UP:
                model.enlarge();
                break;
            case KeyEvent.VK_DOWN:
                model.reduce();
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
