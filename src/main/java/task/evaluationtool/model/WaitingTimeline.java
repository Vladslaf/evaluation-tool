package task.evaluationtool.model;

import java.time.LocalDate;

public class WaitingTimeline {
    private String service;
    private String question;
    private String responseType;
    private LocalDate date;
    private int time;
    private int line;

    public WaitingTimeline(String service, String question, String responseType, LocalDate date, int time, int line) {
        this.service = service;
        this.question = question;
        this.responseType = responseType;
        this.date = date;
        this.time = time;
        this.line = line;
    }

    public String getService() {
        return service;
    }

    public String getQuestion() {
        return question;
    }

    public String getResponseType() {
        return responseType;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getTime() {
        return time;
    }

    public int getLine() {
        return line;
    }
}
