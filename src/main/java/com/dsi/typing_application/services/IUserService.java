package com.dsi.typing_application.services;

import com.dsi.typing_application.entities.Result;
import com.dsi.typing_application.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User getCurrentUser();
    Optional<User> findById(int id);
    Optional<User> findByUsername(String username);

}
