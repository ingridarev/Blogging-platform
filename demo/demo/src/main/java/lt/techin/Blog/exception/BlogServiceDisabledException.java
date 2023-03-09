package lt.techin.Blog.exception;

public class BlogServiceDisabledException extends RuntimeException{

    public BlogServiceDisabledException() {
    }

    public BlogServiceDisabledException(String message) {
        super(message);
    }

}
