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

/**
 * @author Mansurbek Boqinazarov
 */
@WebServlet(name = "LoginServlet", value = "/loginPage")
public class LoginServlet extends HttpServlet {
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

        User user = userService.login(email, password);
        PrintWriter writer = resp.getWriter();

        if (Objects.nonNull(user)) {
            String text = """
                    <!DOCTYPE html>
                    <html lang="en">
                    <head>
                        <meta charset="UTF-8">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <title>User Information</title>
                        <style>
                        .animated-button {
                            background-color: #4CAF50; /* Green background */
                            border: none; /* Remove border */
                            color: white; /* White text */
                            padding: 15px 32px; /* Some padding */
                            text-align: center; /* Centered text */
                            text-decoration: none; /* Remove underline */
                            display: inline-block; /* Make the button inline */
                            font-size: 16px; /* Increase font size */
                            margin: 4px 2px; /* Some margin */
                            cursor: pointer; /* Pointer/hand icon */
                            transition: all 0.3s ease; /* Add transition for animations */
                            border-radius: 12px; /* Rounded corners */
                        }
                        
                        .animated-button:hover {
                            background-color: #45a049; /* Darker green */
                            transform: scale(1.1); /* Slightly increase size */
                            box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0 rgba(0, 0, 0, 0.19); /* Add shadow */
                        }
                            body {
                                font-family: Arial, sans-serif;
                                background-color: #f0f0f0;
                                margin: 0;
                                padding: 100px;
                            }
                            .container {
                                max-width: 600px;
                                margin: auto;
                                background-color: #fff;
                                padding: 20px;
                                border-radius: 8px;
                                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                                opacity: 0;
                                transform: translateY(-20px);
                                animation: fadeIn 1s forwards;
                            }
                            h1, h5 {
                                color: #333;
                            }
                            h1 {
                                margin-top: 0;
                                font-size: 24px;
                                text-transform: uppercase;
                                letter-spacing: 1px;
                            }
                            h5 {
                                margin-bottom: 5px;
                                font-size: 16px;
                                color: #555;
                            }
                            p {
                                margin: 0;
                                font-size: 14px;
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
                            <h5>Firstname: <i>%s</i></h5>
                            <h5>Lastname: <i>%s</i> </h5>
                            <h5>Email: <i>%s</i>    </h5>
                            <h5>Password: <i>%s</i> </h5>
                            <h5>Phone: <i>%s</i> </h5>
                            <h5>BirthDay: <i>%s</i> </h5>
                            <hr>
                         <a href="/"><button class="animated-button">Back to Home</button></a>
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
                    """.formatted(user.firstName, user.lastName,
                    user.firstName,
                    user.lastName,
                    user.email,
                    user.password,
                    user.phone,
                    user.birthDate);
            writer.write(text);
        } else {
            writer.write(LOGIN_ERROR);
        }
    }
}
