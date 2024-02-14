package poc.vivek.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import poc.vivek.user.bean.UserSecret;
import poc.vivek.user.repo.UserSecretRepository;

import java.time.LocalDate;

@Service
@DependsOn("passwordEncoder")
public class UserSecretService implements IUserSecretService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserSecretRepository userSecretRepository;

    @Override
    public UserSecret getUserDetailsById(long userId) {
        return userSecretRepository.findByUserId(userId);
    }

    @Override
    public void save(UserSecret userSecret) {
        userSecret.setLastUpdated(LocalDate.now());
        userSecret.setValidTill(LocalDate.now().plusDays(90));
        String encodedPassword = passwordEncoder.encode(userSecret.getPassword());
        userSecret.setPassword(encodedPassword);
        userSecretRepository.save(userSecret);
    }
}
