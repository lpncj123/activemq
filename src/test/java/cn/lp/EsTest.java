package cn.lp;

import cn.lp.model.UserEs;
import cn.lp.repository.UserRepositoryEs;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class EsTest extends TestJunit {
  public EsTest() {
    //在构造函数上写上这个
    System.setProperty("es.set.netty.runtime.available.processors", "false");
  }

  @Autowired
  private RestHighLevelClient client;
  @Autowired
  private UserRepositoryEs userRepositoryEs;
  @Autowired
  private ElasticsearchRestTemplate elasticsearchRestTemplate;

  /**
   * 创建索引，给实体类加上注解自动创建
   */
  @Test
  public void createIndex() {
    System.out.println("创建索引");
  }

  /**
   * 删除索引的两种方式
   *
   * @throws IOException
   */
  @Test
  public void deleteIndex() throws IOException {
    /**
     * 第一种
     */
//    IndicesClient indicesClient = client.indices();
//    DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("shopping");
//    AcknowledgedResponse response = indicesClient.delete(deleteIndexRequest, RequestOptions.DEFAULT);
//    boolean acknowledged = response.isAcknowledged();
//    System.out.println("删除是否成功？"+acknowledged);
    /**
     * 第二种
     */
    boolean user = elasticsearchRestTemplate.deleteIndex("user");
    System.out.println(user);
  }

  /**
   * 批量新增
   */
  @Test
  //帮我优化下这个方法
  public void saveAll() {
    List<UserEs> list = new ArrayList<>();
    list.add(new UserEs(8, 1, "李四", "15022222222", 12));
    list.add(new UserEs(9, 2, "李八", "15022222123", 9870));
    list.add(new UserEs(10, 2, "李五", "15022222221", 213212));
    list.add(new UserEs(11, 23, "李五", "15048293147", 234234));
    list.add(new UserEs(12, 33, "李五", "15048291111", 23423411));
    list.add(new UserEs(13, 2, "李九", "15022227890", 797856));
    list.add(new UserEs(14, 3, "赵六", "15022222321", 4543));
    try {
      userRepositoryEs.saveAll(list);
      System.out.println();
    } catch (Exception exception) {
      if (!(exception.getMessage()).contains("OK")) {
        System.out.println("nonononon");
        throw exception;
      }
      System.out.println("200 ok");
    }
  }

  /**
   * 没有查到id新增，有id修改
   */
  @Test
  public void save() {
    try {
      userRepositoryEs.save(new UserEs(23, "李五", "15048293147", 234234));
      System.out.println();
    } catch (Exception exception) {
      if (!(exception.getMessage()).contains("Created")) {
        System.out.println("nonononon");
        throw exception;
      }
      System.out.println("200 ok");
    }

  }

  /**
   * 根据id删除
   */
  @Test
  public void delete() {
    UserEs userEs = new UserEs();
    userEs.setId(4);
    try {
      userRepositoryEs.delete(userEs);
    } catch (Exception exception) {
      System.out.println(exception.getMessage());
      if (!(exception.getMessage()).contains("OK")) {
        System.out.println("nonononon");
        throw exception;
      }
      System.out.println("200 ok");
    }
  }

  @Test
  public void update() {
    try {
      userRepositoryEs.save(new UserEs(1, 2, "李四大", "22222222222", 99));
    } catch (Exception exception) {
      System.out.println(exception.getMessage());
      if (!(exception.getMessage()).contains("OK")) {
        System.out.println("nonononon");
        throw exception;
      }
      System.out.println("200 ok");
    }
  }

  //分页查询
  @Test
  public void findPage() {
    Sort sort = Sort.by(Sort.Direction.DESC, "id");
    PageRequest pageRequest = PageRequest.of(0, 2, sort);
    Page<UserEs> userEsPage = userRepositoryEs.findAll(pageRequest);
    System.out.println(JSON.toJSON(userEsPage).toString());
    userEsPage.getContent().forEach(System.out::println);
  }

  /**
   * 条件查询
   */
  @Test
  public void termQuery() {
    PageRequest pageRequest = PageRequest.of(0, 5);
    Page<UserEs> userEsPage = userRepositoryEs.findByUserNameOrderByUserAgeAsc("李五", pageRequest);
    System.out.println(JSON.toJSONString(userEsPage));
  }

  /**
   * 查询
   */
  @Test
  public void searchSource() throws IOException {
    SearchSourceBuilder builder = new SearchSourceBuilder().query(
        QueryBuilders.termsQuery("userName", "六")
    );
    SearchRequest searchRequest = new SearchRequest();
    searchRequest.indices("user");
    searchRequest.source(builder);
    SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
    List<SearchHit> collect = Arrays.stream(searchResponse.getHits().getHits()).collect(Collectors.toList());
    collect.forEach(e -> {
      log.info("处理结果-->{}", e.getSourceAsMap());
    });

    log.info("结果-->{}", searchResponse);
  }

  @Test
  public void sum() throws IOException {
    TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("group_userTelephone").field("userTelephone");
    SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().sort("userAge", SortOrder.DESC);
    BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder().filter(QueryBuilders.rangeQuery("userAge").gte(10000));
    searchSourceBuilder.aggregation(termsAggregationBuilder);
    searchSourceBuilder.query(boolQueryBuilder);
    SearchRequest searchRequest = new SearchRequest("user");
    searchRequest.source(searchSourceBuilder);
    SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
    log.info("查询出结果-->{}", response);
    Aggregations aggregations = response.getAggregations();
    if (aggregations != null) {
      Terms terms = aggregations.get("group_userTelephone");
      //解析桶
      for (Terms.Bucket bucket : terms.getBuckets()) {
        log.info("key-->{},value-->{}",bucket.getKeyAsString(),bucket.getDocCount());
      }
    }
  }

}
