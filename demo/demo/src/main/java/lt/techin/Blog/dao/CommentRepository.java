package lt.techin.Blog.dao;

import lt.techin.Blog.Model.Comment;
import lt.techin.Blog.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByPost_IdOrderByPublishedDesc(Long postId);
}
