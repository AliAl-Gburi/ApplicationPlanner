package services;

import domain.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAllAppointmetsByService(int serviceid);
    Appointment getAppointmentByApID(int apId);
    List<Appointment> getAllAppointmentsByUserID(int userid);
    void addAppointment(Appointment appointment);
    void deleteAppointment(int aid);
}
