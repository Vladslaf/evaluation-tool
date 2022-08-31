package task.evaluationtool.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import task.evaluationtool.model.Query;
import task.evaluationtool.model.WaitingTimeline;
import task.evaluationtool.service.ParserService;
import task.evaluationtool.service.QueryService;
import task.evaluationtool.service.WaitingTimelineService;

@Service
public class ParserServiceImpl implements ParserService {
    private static final String QUERY = "D";
    private static final String TIME_LINE = "C";

    private final QueryService queryService;
    private final WaitingTimelineService timelineService;

    public ParserServiceImpl(QueryService queryService, WaitingTimelineService timelineService) {
        this.queryService = queryService;
        this.timelineService = timelineService;
    }

    @Override
    public List<WaitingTimeline> prepTimeLines(List<String> strings) {
        return strings.stream()
                .filter(line -> line.startsWith(TIME_LINE))
                .map(timelineService::parse)
                .collect(Collectors.toList());
    }

    @Override
    public List<Query> prepQueries(List<String> strings) {
        return strings.stream()
                .filter(line -> line.startsWith(QUERY))
                .map(queryService::parse)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> addLineCounter(String input) {
        List<String> lines = new ArrayList<>();
        String[] strings = input.split(System.lineSeparator());
        for (int i = 0; i < strings.length; i++) {
            lines.add(strings[i] + " " + i);
        }
        return lines;
    }
}
