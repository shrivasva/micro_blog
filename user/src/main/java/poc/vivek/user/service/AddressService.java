package poc.vivek.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poc.vivek.user.bean.Address;
import poc.vivek.user.repo.AddressRepository;

@Service
public class AddressService implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address findByUserId(Long id) {
        return addressRepository.findByUserId(id);
    }

    @Override
    public void save(Address address) {
        addressRepository.save(address);
    }
}
