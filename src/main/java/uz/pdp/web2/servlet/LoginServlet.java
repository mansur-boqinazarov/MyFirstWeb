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

/**
 * @author Mansurbek Boqinazarov
 */
@WebServlet(name = "LoginServlet", value = "/loginPage")
public class LoginServlet extends HttpServlet {
    UserService userService;
    @Override
    public void init() {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        String text  = """
                <head>
                <style>
                body {
                    font-family: Arial, sans-serif;
                    background-color: #f0f0f0;
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    height: 100vh;
                    margin: 0;
                }
                                
                .login-container {
                    background-color: white;
                    padding: 20px;
                    border-radius: 8px;
                    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                    width: 300px;
                    text-align: center;
                }
                                
                .login-container h2 {
                    margin-bottom: 20px;
                }
                                
                .input-group {
                    margin-bottom: 15px;
                    text-align: left;
                }
                                
                .input-group label {
                    display: block;
                    margin-bottom: 5px;
                }
                                
                .input-group input {
                    width: 100%;
                    padding: 8px;
                    border: 1px solid #ccc;
                    border-radius: 4px;
                    box-sizing: border-box;
                }
                                
                button {
                    background-color: #4CAF50;
                    color: white;
                    padding: 10px 15px;
                    border: none;
                    border-radius: 4px;
                    cursor: pointer;
                    width: 100%;
                }
                                
                button:hover {
                    background-color: #45a049;
                }
                                
                </style>
                </head>
                <body>
                    <div class="login-container">
                        <h2>Login</h2>
                        <form action="/loginPage">
                            <div class="input-group">
                                <label for="email">Email:</label>
                                <input type="email" id="email" name="email" required>
                            </div>
                            <div class="input-group">
                                <label for="password">Password:</label>
                                <input type="password" id="password" name="password" required>
                            </div>
                            <a href="userInfoPage"><button type="submit">Login</button></a>
                        </form>
                    </div>
                </body>
                """;
        writer.write(text);
    }

    @Override
    public void destroy() {

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User login = userService.login(email, password);
        PrintWriter writer = resp.getWriter();
        User user = new User();
        String text = """
                <body>
                <h1>Welcome %s %s</h1>
                <h5>Firstname: %s</h5>
                <h5>Lastname: %s</h5>
                <h5>Email: %s</h5>
                <h5>Password: %s</h5>
                <h5>Phone: %s</h5>
                <h5>BirthDay: %s</h5>
                </body>
                """.formatted(user.firstName, user.lastName,
                user.firstName,
                user.lastName,
                user.email,
                user.password,
                user.phone,
                user.birthDate);
        if (Objects.nonNull(login)){
            writer.write(text);
        }else {
            writer.write("<h1>Login Error</h1>");
        }
    }
}
