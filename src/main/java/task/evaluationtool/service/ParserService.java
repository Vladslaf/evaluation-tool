package task.evaluationtool.service;

import task.evaluationtool.model.Query;
import task.evaluationtool.model.WaitingTimeline;

import java.util.List;

public interface ParserService {
    List<WaitingTimeline> prepTimeLines(List<String> strings);
    List<Query> prepQueries(List<String> strings);

    List<String> addLineCounter(String input);
}
