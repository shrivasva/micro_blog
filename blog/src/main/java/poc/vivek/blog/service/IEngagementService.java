package poc.vivek.blog.service;

import poc.vivek.blog.model.EngagementCommentResponseModel;

import java.util.List;
import java.util.Map;

public interface IEngagementService {
    void like(long blogId, long userId);

    void comment(long blogId, long userId, String comment);

    void comment(long blogId, long userId, long commentId, String comment);

    void like(long blogId, long userId, long commentId);

    List<EngagementCommentResponseModel> getAllComments(long blogId, long userId);

    Map<String, Long> getEngagementCount(long blogId, long userId);

    Map<String, Long> getEngagementCountForUser(long userId);
}
