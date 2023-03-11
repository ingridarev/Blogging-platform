package lt.techin.Blog.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Negali buti tuscias")
    @Size(min = 1, max = 200)
    private String postName;
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

    public Post(){}

    public Post(Long id, String postName, String text, LocalDateTime published) {
        this.id = id;
        this.postName = postName;
        this.text = text;
        this.published = published;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(postName, post.postName) && Objects.equals(text, post.text) && Objects.equals(published, post.published);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, postName, text, published);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", postName='" + postName + '\'' +
                ", text='" + text + '\'' +
                ", published=" + published +
                '}';
    }
}


