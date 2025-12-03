package todoList.view;

import todoList.domain.TodoVO;

import javax.swing.*;
import java.awt.*;

public class TodoEditView extends JDialog {
    private JTextField tfContent;
    private JCheckBox cbComplete;

    private JButton btnUpdate;
    private JButton btnCancel;

    private TodoVO todo;

    public TodoEditView(JFrame owner, TodoVO todo) {
        super(owner, "할 일 수정", true);  // 모달 다이얼로그
        this.todo = todo;

        setLayout(new BorderLayout());
        initView();

        setSize(400, 250);
        setLocationRelativeTo(owner);
    }

    private void initView() {

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // --- Content ---
        formPanel.add(new JLabel("내용: "));
        tfContent = new JTextField(todo.getContent());
        formPanel.add(tfContent);

        // --- Complete ---
        formPanel.add(new JLabel("완료 여부: "));
        cbComplete = new JCheckBox("완료됨", todo.getComplete() == 1);
        formPanel.add(cbComplete);

        // --- Buttons ---
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        btnUpdate = new JButton("수정하기");
        btnCancel = new JButton("취소");

        btnPanel.add(btnUpdate);
        btnPanel.add(btnCancel);

        add(formPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);

        // 취소 버튼
        btnCancel.addActionListener(e -> dispose());
    }

    // Controller가 값 가져가도록 Getter 제공
    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public String getUpdatedContent() {
        return tfContent.getText();
    }

    public int getUpdatedComplete() {
        return cbComplete.isSelected() ? 1 : 0;
    }
}
