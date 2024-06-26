package com.core.corebackboard.user.api;

import com.core.corebackboard.user.dto.SignUpRequest;
import com.core.corebackboard.user.dto.UserResponse;
import com.core.corebackboard.user.service.UserDomain;
import com.core.corebackboard.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<Long> signUp(@RequestBody SignUpRequest signUpRequest) {
        userService.signUp(signUpRequest.toUserInfo());
        return ResponseEntity.ok(1L);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserResponse>userInfo(@PathVariable Long userId){
        UserDomain domain = userService.getUserInfo(userId);

        UserResponse response = UserResponse.from(domain);
        return ResponseEntity.ok(response);
    }
}
