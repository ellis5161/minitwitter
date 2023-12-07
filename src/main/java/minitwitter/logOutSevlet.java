
package minitwitter;

        import DAO.impl.UserDAOImp;
        import DAO.userDAO;
        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;

        import java.io.IOException;

@WebServlet("/logOut")
public class logOutSevlet extends ViewBaseServlet {

    private userDAO UserDAO = new UserDAOImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("user");
        response.sendRedirect("index.jsp");
    }
}
