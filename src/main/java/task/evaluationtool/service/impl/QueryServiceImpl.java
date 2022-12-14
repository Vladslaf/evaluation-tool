package task.evaluationtool.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import org.springframework.stereotype.Service;
import task.evaluationtool.model.Query;
import task.evaluationtool.service.QueryService;

@Service
public class QueryServiceImpl implements QueryService {

    @Override
    public Query parse(String queryLine) {
        String[] params = queryLine.split(" ");
        String date = params[4];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        LocalDate dateFrom;
        Optional<LocalDate> dateTo;
        if (date.contains("-")) {
            dateFrom = LocalDate.parse(date.substring(0, date.indexOf("-")), formatter);
            dateTo = Optional.ofNullable(LocalDate.parse(
                    date.substring(date.indexOf("-") + 1), formatter));
        } else {
            dateFrom = LocalDate.parse(date, formatter);
            dateTo = Optional.empty();
        }
        return new Query(params[1], params[2], params[3], dateFrom, dateTo,
                Integer.parseInt(params[5]));
    }
}
