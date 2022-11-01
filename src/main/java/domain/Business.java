package domain;

import java.util.ArrayList;
import java.util.List;

public class Business {
    private int businessid;
    private String name;
    private List<Service> services;

    public Business() {
        services = new ArrayList<>();
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setServices(List<Service> services) {
        this.services = services;
    }
    public void setBusinessid(int id) {
        businessid = id;
    }

    public String getName() {
        return this.name;
    }
    public List<Service> getServices() {
        return this.services;
    }
    public int getBusinessid() {
        return businessid;
    }
}
