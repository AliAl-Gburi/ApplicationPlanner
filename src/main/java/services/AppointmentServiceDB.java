package services;

import domain.Appointment;
import util.DbConnectionService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentServiceDB implements AppointmentService{
    private Connection connection;
    private String schema;

    public AppointmentServiceDB() {
        this.connection = DbConnectionService.getDbConnection();
        this.schema = DbConnectionService.getSchema();
    }

    @Override
    public List<Appointment> getAllAppointmetsByService(int serviceid) {
        List<Appointment> appointmentList = new ArrayList<>();
        String query = String.format("SELECT * FROM %s.appointment WHERE serviceid =" + serviceid, schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Appointment appointment = new Appointment();
                int apid = resultSet.getInt("appointmentid");
                int uid = resultSet.getInt("userid");
                int sid = resultSet.getInt("serviceid");
                Timestamp timestamp = resultSet.getTimestamp("apdate");
                appointment.setAppointmentid(apid);
                appointment.setServiceid(sid);
                appointment.setUserid(uid);
                appointment.setDateFromDB(timestamp);
                appointmentList.add(appointment);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return appointmentList;
    }

    @Override
    public Appointment getAppointmentByApID(int apId) {
        Appointment appointment = new Appointment();
        String query = String.format("SELECT * FROM %s.appointment as a INNER JOIN %s.service as s ON a.serviceid = s.serviceid WHERE appointmentid = " + apId, schema, schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                int aid = resultSet.getInt("appointmentid");
                int sid = resultSet.getInt("serviceid");
                Timestamp timestamp = resultSet.getTimestamp("apdate");
                int uid = resultSet.getInt("userid");
                String sname = resultSet.getString("name");
                appointment.setAppointmentid(aid);
                appointment.setDateFromDB(timestamp);
                appointment.setServiceName(sname);
                appointment.setServiceid(sid);
                appointment.setUserid(uid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointment;
    }

    @Override
    public List<Appointment> getAllAppointmentsByUserID(int userid) {
        List<Appointment> appointmentList = new ArrayList<>();
        String query = String.format("SELECT appointmentid, a.userid, a.serviceid, apdate, name FROM %s.appointment as a INNER JOIN %s.service as s ON a.serviceid = s.serviceid WHERE a.userid =" + userid, schema, schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Appointment appointment = new Appointment();
                int apid = resultSet.getInt("appointmentid");
                int uid = resultSet.getInt("userid");
                int sid = resultSet.getInt("serviceid");
                Timestamp timestamp = resultSet.getTimestamp("apdate");
                String servicename = resultSet.getString("name");
                appointment.setAppointmentid(apid);
                appointment.setServiceid(sid);
                appointment.setUserid(uid);
                appointment.setDateFromDB(timestamp);
                appointment.setServiceName(servicename);
                appointmentList.add(appointment);
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            throwables.printStackTrace();
        }
        return appointmentList;
    }

    @Override
    public void addAppointment(Appointment appointment) {
        String sql = String.format("INSERT into %s.appointment (userid, serviceid, apdate) VALUES (?, ?, ?)", schema);

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);

            preparedStatement.setInt(1, appointment.getUserid());

            preparedStatement.setInt(2, appointment.getServiceid());

            preparedStatement.setTimestamp(3, appointment.getTimestamp());
            preparedStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteAppointment(int aid) {
        String sql = String.format("DELETE from %s.appointment WHERE appointmentid = " + aid, schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
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
