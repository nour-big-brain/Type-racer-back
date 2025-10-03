package com.dsi.typing_application.controllers;

import com.dsi.typing_application.entities.Result;
import com.dsi.typing_application.services.IResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResultController {
    @Autowired
    private IResultService resultService;

    @PostMapping("/save")
    public ResponseEntity<String> saveResult(@RequestBody Result result) {
        resultService.saveResult(result);
        return ResponseEntity.ok("Result saved successfully.");
    }

    @GetMapping("/my")
    public ResponseEntity<List<Result>> getMyResults() {
        List<Result> results = resultService.getUserResults();
        return ResponseEntity.ok(results);
    }

    @GetMapping("/leaderboard")
    public ResponseEntity<List<Result>> getLeaderboard(@RequestParam(defaultValue = "10") int limit) {
        List<Result> topResults = resultService.getLeaderboard(limit);
        return ResponseEntity.ok(topResults);
    }
}
