package poc.vivek.blog.repo;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import poc.vivek.blog.bean.EngagementComments;

import java.time.LocalDate;
import java.util.List;

public interface EngagementCommentsRepository extends CrudRepository<EngagementComments, Long> {
    @Modifying
    @Query("Insert into app_engagement_comments (blog_id, user_id, active, comment, comment_date) values (:blogId,:userId, '1', :comment, :localDate) ")
    void addComment(@Param("blogId") long blogId, @Param("userId") long userId, @Param("comment") byte[] comment, @Param("localDate") LocalDate localDate);

    @Modifying
    @Query("Insert into app_engagement_comments (blog_id, user_id, comment_id, active, comment, comment_date) values (:blogId,:userId, :commentId, '1', :comment, :localDate) ")
    void addComment(@Param("blogId") long blogId, @Param("userId") long userId, @Param("commentId") long commentId, @Param("comment") byte[] bytes, @Param("localDate") LocalDate localDate);

    @Query("Select * from app_engagement_comments where blog_id = :blogId and user_id = :userId and active = '1' ")
    List<EngagementComments> getAllCommentsByBlogIdAndCommentId(@Param("blogId") long blogId, @Param("userId") long userId);

    @Query("Select count(*) from app_engagement_comments where blog_id = :blogId and user_id = :userId and active = '1' and comment_id is null ")
    long getEngagementCommentCountForBlogs(@Param("blogId") long blogId, @Param("userId") long userId);

    @Query("Select count(*) from app_engagement_comments where user_id = :userId and active = '1' and comment_id is null")
    long getEngagementCommentCountForBlogs(@Param("userId") long userId);
}
