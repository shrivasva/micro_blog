package poc.vivek.user.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import poc.vivek.common.model.ResponseEntityBuilder;
import poc.vivek.common.model.ResponseModel;
import poc.vivek.user.config.JwtUtil;
import poc.vivek.user.model.UserResponseModel;
import poc.vivek.user.model.UsernamePasswordModel;
import poc.vivek.user.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    UserService userService;
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<ResponseModel> auth(@Valid @RequestBody UsernamePasswordModel usernamePasswordModel) {
        UserResponseModel userResponseModel = userService.verifyUserNameAndPassword(usernamePasswordModel);
        HttpHeaders headers = new HttpHeaders();
        if (userResponseModel != null) {
            String jwtToken = jwtUtil.generateToken(userResponseModel.getEmailId());
            headers.add("token", jwtToken);

        }
        return new ResponseEntityBuilder<ResponseModel>().setStatusCode(HttpStatus.OK).setErCode("000").setMessage("SUCCESS").setBody(userResponseModel).build(headers);
    }
}
