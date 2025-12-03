package todoList;

import todoList.domain.TodoVO;
import todoList.respository.TodoRepository;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        TodoRepository todoRepository = new TodoRepository();
        ArrayList<TodoVO> todoVOList = todoRepository.selectAll();
        for(TodoVO todoVO : todoVOList){
            System.out.println("todoId: " + todoVO.getTodoId());
            System.out.println("content: " + todoVO.getContent());
            System.out.println("createAt: " + todoVO.getCreateAT());
            System.out.println("complete: " + todoVO.getComplete());
            System.out.println("=====================================");
        }
    }
}
