package poc.vivek.blog.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poc.vivek.blog.model.EngagementRequestModel;
import poc.vivek.blog.service.IEngagementService;
import poc.vivek.common.model.ResponseEntityBuilder;
import poc.vivek.common.model.ResponseModel;

@RestController
@RequestMapping("/api/blog/")
public class EngagementController {
    @Autowired
    IEngagementService engagementService;

    @GetMapping("/like/{blogId}/{userId}")
    public ResponseEntity<ResponseModel> addLike(@Valid @PathVariable @NotNull long blogId, @Valid @PathVariable @NotNull long userId) {
        engagementService.like(blogId, userId);
        return new ResponseEntityBuilder<ResponseModel>().setStatusCode(HttpStatus.OK).setErCode("000").setMessage("SUCCESS").setBody("like added").build();
    }

    @PostMapping("/comment/{blogId}/{userId}")
    public ResponseEntity<ResponseModel> addComment(@Valid @PathVariable @NotNull long blogId, @Valid @PathVariable @NotNull long userId, @Valid @RequestBody @NotNull EngagementRequestModel engagementRequestModel) {
        engagementService.comment(blogId, userId, engagementRequestModel.getComments());
        return new ResponseEntityBuilder<ResponseModel>().setStatusCode(HttpStatus.OK).setErCode("000").setMessage("SUCCESS").setBody("comment added").build();
    }

    @PostMapping("/comment/{blogId}/{userId}/{commentId}")
    public ResponseEntity<ResponseModel> addComment(@Valid @PathVariable @NotNull long blogId, @Valid @PathVariable @NotNull long userId, @Valid @PathVariable @NotNull long commentId, @Valid @RequestBody @NotNull EngagementRequestModel engagementRequestModel) {
        engagementService.comment(blogId, userId, commentId, engagementRequestModel.getComments());
        return new ResponseEntityBuilder<ResponseModel>().setStatusCode(HttpStatus.OK).setErCode("000").setMessage("SUCCESS").setBody("comment added").build();
    }

    @GetMapping("/like/{blogId}/{userId}/{commentId}")
    public ResponseEntity<ResponseModel> addLikeUnderComment(@Valid @PathVariable @NotNull long blogId, @Valid @PathVariable @NotNull long userId, @Valid @PathVariable @NotNull long commentId) {
        engagementService.like(blogId, userId, commentId);
        return new ResponseEntityBuilder<ResponseModel>().setStatusCode(HttpStatus.OK).setErCode("000").setMessage("SUCCESS").setBody("like added").build();
    }

    @GetMapping("/getAllComments/{blogId}/{userId}")
    public ResponseEntity<ResponseModel> getAllComments(@Valid @PathVariable @NotNull long blogId, @Valid @PathVariable @NotNull long userId) {
        return new ResponseEntityBuilder<ResponseModel>().setStatusCode(HttpStatus.OK).setErCode("000").setMessage("SUCCESS").setBody(engagementService.getAllComments(blogId, userId)).build();
    }

    @GetMapping("/engagementCount/{blogId}/{userId}")
    public ResponseEntity<ResponseModel> getEngagementCount(@Valid @PathVariable @NotNull long blogId, @Valid @PathVariable @NotNull long userId) {
        return new ResponseEntityBuilder<ResponseModel>().setStatusCode(HttpStatus.OK).setErCode("000").setMessage("SUCCESS").setBody( engagementService.getEngagementCount(blogId, userId)).build();
    }

    @GetMapping("/engagementCount/{userId}")
    public ResponseEntity<ResponseModel> getAllEngagementCountForUser(@Valid @PathVariable @NotNull long userId) {
        return new ResponseEntityBuilder<ResponseModel>().setStatusCode(HttpStatus.OK).setErCode("000").setMessage("SUCCESS").setBody(engagementService.getEngagementCountForUser(userId)).build();
    }

}
