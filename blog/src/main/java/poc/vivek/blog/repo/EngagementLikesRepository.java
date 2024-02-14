package poc.vivek.blog.repo;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import poc.vivek.blog.bean.EngagementLikes;

import java.time.LocalDate;

public interface EngagementLikesRepository extends CrudRepository<EngagementLikes, Long> {
    @Modifying
    @Query("Insert into app_engagement_likes (blog_id, user_id, likes, active, like_date) values ( :blogId, :userId, '1', '1', :localDate) ")
    void addLike(@Param("blogId") long blogId, @Param("userId") long userId, @Param("localDate") LocalDate localDate);

    @Modifying
    @Query("Insert into app_engagement_likes (blog_id, user_id, comment_id, likes, like_date) values (:blogId,:userId,:commentId, '1', :localDate) ")
    void addLike(@Param("blogId") long blogId, @Param("userId") long userId, @Param("commentId") long commentId, @Param("blogId") LocalDate localDate);

    @Query("Select count(*) from app_engagement_likes where blog_id = :blogId and user_id = :userId and active = '1' ")
    long getEngagementLikesCountForBlogs(@Param("blogId") long blogId, @Param("userId") long userId);

    @Query("Select count(*) from app_engagement_likes where user_id = :userId and active = '1' ")
    long getEngagementLikesCountForBlogs(@Param("userId") long userId);
}
