package task.evaluationtool.model;

import java.time.LocalDate;
import java.util.Optional;

public class Query {
    private String service;
    private String question;
    private String responseType;
    private LocalDate dateFrom;
    private Optional<LocalDate> dateTo;

    public Query(String service, String question, String responseType, LocalDate dateFrom, Optional<LocalDate> dateTo) {
        this.service = service;
        this.question = question;
        this.responseType = responseType;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Optional<LocalDate> getDateTo() {
        return dateTo;
    }

    public void setDateTo(Optional<LocalDate> dateTo) {
        this.dateTo = dateTo;
    }
}
