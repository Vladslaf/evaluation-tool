package task.evaluationtool.service.impl;

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
            for (WaitingTimeline timeline: timelines) {

            }
            if (builder.length() != 0) {
                builder.append(System.lineSeparator());
            }
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
