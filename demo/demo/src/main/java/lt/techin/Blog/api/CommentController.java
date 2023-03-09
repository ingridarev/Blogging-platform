package lt.techin.Blog.api;

import lt.techin.Blog.Model.Comment;
import lt.techin.Blog.Service.CommentService;
import lt.techin.Blog.api.dto.CommentDto;
import lt.techin.Blog.api.dto.CommentEntityDto;
import lt.techin.Blog.api.dto.Mapper.CommentMapper;
import lt.techin.Blog.api.dto.PostDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static lt.techin.Blog.api.dto.Mapper.CommentMapper.toComment;
import static lt.techin.Blog.api.dto.Mapper.CommentMapper.toCommentDto;
import static lt.techin.Blog.api.dto.Mapper.PostMapper.toPost;
import static lt.techin.Blog.api.dto.Mapper.PostMapper.toPostDto;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/api/v1/comments")
@Validated
public class CommentController {
    public static Logger logger = LoggerFactory.getLogger(CommentController.class);

    private final CommentService commentService;


    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(value = "/{postId}/comments", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<CommentEntityDto> getComments(@PathVariable Long postId) {
        return commentService.getAll(postId).stream()
                .map(CommentMapper::toCommentEntityDto)
                .collect(toList());
    }

    @PostMapping(value = "/{postId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CommentDto> createComment(@PathVariable Long postId, @Valid @RequestBody CommentDto commentDto) {

        var createdComment = commentService.create(commentDto,postId);
        return ok(toCommentDto(createdComment));
    }

    @GetMapping(value = "/{commentId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Comment> getComment(@PathVariable Long commentId) {
        var commentOptional = commentService.getById(commentId);

        var responseEntity = commentOptional
                .map(comment -> ok(comment))
                .orElseGet(() -> ResponseEntity.notFound().build());

        return responseEntity;
    }
}
