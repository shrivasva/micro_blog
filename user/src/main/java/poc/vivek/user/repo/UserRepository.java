package poc.vivek.user.repo;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import poc.vivek.user.bean.User;
import poc.vivek.user.model.UserResponseModel;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("Select users.first_name, users.last_name, secret.password, users.email_id from app_users users" +
            " inner join app_users_secret secret on users.id = secret.user_id" +
            " where users.email_id = :username")
    UserResponseModel getUserByUsername(@Param("username") String username);

    User findByContactNo(String contactNo);
    @Modifying
    @Query("insert into APP_USERS_TEMP values (encrypt_iv(:value::bytea, :key::bytea, '0000000000000000'::bytea, 'AES'))")
    void insertTemp(@Param("value") String value, @Param("key") String key);
    @Query("select decrypt_iv(users.password::bytea, :key::bytea, '0000000000000000'::bytea, 'AES') from APP_USERS_TEMP  users where users.password = :value")
    String getTemp(@Param("value") String value,@Param("key") String key);
}