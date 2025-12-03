package todoList.view;

import javax.swing.*;
import java.awt.*;

public class TodoInsertView extends JPanel {

    private JLabel lblContent = new JLabel("내용:");
    private JTextField tfContent = new JTextField(15);
    private JButton btnInsert = new JButton("등록");

    public TodoInsertView() {
        setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(lblContent, gbc);

        gbc.gridx = 1;
        formPanel.add(tfContent, gbc);

        formPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnPanel.add(btnInsert);
        btnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(formPanel);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(btnPanel);

        add(centerPanel, BorderLayout.CENTER);
    }

    public JButton getBtnInsert() {
        return btnInsert;
    }

    public String getContent() {
        return tfContent.getText();
    }

    public void clearInput() {
        tfContent.setText("");
    }
}