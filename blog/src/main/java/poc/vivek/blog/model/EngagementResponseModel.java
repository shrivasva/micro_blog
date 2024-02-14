package poc.vivek.blog.model;

import java.util.List;

public class EngagementResponseModel {
    private long userId;
    private long blogId;
    private int likes;

    private List<EngagementCommentResponseModel> engagementResponseModelList;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getBlogId() {
        return blogId;
    }

    public void setBlogId(long blogId) {
        this.blogId = blogId;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<EngagementCommentResponseModel> getEngagementResponseModelList() {
        return engagementResponseModelList;
    }

    public void setEngagementResponseModelList(List<EngagementCommentResponseModel> engagementResponseModelList) {
        this.engagementResponseModelList = engagementResponseModelList;
    }
}
