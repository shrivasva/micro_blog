package poc.vivek.blog.service;

import poc.vivek.blog.model.BlogRequestModel;
import poc.vivek.blog.model.BlogResponseModel;

import java.util.List;

public interface IBlogService {
    BlogResponseModel addBlog(BlogRequestModel blogRequestModel);

    BlogResponseModel updateBlog(BlogRequestModel blogRequestModel);

    BlogResponseModel deleteBlog(BlogRequestModel blogRequestModel);

    List<BlogResponseModel> getAllBlogByUser(BlogRequestModel blogRequestModel);

    BlogResponseModel getAllBlogBIdAndUserId(BlogRequestModel blogRequestModel);
}
