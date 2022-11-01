package domain;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Appointment {
    private int appointmentid;
    private int userid;
    private int serviceid;
    private String serviceName;
    private LocalDateTime date;

    public Appointment(){
    }
    public void setAppointmentid(int appointmentid) {
        this.appointmentid = appointmentid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    public void setServiceid(int serviceid) {
        this.serviceid = serviceid;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public void setDateFromDB(Timestamp date) {

        this.date = LocalDateTime.parse(date.toString().replace(" ", "T"));
    }
    public void setServiceName(String name) {
        serviceName = name;
    }

    public String getServiceName() {
        return this.serviceName;
    }
    public int getAppointmentid() {
        return this.appointmentid;
    }
    public String getAppointmentDay() {
        return date.toLocalDate().toString();
    }
    public int getUserid() {
        return this.userid;
    }
    public int getServiceid() {
        return serviceid;
    }
    public String getSimpleTime() {
        return date.toLocalTime().toString();
    }
    public Timestamp getTimestamp() {
        Timestamp timestamp = Timestamp.valueOf(date);
        return timestamp;
    }

   public LocalDateTime getDate() {
        return date;
    }
}
