package com.example.jwt2.controller.dto;

import com.example.jwt2.entity.Authority;
import com.example.jwt2.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.example.jwt2.entity.Member.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequestDto {
    private String nickname;
    private String password;
    private String password2;
    public Member toMember(PasswordEncoder passwordEncoder) {
        return builder()
                .nickname(nickname)
                .password(passwordEncoder.encode(password))
                .authority(Authority.ROLE_USER)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(nickname, password);
    }
}