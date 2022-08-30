package task.evaluationtool.service.impl;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import task.evaluationtool.model.Query;
import task.evaluationtool.model.WaitingTimeline;
import task.evaluationtool.service.EvaluationService;
import task.evaluationtool.service.ParserService;

@Service
public class EvaluationServiceImpl implements EvaluationService {
    private final ParserService parserService;

    public EvaluationServiceImpl(ParserService parserService) {
        this.parserService = parserService;
    }

    @Override
    public String evaluate(String input) {
        List<String> countedLines = parserService.addLineCounter(input);
        List<Query> queries = parserService.prepQueries(countedLines);
        List<WaitingTimeline> timelines = parserService.prepTimeLines(countedLines);
        StringBuilder builder = new StringBuilder();

        for (Query q: queries) {
            int time = 0;
            int count = 0;
            for (WaitingTimeline t: timelines) {
                if (t.getLine() < q.getLine()
                        && (q.getService().equals("*") || t.getService().startsWith(q.getService()))
                        && (q.getQuestion().equals("*") || t.getQuestion().startsWith(q.getQuestion()))
                        && q.getResponseType().equals(t.getResponseType())
                        && t.getDate().isAfter(q.getDateFrom())
                        && t.getDate().isBefore(q.getDateTo().orElse(LocalDate.MAX))) {
                    count++;
                    time += t.getTime();
                }
            }
            if (builder.length() != 0) {
                builder.append(System.lineSeparator());
            }
            builder.append(count == 0 ? "-": time / count);
        }
        return builder.toString();
    }
}
