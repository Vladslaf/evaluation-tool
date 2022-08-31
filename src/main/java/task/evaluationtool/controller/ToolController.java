package task.evaluationtool.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import task.evaluationtool.service.EvaluationService;

@RestController
@RequestMapping("/tool")
public class ToolController {
    private final EvaluationService evaluationService;

    public ToolController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @PostMapping("/evaluate")
    String evaluate(@RequestBody String input) {
        return evaluationService.evaluate(input);
    }
}
