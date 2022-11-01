package services;

import domain.Business;
import domain.User;

import java.util.List;

public interface BusinessService {
    void addBusiness(Business business, User user);
    List<Business> getAllBusinesses();
    List<Business> getAllUserBusiness(int userid);
    Business getBusiness(int id);
    Business getBusinessByID(int id);

}
