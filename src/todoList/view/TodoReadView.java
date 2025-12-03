package todoList.view;

import todoList.domain.TodoVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TodoReadView extends JPanel {

    JTable table;
    DefaultTableModel model;
    ArrayList<TodoVO> todoList;

    String[] header = {"ID", "내용", "생성일", "완료여부", "수정", "삭제"};

    JButton btnRefresh = new JButton("새로고침");

    // 버튼 클릭 시 Controller에서 사용할 리스너
    private ActionListener updateListener;
    private ActionListener deleteListener;

    public TodoReadView(ArrayList<TodoVO> todoList) {
        this.todoList = todoList;
        setLayout(new BorderLayout());
        initView();
    }

    public void initView() {

        model = new DefaultTableModel(header, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4 || column == 5;  // 수정/삭제 버튼만 클릭 가능
            }
        };

        table = new JTable(model);

        table.setRowHeight(30);

        // 버튼 렌더러 & 에디터 등록
        table.getColumn("수정").setCellRenderer(new ButtonRenderer());
        table.getColumn("수정").setCellEditor(new ButtonEditor("수정"));
        table.getColumn("삭제").setCellRenderer(new ButtonRenderer());
        table.getColumn("삭제").setCellEditor(new ButtonEditor("삭제"));

        pubSearchResult();

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        add(btnRefresh, BorderLayout.SOUTH);
    }

    public void setTodoList(ArrayList<TodoVO> todoList) {
        this.todoList = todoList;
    }

    public JButton getBtnRefresh() {
        return btnRefresh;
    }

    public void pubSearchResult() {
        model.setRowCount(0);

        for (TodoVO vo : todoList) {
            Object[] row = {
                    vo.getTodoId(),
                    vo.getContent(),
                    vo.getCreateAT(),
                    vo.getComplete() == 1 ? "완료" : "미완료",
                    "수정",
                    "삭제"
            };
            model.addRow(row);
        }
    }

    public void setUpdateListener(ActionListener listener) {
        this.updateListener = listener;
    }

    public void setDeleteListener(ActionListener listener) {
        this.deleteListener = listener;
    }

    // ---------- 버튼 렌더러 ----------
    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus,
                                                       int row, int column) {

            setText(value == null ? "" : value.toString());
            return this;
        }
    }

    // ---------- 버튼 에디터 (안정 버전) ----------
    class ButtonEditor extends AbstractCellEditor implements TableCellEditor {

        private JButton button;
        private String actionType;
        private int currentRow;

        private ActionListener buttonAction;  // ★ 액션 리스너 저장

        public ButtonEditor(String actionType) {
            this.actionType = actionType;
            this.button = new JButton(actionType);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int col) {

            this.currentRow = row;
            button.setText(actionType);

            // ★ 기존 리스너 제거 (중복 방지)
            if (buttonAction != null) {
                button.removeActionListener(buttonAction);
            }

            // ★ 새 리스너 등록
            buttonAction = ae -> {

                int todoId = (int) table.getValueAt(currentRow, 0);

                // fireEditingStopped() 후에 실행되도록 분리 → 무한 루프 방지
                SwingUtilities.invokeLater(() -> {
                    if ("수정".equals(actionType) && updateListener != null) {
                        updateListener.actionPerformed(
                                new ActionEvent(todoId, ActionEvent.ACTION_PERFORMED, "update"));
                    }

                    if ("삭제".equals(actionType) && deleteListener != null) {
                        deleteListener.actionPerformed(
                                new ActionEvent(todoId, ActionEvent.ACTION_PERFORMED, "delete"));
                    }
                });

                fireEditingStopped();  // ★ 여기서 에디팅 종료
            };

            button.addActionListener(buttonAction);

            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return actionType;
        }
    }
}
