package services;

import domain.Business;
import domain.Service;
import util.DbConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceServiceDB implements ServiceService{
    private Connection connection;
    private String schema;
    public ServiceServiceDB() {
        this.connection = DbConnectionService.getDbConnection();
        this.schema = DbConnectionService.getSchema();
    }

    @Override
    public List<Service> getServices(int bid) {
        List<Service> services = new ArrayList<>();
        String query = String.format("SELECT * FROM %s.service WHERE businessid=" + bid, schema);
        try{
            PreparedStatement statement = getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Service service = new Service();
                int id = resultSet.getInt("serviceid");
                String name = resultSet.getString("name");
                String workinghours = resultSet.getString("workinghours");
                int appointmentint = resultSet.getInt("appointmentinterval");
                service.setServiceid(id);
                service.setAppointmentInterval(appointmentint);
                service.setWorkingHours(workinghours);
                service.setName(name);
                services.add(service);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return services;
    }

    @Override
    public Service getServiceByServiceID(int sid) {
        Service service = new Service();
        String query = String.format("SELECT * FROM %s.service WHERE serviceid=" + sid, schema);
        try{
            PreparedStatement statement = getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                int id = resultSet.getInt("serviceid");
                String name = resultSet.getString("name");
                String workinghours = resultSet.getString("workinghours");
                int appointmentint = resultSet.getInt("appointmentinterval");
                service.setServiceid(id);
                service.setAppointmentInterval(appointmentint);
                service.setWorkingHours(workinghours);
                service.setName(name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return service;
    }

    @Override
    public void addService(Service service, Business business) {
        String query = String.format("INSERT into %s.service (name, workinghours, appointmentinterval, businessid) values (?, ?, ?, ?)", schema);
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, service.getName());
            preparedStatement.setString(2, service.getWorkingHours());
            preparedStatement.setInt(3,service.getAppointmentInterval());
            preparedStatement.setInt(4, business.getBusinessid());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Service> getAllServices() {
        String query = String.format("SELECT * FROM %s.service", schema);
        List<Service> res = new ArrayList<>();
        try {
            PreparedStatement statement = getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Service service = new Service();
                int id = resultSet.getInt("serviceid");
                String name = resultSet.getString("name");
                String workinghours = resultSet.getString("workinghours");
                int app = resultSet.getInt("appointmentinterval");
                service.setName(name);
                service.setServiceid(id);
                service.setAppointmentInterval(app);
                service.setWorkingHours(workinghours);
                res.add(service);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
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
