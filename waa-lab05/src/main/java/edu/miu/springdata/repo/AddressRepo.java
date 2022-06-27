package edu.miu.springdata.repo;

import edu.miu.springdata.entity.Address;
import edu.miu.springdata.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepo extends CrudRepository<Address,Integer> {
    List<Address> findAll();
    Address findById(int id);
    void deleteById(int id);
    default public void create(Address a){

    };
}
