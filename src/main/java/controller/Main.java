package controller;

import domain.MyDate;

import java.sql.Timestamp;
import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) {


        Timestamp now = Timestamp.valueOf(LocalDateTime.now());
        LocalDateTime tiem = LocalDateTime.parse(now.toString().replace(" ", "T"));

        MyDate date = new MyDate();
        date.setDate(tiem);
        System.out.println(date.getSimpleDate());


    }
}
