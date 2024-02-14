package poc.vivek.user.repo;

import org.springframework.data.repository.CrudRepository;
import poc.vivek.user.bean.UserSecret;

public interface UserSecretRepository extends CrudRepository<UserSecret, Long> {
    UserSecret findByUserId(Long userId);

}