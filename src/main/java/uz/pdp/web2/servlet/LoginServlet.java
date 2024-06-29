package uz.pdp.web2.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.web2.user.User;
import uz.pdp.web2.user.UserService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import static uz.pdp.web2.codes.Codes.LOGIN;
import static uz.pdp.web2.codes.LoginCodes.LOGIN_ERROR;


@WebServlet(name = "LoginServlet", value = "/loginPage")
public class LoginServlet extends HttpServlet {
    public static User USER ;
    UserService userService = new UserService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.write(LOGIN);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getMethod());

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        USER = userService.login(email, password);
        PrintWriter writer = resp.getWriter();

        if (Objects.nonNull(USER)) {
            String text = """
                    <!DOCTYPE html>
                           <html lang="en">
                           <head>
                               <meta charset="UTF-8">
                               <meta name="viewport" content="width=device-width, initial-scale=1.0">
                               <title>User Information</title>
                               <style>
                                   body {
                                       font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                                       background-color: #f0f0f0;
                                       margin: 0;
                                       padding: 0;
                                       display: flex;
                                       justify-content: center;
                                       align-items: center;
                                       height: 100vh;
                                   }
                                   .container {
                                       max-width: 600px;
                                       background-color: #ffffff;
                                       padding: 20px;
                                       border-radius: 8px;
                                       box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
                                       opacity: 0;
                                       transform: translateY(-20px);
                                       animation: fadeIn 1s forwards;
                                   }
                                   h1 {
                                       margin-top: 0;
                                       font-size: 28px;
                                       text-transform: uppercase;
                                       letter-spacing: 2px;
                                       color: #4CAF50;
                                       border-bottom: 2px solid #4CAF50;
                                       padding-bottom: 10px;
                                   }
                                   h5 {
                                       font-size: 16px;
                                       color: #555;
                                       margin-bottom: 15px;
                                   }
                                   p {
                                       margin: 0;
                                       font-size: 14px;
                                       color: #333;
                                   }
                                   .button-container {
                                       display: flex;
                                       justify-content: space-between;
                                       margin-top: 20px;
                                   }
                                   .custom-button, .animated-button {
                                       background-color: #4CAF50;
                                       border: none;
                                       color: white;
                                       padding: 15px 32px;
                                       text-align: center;
                                       text-decoration: none;
                                       display: inline-block;
                                       font-size: 16px;
                                       margin: 4px 2px;
                                       cursor: pointer;
                                       transition-duration: 0.4s;
                                       border-radius: 12px;
                                       flex: 1; /* Tugmalarni teng ravishda bo'lish uchun */
                                       margin: 5px; /* Tugmalar orasidagi bo'shliq */
                                   }
                                   .custom-button:hover, .animated-button:hover {
                                       background-color: white;
                                       color: black;
                                       border: 2px solid #4CAF50;
                                       transform: scale(1.05);
                                   }
                                   @keyframes fadeIn {
                                       to {
                                           opacity: 1;
                                           transform: translateY(0);
                                       }
                                   }
                               </style>
                           </head>
                           <body>
                               <div class="container">
                                   <h1>Welcome %s %s</h1>
                                   <div class="button-container">
                                       <a href="/addTask"><button class="animated-button">Add Task</button></a>
                                       <a href="/showTask"><button class="animated-button">Show Task</button></a>
                                       <a href="/"><button class="custom-button">Back to Home</button></a>
                                   </div>
                               </div>
                               <script>
                                   document.addEventListener('DOMContentLoaded', function() {
                                       const container = document.querySelector('.container');
                                       container.style.opacity = '1';
                                       container.style.transform = 'translateY(0)';
                                   });
                               </script>
                           </body>
                           </html>
                    """.formatted(USER.firstName, USER.lastName,
                    USER.firstName,
                    USER.lastName,
                    USER.email,
                    USER.password,
                    USER.phone,
                    USER.birthDate);
            writer.write(text);
        } else {
            writer.write(LOGIN_ERROR);
        }
    }
}
