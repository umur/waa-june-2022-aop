package springaop.lab4.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springaop.lab4.domain.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
}
