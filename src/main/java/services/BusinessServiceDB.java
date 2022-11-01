package services;

import domain.Business;
import domain.User;
import util.DbConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusinessServiceDB implements BusinessService {
    private Connection connection;
    private String schema;

    public BusinessServiceDB() {
        this.connection = DbConnectionService.getDbConnection();
        this.schema = DbConnectionService.getSchema();
    }

    @Override
    public void addBusiness(Business business, User user) {
        String query = String.format("insert into %s.business (name, userid) values (?, ?)", schema);
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, business.getName());
            preparedStatement.setInt(2, user.getUserid());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    @Override
    public List<Business> getAllBusinesses() {
        return null;
    }

    @Override
    public List<Business> getAllUserBusiness(int userid) {
        List<Business> businesses = new ArrayList<>();
        String sql = String.format("SELECT * FROM %s.business WHERE userid = " + userid, schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet set = statement.executeQuery();

            while (set.next()) {
                int id = set.getInt("businessid");
                String name = set.getString("name");
                Business business = new Business();
                business.setName(name);
                business.setBusinessid(id);
                businesses.add(business);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return businesses;
    }

    @Override
    public Business getBusiness(int id) {
        return null;
    }

    @Override
    public Business getBusinessByID(int id) {
        Business b = new Business();
        String query = String.format("SELECT * FROM %s.business WHERE businessid ="+id, schema);

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int bid = resultSet.getInt("businessid");
                String name = resultSet.getString("name");
                b.setBusinessid(bid);
                b.setName(name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return b;
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
