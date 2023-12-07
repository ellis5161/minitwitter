package minitwitter;

import DAO.impl.UserDAOImp;
import DAO.userDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/loginS")
public class loginSServlet extends ViewBaseServlet {

    private userDAO UserDAO = new UserDAOImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object user = request.getSession().getAttribute("user");
        System.out.println("loginss: " +user);
        super.processTemplate("loginS",request,response);

    }
}
