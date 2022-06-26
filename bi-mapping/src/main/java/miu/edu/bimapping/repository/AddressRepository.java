package miu.edu.bimapping.repository;

import miu.edu.bimapping.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}
