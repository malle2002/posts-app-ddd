package mk.ukim.finki.posts.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mk.ukim.finki.posts.domain.exceptions.CommentIdNotExistException;
import mk.ukim.finki.posts.domain.exceptions.PostIdNotExistException;
import mk.ukim.finki.posts.domain.models.CommentId;
import mk.ukim.finki.posts.domain.models.Post;
import mk.ukim.finki.posts.domain.models.PostId;
import mk.ukim.finki.posts.domain.repository.PostRepository;
import mk.ukim.finki.posts.service.PostService;
import mk.ukim.finki.posts.service.form.CommentForm;
import mk.ukim.finki.posts.service.form.PostForm;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public PostId createPost(PostForm postForm) {
        Objects.requireNonNull(postForm,"post must not be null.");
        var newPost = postRepository.saveAndFlush(toDomainObject(postForm));
        return newPost.getId();

    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(PostId id) {
        return postRepository.findById(id);
    }

    @Override
    public void addItem(PostId postId, CommentForm commentForm) throws PostIdNotExistException {
        Post post = postRepository.findById(postId).orElseThrow(PostIdNotExistException::new);
        post.addComment(commentForm.getUser().getId(), commentForm.getText());
        postRepository.saveAndFlush(post);
    }

    @Override
    public void deleteItem(PostId postId, CommentId commentId) throws PostIdNotExistException, CommentIdNotExistException {
        Post post = postRepository.findById(postId).orElseThrow(PostIdNotExistException::new);
        post.removeComment(commentId);
        postRepository.saveAndFlush(post);
    }
    private Post toDomainObject(PostForm postForm) {
        var post = new Post(Instant.now(),postForm.getTitle(),postForm.getBody(),postForm.getUser().getId());
        postForm.getCommentList().forEach(cmt->post.addComment(cmt.getUser().getId(), cmt.getText()));
        return post;
    }

}
