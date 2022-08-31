package task.evaluationtool.service;

import task.evaluationtool.model.Query;

public interface QueryService {
    Query parse(String queryLine);
}
