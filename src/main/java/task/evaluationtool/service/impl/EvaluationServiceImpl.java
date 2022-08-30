package task.evaluationtool.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import task.evaluationtool.model.Query;
import task.evaluationtool.model.WaitingTimeline;
import task.evaluationtool.service.EvaluationService;
import task.evaluationtool.service.ParserService;
import task.evaluationtool.service.QueryService;
import task.evaluationtool.service.WaitingTimelineService;

@Service
public class EvaluationServiceImpl implements EvaluationService {
    private final ParserService parserService;
    private final QueryService queryService;
    private final WaitingTimelineService timelineService;

    public EvaluationServiceImpl(ParserService parserService, QueryService queryService, WaitingTimelineService timelineService) {
        this.parserService = parserService;
        this.queryService = queryService;
        this.timelineService = timelineService;
    }

    @Override
    public String evaluate(String input) {
        List<Query> queries = prepareAllQueries(parserService.getAllQueries(input));
        List<WaitingTimeline> timelines = prepareAllTimeLines(parserService.getAllTimelines(input));
        StringBuilder builder = new StringBuilder();
        for (Query q: queries) {
            int time = 0;
            int count = 0;
            for (WaitingTimeline t: timelines) {
                if (q.getService().equals("*") || t.getService().startsWith(q.getService())
                    && q.getQuestion().equals("*") || t.getService().startsWith(q.getService())
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

    @Override
    public List<WaitingTimeline> prepareAllTimeLines(List<String> allTimelines) {
        return allTimelines.stream()
                .map(timelineService::parse)
                .collect(Collectors.toList());
    }

    @Override
    public List<Query> prepareAllQueries(List<String> allQueries) {
        return allQueries.stream()
                .map(queryService::parse)
                .collect(Collectors.toList());
    }

}
