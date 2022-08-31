package task.evaluationtool.model;

import java.time.LocalDate;
import java.util.Optional;

public class Query {
    private String service;
    private String question;
    private String responseType;
    private LocalDate dateFrom;
    private Optional<LocalDate> dateTo;
    private int line;

    public Query(String service, String question, String responseType, LocalDate dateFrom,
                 Optional<LocalDate> dateTo, int line) {
        this.service = service;
        this.question = question;
        this.responseType = responseType;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
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

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public Optional<LocalDate> getDateTo() {
        return dateTo;
    }

    public int getLine() {
        return line;
    }
}
