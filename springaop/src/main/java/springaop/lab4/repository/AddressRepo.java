package springaop.lab4.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springaop.lab4.domain.Address;

@Repository
public interface AddressRepo extends CrudRepository<Address, Long> {
}
