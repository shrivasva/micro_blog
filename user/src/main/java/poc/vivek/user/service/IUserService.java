package poc.vivek.user.service;

import poc.vivek.user.bean.User;
import poc.vivek.user.model.UserDetailModel;
import poc.vivek.user.model.UserResponseModel;
import poc.vivek.user.model.UsernamePasswordModel;

public interface IUserService {
    Iterable<UserResponseModel> getAllUsers() throws Exception;

    void save(UserDetailModel userDetailModel);

    User findById(Long id);

    void deleteById(Long id);

    UserResponseModel verifyUserNameAndPassword(UsernamePasswordModel usernamePasswordModel);

    void insertTemp(String password) throws Exception;

    String getTemp(String password) throws Exception;

}
