package poc.vivek.blog.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import poc.vivek.blog.model.BlogRequestModel;
import poc.vivek.blog.model.BlogResponseModel;
import poc.vivek.blog.service.IBlogService;
import poc.vivek.common.model.ResponseEntityBuilder;
import poc.vivek.common.model.ResponseModel;

import java.util.List;

@RestController
@RequestMapping("/api/blog/")
public class BlogController {
    @Autowired
    IBlogService blogService;

    @PostMapping("/addBlog")
    public ResponseEntity<ResponseModel> addBlog(@Valid @RequestBody BlogRequestModel blogRequestModel) {
        BlogResponseModel userResponseModel = blogService.addBlog(blogRequestModel);
        return new ResponseEntityBuilder<ResponseModel>().setStatusCode(HttpStatus.OK).setErCode("000").setMessage("SUCCESS").setBody(userResponseModel).build();
    }

    @PostMapping("/updateBlog")
    public ResponseEntity<ResponseModel> updateBlog(@Valid @RequestBody BlogRequestModel blogRequestModel) {
        BlogResponseModel userResponseModel = blogService.updateBlog(blogRequestModel);
        return new ResponseEntityBuilder<ResponseModel>().setStatusCode(HttpStatus.OK).setErCode("000").setMessage("SUCCESS").setBody(userResponseModel).build();
    }

    @PostMapping("/deleteBlog")
    public ResponseEntity<ResponseModel> deleteBlog(@Valid @RequestBody BlogRequestModel blogRequestModel) {
        BlogResponseModel userResponseModel = blogService.deleteBlog(blogRequestModel);
        return new ResponseEntityBuilder<ResponseModel>().setStatusCode(HttpStatus.OK).setErCode("000").setMessage("SUCCESS").setBody(userResponseModel).build();
    }

    @PostMapping("/getAllBlogByUser")
    public ResponseEntity<ResponseModel> getAllBlogByUser(@Valid @RequestBody BlogRequestModel blogRequestModel) {
        List<BlogResponseModel> userResponseModels = blogService.getAllBlogByUser(blogRequestModel);
        return new ResponseEntityBuilder<ResponseModel>().setStatusCode(HttpStatus.OK).setErCode("000").setMessage("SUCCESS").setBody(userResponseModels).build();
    }

    @PostMapping("/getAllBlogById")
    public ResponseEntity<ResponseModel> getAllBlogBIdAndUserId(@Valid @RequestBody BlogRequestModel blogRequestModel) {
        BlogResponseModel userResponseModel = blogService.getAllBlogBIdAndUserId(blogRequestModel);
        return new ResponseEntityBuilder<ResponseModel>().setStatusCode(HttpStatus.OK).setErCode("000").setMessage("SUCCESS").setBody(userResponseModel).build();
    }
}
