package uz.pdp.web2.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.web2.todo.ToDoService;
import uz.pdp.web2.todo.Todo;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import static uz.pdp.web2.codes.SignUpCodes.SIGN_UP_SUCCESS;

@WebServlet(name = "AssTaskServlet",value = "/addTask")
public class AddTaskServlet extends HttpServlet{
    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("jsp/addTask/addTaskJsp.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String task = req.getParameter("task");
        String description = req.getParameter("description");
        LocalDateTime dueDate = LocalDateTime.parse(req.getParameter("due_date"));
        ToDoService toDoService = new ToDoService();
        boolean save = toDoService.save(new Todo(LoginServlet.USER.id, task, description, dueDate));
        resp.getWriter().write(SIGN_UP_SUCCESS);
    }
}
