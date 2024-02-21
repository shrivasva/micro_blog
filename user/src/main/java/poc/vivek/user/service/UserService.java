package poc.vivek.user.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import poc.vivek.common.exception.GenericException;
import poc.vivek.user.bean.Address;
import poc.vivek.user.bean.User;
import poc.vivek.user.bean.UserSecret;
import poc.vivek.user.enc.AESEncrypt;
import poc.vivek.user.model.UserDetailModel;
import poc.vivek.user.model.UserResponseModel;
import poc.vivek.user.model.UsernamePasswordModel;
import poc.vivek.user.repo.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private AESEncrypt aesEncrypt;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IAddressService addressService;
    @Autowired
    private IUserSecretService userSecretService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Iterable<UserResponseModel> getAllUsers() throws Exception {
        Iterable<User> users = userRepository.findAll();
        List<UserResponseModel> userResponseModels = new ArrayList<>();
        for (User user : users) {
            UserResponseModel userResponseModel = new UserResponseModel();
            BeanUtils.copyProperties(user, userResponseModel);
            userResponseModel.setContactNo(aesEncrypt.decrypt(user.getContactNo()));
            userResponseModels.add(userResponseModel);
        }
        return userResponseModels;
    }

    @Override
    public void save(UserDetailModel userDetailModel) {
        User user = new User();
        Address address = new Address();
        UserSecret userSecret = new UserSecret();
        BeanUtils.copyProperties(userDetailModel, user);
        BeanUtils.copyProperties(userDetailModel, address);
        BeanUtils.copyProperties(userDetailModel, userSecret);
        try {
            user.setContactNo(aesEncrypt.encrypt(user.getContactNo()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        userRepository.save(user);
        address.setUserId(user.getId());
        addressService.save(address);
        userSecret.setUserId(user.getId());
        userSecretService.save(userSecret);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserResponseModel verifyUserNameAndPassword(UsernamePasswordModel usernamePasswordModel) {
        UserResponseModel userResponseModel = userRepository.getUserByUsername(usernamePasswordModel.getUsername());
        if (userResponseModel != null) {
            return passwordEncoder.matches(usernamePasswordModel.getPassword(), userResponseModel.getPassword()) ? userResponseModel : null;
        }
        throw new GenericException("INVALID USER");
    }

    @Override
    public void insertTemp(String contactNo) throws Exception {
        System.out.println(aesEncrypt.encrypt(contactNo));
        userRepository.insertTemp(contactNo, "12345678901234567890123456789012");
    }

    @Override
    public String getTemp(String contactNo) throws Exception {
        System.out.println(userRepository.getTemp(contactNo, "12345678901234567890123456789012"));
        return userRepository.getTemp(contactNo, "12345678901234567890123456789012");
    }
}
