package cn.lp.repository;

import cn.lp.model.User;
import cn.lp.model.UserEs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lp
 */
@Repository
public interface UserRepositoryEs extends ElasticsearchRepository<UserEs,Integer> {
  Page<UserEs> findByUserNameOrderByUserAgeAsc(String userName, PageRequest pageable);
}
