package mk.ukim.finki.posts.service;

import mk.ukim.finki.posts.client.UserClient;
import mk.ukim.finki.posts.domain.exceptions.PostIdNotExistException;
import mk.ukim.finki.posts.domain.models.Post;
import mk.ukim.finki.posts.domain.models.PostId;
import mk.ukim.finki.posts.domain.valueobjects.User;
import mk.ukim.finki.posts.domain.valueobjects.UserId;
import mk.ukim.finki.posts.service.form.CommentForm;
import mk.ukim.finki.posts.service.form.PostForm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class PostServiceImplTests {
    @Autowired
    private PostService postService;

    @Autowired
    private UserClient userClient;

    private static User newUser(String name, String surname, String username) {
        User u = new User(UserId.randomId(UserId.class), name,surname,username);
        return u;
    }

    @Test
    public void testMakeComment() {
        User user1 = newUser("Atanas","Atanasov","malle2002");
        User user2 = newUser("Trajce","Trajkov","trajce_trajkov222");
        CommentForm c1 = new CommentForm();
        c1.setText("text-comment-1");
        c1.setUser(user1);

        CommentForm c2 = new CommentForm();
        c2.setText("text-comment-2");
        c2.setUser(user2);

        PostForm postForm = new PostForm();
        postForm.setUser(user1);
        postForm.setBody("body-post-1");
        postForm.setTitle("title-post-1");
        postForm.setCommentList(Arrays.asList(c1,c2));

        PostId newPostId = postService.createPost(postForm);
        Post newPost = postService.findById(newPostId).orElseThrow(PostIdNotExistException::new);
        Assertions.assertEquals(newPost.getCommentList().stream().toList().get(0).getText(),"text-comment-1");

    }

    @Test
    public void testMakeCommentDatabase() {
        List<User> userList = userClient.findAll();
        User u1 = userList.get(0);
        User u2 = userList.get(1);

        CommentForm c1 = new CommentForm();
        c1.setText("text-comment-11");
        c1.setUser(u1);

        CommentForm c2 = new CommentForm();
        c2.setText("text-comment-22");
        c2.setUser(u2);

        PostForm postForm = new PostForm();
        postForm.setUser(u1);
        postForm.setBody("body-post-11");
        postForm.setTitle("title-post-11");
        postForm.setCommentList(Arrays.asList(c1,c2));

        PostId newPostId = postService.createPost(postForm);
        Post newPost = postService.findById(newPostId).orElseThrow(PostIdNotExistException::new);
        Assertions.assertEquals(newPost.getCommentList().stream().toList().get(1).getText(),"text-comment-11");
    }


}
