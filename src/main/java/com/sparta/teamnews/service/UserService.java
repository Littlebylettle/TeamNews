package com.sparta.teamnews.service;

import com.sparta.teamnews.dto.SignupRequestDto;
import com.sparta.teamnews.dto.UserRequestDto;
import com.sparta.teamnews.dto.UserResponseDto;
import com.sparta.teamnews.entity.User;
import com.sparta.teamnews.jwt.JwtUtil;
import com.sparta.teamnews.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    public void signup(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        String password = passwordEncoder.encode(requestDto.getPassword());
        String profilename = requestDto.getProfilename();
        String introduce = requestDto.getIntroduce();

        // 회원 중복 확인
        Optional<User> checkUsername = userRepository.findByUsername(username);
        if (checkUsername.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }

        // email 중복확인
//        String email = requestDto.getEmail();
//        Optional<User> checkEmail = userRepository.findByEmail(email);
//        if (checkEmail.isPresent()) {
//            throw new IllegalArgumentException("중복된 Email 입니다.");
//        }

        // 사용자 등록
        User user = new User(username, password, profilename, introduce);
        userRepository.save(user);
    }

    public UserResponseDto loginUser(UserRequestDto userRequestDto, HttpServletResponse response) {
        String username = userRequestDto.getUsername();
        String password = userRequestDto.getPassword();

        User user = findUser(username);

        // password 체크
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("password 오류입니다.");
        }

        // JWT 생성 및 헤더에 추가
        String token = jwtUtil.createToken(username);
        response.addHeader(JwtUtil.AUTHORIZATION_HEADER, token);

        return new UserResponseDto("로그인 성공", HttpStatus.OK.value());
    }

    public UserResponseDto logoutUser(HttpServletRequest request) {
        // Redis 연동 후
        // 로그아웃 요청 JWT 를 블랙리스트에 등록

        return new UserResponseDto("로그아웃 성공, 테스트용 반환임 제거 필요", HttpStatus.OK.value());
    }

    // username 으로 사용자 찾기 + null 체크
    public User findUser(String username) {
        return userRepository.findByUsername(username).orElseThrow(() ->
                new IllegalArgumentException("해당 username 이 존재하지 않습니다.")
        );
    }
}
