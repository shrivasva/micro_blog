package poc.vivek.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poc.vivek.common.model.ResponseEntityBuilder;
import poc.vivek.common.model.ResponseModel;
import poc.vivek.user.service.IAddressService;
import poc.vivek.user.service.IUserService;

import java.util.Base64;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    IUserService userService;
    @Autowired
    IAddressService addressService;

    @GetMapping
    public ResponseEntity<ResponseModel> getAllUsers() throws Exception {
        return new ResponseEntityBuilder<ResponseModel>().setStatusCode(HttpStatus.OK).setErCode("000").setMessage("SUCCESS").setBody(userService.getAllUsers()).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseModel> getUserById(@PathVariable Long id) {
        return new ResponseEntityBuilder<ResponseModel>().setStatusCode(HttpStatus.OK).setErCode("000").setMessage("SUCCESS").setBody(userService.findById(id)).build();
    }

    @GetMapping("/insertTemp/{pass}")
    public ResponseEntity<ResponseModel> insertTemp(@PathVariable String pass) throws Exception {
        userService.insertTemp(pass);
        return new ResponseEntityBuilder<ResponseModel>().setStatusCode(HttpStatus.OK).setErCode("000").setMessage("SUCCESS").setBody("SUCCESS").build();
    }
    @GetMapping("/getTemp/{pass}")
    public ResponseEntity<ResponseModel> getTemp(@PathVariable String pass) throws Exception {
        return new ResponseEntityBuilder<ResponseModel>().setStatusCode(HttpStatus.OK).setErCode("000").setMessage("SUCCESS").setBody(userService.getTemp(new String(Base64.getDecoder().decode(pass.getBytes())))).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseModel> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return new ResponseEntityBuilder<ResponseModel>().setStatusCode(HttpStatus.OK).setErCode("000").setMessage("SUCCESS").setBody("USER REMOVED").build();
    }

}