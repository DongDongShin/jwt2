package com.example.jwt2.controller.dto;

import com.example.jwt2.entity.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    private String nickname;
    private Long id;
    private String createdDate, modifiedDate;

    public MemberDto(Member member) {
        this.nickname = member.getNickname();
        this.id = member.getId();
        this.createdDate = member.getCreatedAt().toString();
        this.modifiedDate = member.getModifiedAt().toString();
    }
}
