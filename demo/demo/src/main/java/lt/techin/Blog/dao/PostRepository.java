package lt.techin.Blog.dao;

import lt.techin.Blog.Model.Comment;
import lt.techin.Blog.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

List<Post> findAllByOrderByPublishedDesc();

}