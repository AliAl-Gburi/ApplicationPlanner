package controller;

import domain.Business;
import domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CreateBusiness extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");
        String name = request.getParameter("businessname");
        Business business = new Business();
        business.setName(name);
        service.addBusiness(business, user);
        response.sendRedirect("Controller?command=MyBusiness");
        return "Controller?command=MyBusiness";
    }
}
