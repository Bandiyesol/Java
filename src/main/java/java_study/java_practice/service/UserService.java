package java_study.java_practice.service;

import java_study.java_practice.dto.UserRequestDto;
import java_study.java_practice.dto.UserResponseDto;
import java_study.java_practice.model.User;
import java_study.java_practice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto createUser(UserRequestDto dto) {
        if (userRepository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("이미 등록된 이메일 입니다.");
        }

        User user = User.from(dto);
        User savedUser = userRepository.save(user);

        return savedUser.toResponseDto();
    }

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(User::toResponseDto)
                .collect(Collectors.toList());
    }

    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
    }

    public UserResponseDto updateUser(Long id, UserRequestDto dto) {
        User user = getUser(id);
        user.update(dto.username(), dto.email(), dto.password());
        User savedUser = userRepository.save(user);

        return savedUser.toResponseDto();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
