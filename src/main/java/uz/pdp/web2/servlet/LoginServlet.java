package uz.pdp.web2.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import uz.pdp.web2.model.User;
import uz.pdp.web2.service.UserService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import static uz.pdp.web2.codes.Codes.LOGIN;
import static uz.pdp.web2.codes.LoginCodes.LOGIN_ERROR;
import static uz.pdp.web2.codes.LoginCodes.LOGIN_SUCCESS;


@WebServlet(name = "LoginServlet", value = "/loginPage")
public class LoginServlet extends HttpServlet {
    public static User USER ;
    UserService userService = new UserService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.write(LOGIN);
    }

    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        System.out.println(req.getMethod());

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        USER = userService.login(email, password);
        PrintWriter writer = resp.getWriter();

        if (Objects.nonNull(USER)) {
            String text = LOGIN_SUCCESS.formatted(USER.firstName, USER.lastName,
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
