package lt.techin.Blog.Service;

import lt.techin.Blog.Model.Comment;
import lt.techin.Blog.Model.Post;
import lt.techin.Blog.dao.CommentRepository;
import lt.techin.Blog.dao.PostRepository;
import lt.techin.Blog.exception.BlogValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public PostService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    public List<Post> getAll() {
        return postRepository.findAllByOrderByPublishedDesc();
    }

    public Optional<Post> getById(Long id) {
        return postRepository.findById(id);
    }

    public Post create(Post post) {
        return postRepository.save(post);
    }

    public List<Comment> getAllCommentsById(Long postId) {
        return postRepository.findById(postId).get().getCommentList();
    }

    public Post addCommentToPost(Long postId, Long commentId) {
        var existingPost = postRepository.findById(postId)
                .orElseThrow(() -> new BlogValidationException("Post does not exist",
                        "id", "Post not found", postId.toString()));

        var existingComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new BlogValidationException("Comment does not exist",
                        "id", "Comment not found", commentId.toString()));

        existingPost.getCommentList().add(existingComment);

        return postRepository.save(existingPost);
    }
}
