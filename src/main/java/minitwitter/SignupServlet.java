package minitwitter;

import DAO.impl.UserDAOImp;
import DAO.userDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.user;
import utils.JdbcUtils;

import java.io.IOException;

@WebServlet("/sign-up")
public class SignupServlet extends ViewBaseServlet {

    private userDAO user = new UserDAOImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nickname = request.getParameter("nickname");

        if (user.lookForUsername(username)==null) {
            user.saveUser(new user(username, password, nickname, 3));
            request.getSession().setAttribute("message","Sign Up Successfully");
            JdbcUtils.commitAndClose();
//            super.processTemplate("signup",request,response);
            response.sendRedirect("index.jsp");
        }
        else {
            request.getSession().setAttribute("message","Username exists.");
            JdbcUtils.rollbackAndClose();
//            super.processTemplate("signup",request,response);
            response.sendRedirect("signup.jsp");
        }


    }
}
