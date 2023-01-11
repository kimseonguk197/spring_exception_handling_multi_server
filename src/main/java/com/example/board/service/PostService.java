package com.example.board.service;

import com.example.board.Exception.NoListException;
import com.example.board.domain.Post;
import com.example.board.repository.PostRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


//에러처리에 대한 자세한 사항은 spring_exception_handlig_client쪽 소스를 보세요.
@Service
@Transactional
public class PostService {

    private final PostRepository repository;


    public PostService(PostRepository repository) {
        this.repository = repository;
    }

//    404아니면 400에러만을 뱉는 API
    public List<Post> findAll() throws NoListException {
        List<Post> result = repository.findAll();
        if(result.isEmpty()){
            throw new NoListException("ServerNoListException");
        }
        return result;
    }


}
