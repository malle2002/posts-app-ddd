package mk.ukim.finki.posts.domain.repository;

import mk.ukim.finki.posts.domain.models.Post;
import mk.ukim.finki.posts.domain.models.PostId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, PostId> {
}
