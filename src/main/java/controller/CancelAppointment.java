package controller;

import domain.Appointment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CancelAppointment extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int aid = Integer.parseInt(request.getParameter("aid"));
        Appointment appointment = service.getAppointmentByaid(aid);
        request.setAttribute("appointment", appointment);
        return "cancelappointment.jsp";
    }
}
