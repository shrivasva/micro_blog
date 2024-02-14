package poc.vivek.blog.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poc.vivek.blog.bean.Blog;
import poc.vivek.blog.model.BlogRequestModel;
import poc.vivek.blog.model.BlogResponseModel;
import poc.vivek.blog.repo.BlogRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    IEngagementService engagementService;

    @Override
    public BlogResponseModel addBlog(BlogRequestModel blogRequestModel) {
        Blog blog = getBlog(blogRequestModel);
        blog.setCreatedDate(LocalDate.now());
        blog.setBlog(blogRequestModel.getBlog().getBytes());
        blog.setActive(1);
        blog = blogRepository.save(blog);
        BlogResponseModel blogResponseModel = getBlogResponseModel(blog);
        blogResponseModel.setBlog(new String(blog.getBlog()));
        return blogResponseModel;
    }

    @Override
    public BlogResponseModel updateBlog(BlogRequestModel blogRequestModel) {
        Blog blog = getBlog(blogRequestModel);
        blog.setBlog(blogRequestModel.getBlog().getBytes());
        blogRepository.updateBlog(blogRequestModel.getBlog().getBytes(), blog.getId(), LocalDate.now());
        BlogResponseModel blogResponseModel = getBlogResponseModel(blog);
        return blogResponseModel;
    }

    @Override
    public BlogResponseModel deleteBlog(BlogRequestModel blogRequestModel) {
        Blog blog = getBlog(blogRequestModel);
        blog.setActive(0);
        BeanUtils.copyProperties(blogRequestModel, blog);
        blogRepository.deactivateBlog(blog.getId(), LocalDate.now());
        BlogResponseModel blogResponseModel = getBlogResponseModel(blog);
        return blogResponseModel;
    }

    @Override
    public List<BlogResponseModel> getAllBlogByUser(BlogRequestModel blogRequestModel) {
        Iterable<Blog> blogs = blogRepository.findAllByUser(blogRequestModel.getUserId());
        List<BlogResponseModel> blogResponseModels = new ArrayList<>();
        for (Blog blog : blogs) {
            BlogResponseModel blogResponseModel = getBlogResponseModel(blog);
            blogResponseModel.setBlog(new String(blog.getBlog()));
            blogResponseModels.add(blogResponseModel);
        }
        return blogResponseModels;
    }

    @Override
    public BlogResponseModel getAllBlogBIdAndUserId(BlogRequestModel blogRequestModel) {
        Blog blog = blogRepository.findAllByUserAndBlogId(blogRequestModel.getUserId(), blogRequestModel.getId());
        BlogResponseModel blogResponseModel = getBlogResponseModel(blog);
        blogResponseModel.setBlog(new String(blog.getBlog()));
        return blogResponseModel;
    }

    private BlogResponseModel getBlogResponseModel(Blog blog) {
        BlogResponseModel blogResponseModel = new BlogResponseModel();
        BeanUtils.copyProperties(blog, blogResponseModel);
        return blogResponseModel;
    }

    private Blog getBlog(BlogRequestModel blogRequestModel) {
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogRequestModel, blog);
        blog.setUpdatedDate(LocalDate.now());
        return blog;
    }

}
