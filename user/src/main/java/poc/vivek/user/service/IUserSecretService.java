package poc.vivek.user.service;

import poc.vivek.user.bean.UserSecret;

public interface IUserSecretService {
    public UserSecret getUserDetailsById(long userId);

    void save(UserSecret userSecret);
}
