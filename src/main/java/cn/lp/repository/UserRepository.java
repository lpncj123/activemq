package cn.lp.repository;

import cn.lp.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,Integer>{
  @Override
  Page<User> findAll(Pageable pageable);

  @Override
  <S extends User> Optional<S> findOne(Example<S> example);
}
