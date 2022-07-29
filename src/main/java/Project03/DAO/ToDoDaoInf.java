package Project03.DAO;

import Project03.Model.Todo;

import java.util.List;

public interface ToDoDaoInf {
    public void insertToDo(Todo td);

    public Todo selectToDo(int id);

    public List<Todo> selectToDoList();

    public boolean deleteToDo(int id);

    public boolean editToDo(Todo td);

}
