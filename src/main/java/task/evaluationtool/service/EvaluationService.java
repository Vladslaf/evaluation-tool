package task.evaluationtool.service;

import task.evaluationtool.model.Query;
import task.evaluationtool.model.WaitingTimeline;

import java.util.List;

public interface EvaluationService {
    String evaluate(String input);
    List<WaitingTimeline> prepareAllTimeLines(List<String> allTimelines);
    List<Query> prepareAllQueries(List<String> allQueries);
}
