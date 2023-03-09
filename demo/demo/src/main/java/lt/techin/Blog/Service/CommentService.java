package lt.techin.Blog.Service;

import lt.techin.Blog.Model.Comment;
import lt.techin.Blog.api.dto.CommentDto;
import lt.techin.Blog.dao.CommentRepository;
import lt.techin.Blog.dao.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static lt.techin.Blog.api.dto.Mapper.CommentMapper.toComment;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    @Autowired
    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public List<Comment> getAll(Long postId) {
        return commentRepository.findAllByPost_IdOrderByPublishedDesc(postId);
//                findAllByPost_IdOrderByPublishedDesc();
    }

    public Optional<Comment> getById(Long id) {
        return commentRepository.findById(id);
    }

    public Comment create(CommentDto commentDto, Long postId) {
       var postComment = postRepository.findById(postId).get();
       commentDto.setPost(postComment);
        return commentRepository.save(toComment(commentDto));
    }

}
