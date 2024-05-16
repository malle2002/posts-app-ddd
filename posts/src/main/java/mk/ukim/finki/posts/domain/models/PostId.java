package mk.ukim.finki.posts.domain.models;

import mk.ukim.finki.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class PostId extends DomainObjectId {
    private PostId() {
        super(PostId.randomId(PostId.class).getId());
    }

    public PostId(@NonNull String uuid) {
        super(uuid);
    }

}
