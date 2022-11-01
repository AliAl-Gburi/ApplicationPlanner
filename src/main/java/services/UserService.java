package services;

import domain.User;

public interface UserService {
    void add(User user);
    User getifAuthenticated(String email, String password);
    void updateProfilePic(int uid, String filepath);
    User getUserByUID(int uid);
}
