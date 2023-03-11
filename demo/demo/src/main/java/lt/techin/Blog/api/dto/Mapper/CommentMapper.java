package lt.techin.Blog.api.dto.Mapper;

import lt.techin.Blog.Model.Comment;
import lt.techin.Blog.Model.Post;
import lt.techin.Blog.api.dto.CommentDto;
import lt.techin.Blog.api.dto.CommentEntityDto;
import lt.techin.Blog.api.dto.PostEntityDto;

public class CommentMapper {

    public static CommentDto toCommentDto(Comment comment) {
        var commentDto = new CommentDto();

        commentDto.setAuthor(comment.getAuthor());
        commentDto.setText(comment.getText());
        commentDto.setPublished(comment.getPublished());

        return commentDto;
    }

    public static CommentEntityDto toCommentEntityDto(Comment comment) {
        var commentDto = new CommentEntityDto();

        commentDto.setId(comment.getId());
        commentDto.setAuthor(comment.getAuthor());
        commentDto.setText(comment.getText());
        commentDto.setPublished(comment.getPublished());


        return commentDto;
    }

    public static Comment toComment(CommentDto commentDto) {
        var comment = new Comment();

        comment.setAuthor(commentDto.getAuthor());
        comment.setText(commentDto.getText());
        comment.setPublished(commentDto.getPublished());

        return comment;
    }

    public static Comment toCommentEntityDto(CommentEntityDto commentDto) {
        var comment = new Comment();

        comment.setId(commentDto.getId());
        comment.setAuthor(commentDto.getAuthor());
        comment.setText(commentDto.getText());
        comment.setPublished(commentDto.getPublished());

        return comment;
    }

}
