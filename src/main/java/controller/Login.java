package controller;

import domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String error = "No valid email/password";
        String password = request.getParameter("password");
        String destination = "index.jsp";
        try {
            User user = service.getifAuthenticated(email, password);
            if(user.getUserid() < 1) throw new IllegalArgumentException();
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect(destination);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException a) {
            request.setAttribute("error", error);
            return destination;
        }
        return destination;
    }
}
