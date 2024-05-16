package mk.ukim.finki.posts.domain.valueobjects;

import jakarta.persistence.Embeddable;
import mk.ukim.finki.sharedkernel.domain.base.DomainObjectId;

@Embeddable
public class UserId extends DomainObjectId {
    private UserId() {
        super(UserId.randomId(UserId.class).getId());
    }

    public UserId(String uuid) {
        super(uuid);
    }

}
