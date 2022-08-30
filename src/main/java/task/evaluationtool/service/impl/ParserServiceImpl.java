package task.evaluationtool.service.impl;

import org.springframework.stereotype.Service;
import task.evaluationtool.service.ParserService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParserServiceImpl implements ParserService {
    private static final String QUERY = "D";
    private static final String TIME_LINE = "C";
    @Override
    public List<String> getAllTimelines(String input) {
        return Arrays.stream(input.split(System.lineSeparator()))
                .filter(line -> line.startsWith(TIME_LINE))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllQueries(String input) {
        return Arrays.stream(input.split(System.lineSeparator()))
                .filter(line -> line.startsWith(QUERY))
                .collect(Collectors.toList());
    }
}
