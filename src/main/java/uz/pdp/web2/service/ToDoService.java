package uz.pdp.web2.service;

import uz.pdp.web2.repository.ToDoRepository;
import uz.pdp.web2.model.Todo;

import java.util.List;

/**
 * @author Mansurbek Boqinazarov
 */
public class ToDoService {
    public static final ToDoRepository repository = new ToDoRepository();
    public void save(Todo todo){
        repository.save(todo);
    }
    public List<Todo> getAll(){
        return repository.getAll();
    }
    public boolean checkUserTask(int id){
        return repository.getAll().stream()
               .filter(todo -> todo.getOwner_id() == id)
               .allMatch(todo -> todo.getTask().isEmpty());
    }
}
