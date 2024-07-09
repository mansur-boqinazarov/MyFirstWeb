package uz.pdp.web2.servlet;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import lombok.SneakyThrows;
import uz.pdp.web2.model.User;
import uz.pdp.web2.service.UserService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Optional;

import static uz.pdp.web2.codes.Codes.LOGIN;
import static uz.pdp.web2.codes.LoginCodes.LOGIN_ERROR;
import static uz.pdp.web2.codes.LoginCodes.LOGIN_SUCCESS;


@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    UserService userService = new UserService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.write(LOGIN);
    }

    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(req.getMethod());

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = userService.login(email, password);
        PrintWriter writer = resp.getWriter();

        if (Objects.nonNull(user)) {
            HttpSession session = req.getSession();

            session.setAttribute("userId", Optional.of(user.getId()));


            String id = session.getId();
            Cookie coo = new Cookie("JSESSIONID", id);
            coo.setMaxAge(15);
            resp.addCookie(coo);


            String text = LOGIN_SUCCESS.formatted(user.firstName, user.lastName,
                    user.firstName,
                    user.lastName,
                    user.email,
                    user.password,
                    user.phone,
                    user.birthDate);
            writer.write(text);
        }
        else
            writer.write(LOGIN_ERROR);
    }
}
