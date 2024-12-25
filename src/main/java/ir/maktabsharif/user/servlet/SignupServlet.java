package ir.maktabsharif.user.servlet;
import ir.maktabsharif.user.dto.UserDTO;
import ir.maktabsharif.user.service.UserService;
import ir.maktabsharif.user.service.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.util.Set;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO userDTO = UserDTO.builder()
                .username(req.getParameter("username"))
                .password(req.getParameter("password"))
                .build();

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<UserDTO>> validates = validator.validate(userDTO);

        if (validates.isEmpty()) {
            if (!userService.isUsernameExist(req.getParameter("username"))) {
                userService.register(userDTO);
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            } else {
                req.setAttribute("usernameIsExist", "This username is already exist please try something else!");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        } else {
            StringBuilder errors = new StringBuilder();
            for (ConstraintViolation<UserDTO> violation : validates) {
                errors.append(violation.getMessage()).append("\n");
            }
            String errorHtml = errors.toString().replace("\n", "<br>");
            req.setAttribute("errors", errorHtml);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
