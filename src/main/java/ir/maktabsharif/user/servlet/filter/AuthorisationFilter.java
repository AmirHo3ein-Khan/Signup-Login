package ir.maktabsharif.user.servlet.filter;
import ir.maktabsharif.user.dto.UserDTO;
import ir.maktabsharif.user.service.UserService;
import ir.maktabsharif.user.service.UserServiceImpl;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebFilter("/dashboard")
public class AuthorisationFilter implements Filter {
    private final UserService userService = new UserServiceImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession session = ((HttpServletRequest) req).getSession();


        if (username != null && password != null) {
            UserDTO userDTO = userService.login(username, password).get();
            if (!username.equals(userDTO.getUsername()) && !password.equals(userDTO.getPassword())) {
                req.setAttribute("message", "You should login first!");
                RequestDispatcher rq = req.getRequestDispatcher("/login.jsp");
                rq.forward(req, resp);
            } else {
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                filterChain.doFilter(req, resp);
            }
        } else {
            Optional<Object> usernameOptional = Optional.ofNullable(session.getAttribute("username"));
            Optional<Object> passwordOptional = Optional.ofNullable(session.getAttribute("password"));
            if (usernameOptional.isPresent() && passwordOptional.isPresent()) {
                UserDTO userDTO = userService.login(username, password).get();
                if (usernameOptional.get().equals(userDTO.getUsername()) && passwordOptional.get().equals(userDTO.getPassword())) {
                    filterChain.doFilter(req, resp);
                } else {
                    req.setAttribute("message", "You should login first!");
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                }
            } else {
                RequestDispatcher rq = req.getRequestDispatcher("/login.jsp");
                rq.forward(req, resp);
            }
        }
    }


    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
