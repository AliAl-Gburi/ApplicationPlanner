package controller;

import domain.Business;
import domain.Service;
import domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

public class MyBusiness extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Business> businesses = service.getAllUserBusiness(user.getUserid());
        request.setAttribute("businesses", businesses);
        return "mybusinesses.jsp";
    }
}
