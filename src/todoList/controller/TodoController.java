package todoList.controller;

import center_frame.CenterFrame;
import todoList.domain.TodoVO;
import todoList.respository.TodoRepository;
import todoList.view.TodoEditView;
import todoList.view.TodoInsertView;
import todoList.view.TodoReadView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TodoController extends JFrame {

    TodoReadView readView;
    TodoInsertView insertView;

    TodoRepository todoRepository;
    ArrayList<TodoVO> todoList;

    JButton btnRefresh;
    JButton btnInsert;
    JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);

    public TodoController() {

        todoRepository = new TodoRepository();
        todoList = todoRepository.selectAll();

        // 1) 조회 화면
        readView = new TodoReadView(todoList);
        btnRefresh = readView.getBtnRefresh();
        btnRefresh.addActionListener(refreshL);

        // 삭제 버튼 리스너 연결 (⭐추가)
        readView.setDeleteListener(deleteBtnL);

        // 2) INSERT 화면
        insertView = new TodoInsertView();
        btnInsert = insertView.getBtnInsert();
        btnInsert.addActionListener(insertL);

        // 3) 수정 버튼 리스너 연결 (기존)
        readView.setUpdateListener(updateBtnL);

        // 탭 구성
        tab.add("조회", readView);
        tab.add("추가", insertView);

        add(tab);

        // 프레임 설정
        setTitle("투두리스트 관리 시스템");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(700, 500);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    // 새로고침 리스너
    ActionListener refreshL = e -> refreshTable();


    // INSERT 기능
    ActionListener insertL = e -> {
        String content = insertView.getContent();

        if (content.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "내용을 입력하세요.");
            return;
        }

        TodoVO todoVO = new TodoVO();
        todoVO.setContent(content);

        todoRepository.insert(todoVO);

        JOptionPane.showMessageDialog(null, "등록 완료!");
        insertView.clearInput();

        tab.setSelectedIndex(0);  // 조회 탭으로 이동

        refreshTable();   // 이벤트 재귀 방지
    };


    // ⭐ 수정 버튼 리스너
    ActionListener updateBtnL = e -> {

        int todoId = (int) e.getSource();

        TodoVO vo = todoRepository.showById(todoId);

        if (vo == null) {
            JOptionPane.showMessageDialog(null, "해당 할 일을 찾을 수 없습니다.");
            return;
        }

        TodoEditView editView = new TodoEditView(this, vo);

        editView.getBtnUpdate().addActionListener(ev -> {
            vo.setContent(editView.getUpdatedContent());
            vo.setComplete(editView.getUpdatedComplete());

            todoRepository.update(vo);

            JOptionPane.showMessageDialog(null, "수정 완료!");
            editView.dispose();

            refreshTable();
        });

        editView.setVisible(true);
    };


    // ⭐⭐ 삭제 버튼 리스너
    ActionListener deleteBtnL = e -> {

        int todoId = (int) e.getSource();

        int confirm = JOptionPane.showConfirmDialog(
                null,
                "정말 삭제하시겠습니까?",
                "삭제 확인",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {

            todoRepository.delete(todoId);

            JOptionPane.showMessageDialog(null, "삭제 완료!");

            refreshTable();
        }
    };


    // 공통 새로고침
    private void refreshTable() {
        todoList = todoRepository.selectAll();
        readView.setTodoList(todoList);
        readView.pubSearchResult();
    }

    public static void main(String[] args) {
        new TodoController();
    }
}