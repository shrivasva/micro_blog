package poc.vivek.user.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import poc.vivek.common.model.ResponseEntityBuilder;
import poc.vivek.common.model.ResponseModel;
import poc.vivek.user.model.UserDetailModel;
import poc.vivek.user.service.UserService;

@RestController
@RequestMapping("/api/users/register")
public class RegisterController {
    @Autowired
    public UserService userService;

    @PostMapping
    public ResponseEntity<ResponseModel> register(@Valid @RequestBody UserDetailModel userDetailModel) {
        userService.save(userDetailModel);
        return new ResponseEntityBuilder<ResponseModel>().setStatusCode(HttpStatus.OK).setErCode("000").setMessage("SUCCESS").setBody("User added").build();
    }

}
