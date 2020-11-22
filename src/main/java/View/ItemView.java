import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ItemView extends JPanel {
    private ArrayList<JButton> buttons;
    private JTextField textField;
    ItemView() {
        buttons = new ArrayList<JButton>();

        buttons.add(new JButton("Line"));
        buttons.add(new JButton("Circle"));
        buttons.add(new JButton("Rectangle"));
        buttons.add(new JButton("Text"));

        for (JButton button : buttons) {
            add(button);
        }
        textField = new JTextField(16);
        add(textField);

    }

    public void addActionListener(int idx, ActionListener listener) {
        if (idx < buttons.size()) {
            buttons.get(idx).addActionListener(listener);
        }
    }

    public String getText() {
        return textField.getText();
    }

}
