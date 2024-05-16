package mk.ukim.finki.posts.service.form;

import lombok.Data;
import mk.ukim.finki.posts.domain.models.Comment;
import mk.ukim.finki.posts.domain.valueobjects.User;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class PostForm {
    @NotNull
    private String title;
    @NotNull
    private String body;
    @NotNull
    private User user;
    @Valid
    @NotEmpty
    private List<CommentForm> commentList = new ArrayList<>();

}
