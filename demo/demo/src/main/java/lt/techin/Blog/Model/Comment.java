package lt.techin.Blog.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Negali buti tuscias")
    @Size(min = 1, max = 200)
    private String author;
    @NotBlank(message = "Negali buti tuscias")
    @Size(min = 1, max = 4000)
    private String text;
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime published;

    @PrePersist
    public void prePersist() {
        published = LocalDateTime.now();
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment(){}

    public Comment(Long id, String author, String text, LocalDateTime published, Post post) {
        this.id = id;
        this.author = author;
        this.text = text;
        this.published = published;
        this.post = post ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getPublished() {
        return published;
    }

    public void setPublished(LocalDateTime published) {
        this.published = published;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) && Objects.equals(author, comment.author) && Objects.equals(text, comment.text) && Objects.equals(published, comment.published) && Objects.equals(post, comment.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, text, published, post);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", published=" + published +
                ", post=" + post +
                '}';
    }
}
