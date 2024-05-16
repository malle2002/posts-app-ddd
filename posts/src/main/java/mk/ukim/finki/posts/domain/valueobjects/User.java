package mk.ukim.finki.posts.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.sharedkernel.domain.base.ValueObject;

@Getter
public class User implements ValueObject {
    private final UserId id;
    private final String name;
    private final String surname;
    private final String username;
    private User() {
        this.id=UserId.randomId(UserId.class);
        this.name= "";
        this.surname = "";
        this.username = "";
    }

    @JsonCreator
    public User(@JsonProperty("id") UserId id,
                   @JsonProperty("name") String name,
                   @JsonProperty("surname") String surname,
                   @JsonProperty("username") String username) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
    }

}
