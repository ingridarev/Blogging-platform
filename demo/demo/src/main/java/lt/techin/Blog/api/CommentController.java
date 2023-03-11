package lt.techin.Blog.api;

import lt.techin.Blog.Model.Comment;
import lt.techin.Blog.Service.CommentService;
import lt.techin.Blog.api.dto.CommentDto;
import lt.techin.Blog.api.dto.CommentEntityDto;
import lt.techin.Blog.api.dto.Mapper.CommentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/api/v1/posts/comments")
@Validated
public class CommentController {
    public static Logger logger = LoggerFactory.getLogger(CommentController.class);

    private final CommentService commentService;


    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    @ResponseBody
    public List<CommentEntityDto> getAllComments() {
        return commentService.getAll().stream()
                .map(CommentMapper::toCommentEntityDto)
                .collect(Collectors.toList());
    }



    @PostMapping("/{postId}")
    @ResponseBody
    public ResponseEntity<Comment> createComment(@PathVariable Long postId, @RequestBody CommentDto commentDto) {
        return ResponseEntity.ok(commentService.createComment(postId, commentDto));
    }


    @GetMapping("/{postId}")
    @ResponseBody
    public List<Comment> getCommentsByPostId(@PathVariable Long postId) {
        return commentService.getCommentsByPostId(postId);
    }
}
