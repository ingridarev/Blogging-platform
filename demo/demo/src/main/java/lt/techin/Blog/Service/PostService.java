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
    @Autowired
    private final PostRepository postRepository;


    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAll() {
        return postRepository.findAllByOrderByPublishedDesc();
    }

    public Optional<Post> getById(Long id) {
        return postRepository.findById(id);
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Optional<Post> getPostByPostName(String postName) {
        return postRepository.findByPostName(postName);
    }

//    public List<Post> getAllPostsOrdered() {
//        return postRepository.findAllByOrderByPublishedDesc();
//    }


}
