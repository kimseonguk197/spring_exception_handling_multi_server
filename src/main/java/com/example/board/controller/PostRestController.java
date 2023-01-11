package com.example.board.controller;

import com.example.board.Exception.NoListException;
import com.example.board.domain.Post;
import com.example.board.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//에러처리에 대한 자세한 사항은 spring_exception_handlig_client쪽 소스를 보세요.
@Slf4j
@RestController
public class PostRestController {

    private final PostService postService;

    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    //    404아니면 400에러만을 뱉는 API
    @GetMapping("acompany")
    public List<Post> postList() throws NoListException {
//        try {
////        wraping하지 않고 service에서 받아온 error를 return하는 case
//            List<Post> posts = postService.findAll();
//            return posts;
//        } catch (NoListException e) {
//            throw new NoListException("NolistException" + e.getMessage());
//        }
//        wraping하지 않고 service에서 받아온 error를 return하는 case
        return postService.findAll();
    }
}
