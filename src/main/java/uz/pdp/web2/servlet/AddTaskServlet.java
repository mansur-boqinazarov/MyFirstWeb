package uz.pdp.web2.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import uz.pdp.web2.model.File;
import uz.pdp.web2.service.FileService;
import uz.pdp.web2.service.ToDoService;
import uz.pdp.web2.model.Todo;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

import static uz.pdp.web2.codes.SignUpCodes.SIGN_UP_SUCCESS;

@WebServlet(name = "AssTaskServlet",value = "/addTask")
@MultipartConfig
public class AddTaskServlet extends HttpServlet{
    ToDoService toDoService = new ToDoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("addTaskJsp.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String task = req.getParameter("task");
        String description = req.getParameter("description");
//        LocalDateTime dueDate = LocalDateTime.parse(req.getParameter("due_date"));
        LocalDateTime dueDate = LocalDateTime.now();
        Part file = req.getPart("file");
        int fileId = saveFile(file);
        toDoService.save(new Todo(LoginServlet.USER.id, task, description, dueDate,fileId));
        resp.getWriter().write(SIGN_UP_SUCCESS);
    }
    private int saveFile(Part file) throws IOException {
        FileService fileService =new FileService();
        String original_name = file.getSubmittedFileName();
        String mime_type = file.getContentType();
        byte[] fileData = file.getInputStream().readAllBytes();
        LocalDateTime uploadTime = LocalDateTime.now();

        File file1 = new File();
        file1.setOriginal_name(original_name);
        file1.setMime_type(mime_type);
        file1.setNew_name(UUID.randomUUID().toString());
        file1.setFile(fileData);
        file1.setUploadTime(uploadTime);

        return fileService.save(file1);

    }
}
