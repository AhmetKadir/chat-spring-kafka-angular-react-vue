package com.wandrilleCorp.doodleapi.api.user;

import com.wandrilleCorp.doodleapi.application.UserManager;
import com.wandrilleCorp.doodleapi.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserManager userManager;

    @Autowired
    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }

    @PostMapping()
    public User createUser(
            @Valid @RequestBody UserCreatedCommand command
    ) {
        try {
            return this.userManager.findOrCreateUser(command.getName());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "An error has occurred, sorry.");
        }
    }
}
