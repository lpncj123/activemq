package cn.lp;

import cn.lp.mapper.UserMapper;
import cn.lp.model.User;
import cn.lp.repository.UserRepository;
import com.alibaba.fastjson.JSON;
import com.mongodb.client.result.DeleteResult;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.bson.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.schema.JsonSchemaObject;

import java.util.List;
import java.util.Map;

public class MongDBTest extends TestJunit {
  @Autowired
  private MongoTemplate mongoTemplate;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private UserRepository userRepository;

  @Test
  public void save() {
    List<User> users = userMapper.selectAll();
    List<User> save = (List<User>) mongoTemplate.insert(users, User.class);
    System.out.println(save);
  }

  @Test
  public void selectOne() {
    //查询全部
//    List<User> all = mongoTemplate.findAll(User.class);
//    System.out.println(all);

    //条件查询
    Query query = new Query();
    query.addCriteria(Criteria.where("userAge").type(JsonSchemaObject.Type.NUMBER).gte(0).lte(100));
    //排序
    query.with(Sort.by(new Sort.Order(Sort.Direction.ASC, "userAge"), new Sort.Order(Sort.Direction.DESC, "userId")));
//    query.limit(1);
//    List<User> userList = mongoTemplate.find(query, User.class, "user");
//    System.out.println(userList);

    //查询单条
//    User user = mongoTemplate.findOne(query, User.class);
//    System.out.println(user);
    Pageable pageableObj = PageRequest.of(1,2 );
    Page<User> all = userRepository.findAll(pageableObj);
    System.out.println(JSON.toJSON(all).toString());
  }
  @Test
  public void removeUser(){
    Query query = new Query();
    query.addCriteria(Criteria.where("userId").is(24));
    DeleteResult result = mongoTemplate.remove(query, User.class);
    System.out.println(result);
  }
  @Test
  public void update(){
    User user = new User(119,"牛牛","15123113211",88);
    Query query = new Query(Criteria.where("userId").is(user.getUserId()));
    Update update = new Update().set("userName",user.getUserName()).set("userAge",user.getUserAge());
    mongoTemplate.upsert(query,update,User.class);
  }

  /**
   * 分组查询   first必须和聚合查询一起使用
   */
  @Test
  public void aggregation(){
    //分组查询
    TypedAggregation<User> typedAggregation = Aggregation.newAggregation(User.class, Aggregation.group("userTelephone").count().as("count").sum("userAge").as("userAgeSum").first("userAge").as("userAgeFirst").addToSet("userAge").as("agess").max("userAge").as("maxAge"));
    AggregationResults<Document> aggregate = mongoTemplate.aggregate(typedAggregation, Document.class);
//    aggregate.forEach(e-> System.out.println(e));


    Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("userAge").gt(50)),
        Aggregation.group("userTelephone").count().as("count").sum("userAge").as("userAgeSum").first("userAge").as("userAgeFirst").addToSet("userAge").as("agess").max("userAge").as("maxAge"),
        Aggregation.sort(Sort.Direction.DESC,"maxAge")
    );
    AggregationResults<Map> users = mongoTemplate.aggregate(aggregation, User.class, Map.class);
    users.forEach(e-> System.out.println(e));


  }

  /**
   * 联表查询
   */
  @Test
  public void lookupOperation(){
    LookupOperation lookupOperation = LookupOperation.newLookup().from("practice").localField("userId").foreignField("age").as("test");
    Aggregation aggregation = Aggregation.newAggregation(lookupOperation,Aggregation.match(Criteria.where("userAge").lt(20)));
    AggregationResults<Map> results = mongoTemplate.aggregate(aggregation, "user", Map.class);
    System.out.println(results.getMappedResults());
  }

}
