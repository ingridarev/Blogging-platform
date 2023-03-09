package lt.techin.Blog.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lt.techin.Blog.Model.Comment;
import org.springframework.data.annotation.CreatedDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class PostDto {

    private String postName;

    private String text;
    private LocalDateTime published;
    private List<Comment> commentList;


    public PostDto(){}

    public PostDto(String postName, String text, LocalDateTime published,List<Comment> commentList) {
        this.postName = postName;
        this.text = text;
        this.published = published;
        this.commentList=commentList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
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
    public String toString() {
        return "PostDto{" +
                "postName='" + postName + '\'' +
                ", text='" + text + '\'' +
                ", published=" + published +
                ", commentList=" + commentList +
                '}';
    }
}
