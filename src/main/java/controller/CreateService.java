package controller;

import domain.Business;
import domain.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateService extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int bid = Integer.parseInt(request.getParameter("bid"));
        Business business = service.getBusinessbyID(bid);
        Service srvice = new Service();
        setName(srvice, request);
        setAppointmentIntervals(srvice, request);
        setWorkingHours(srvice, request);
        service.addService(srvice, business);
        response.sendRedirect("Controller?command=BusinessPage");
        return "Controller?command=BusinessPage";
    }

    private void setName(Service service, HttpServletRequest request) {
        String name = request.getParameter("servicename");
        service.setName(name);
    }

    private void setWorkingHours(Service service, HttpServletRequest request) {
        String res = "";
        String monday = request.getParameter("monday");
        if(monday != null && !monday.trim().isEmpty()) {
            res += monday + ",";
        }

        String mons1 = request.getParameter("starttimemonday1");
        String mone1 = request.getParameter("endtimemonday1");

        if(mons1 != null && !mons1.trim().isEmpty()) {
            res+= mons1 + "-" + mone1 + ",";
        }

        String mons2 = request.getParameter("starttimemonday2");
        String mone2 = request.getParameter("endtimemonday2");

        if(mons2 != null && !mons2.trim().isEmpty()) {
            res+= mons2 + "-" + mone2 + ",";
        }

        String mons3 = request.getParameter("starttimemonday3");
        String mone3 = request.getParameter("endtimemonday3");

        if(mons3 != null && !mons3.trim().isEmpty()) {
            res+= mons3 + "-" + mone3 + ",";
        }

        String mons4 = request.getParameter("starttimemonday4");
        String mone4 = request.getParameter("endtimemonday4");

        if(mons4 != null && !mons4.trim().isEmpty()) {
            res+= mons4 + "-" + mone4 + ",";
        }

        String mons5 = request.getParameter("starttimemonday5");
        String mone5 = request.getParameter("endtimemonday5");

        if(mons5 != null && !mons5.trim().isEmpty()) {
            res+= mons5 + "-" + mone5 + ",";
        }
        if(monday != null && !monday.trim().isEmpty()) {
            res += ";";
        }

        String tuesday = request.getParameter("tuesday");

        if(tuesday != null && !tuesday.trim().isEmpty()) {
            res += tuesday + ",";
        }

        String tues1 = request.getParameter("starttimetuesday1");
        String tuee1 = request.getParameter("endtimetuesday1");

        if(tues1 != null && !tues1.trim().isEmpty()) {
            res+= tues1 + "-" + tuee1 + ",";
        }

        String tues2 = request.getParameter("starttimetuesday2");
        String tuee2 = request.getParameter("endtimetuesday2");

        if(tues2 != null && !tues2.trim().isEmpty()) {
            res+= tues2 + "-" + tuee2 + ",";
        }

        String tues3 = request.getParameter("starttimetuesday3");
        String tuee3 = request.getParameter("endtimetuesday3");

        if(tues3 != null && !tues3.trim().isEmpty()) {
            res+= tues3 + "-" + tuee3 + ",";
        }

        String tues4 = request.getParameter("starttimetuesday4");
        String tuee4 = request.getParameter("endtimetuesday4");

        if(tues4 != null && !tues4.trim().isEmpty()) {
            res+= tues4 + "-" + tuee4 + ",";
        }

        String tues5 = request.getParameter("starttimetuesday5");
        String tuee5 = request.getParameter("endtimetuesday5");

        if(tues5 != null && !tues5.trim().isEmpty()) {
            res+= tues5 + "-" + tuee5 + ",";
        }

        if(tuesday != null && !tuesday.trim().isEmpty()) {
            res += ";";
        }

        String wednesday = request.getParameter("wednesday");

        if(wednesday != null && !wednesday.trim().isEmpty()) {
            res += wednesday + ",";
        }

        String weds1 = request.getParameter("starttimewednesday1");
        String wede1 = request.getParameter("endtimewednesday1");

        if(weds1 != null && !weds1.trim().isEmpty()) {
            res+= weds1 + "-" + wede1 + ",";
        }

        String weds2 = request.getParameter("starttimewednesday2");
        String wede2 = request.getParameter("endtimewednesday2");

        if(weds2 != null && !weds2.trim().isEmpty()) {
            res+= weds2 + "-" + wede2 + ",";
        }

        String weds3 = request.getParameter("starttimewednesday3");
        String wede3 = request.getParameter("endtimewednesday3");

        if(weds3 != null && !weds3.trim().isEmpty()) {
            res+= weds3 + "-" + wede3 + ",";
        }

        String weds4 = request.getParameter("starttimewednesday4");
        String wede4 = request.getParameter("endtimewednesday4");

        if(weds4 != null && !weds4.trim().isEmpty()) {
            res+= weds4 + "-" + wede4 + ",";
        }

        String weds5 = request.getParameter("starttimewednesday5");
        String wede5 = request.getParameter("endtimewednesday5");

        if(weds5 != null && !weds5.trim().isEmpty()) {
            res+= weds5 + "-" + wede5 + ",";
        }

        if(wednesday != null && !wednesday.trim().isEmpty()) {
            res += ";";
        }

        String thursday = request.getParameter("thursday");

        if(thursday != null && !thursday.trim().isEmpty()) {
            res += thursday + ",";
        }

        String thus1 = request.getParameter("starttimethursday1");
        String thue1 = request.getParameter("endtimethursday1");

        if(thus1 != null && !thus1.trim().isEmpty()) {
            res+= thus1 + "-" + thue1 + ",";
        }

        String thus2 = request.getParameter("starttimethursday2");
        String thue2 = request.getParameter("endtimethursday2");

        if(thus2 != null && !thus2.trim().isEmpty()) {
            res+= thus2 + "-" + thue2 + ",";
        }

        String thus3 = request.getParameter("starttimethursday3");
        String thue3 = request.getParameter("endtimethursday3");

        if(thus3 != null && !thus3.trim().isEmpty()) {
            res+= thus3 + "-" + thue3 + ",";
        }

        String thus4 = request.getParameter("starttimethursday4");
        String thue4 = request.getParameter("endtimethursday4");

        if(thus4 != null && !thus4.trim().isEmpty()) {
            res+= thus4 + "-" + thue4 + ",";
        }

        String thus5 = request.getParameter("starttimethursday5");
        String thue5 = request.getParameter("endtimethursday5");

        if(thus5 != null && !thus5.trim().isEmpty()) {
            res+= thus5 + "-" + thue5 + ",";
        }

        if(thursday != null && !thursday.trim().isEmpty()) {
            res += ";";
        }

        String friday = request.getParameter("friday");

        if(friday != null && !friday.trim().isEmpty()) {
            res += friday + ",";
        }

        String fris1 = request.getParameter("starttimefriday1");
        String frie1 = request.getParameter("endtimefriday1");

        if(fris1 != null && !fris1.trim().isEmpty()) {
            res+= fris1 + "-" + frie1 + ",";
        }

        String fris2 = request.getParameter("starttimefriday2");
        String frie2 = request.getParameter("endtimefriday2");

        if(fris2 != null && !fris2.trim().isEmpty()) {
            res+= fris2 + "-" + frie2 + ",";
        }

        String fris3 = request.getParameter("starttimefriday3");
        String frie3 = request.getParameter("endtimefriday3");

        if(fris3 != null && !fris3.trim().isEmpty()) {
            res+= fris3 + "-" + frie3 + ",";
        }

        String fris4 = request.getParameter("starttimefriday4");
        String frie4 = request.getParameter("endtimefriday4");

        if(fris4 != null && !fris4.trim().isEmpty()) {
            res+= fris4 + "-" + frie4 + ",";
        }

        String fris5 = request.getParameter("starttimefriday5");
        String frie5 = request.getParameter("endtimefriday5");

        if(fris5 != null && !fris5.trim().isEmpty()) {
            res+= fris5 + "-" + frie5 + ",";
        }

        if(friday != null && !friday.trim().isEmpty()) {
            res += ";";
        }

        String saturday = request.getParameter("saturday");

        if(saturday != null && !saturday.trim().isEmpty()) {
            res += saturday + ",";
        }

        String sats1 = request.getParameter("starttimesaturday1");
        String sate1 = request.getParameter("endtimesaturday1");

        if(sats1 != null && !sats1.trim().isEmpty()) {
            res+= sats1 + "-" + sate1 + ",";
        }

        String sats2 = request.getParameter("starttimesaturday2");
        String sate2 = request.getParameter("endtimesaturday2");

        if(sats2 != null && !sats2.trim().isEmpty()) {
            res+= sats2 + "-" + sate2 + ",";
        }

        String sats3 = request.getParameter("starttimesaturday3");
        String sate3 = request.getParameter("endtimesaturday3");

        if(sats3 != null && !sats3.trim().isEmpty()) {
            res+= sats3 + "-" + sate3 + ",";
        }

        String sats4 = request.getParameter("starttimesaturday4");
        String sate4 = request.getParameter("endtimesaturday4");

        if(sats4 != null && !sats4.trim().isEmpty()) {
            res+= sats4 + "-" + sate4 + ",";
        }

        String sats5 = request.getParameter("starttimesaturday5");
        String sate5 = request.getParameter("endtimesaturday5");

        if(sats5 != null && !sats5.trim().isEmpty()) {
            res+= sats5 + "-" + sate5 + ",";
        }

        if(saturday != null && !saturday.trim().isEmpty()) {
            res += ";";
        }

        String sunday = request.getParameter("sunday");

        if(sunday != null && !sunday.trim().isEmpty()) {
            res += sunday + ",";
        }

        String suns1 = request.getParameter("starttimesunday1");
        String sune1 = request.getParameter("endtimesunday1");

        if(suns1 != null && !suns1.trim().isEmpty()) {
            res+= suns1 + "-" + sune1 + ",";
        }

        String suns2 = request.getParameter("starttimesunday2");
        String sune2 = request.getParameter("endtimesunday2");

        if(suns2 != null && !suns2.trim().isEmpty()) {
            res+= suns2 + "-" + sune2 + ",";
        }

        String suns3 = request.getParameter("starttimesunday3");
        String sune3 = request.getParameter("endtimesunday3");

        if(suns3 != null && !suns3.trim().isEmpty()) {
            res+= suns3 + "-" + sune3 + ",";
        }

        String suns4 = request.getParameter("starttimesunday4");
        String sune4 = request.getParameter("endtimesunday4");

        if(suns4 != null && !suns4.trim().isEmpty()) {
            res+= suns4 + "-" + sune4 + ",";
        }

        String suns5 = request.getParameter("starttimesunday5");
        String sune5 = request.getParameter("endtimesunday5");

        if(suns5 != null && !suns5.trim().isEmpty()) {
            res+= suns5 + "-" + sune5 + ",";
        }

        if(sunday != null && !sunday.trim().isEmpty()) {
            res += ";";
        }



        /*res += monday + " ("+ mons1 + "-" + mone1 + "," + mons2 + "-" + mone2 + "," + mons3 + "-" + mone3 + "," + mons4 + "-" + mone4 + "," + mons5 + "-" + mone5 + "), ";

        res += tuesday + " ("+ tues1 + "-" + tuee1 + "," + tues2 + "-" + tuee2 + "," + tues3 + "-" + tuee3 + "," + tues4 + "-" + tuee4 + "," + tues5 + "-" + tuee5 + "), ";

        res += wednesday + " ("+ weds1 + "-" + wede1 + "," + weds2 + "-" + wede2 + "," + weds3 + "-" + wede3 + "," + weds4 + "-" + wede4 + "," + weds5 + "-" + wede5 + "), ";

        res += thursday + " ("+ thus1 + "-" + thue1 + "," + thus2 + "-" + thue2 + "," + thus3 + "-" + thue3 + "," + thus4 + "-" + thue4 + "," + thus5 + "-" + thue5 + "), ";

        res += friday + " ("+ fris1 + "-" + frie1 + "," + fris2 + "-" + frie2 + "," + fris3 + "-" + frie3 + "," + fris4 + "-" + frie4 + "," + fris5 + "-" + frie5 + "), ";

        res += saturday + " ("+ sats1 + "-" + sate1 + "," + sats2 + "-" + sate2 + "," + sats3 + "-" + sate3 + "," + sats4 + "-" + sate4 + "," + sats5 + "-" + sate5 + "), ";

        res += sunday + " ("+ suns1 + "-" + sune1 + "," + suns2 + "-" + sune2 + "," + suns3 + "-" + sune3 + "," + suns4 + "-" + sune4 + "," + suns5 + "-" + sune5 + "), ";*/

        System.out.println(res);
        service.setWorkingHours(res);

    }

    private void setAppointmentIntervals(Service service, HttpServletRequest request) {
        String appointmentinterval = request.getParameter("appointmentintervals");
        int apint = Integer.parseInt(appointmentinterval);
        service.setAppointmentInterval(apint);
    }
}
