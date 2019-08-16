package com.codurance.countries.infrastructure;

import com.codurance.countries.domain.MyUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<MyUser, Long> {
    MyUser findByUsernameAndPassword(String username, String password);
}
