package controller;

import domain.Appointment;
import domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UserPage extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Appointment> appointmentList = service.getAppointmentsByUserId(user.getUserid());
        request.setAttribute("appointments", appointmentList);
        return "userpage.jsp";
    }
}
