package lt.techin.Blog.api.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class PostEntityDto extends PostDto{

    private Long id;

    public PostEntityDto(){}

    public PostEntityDto(String postName, String text, LocalDateTime published, Long id) {
        super(postName, text, published);
        this.id = id;
    }

    public PostEntityDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PostEntityDto that = (PostEntityDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "PostEntityDto{" +
                "id=" + id +
                '}';
    }
}
