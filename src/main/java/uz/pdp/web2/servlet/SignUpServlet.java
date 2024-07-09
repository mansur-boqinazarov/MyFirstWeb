package uz.pdp.web2.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.web2.model.User;
import uz.pdp.web2.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import static uz.pdp.web2.codes.Codes.SIGN_UP;
import static uz.pdp.web2.codes.SignUpCodes.*;

@WebServlet(name = "SignUpServlet", value = "/signup")
public class SignUpServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));
        boolean b = userService.signUp(new User(firstName, lastName, email, password, phone, birthDate));
        PrintWriter writer = resp.getWriter();
        if (b) {
            writer.write(SIGN_UP_SUCCESS);
        } else {
            writer.write(SIGN_UP_ERROR);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write(SIGN_UP);
    }

}
