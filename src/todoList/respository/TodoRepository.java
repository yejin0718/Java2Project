package todoList.respository;

import jdbc_test.JDBCConnector;
import todoList.domain.TodoVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TodoRepository {
    ArrayList<TodoVO> todoVOList;

    public ArrayList<TodoVO> selectAll() {
        Connection con = JDBCConnector.getConnection();
        todoVOList = new ArrayList<TodoVO>();
        ResultSet rs = null;
        PreparedStatement psmt = null;
        String sql = "select * from todo ORDER BY todo_id ASC";
        try {
            psmt = con.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                TodoVO todoVO = new TodoVO();
                todoVO.setTodoId(rs.getInt("todo_id"));
                todoVO.setContent(rs.getString("content"));
                todoVO.setCreateAT(rs.getDate("create_at"));
                todoVO.setComplete(rs.getInt("complete"));
                todoVOList.add(todoVO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                if(rs!=null)
                    rs.close();

                if(psmt!=null)
                    psmt.close();

                if(con!=null)
                    con.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return  todoVOList;
    }

    public TodoVO showById(int todoId) {
        Connection con = JDBCConnector.getConnection();
        TodoVO todoVO = null;
        ResultSet rs = null;
        String sql = "select * from todo where todo_id = ?";
        PreparedStatement psmt = null;
        try {
            psmt = con.prepareStatement(sql);
            psmt.setInt(1, todoId);
            rs = psmt.executeQuery();

            if (rs.next()) {
                todoVO = new TodoVO();
                todoVO.setTodoId(rs.getInt("todo_id"));
                todoVO.setContent(rs.getString("content"));
                todoVO.setCreateAT(rs.getDate("create_at"));
                todoVO.setComplete(rs.getInt("complete"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(rs!=null)
                    rs.close();

                if (psmt != null)
                    psmt.close();

                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("insert close 문제 발생");
                e.printStackTrace();
            }
        }
        return todoVO;
    }

    public void insert(TodoVO todoVO) {
        Connection con = JDBCConnector.getConnection();
        String sql = "INSERT INTO todo (content)\n" +
                "VALUES (?)";
        PreparedStatement psmt = null;

        try {
            psmt = con.prepareStatement(sql);
            psmt.setString(1, todoVO.getContent());
            psmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (psmt != null)
                    psmt.close();

                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("insert close 문제 발생");
                e.printStackTrace();
            }
        }
    }

    public void update(TodoVO todoVO) {
        Connection con = JDBCConnector.getConnection();
        String sql = "UPDATE todo SET content = ?, complete = ? WHERE todo_id = ?";
        PreparedStatement psmt = null;

        try {
            psmt = con.prepareStatement(sql);
            psmt.setString(1, todoVO.getContent());
            psmt.setInt(2, todoVO.getComplete());
            psmt.setInt(3, todoVO.getTodoId());
            psmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(psmt!=null)
                    psmt.close();

                if(con!=null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("update close 문제 발생");
                e.printStackTrace();
            }
        }
    }

    public void delete(int todoId) {
        Connection con = JDBCConnector.getConnection();
        String sql = "delete from todo where todo_id = ?";
        PreparedStatement psmt = null;

        try {
            psmt = con.prepareStatement(sql);
            psmt.setInt(1, todoId);
            psmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (psmt != null)
                    psmt.close();

                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("delete close 문제 발생");
                e.printStackTrace();
            }
        }
    }
}
