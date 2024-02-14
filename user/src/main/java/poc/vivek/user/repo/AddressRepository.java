package poc.vivek.user.repo;

import org.springframework.data.repository.CrudRepository;
import poc.vivek.user.bean.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

    Address findByUserId(Long userId);
}