package lt.techin.Blog.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lt.techin.Blog.Model.Post;
import org.springframework.data.annotation.CreatedDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

public class CommentDto {

    private String author;

    private String text;

    private LocalDateTime published;
@JsonIgnore
    private Post post;

    public CommentDto(){}

    public CommentDto(String author, String text, LocalDateTime published, Post post) {
        this.author = author;
        this.text = text;
        this.published = published;
        this.post = post;
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
        CommentDto that = (CommentDto) o;
        return Objects.equals(author, that.author) && Objects.equals(text, that.text) && Objects.equals(published, that.published) && Objects.equals(post, that.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, text, published, post);
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", published=" + published +
                ", post=" + post +
                '}';
    }
}
