package lt.techin.Blog.api.dto.Mapper;

import lt.techin.Blog.Model.Comment;
import lt.techin.Blog.Model.Post;
import lt.techin.Blog.api.dto.CommentDto;
import lt.techin.Blog.api.dto.CommentEntityDto;
import lt.techin.Blog.api.dto.PostDto;
import lt.techin.Blog.api.dto.PostEntityDto;

public class PostMapper {


    public static PostDto toPostDto(Post post) {
        var postDto = new PostDto();

        postDto.setPostName(post.getPostName());
        postDto.setText(post.getText());
        postDto.setPublished(post.getPublished());

        return postDto;
    }

    public static PostEntityDto toPostEntityDto(Post post) {
        var postDto = new PostEntityDto();

        postDto.setId(post.getId());
        postDto.setPostName(post.getPostName());
        postDto.setText(post.getText());
        postDto.setPublished(post.getPublished());

        return postDto;
    }

    public static Post toPost(PostDto postDto) {
        var post = new Post();

        post.setPostName(postDto.getPostName());
        post.setText(postDto.getText());
        post.setPublished(postDto.getPublished());

        return post;
    }

    public static Post toPostFromEntityDto(PostEntityDto postDto) {
        var post = new Post();

        post.setId(postDto.getId());
        post.setPostName(postDto.getPostName());
        post.setText(postDto.getText());
        post.setPublished(postDto.getPublished());

        return post;
    }

}
