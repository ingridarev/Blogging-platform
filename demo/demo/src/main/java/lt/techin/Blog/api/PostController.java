package lt.techin.Blog.api;

import lt.techin.Blog.Model.Post;
import lt.techin.Blog.Service.PostService;
import lt.techin.Blog.api.dto.Mapper.PostMapper;
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
import static lt.techin.Blog.api.dto.Mapper.PostMapper.toPost;
import static lt.techin.Blog.api.dto.Mapper.PostMapper.toPostDto;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/api/v1/posts")
@Validated
public class PostController {

    public static Logger logger = LoggerFactory.getLogger(PostController.class);

private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    @ResponseBody
    public List<Post> getPosts() {
        return postService.getAll();
    }

//    @GetMapping(value="/ordered",produces = {MediaType.APPLICATION_JSON_VALUE})
//    private List<Post> getAllPostsOrdered() {
//        return postService.getAllPostsOrdered();
//    }


    @PostMapping
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto) {

            var createdPost = postService.create(toPost(postDto));
            return ok(toPostDto(createdPost));
        }

    @GetMapping(value = "/{postId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Post> getPost(@PathVariable Long postId) {
        var postOptional = postService.getById(postId);

        var responseEntity = postOptional
                .map(post -> ok(post))
                .orElseGet(() -> ResponseEntity.notFound().build());

        return responseEntity;
    }


}
