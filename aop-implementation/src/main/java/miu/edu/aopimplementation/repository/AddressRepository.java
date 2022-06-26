package miu.edu.aopimplementation.repository;

import miu.edu.aopimplementation.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}
