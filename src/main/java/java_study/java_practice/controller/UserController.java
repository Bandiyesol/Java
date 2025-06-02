package java_study.java_practice.controller;

import jakarta.servlet.http.HttpServletRequest;
import java_study.java_practice.dto.UserLoginRequestDto;
import java_study.java_practice.dto.UserSignupRequestDto;
import java_study.java_practice.dto.UserSignupResponseDto;
import java_study.java_practice.repository.UserRepository;
import java_study.java_practice.service.UserService;
import java_study.java_practice.domain.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<UserSignupResponseDto> signup(@RequestBody UserSignupRequestDto request) {
        UserSignupResponseDto response = userService.signUpUser(request);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/changename/{id}")
    public ResponseEntity<UserSignupResponseDto> changeName(@PathVariable("id") Long id,@RequestBody String name) {
        UserSignupResponseDto response = userService.changeName(id, name);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/changemail/{id}")
    public ResponseEntity<UserSignupResponseDto> changeEmail(@PathVariable("id") Long id,@RequestBody String email) {
        UserSignupResponseDto response = userService.changeEmail(id, email);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/changepassword/{id}")
    public ResponseEntity<UserSignupResponseDto> changePassword(@PathVariable("id") Long id,@RequestBody String password) {
        UserSignupResponseDto response = userService.changePassword(id, password);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public List<UserEntity> userList() {
        return userRepository.findAll();
    }

    @DeleteMapping("/deleteinfo/{id}")
    public ResponseEntity<UserSignupResponseDto> deleteInfo(@PathVariable("id") Long id) {
        userService.deleteInfo(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequestDto request) {
        String token = userService.login(request);

        return ResponseEntity.ok().header("tempToken", token).body("로그인 되었습니다.");
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody HttpServletRequest request) {
        String token = request.getHeader("tempToken");
        userService.logout(token);

        return ResponseEntity.ok("로그아웃 되었습니다.");
    }

}
