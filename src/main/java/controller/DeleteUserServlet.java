package controller;

import dao.UserDao;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/users/delete")
public class DeleteUserServlet extends HttpServlet {

    private UserDao userDao;

    public DeleteUserServlet() {
        this.userDao = new UserDao();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        try {
            userDao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("/users");

    }


}
