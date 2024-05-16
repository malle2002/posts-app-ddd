package mk.ukim.finki.posts.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import mk.ukim.finki.posts.domain.valueobjects.User;
import mk.ukim.finki.posts.domain.valueobjects.UserId;
import mk.ukim.finki.sharedkernel.domain.base.AbstractEntity;
import org.springframework.lang.NonNull;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="posts")
@Getter
public class Post extends AbstractEntity<PostId> {
    private Instant createdOn;
    private String title;
    private String body;
    @AttributeOverride(name = "id", column = @Column(name = "user_id", nullable = false))
    private UserId userId;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Comment> commentList = new HashSet<>();
    private Post() {
        super(PostId.randomId(PostId.class));
    }
    public Post(Instant now, @NonNull String title, @NonNull String body,@NonNull UserId userId) {
        super(PostId.randomId(PostId.class));
        this.createdOn = now;
        this.userId = userId;
        this.body = body;
        this.title = title;
    }
    public Comment addComment(@NonNull UserId userId, @NonNull String text) {
        Objects.requireNonNull(userId,"user must not be null");
        var cmt  = new Comment(userId,Instant.now(),text);
        commentList.add(cmt);
        return cmt;
    }
    public void removeComment(@NonNull CommentId commentId) {
        Objects.requireNonNull(commentId,"Comment must not be null");
        commentList.removeIf(c->c.getId().equals(commentId));
    }

}
