package controller;

import domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class Register extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        User user = new User();
        setEmail(user, request);
        setPassword(user, request);
        setUserName(user, request);
        service.add(user);
        return "index.jsp";
    }

    public void setEmail(User user, HttpServletRequest request) {
        String email = request.getParameter("email");
        user.setEmail(email);
    }
    public void setPassword(User user, HttpServletRequest request) {
        String password = request.getParameter("password");
        user.setPassword(password);
    }
    public void setUserName(User user, HttpServletRequest request) {
        String username = request.getParameter("username");
        user.setUsername(username);
    }
}
