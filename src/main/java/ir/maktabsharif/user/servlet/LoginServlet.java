package ir.maktabsharif.user.servlet;
import ir.maktabsharif.user.dto.UserDTO;
import ir.maktabsharif.user.service.UserService;
import ir.maktabsharif.user.service.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Optional<UserDTO> user = userService.login(username, password);
        if (user.isPresent()) {
        req.getRequestDispatcher("/dashboard.jsp").forward(req,resp);
        } else {
            req.setAttribute("loginError", "Username or password incorrect please try again!");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }
}