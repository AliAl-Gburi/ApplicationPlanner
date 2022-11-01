package domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int userid;
    private String profilePicPath;
    private String email;
    private String password;
    private List<Appointment> appointments;
    private String username;

    public User(){
        appointments = new ArrayList<>();
    }
    public void setEmail( String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;

    }
    public void setProfilePicPath(String path) {
        profilePicPath = path;
    }
    public void setID(int id) {
        this.userid = id;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
    public String getUsername() {
        return this.username;
    }
    public int getUserid() {
        return userid;
    }
    public String getProfilePicPath() {
        return profilePicPath;
    }

}
