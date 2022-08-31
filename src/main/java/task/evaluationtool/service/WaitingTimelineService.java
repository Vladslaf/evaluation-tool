package task.evaluationtool.service;

import task.evaluationtool.model.WaitingTimeline;

public interface WaitingTimelineService {
    WaitingTimeline parse(String timeLine);
}
