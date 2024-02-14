package poc.vivek.blog.repo;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import poc.vivek.blog.bean.Blog;

import java.time.LocalDate;

public interface BlogRepository extends CrudRepository<Blog, Long> {
    @Modifying
    @Query("Update APP_BLOG_CONTENT set blog = :blog::bytea, updated_date = :localDate where blog_id = :blogId ")
    void updateBlog(@Param("blog") byte[] blog, @Param("blogId") long blogId, @Param("localDate") LocalDate localDate);

    @Modifying
    @Query("Update APP_BLOG_CONTENT set active = '0' , updated_date = :localDate where blog_id = :blogId ")
    void deactivateBlog(@Param("blogId") long blogId, @Param("localDate") LocalDate localDate);

    @Query("Select * from APP_BLOG_CONTENT where active = '1' and user_id = :userId ")
    Iterable<Blog> findAllByUser(@Param("userId") long userId);

    @Query("Select * from APP_BLOG_CONTENT where active = '1' and user_id = :userId  and id = :blogId")
    Blog findAllByUserAndBlogId(@Param("userId") long userId, @Param("blogId") long blogId);
}
