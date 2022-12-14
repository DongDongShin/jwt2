package com.example.jwt2.service;

import com.example.jwt2.controller.dto.PostDto;
import com.example.jwt2.controller.dto.PostRequestDto;
import com.example.jwt2.controller.dto.PostsResponseDto;
import com.example.jwt2.controller.dto.ResponseDto;
import com.example.jwt2.entity.Member;
import com.example.jwt2.entity.Post;
import com.example.jwt2.repository.MemberRepository;
import com.example.jwt2.repository.PostRepository;
import com.example.jwt2.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public ResponseDto<?> createPost(PostRequestDto requestDto) {
        Optional<Member> temp = memberRepository.findById(SecurityUtil.getCurrentMemberId());//
        Member member = temp.get();
        Post post = new Post(requestDto,member.getNickname(),member);

        postRepository.save(post);

        return ResponseDto.success(new PostDto(post));
    }
    @Transactional
    public ResponseDto<?> modifyPost(PostRequestDto requestDto,Long id) {
        Optional<Member> current = memberRepository.findById(SecurityUtil.getCurrentMemberId());//일단 꺼내는 거임
        Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty()) {
            return ResponseDto.fail("NULL_POST_ID", "해당 게시글 ID가 존재하지 않습니다.");
        }
        Post temp =post.get();//post의 정보
        Member temp2 =  current.get();//현재 로그인된 사용자의 정보


        if (!temp.getAuthor().equals(temp2.getNickname())) {
            return ResponseDto.fail("WRONG_ACCESS", "해당 게시글의 작성자가 아닙니다.");
        }
        temp.update(requestDto);
        return ResponseDto.success(new PostsResponseDto(temp));
    }

    @Transactional
    public ResponseDto<?> deletePost(Long id) {
        //일단 post 중에서 찾고 하는거제
        Optional<Member> current = memberRepository.findById(SecurityUtil.getCurrentMemberId());//일단 꺼내는 거임
        Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty()) {
            return ResponseDto.fail("NULL_POST_ID", "해당 게시글 ID가 존재하지 않습니다.");
        }
        Post temp =  post.get();//post의 정보
        Member temp2 = current.get();//현재 로그인된 사용자의 정보
        if (!temp.getAuthor().equals(temp2.getNickname())) {
            return ResponseDto.fail("WRONG_ACCESS", "해당 게시글의 작성자가 아닙니다.");
        } else
            postRepository.delete(temp);//지웠다잉
        return ResponseDto.success("success");

    }
}
