package mk.ukim.finki.posts.domain.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.posts.domain.valueobjects.UserId;
import mk.ukim.finki.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.sharedkernel.domain.base.DomainObjectId;

import java.time.Instant;

@Entity
@Table(name="comments")
@Getter
public class Comment extends AbstractEntity<CommentId> {
    @AttributeOverride(name = "id", column = @Column(name = "user_id", nullable = false))
    private UserId userId;
    private Instant createdOn;
    private String text;
    private Comment() {
        super(DomainObjectId.randomId(CommentId.class));
    }

    public Comment(@NonNull UserId userId, Instant createdOn, String text) {
        super(DomainObjectId.randomId(CommentId.class));
        this.userId = userId;
        this.text = text;
        this.createdOn = createdOn;
    }

}
