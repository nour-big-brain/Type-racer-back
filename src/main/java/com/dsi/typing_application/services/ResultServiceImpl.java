package com.dsi.typing_application.services;

import com.dsi.typing_application.entities.Result;
import com.dsi.typing_application.entities.User;
import com.dsi.typing_application.repositories.ResultRepository;
import com.dsi.typing_application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements IResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IUserService userService;

    @Override
    public void saveResult(Result result) {
        // Get the current authenticated user using userService
        User currentUser = userService.getCurrentUser();

        result.setUser(currentUser);
        resultRepository.save(result);
    }

    @Override
    public List<Result> getUserResults() {
        User currentUser = userService.getCurrentUser();
        return resultRepository.findByUserOrderByWpmDesc(currentUser);
    }

    @Override
    public List<Result> getLeaderboard(int limit) {
        return resultRepository.findTopNByOrderByWpmDesc(limit);
    }
}
