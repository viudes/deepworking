package br.com.deepworking.project.model;

public class SimpleTime {

    private int hour;
    private int minute;
    private int second;

    public SimpleTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public SimpleTime(String input) {
        String[] time = input.split(":");

        hour = Integer.parseInt(time[0]);
        minute = Integer.parseInt(time[1]);
        second = Integer.parseInt(time[2]);
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "SimpleTime [hour=" + hour + ", minute=" + minute + ", second=" + second + "]";
    }

}
