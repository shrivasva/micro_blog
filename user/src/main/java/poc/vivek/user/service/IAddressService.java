package poc.vivek.user.service;

import poc.vivek.user.bean.Address;

public interface IAddressService {
    Address findByUserId(Long id);

    void save(Address address);
}
