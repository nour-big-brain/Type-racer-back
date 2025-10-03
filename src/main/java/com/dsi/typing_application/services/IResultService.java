package com.dsi.typing_application.services;

import com.dsi.typing_application.entities.Result;

import java.util.List;

public interface IResultService {
    void saveResult(Result dto);
    List<Result> getUserResults();
    List<Result> getLeaderboard(int limit);
}
