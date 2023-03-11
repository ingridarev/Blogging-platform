package lt.techin.Blog.Service;

import lt.techin.Blog.Model.Comment;
import lt.techin.Blog.Model.Post;
import lt.techin.Blog.api.dto.CommentDto;
import lt.techin.Blog.api.dto.Mapper.CommentMapper;
import lt.techin.Blog.dao.CommentRepository;
import lt.techin.Blog.dao.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static lt.techin.Blog.api.dto.Mapper.CommentMapper.toComment;

@Service
public class CommentService {
    @Autowired
    private final CommentRepository commentRepository;
    @Autowired
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    public Optional<Comment> getById(Long id) {
        return commentRepository.findById(id);
    }

//    public Comment create(CommentDto commentDto, Long postId) {
//       var postComment = postRepository.findById(postId).get();
//       commentDto.setPost(postComment);
//        return commentRepository.save(toComment(commentDto));
//    }

    public List<Comment> getCommentsByPostId (Long postId) {
        Post post = postRepository.findById(postId).orElseThrow();
        return commentRepository.findAllByPost(post);
    }


    public Comment create(Long postId, CommentDto commentDto) {

        var post = postRepository.findById(postId).orElseThrow();
        Comment newComment = CommentMapper.toComment(commentDto);
        newComment.setPost(post);
        return commentRepository.save(newComment);
    }

}
