package ir.maktabsharif.user.servlet.filter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebFilter("/dashboard")
public class AuthorisationFilter implements Filter {

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
            req.setAttribute("message", "You should login first!");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            Optional<Object> usernameOptional = Optional.ofNullable(session.getAttribute("username"));
            Optional<Object> passwordOptional = Optional.ofNullable(session.getAttribute("password"));
            if (usernameOptional.isPresent() && passwordOptional.isPresent()) {
                filterChain.doFilter(req, resp);
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
