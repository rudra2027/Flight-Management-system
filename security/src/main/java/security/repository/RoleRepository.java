package security.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import security.pojo.ERole;
import security.pojo.Role;

public interface RoleRepository extends MongoRepository<Role, String>{
	Optional<Role> findByName(ERole name);

}
