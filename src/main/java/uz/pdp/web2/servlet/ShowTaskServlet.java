package uz.pdp.web2.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.web2.service.ToDoService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShowTaskServlet", value = "/showTask")
public class ShowTaskServlet extends HttpServlet {
    ToDoService toDoService = new ToDoService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = (int) req.getSession().getAttribute("userId");
        boolean b = toDoService.checkUserTask(userId);
        if (!b) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("showTaskJsp.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            PrintWriter writer = resp.getWriter();
            writer.println("""
                    <!DOCTYPE html>
                    <html lang="en">
                    <head>
                        <meta charset="UTF-8">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <title>No Tasks</title>
                        <style>
                            body {
                                display: flex;
                                justify-content: center;
                                align-items: center;
                                height: 100vh;
                                background-color: #ffffff; /* Initial background color */
                                margin: 0;
                                transition: background-color 3s;
                            }
                            h1 {
                                font-family: Arial, sans-serif;
                                font-size: 2rem;
                                color: #ff6347;
                                text-shadow: 2px 2px 5px rgba(0,0,0,0.3);
                                transition: color 3s;
                            }
                        </style>
                    </head>
                    <body>
                        <h1>No tasks for this user</h1>
                                       
                        <script>
                            document.addEventListener("DOMContentLoaded", function() {
                                const message = "You currently have no tasks.";
                                alert(message);
                                       
                                const body = document.body;
                                const heading = document.querySelector('h1');
                                       
                                // Change background color and text color with transition
                                body.style.backgroundColor = "#f0f8ff"; // Light blue background
                                heading.style.color = "#4682b4"; // Steel blue text color
                                       
                                // Redirect to the previous page after 5 seconds
                                setTimeout(function() {
                                    heading.style.opacity = '0';
                                    body.style.transition = 'opacity 2s';
                                    body.style.opacity = '0';
                                    setTimeout(function() {
                                        window.history.back();
                                    }, 500);
                                }, 3000);
                            });
                        </script>
                    </body>
                    </html>
                    """);
            writer.close();
        }
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init() throws ServletException {

    }
}
