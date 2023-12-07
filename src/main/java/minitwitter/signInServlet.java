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

@WebServlet("/signin")
public class signInServlet extends ViewBaseServlet {

    private userDAO UserDAO = new UserDAOImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        user User = UserDAO.signInVerification(username, password);

        if (User==null) {
            request.setAttribute("message","Username or password doesn't match the record!");

            response.sendRedirect("index.jsp");
//            super.processTemplate("index",request,response);
        }
        else {
            System.out.println(User);
            request.getSession().setAttribute("user",User);
            response.sendRedirect("index.jsp");
//            super.processTemplate("index",request,response);
        }

    }
}
