package uz.pdp.web2.todo;

import java.util.List;

/**
 * @author Mansurbek Boqinazarov
 */
public class ToDoService {
    public static final ToDoRepository repository = new ToDoRepository();
    public boolean save(Todo todo){
        repository.save(todo);
        return true;
    }
    public List<Todo> getAll(){
        return repository.getAll();
    }
}
