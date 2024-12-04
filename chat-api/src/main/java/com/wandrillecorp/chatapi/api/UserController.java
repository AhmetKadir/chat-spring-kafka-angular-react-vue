package com.wandrillecorp.chatapi.api;

import com.wandrillecorp.chatapi.dto.UserCreateDto;
import com.wandrillecorp.chatapi.service.UserService;
import com.wandrillecorp.chatapi.domain.user.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:5173", "http://localhost:3000"}, maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public User createUser(@Valid @RequestBody UserCreateDto command) {
        try {
            return this.userService.findOrCreateUser(command.getName());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "An error has occurred, sorry.");
        }
    }

    @PutMapping("/{userId}/rooms/{roomId}")
    public ResponseEntity<User> enterRoom(@PathVariable String userId,
                                          @PathVariable String roomId) {
        return userService.enterRoom(userId, roomId);
    }
}
