package mk.ukim.finki.posts.service;

import mk.ukim.finki.posts.domain.exceptions.CommentIdNotExistException;
import mk.ukim.finki.posts.domain.exceptions.PostIdNotExistException;
import mk.ukim.finki.posts.domain.models.CommentId;
import mk.ukim.finki.posts.domain.models.Post;
import mk.ukim.finki.posts.domain.models.PostId;
import mk.ukim.finki.posts.service.form.CommentForm;
import mk.ukim.finki.posts.service.form.PostForm;

import java.util.List;
import java.util.Optional;

public interface PostService {
    PostId createPost(PostForm postForm);

    List<Post> findAll();

    Optional<Post> findById(PostId id);

    void addItem(PostId postId, CommentForm commentForm) throws PostIdNotExistException;

    void deleteItem(PostId postId, CommentId commentId) throws PostIdNotExistException, CommentIdNotExistException;

}
