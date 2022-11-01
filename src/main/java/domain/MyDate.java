package domain;

import java.time.LocalDateTime;

public class MyDate {
    private LocalDateTime date;

    public MyDate() {

    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public LocalDateTime getDate() {
        return this.date;
    }

    public String getSimpleDate() {
        return date.toLocalDate().toString();
    }

    public String getSimpleTime() {
        if(date.getMinute() < 10) {
            if(date.getHour() < 10) {
                return "0"+date.getHour()+":0"+date.getMinute();
            }else {
                return date.getHour()+":0"+date.getMinute();
            }

        } else {
            if(date.getHour() < 10) {
                return "0"+date.getHour()+":"+date.getMinute();
            } else {
                return date.getHour()+":"+date.getMinute();
            }
        }

    }

}
