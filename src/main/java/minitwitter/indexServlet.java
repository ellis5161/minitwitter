package minitwitter;

import DAO.impl.UserDAOImp;
import DAO.userDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.user;
import utils.JdbcUtils;

import java.io.IOException;

@WebServlet("/index")
public class indexServlet extends ViewBaseServlet {

    private userDAO UserDAO = new UserDAOImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        user User = (user) session.getAttribute("user");

        if (User==null) {
            super.processTemplate("index",request,response);
        }
        else {
            super.processTemplate("index",request,response);
        }

    }
}
