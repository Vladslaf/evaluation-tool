package task.evaluationtool.service;

import java.util.List;
import task.evaluationtool.model.Query;
import task.evaluationtool.model.WaitingTimeline;

public interface ParserService {
    List<WaitingTimeline> prepTimeLines(List<String> strings);

    List<Query> prepQueries(List<String> strings);

    List<String> addLineCounter(String input);
}
