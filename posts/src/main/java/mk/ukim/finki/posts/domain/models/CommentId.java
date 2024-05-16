package mk.ukim.finki.posts.domain.models;

import mk.ukim.finki.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class CommentId extends DomainObjectId {
    private CommentId() {
        super(CommentId.randomId(CommentId.class).getId());
    }

    public CommentId(@NonNull String uuid) {
        super(uuid);
    }

}
