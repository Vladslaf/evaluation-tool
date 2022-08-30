package task.evaluationtool.service;

import java.util.List;

public interface ParserService {
    List<String> getAllTimelines(String input);
    List<String> getAllQueries(String input);
}
