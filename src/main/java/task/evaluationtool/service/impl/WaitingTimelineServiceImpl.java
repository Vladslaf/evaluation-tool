package task.evaluationtool.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;
import task.evaluationtool.model.WaitingTimeline;
import task.evaluationtool.service.WaitingTimelineService;

@Service
public class WaitingTimelineServiceImpl implements WaitingTimelineService {

    @Override
    public WaitingTimeline parse(String timeLine) {
        String[] params = timeLine.split(" ");
        String date = params[3];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return new WaitingTimeline(params[1], params[2], params[3],
                LocalDate.parse(date, formatter));
    }
}
