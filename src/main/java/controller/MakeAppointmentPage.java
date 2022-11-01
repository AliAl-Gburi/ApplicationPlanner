package controller;

import domain.Appointment;
import domain.MyDate;
import domain.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class MakeAppointmentPage extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int sid = Integer.parseInt(request.getParameter("sid"));
        Service currentService = service.getServiceByServiceID(sid);
        List<Appointment> bookedAppointments = service.getAppointmentsByServiceId(sid);
        Map<String, List<MyDate>> boop = currentService.getAvailableSlotsNext3WeeksMap();

        for (Appointment ap: bookedAppointments
             ) {
            if(boop.containsKey(ap.getAppointmentDay())) {
                boop.get(ap.getAppointmentDay()).removeIf(d -> d.getDate().getHour() == ap.getDate().getHour() && d.getDate().getMinute() == ap.getDate().getMinute());
            }
        }

        List<List<MyDate>> gotta = new ArrayList<>();
        for (List<MyDate> dl: boop.values()
             ) {
            gotta.add(dl);
        }
        request.setAttribute("currentService", currentService);
        request.setAttribute("gotta", gotta);
        request.setAttribute("availableAppointments", boop);
        return "makeappointment.jsp";
    }
}
