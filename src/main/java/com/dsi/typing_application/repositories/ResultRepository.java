package com.dsi.typing_application.repositories;

import com.dsi.typing_application.entities.Result;
import com.dsi.typing_application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result,Integer> {
    List<Result> findByUserOrderByWpmDesc(User user);

    @Query(value = "SELECT r FROM Result r ORDER BY r.wpm DESC LIMIT ?1")
    List<Result> findTopNByOrderByWpmDesc(int limit);
}
