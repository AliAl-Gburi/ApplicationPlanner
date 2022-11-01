package controller;

import domain.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class MakeAppointment extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int sid = Integer.parseInt(request.getParameter("sid"));
        Service svc = service.getServiceByServiceID(sid);
        String date= request.getParameter("date");
        String time = request.getParameter("time");
        LocalDateTime dateTime = LocalDateTime.parse(date+"T"+time+":00");

        request.setAttribute("date", date);
        request.setAttribute("time", time);
        request.setAttribute("svc", svc);
        return "appointment-confirmation.jsp";
    }
}
