package services;

import domain.User;
import util.DbConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceDB implements UserService{
    private Connection connection;
    private String schema;
    public UserServiceDB() {
        this.connection = DbConnectionService.getDbConnection();
        this.schema = DbConnectionService.getSchema();
    }
    @Override
    public void add(User user) {
        String query = String.format("insert into %s.user (email, password, username) values (?, ?, ?)", schema);
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public User getUserByUID(int uid) {
        String sql = String.format("SELECT * from %s.user where userid = "+uid, schema);
        User user = new User();
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("userid");
                String emails = resultSet.getString("email");
                String passwords = resultSet.getString("password");
                String username = resultSet.getString("username");
                String profilepath = resultSet.getString("profile_pic_path");
                user.setEmail(emails);
                user.setPassword(passwords);
                user.setUsername(username);
                user.setID(id);
                user.setProfilePicPath(profilepath);
                if(user.getUserid() < 0) throw new IllegalArgumentException();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }


    public User getifAuthenticated(String email, String password) {
        if(email == null || email.trim().isEmpty()) throw new IllegalArgumentException();
        if(password == null || password.trim().isEmpty()) throw new IllegalArgumentException();
        String sql = String.format("SELECT * from %s.user where email = '"+email+"' and password ='" + password+"';", schema);
        User user = new User();
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("userid");
                String emails = resultSet.getString("email");
                String passwords = resultSet.getString("password");
                String username = resultSet.getString("username");
                String profilepath = resultSet.getString("profile_pic_path");
                user.setEmail(emails);
                user.setPassword(passwords);
                user.setUsername(username);
                user.setID(id);
                user.setProfilePicPath(profilepath);
                if(user.getUserid() < 0) throw new IllegalArgumentException();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public void updateProfilePic(int uid, String filepath) {
        String query = String.format("UPDATE %s.user SET profile_pic_path = '%s' WHERE userid = " + uid, schema, filepath);

        try {
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() {
        checkConnection();
        return this.connection;
    }

    private void checkConnection() {
        try {
            if(this.connection == null || this.connection.isClosed()) {
                System.out.println("Connection has been closed");
                this.reConnect();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void reConnect() {
        DbConnectionService.disconnect();
        DbConnectionService.reconnect();
        this.connection = DbConnectionService.getDbConnection();
    }
}
