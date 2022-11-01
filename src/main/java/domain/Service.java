package domain;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class Service {
    private int serviceid;
    private String name;
    private String workingHours;
    private int appointmentInterval;
    private List<Appointment> appointments;

    public Service() {
        appointments = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setServiceid(int id) {
        serviceid = id;
    }


    public void setAppointments(List<Appointment>appointments) {
        this.appointments = appointments;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }
    public void setAppointmentInterval(int appointmentInterval ){
        this.appointmentInterval = appointmentInterval;
    }

    public String getName() {
        return this.name;
    }

    public String getWorkingHours() {
        return this.workingHours;
    }

    public int getServiceid() {
        return serviceid;
    }

    public List<Appointment> getAppointments() {
        return this.appointments;
    }

    public int getAppointmentInterval() {
        return this.appointmentInterval;
    }


    public List<MyDate> getAvailableSlotsNext3Weeks() {
        List<MyDate> res = new ArrayList<>();
        LocalDateTime l = LocalDateTime.now();
        l = l.minusDays(7);
        String[] daysworking = workingHours.split(";");
        for(int k = 0; k < 12; k++) {
            l = l.plusDays(7);
            for(int i = 0; i < daysworking.length; i++) {
                String[] hours = daysworking[i].split(",");
                if(hours[0].equals("sunday")) {

                    for (int j = 1; j < hours.length; j++) {
                        String[] shift = hours[j].split("-");
                        String[] shiftstarthour = shift[0].split(":");
                        String[] shiftEndHour = shift[1].split(":");

                        LocalDateTime nextSundayStart = l.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)).withHour(Integer.parseInt(shiftstarthour[0])).withMinute(Integer.parseInt(shiftstarthour[1]));

                        LocalDateTime nextSundayEnd = l.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)).withHour(Integer.parseInt(shiftEndHour[0])).withMinute(Integer.parseInt(shiftEndHour[1]));


                        while(nextSundayStart.isBefore(nextSundayEnd.minusMinutes(appointmentInterval))) {
                            LocalDateTime apped = nextSundayStart;
                            MyDate date = new MyDate();
                            date.setDate(apped);
                            nextSundayStart = nextSundayStart.plusMinutes(appointmentInterval);

                            res.add(date);

                        }

                    }
                }

                if(hours[0].equals("monday")) {
                    for (int j = 1; j < hours.length; j++) {
                        String[] shift = hours[j].split("-");
                        String[] shiftstarthour = shift[0].split(":");
                        String[] shiftEndHour = shift[1].split(":");

                        LocalDateTime nextMondayStart = l.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).withHour(Integer.parseInt(shiftstarthour[0])).withMinute(Integer.parseInt(shiftstarthour[1]));

                        LocalDateTime nextMondayEnd = l.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).withHour(Integer.parseInt(shiftEndHour[0])).withMinute(Integer.parseInt(shiftEndHour[1]));


                        while(nextMondayStart.isBefore(nextMondayEnd.minusMinutes(appointmentInterval))) {
                            LocalDateTime apped = nextMondayStart;
                            MyDate date = new MyDate();
                            date.setDate(apped);
                            nextMondayStart = nextMondayStart.plusMinutes(appointmentInterval);
                            res.add(date);

                        }

                    }
                }

                if(hours[0].equals("tuesday")) {
                    for (int j = 1; j < hours.length; j++) {
                        String[] shift = hours[j].split("-");
                        String[] shiftstarthour = shift[0].split(":");
                        String[] shiftEndHour = shift[1].split(":");

                        LocalDateTime nextTuesdayStart = l.with(TemporalAdjusters.next(DayOfWeek.TUESDAY)).withHour(Integer.parseInt(shiftstarthour[0])).withMinute(Integer.parseInt(shiftstarthour[1]));

                        LocalDateTime nextTuesdayEnd = l.with(TemporalAdjusters.next(DayOfWeek.TUESDAY)).withHour(Integer.parseInt(shiftEndHour[0])).withMinute(Integer.parseInt(shiftEndHour[1]));


                        while(nextTuesdayStart.isBefore(nextTuesdayEnd.minusMinutes(appointmentInterval))) {
                            LocalDateTime apped = nextTuesdayStart;
                            MyDate date = new MyDate();
                            date.setDate(apped);
                            nextTuesdayStart = nextTuesdayStart.plusMinutes(appointmentInterval);
                            res.add(date);

                        }

                    }
                }
                if(hours[0].equals("wednesday")) {
                    for (int j = 1; j < hours.length; j++) {
                        String[] shift = hours[j].split("-");
                        String[] shiftstarthour = shift[0].split(":");
                        String[] shiftEndHour = shift[1].split(":");

                        LocalDateTime nextWednesdayStart = l.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY)).withHour(Integer.parseInt(shiftstarthour[0])).withMinute(Integer.parseInt(shiftstarthour[1]));

                        LocalDateTime nextWednesdayEnd = l.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY)).withHour(Integer.parseInt(shiftEndHour[0])).withMinute(Integer.parseInt(shiftEndHour[1]));


                        while(nextWednesdayStart.isBefore(nextWednesdayEnd.minusMinutes(appointmentInterval))) {
                            LocalDateTime apped = nextWednesdayStart;
                            MyDate date = new MyDate();
                            date.setDate(apped);
                            nextWednesdayStart = nextWednesdayStart.plusMinutes(appointmentInterval);
                            res.add(date);

                        }

                    }
                }
                if(hours[0].equals("thursday")) {
                    for (int j = 1; j < hours.length; j++) {
                        String[] shift = hours[j].split("-");
                        String[] shiftstarthour = shift[0].split(":");
                        String[] shiftEndHour = shift[1].split(":");

                        LocalDateTime nextThursdayStart = l.with(TemporalAdjusters.next(DayOfWeek.THURSDAY)).withHour(Integer.parseInt(shiftstarthour[0])).withMinute(Integer.parseInt(shiftstarthour[1]));

                        LocalDateTime nextThursdayEnd = l.with(TemporalAdjusters.next(DayOfWeek.THURSDAY)).withHour(Integer.parseInt(shiftEndHour[0])).withMinute(Integer.parseInt(shiftEndHour[1]));


                        while(nextThursdayStart.isBefore(nextThursdayEnd.minusMinutes(appointmentInterval))) {
                            LocalDateTime apped = nextThursdayStart;
                            MyDate date = new MyDate();
                            date.setDate(apped);
                            nextThursdayStart = nextThursdayStart.plusMinutes(appointmentInterval);
                            res.add(date);

                        }

                    }
                }
                if(hours[0].equals("friday")) {
                    for (int j = 1; j < hours.length; j++) {
                        String[] shift = hours[j].split("-");
                        String[] shiftstarthour = shift[0].split(":");
                        String[] shiftEndHour = shift[1].split(":");

                        LocalDateTime nextFridayStart = l.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)).withHour(Integer.parseInt(shiftstarthour[0])).withMinute(Integer.parseInt(shiftstarthour[1]));

                        LocalDateTime nextFridayEnd = l.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)).withHour(Integer.parseInt(shiftEndHour[0])).withMinute(Integer.parseInt(shiftEndHour[1]));


                        while(nextFridayStart.isBefore(nextFridayEnd.minusMinutes(appointmentInterval))) {
                            LocalDateTime apped = nextFridayStart;
                            MyDate date = new MyDate();
                            date.setDate(apped);
                            nextFridayStart = nextFridayStart.plusMinutes(appointmentInterval);
                            res.add(date);

                        }

                    }
                }
                if(hours[0].equals("saturday")) {
                    for (int j = 1; j < hours.length; j++) {
                        String[] shift = hours[j].split("-");
                        String[] shiftstarthour = shift[0].split(":");
                        String[] shiftEndHour = shift[1].split(":");

                        LocalDateTime nextSaturdayStart = l.with(TemporalAdjusters.next(DayOfWeek.SATURDAY)).withHour(Integer.parseInt(shiftstarthour[0])).withMinute(Integer.parseInt(shiftstarthour[1]));

                        LocalDateTime nextSaturdayEnd = l.with(TemporalAdjusters.next(DayOfWeek.SATURDAY)).withHour(Integer.parseInt(shiftEndHour[0])).withMinute(Integer.parseInt(shiftEndHour[1]));


                        while(nextSaturdayStart.isBefore(nextSaturdayEnd.minusMinutes(appointmentInterval))) {
                            LocalDateTime apped = nextSaturdayStart;
                            MyDate date = new MyDate();
                            date.setDate(apped);
                            nextSaturdayStart = nextSaturdayStart.plusMinutes(appointmentInterval);
                            res.add(date);

                        }

                    }
                }
            }
        }

        return res;
        }

    public Map<String,List<MyDate>> getAvailableSlotsNext3WeeksMap() {
        Map<String, List<MyDate>> res = new TreeMap<>();
        LocalDateTime l = LocalDateTime.now();
        l = l.minusDays(7);
        String[] daysworking = workingHours.split(";");
        for(int k = 0; k < 12; k++) {
            l = l.plusDays(7);
            for(int i = 0; i < daysworking.length; i++) {
                String[] hours = daysworking[i].split(",");
                if(hours[0].equals("sunday")) {
                    List<MyDate> datelist = new ArrayList<>();
                    String dayString = l.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)).toLocalDate().toString();
                    for (int j = 1; j < hours.length; j++) {
                        String[] shift = hours[j].split("-");
                        String[] shiftstarthour = shift[0].split(":");
                        String[] shiftEndHour = shift[1].split(":");

                        LocalDateTime nextSundayStart = l.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)).withHour(Integer.parseInt(shiftstarthour[0])).withMinute(Integer.parseInt(shiftstarthour[1]));

                        LocalDateTime nextSundayEnd = l.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)).withHour(Integer.parseInt(shiftEndHour[0])).withMinute(Integer.parseInt(shiftEndHour[1]));


                        while(nextSundayStart.isBefore(nextSundayEnd.minusMinutes(appointmentInterval-1))) {
                            LocalDateTime apped = nextSundayStart;
                            MyDate date = new MyDate();
                            date.setDate(apped);
                            nextSundayStart = nextSundayStart.plusMinutes(appointmentInterval);

                            datelist.add(date);

                        }

                    }
                    res.put(dayString, datelist);

                }

                if(hours[0].equals("monday")) {
                    List<MyDate> datelist = new ArrayList<>();
                    String dayString = l.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).toLocalDate().toString();
                    for (int j = 1; j < hours.length; j++) {
                        String[] shift = hours[j].split("-");
                        String[] shiftstarthour = shift[0].split(":");
                        String[] shiftEndHour = shift[1].split(":");

                        LocalDateTime nextMondayStart = l.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).withHour(Integer.parseInt(shiftstarthour[0])).withMinute(Integer.parseInt(shiftstarthour[1]));

                        LocalDateTime nextMondayEnd = l.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).withHour(Integer.parseInt(shiftEndHour[0])).withMinute(Integer.parseInt(shiftEndHour[1]));


                        while(nextMondayStart.isBefore(nextMondayEnd.minusMinutes(appointmentInterval-1))) {
                            LocalDateTime apped = nextMondayStart;
                            MyDate date = new MyDate();
                            date.setDate(apped);
                            nextMondayStart = nextMondayStart.plusMinutes(appointmentInterval);
                            datelist.add(date);

                        }

                    }
                    res.put(dayString, datelist);
                }

                if(hours[0].equals("tuesday")) {
                    List<MyDate> datelist = new ArrayList<>();
                    String dayString = l.with(TemporalAdjusters.next(DayOfWeek.TUESDAY)).toLocalDate().toString();
                    for (int j = 1; j < hours.length; j++) {
                        String[] shift = hours[j].split("-");
                        String[] shiftstarthour = shift[0].split(":");
                        String[] shiftEndHour = shift[1].split(":");

                        LocalDateTime nextTuesdayStart = l.with(TemporalAdjusters.next(DayOfWeek.TUESDAY)).withHour(Integer.parseInt(shiftstarthour[0])).withMinute(Integer.parseInt(shiftstarthour[1]));

                        LocalDateTime nextTuesdayEnd = l.with(TemporalAdjusters.next(DayOfWeek.TUESDAY)).withHour(Integer.parseInt(shiftEndHour[0])).withMinute(Integer.parseInt(shiftEndHour[1]));


                        while(nextTuesdayStart.isBefore(nextTuesdayEnd.minusMinutes(appointmentInterval-1))) {
                            LocalDateTime apped = nextTuesdayStart;
                            MyDate date = new MyDate();
                            date.setDate(apped);
                            nextTuesdayStart = nextTuesdayStart.plusMinutes(appointmentInterval);
                            datelist.add(date);

                        }

                    }
                    res.put(dayString, datelist);
                }
                if(hours[0].equals("wednesday")) {
                    List<MyDate> datelist = new ArrayList<>();
                    String dayString = l.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY)).toLocalDate().toString();
                    for (int j = 1; j < hours.length; j++) {
                        String[] shift = hours[j].split("-");
                        String[] shiftstarthour = shift[0].split(":");
                        String[] shiftEndHour = shift[1].split(":");

                        LocalDateTime nextWednesdayStart = l.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY)).withHour(Integer.parseInt(shiftstarthour[0])).withMinute(Integer.parseInt(shiftstarthour[1]));

                        LocalDateTime nextWednesdayEnd = l.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY)).withHour(Integer.parseInt(shiftEndHour[0])).withMinute(Integer.parseInt(shiftEndHour[1]));


                        while(nextWednesdayStart.isBefore(nextWednesdayEnd.minusMinutes(appointmentInterval-1))) {
                            LocalDateTime apped = nextWednesdayStart;
                            MyDate date = new MyDate();
                            date.setDate(apped);
                            nextWednesdayStart = nextWednesdayStart.plusMinutes(appointmentInterval);
                            datelist.add(date);

                        }

                    }
                    res.put(dayString, datelist);
                }
                if(hours[0].equals("thursday")) {
                    List<MyDate> datelist = new ArrayList<>();
                    String dayString = l.with(TemporalAdjusters.next(DayOfWeek.THURSDAY)).toLocalDate().toString();
                    for (int j = 1; j < hours.length; j++) {
                        String[] shift = hours[j].split("-");
                        String[] shiftstarthour = shift[0].split(":");
                        String[] shiftEndHour = shift[1].split(":");

                        LocalDateTime nextThursdayStart = l.with(TemporalAdjusters.next(DayOfWeek.THURSDAY)).withHour(Integer.parseInt(shiftstarthour[0])).withMinute(Integer.parseInt(shiftstarthour[1]));

                        LocalDateTime nextThursdayEnd = l.with(TemporalAdjusters.next(DayOfWeek.THURSDAY)).withHour(Integer.parseInt(shiftEndHour[0])).withMinute(Integer.parseInt(shiftEndHour[1]));


                        while(nextThursdayStart.isBefore(nextThursdayEnd.minusMinutes(appointmentInterval-1))) {
                            LocalDateTime apped = nextThursdayStart;
                            MyDate date = new MyDate();
                            date.setDate(apped);
                            nextThursdayStart = nextThursdayStart.plusMinutes(appointmentInterval);
                            datelist.add(date);

                        }

                    }
                    res.put(dayString, datelist);
                }
                if(hours[0].equals("friday")) {
                    List<MyDate> datelist = new ArrayList<>();
                    String dayString = l.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)).toLocalDate().toString();
                    for (int j = 1; j < hours.length; j++) {
                        String[] shift = hours[j].split("-");
                        String[] shiftstarthour = shift[0].split(":");
                        String[] shiftEndHour = shift[1].split(":");

                        LocalDateTime nextFridayStart = l.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)).withHour(Integer.parseInt(shiftstarthour[0])).withMinute(Integer.parseInt(shiftstarthour[1]));

                        LocalDateTime nextFridayEnd = l.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)).withHour(Integer.parseInt(shiftEndHour[0])).withMinute(Integer.parseInt(shiftEndHour[1]));


                        while(nextFridayStart.isBefore(nextFridayEnd.minusMinutes(appointmentInterval-1))) {
                            LocalDateTime apped = nextFridayStart;
                            MyDate date = new MyDate();
                            date.setDate(apped);
                            nextFridayStart = nextFridayStart.plusMinutes(appointmentInterval);
                            datelist.add(date);

                        }

                    }
                    res.put(dayString, datelist);
                }
                if(hours[0].equals("saturday")) {
                    List<MyDate> datelist = new ArrayList<>();
                    String dayString = l.with(TemporalAdjusters.next(DayOfWeek.SATURDAY)).toLocalDate().toString();
                    for (int j = 1; j < hours.length; j++) {
                        String[] shift = hours[j].split("-");
                        String[] shiftstarthour = shift[0].split(":");
                        String[] shiftEndHour = shift[1].split(":");

                        LocalDateTime nextSaturdayStart = l.with(TemporalAdjusters.next(DayOfWeek.SATURDAY)).withHour(Integer.parseInt(shiftstarthour[0])).withMinute(Integer.parseInt(shiftstarthour[1]));

                        LocalDateTime nextSaturdayEnd = l.with(TemporalAdjusters.next(DayOfWeek.SATURDAY)).withHour(Integer.parseInt(shiftEndHour[0])).withMinute(Integer.parseInt(shiftEndHour[1]));


                        while(nextSaturdayStart.isBefore(nextSaturdayEnd.minusMinutes(appointmentInterval-1))) {
                            LocalDateTime apped = nextSaturdayStart;
                            MyDate date = new MyDate();
                            date.setDate(apped);
                            nextSaturdayStart = nextSaturdayStart.plusMinutes(appointmentInterval);
                            datelist.add(date);

                        }

                    }
                    res.put(dayString, datelist);
                }

            }
        }
        return res;
    }


}
