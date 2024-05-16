package mk.ukim.finki.posts.service.form;

import lombok.Data;
import mk.ukim.finki.posts.domain.valueobjects.User;

import javax.validation.constraints.NotNull;

@Data
public class CommentForm {
    @NotNull
    private String text;
    @NotNull
    private User user;
}
