package poc.vivek.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poc.vivek.blog.bean.EngagementComments;
import poc.vivek.blog.model.EngagementCommentResponseModel;
import poc.vivek.blog.repo.EngagementCommentsRepository;
import poc.vivek.blog.repo.EngagementLikesRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EngagementService implements IEngagementService {
    @Autowired
    EngagementCommentsRepository engagementCommentsRepository;
    @Autowired
    EngagementLikesRepository engagementLikesRepository;

    @Override
    public void like(long blogId, long userId) {
        engagementLikesRepository.addLike(blogId, userId, LocalDate.now());
    }

    @Override
    public void comment(long blogId, long userId, String comment) {
        engagementCommentsRepository.addComment(blogId, userId, comment.getBytes(), LocalDate.now());
    }

    @Override
    public void comment(long blogId, long userId, long commentId, String comment) {
        engagementCommentsRepository.addComment(blogId, userId, commentId, comment.getBytes(), LocalDate.now());
    }

    @Override
    public void like(long blogId, long userId, long commentId) {
        engagementLikesRepository.addLike(blogId, userId, commentId, LocalDate.now());
    }

    @Override
    public List<EngagementCommentResponseModel> getAllComments(long blogId, long userId) {
        List<EngagementComments> engagementCommentList = engagementCommentsRepository.getAllCommentsByBlogIdAndCommentId(blogId, userId);
        List<EngagementCommentResponseModel> engagementCommentResponseModelList = new ArrayList<>();

        for (EngagementComments engagementComment : engagementCommentList) {
            EngagementCommentResponseModel engagementCommentResponseModel = new EngagementCommentResponseModel();
            engagementCommentResponseModel.setComment(new String(engagementComment.getComment()));
            engagementCommentResponseModel.setCommentId(engagementComment.getCommentId());
            engagementCommentResponseModelList.add(engagementCommentResponseModel);
        }
        return engagementCommentResponseModelList;
    }

    @Override
    public Map<String, Long> getEngagementCount(long blogId, long userId) {
        long engagementCommentCountForBlogs = engagementCommentsRepository.getEngagementCommentCountForBlogs(blogId, userId);
        long engagementLikesCountForBlogs = engagementLikesRepository.getEngagementLikesCountForBlogs(blogId, userId);
        Map<String, Long> map = new HashMap<>();
        map.put("likes", engagementLikesCountForBlogs);
        map.put("comments", engagementCommentCountForBlogs);
        return map;
    }

    @Override
    public Map<String, Long> getEngagementCountForUser(long userId) {
        long engagementCommentCountForBlogs = engagementCommentsRepository.getEngagementCommentCountForBlogs(userId);
        long engagementLikesCountForBlogs = engagementLikesRepository.getEngagementLikesCountForBlogs(userId);
        Map<String, Long> map = new HashMap<>();
        map.put("likes", engagementLikesCountForBlogs);
        map.put("comments", engagementCommentCountForBlogs);
        return map;
    }
}
