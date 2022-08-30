package task.evaluationtool.model;

import java.time.LocalDate;

public class WaitingTimeline {
    private String service;
    private String question;
    private String responseType;
    private LocalDate date;
    private int time;

    public WaitingTimeline(String service, String question, String responseType, LocalDate date, int time) {
        this.service = service;
        this.question = question;
        this.responseType = responseType;
        this.date = date;
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
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

    public void setService(String service) {
        this.service = service;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
