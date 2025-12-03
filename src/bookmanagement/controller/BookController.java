package bookmanagement.controller;

import bookmanagement.domain.BookVO;
import bookmanagement.repository.BookRepository;
import bookmanagement.view.BookInsertView;
import bookmanagement.view.BookSearchView;
import bookmanagement.view.BookUpdateView;
import center_frame.CenterFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class BookController extends JFrame {
    BookSearchView searchPan;
    BookInsertView insertPan;
    BookUpdateView updatePan;
    BookRepository bookRepository;
    ArrayList<BookVO> bookVOList;
    JComboBox<String> combo;
    JButton btnSearch;
    JButton btnInsert;
    JButton btnUpdate;
    JTable updateTable;
    JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);

    public BookController() {
        searchPan = new BookSearchView();
        combo = searchPan.getCombo();
        bookRepository = new BookRepository();
        bookVOList = bookRepository.select("", combo.getSelectedIndex());
        searchPan.setBookVOList(bookVOList);
        searchPan.initView();
        searchPan.pubSearchResult();
        btnSearch = searchPan.getBtnSearch();
        btnSearch.addActionListener(btnSearchL);

        tab.add("도서검색", searchPan);
        add(tab);

        //도서추가
        insertPan = new BookInsertView();
        bookVOList = bookRepository.select("", 0);
        insertPan.setBookVOList(bookVOList);
        insertPan.initView();
        btnInsert = insertPan.getBtnAdd();
        btnInsert.addActionListener(btnInsertL);
        tab.add("도서추가", insertPan);

        //도서 수정 및 삭제
        updatePan = new BookUpdateView();
        bookVOList = bookRepository.select("", 0);
        updatePan.setBookVOList(bookVOList);
        updatePan.initView();
        btnUpdate = updatePan.getBtnUpdate();
        btnUpdate.addActionListener(btnUpdateL);
        updateTable = updatePan.getTable();
        updateTable.addMouseListener(tableUpdateL);
        tab.add("도서수정 및 삭제", updatePan);
        tab.addMouseListener(tabL);


        setTitle("도서관리시스템");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(600, 500);
        cf.centerXY();
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    ActionListener btnSearchL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            bookVOList = bookRepository.select(searchPan.getSearchWord(), combo.getSelectedIndex());
            searchPan.setBookVOList(bookVOList);
            searchPan.pubSearchResult();
        }
    };

    ActionListener btnInsertL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            BookVO vo = insertPan.neededInsertData();
            bookRepository.insert(vo);
            bookVOList = bookRepository.select("", 0);
            insertPan.setBookVOList(bookVOList);
            insertPan.pubSearchResult();
            insertPan.initInsertData();
        }
    };

    MouseAdapter tableUpdateL = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 1) {
                int rowIndex = updateTable.getSelectedRow();
                updatePan.setTextFiled(rowIndex);
            }
            if(e.getClickCount() == 2){
                int result = JOptionPane.showConfirmDialog(BookController.this, "정말로 삭제하시겠습니까?", "예", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    BookVO vo = updatePan.neededUpdateData();
                    bookRepository.delete(vo);
                    bookVOList = bookRepository.select("", 0);
                    updatePan.setBookVOList(bookVOList);
                    updatePan.pubSearchResult();
                }
            }
        }
    };

    ActionListener btnUpdateL = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            BookVO vo = updatePan.neededUpdateData();
            bookRepository.update(vo);
            bookVOList = bookRepository.select("", 0);
            updatePan.setBookVOList(bookVOList);
            updatePan.pubSearchResult();
        }
    };

    MouseAdapter tabL = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int tabIndex = tab.getSelectedIndex();
            if (tabIndex == 0) {
                bookVOList = bookRepository.select("", 0);
                searchPan.setBookVOList(bookVOList);
                searchPan.pubSearchResult();
            } else if (tabIndex == 1) {
                bookVOList = bookRepository.select("", 0);
                insertPan.setBookVOList(bookVOList);
                insertPan.pubSearchResult();
            } else if (tabIndex == 2) {
                bookVOList = bookRepository.select("", 0);
                updatePan.setBookVOList(bookVOList);
                updatePan.pubSearchResult();
            }
        }
    };

    public static void main(String[] args) {
        new BookController();
    }
}
