package services;

import domain.Appointment;
import domain.Business;
import domain.Service;
import domain.User;

import java.util.List;

public class AppService {
    private UserService users = new UserServiceDB();
    private BusinessService businesses = new BusinessServiceDB();
    private ServiceService services = new ServiceServiceDB();
    private AppointmentServiceDB appointments = new AppointmentServiceDB();

    public void add(User user) {
        users.add(user);
    }
    public User getifAuthenticated(String email, String password) {
        return users.getifAuthenticated(email, password);
    }
    public void updateProfilePic(int uid, String path) {
        users.updateProfilePic(uid, path);
    }

    public User getUserByUserid(int uid) {
        return users.getUserByUID(uid);
    }

    public void addBusiness(Business business, User user) {
        businesses.addBusiness(business, user);
    }

    public List<Business> getAllUserBusiness(int id) {
        return businesses.getAllUserBusiness(id);
    }

    public Business getBusinessbyID(int id) {
        return businesses.getBusinessByID(id);
    }

    public List<Service> getServices(int bid) {
        return services.getServices(bid);
    }

    public List<Service> getAllServices() {
        return  services.getAllServices();
    }
    public void addService(Service service, Business business) {
        services.addService(service, business);
    }

    public Service getServiceByServiceID(int sid) {
       return services.getServiceByServiceID(sid);
    }

    public List<Appointment> getAppointmentsByServiceId(int sid) {
        return appointments.getAllAppointmetsByService(sid);
    }
    public void addAppointment(Appointment appointment) {
        appointments.addAppointment(appointment);
        System.out.println("apservices");
    }

    public List<Appointment> getAppointmentsByUserId(int userid) {
        return appointments.getAllAppointmentsByUserID(userid);
    }

    public Appointment getAppointmentByaid(int aid) {
        return appointments.getAppointmentByApID(aid);
    }
    public void deleteAppointment(int aid) {
        appointments.deleteAppointment(aid);
    }
}
