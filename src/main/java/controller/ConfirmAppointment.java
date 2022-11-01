package controller;

import domain.Appointment;
import domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

public class ConfirmAppointment extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        int sid = Integer.parseInt(request.getParameter("sid"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        LocalDateTime localDateTime = LocalDateTime.parse(date+"T"+time+":00");
        System.out.println(localDateTime.toString());
        Appointment appointment = new Appointment();
        appointment.setUserid(user.getUserid());
        appointment.setDate(localDateTime);
        appointment.setServiceid(sid);
        System.out.println(appointment.getTimestamp().toString()+"XD");
        service.addAppointment(appointment);
        System.out.println(appointment.getTimestamp()+"XD");
        return "Controller?command=MakeAppointmentPage&sid="+sid;
    }
}
