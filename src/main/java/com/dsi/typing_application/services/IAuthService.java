package com.dsi.typing_application.services;

import com.dsi.typing_application.entities.User;

public interface IAuthService {
    String register(User request);
    String login(User request);
}
