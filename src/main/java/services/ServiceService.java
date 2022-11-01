package services;

import domain.Business;
import domain.Service;

import java.util.List;

public interface ServiceService {
    List<Service> getServices(int bid);
    Service getServiceByServiceID(int sid);
    void addService(Service service, Business business);
    List<Service> getAllServices();
}
