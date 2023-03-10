package cn.lp;

import cn.lp.model.UserEs;
import cn.lp.repository.UserRepositoryEs;
import com.alibaba.fastjson.JSON;
import com.sun.media.jfxmedia.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedDoubleTerms;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.ParsedSum;
import org.elasticsearch.search.aggregations.metrics.SumAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class EsTest extends TestJunit {
  public EsTest() {
    //??????????????????????????????
    System.setProperty("es.set.netty.runtime.available.processors", "false");
  }

  @Autowired
  private RestHighLevelClient client;
  @Autowired
  private UserRepositoryEs userRepositoryEs;
  @Autowired
  private ElasticsearchRestTemplate elasticsearchRestTemplate;

  /**
   * ???????????????????????????????????????????????????
   */
  @Test
  public void createIndex() {
    System.out.println("????????????");
  }

  /**
   * ???????????????????????????
   *
   * @throws IOException
   */
  @Test
  public void deleteIndex() throws IOException {
    /**
     * ?????????
     */
//    IndicesClient indicesClient = client.indices();
//    DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("shopping");
//    AcknowledgedResponse response = indicesClient.delete(deleteIndexRequest, RequestOptions.DEFAULT);
//    boolean acknowledged = response.isAcknowledged();
//    System.out.println("?????????????????????"+acknowledged);
    /**
     * ?????????
     */
    boolean user = elasticsearchRestTemplate.deleteIndex("user");
    System.out.println(user);
  }

  /**
   * ????????????
   */
  @Test
  public void saveAll() {
    List<UserEs> list = new ArrayList<>();
    list.add(new UserEs(8, 1, "??????", "15022222222", 12));
    list.add(new UserEs(9, 2, "??????", "15022222123", 9870));
    list.add(new UserEs(10, 2, "??????", "15022222221", 213212));
    list.add(new UserEs(11, 23, "??????", "15048293147", 234234));
    list.add(new UserEs(12, 33, "??????", "15048291111", 23423411));
    list.add(new UserEs(13, 2, "??????", "15022227890", 797856));
    list.add(new UserEs(14, 3, "??????", "15022222321", 4543));
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
   * ????????????id????????????id??????
   */
  @Test
  public void save() {
    try {
      userRepositoryEs.save(new UserEs(23, "??????", "15048293147", 234234));
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
   * ??????id??????
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
      userRepositoryEs.save(new UserEs(1, 2, "?????????", "22222222222", 99));
    } catch (Exception exception) {
      System.out.println(exception.getMessage());
      if (!(exception.getMessage()).contains("OK")) {
        System.out.println("nonononon");
        throw exception;
      }
      System.out.println("200 ok");
    }
  }

  //????????????
  @Test
  public void findPage() {
    Sort sort = Sort.by(Sort.Direction.DESC, "id");
    PageRequest pageRequest = PageRequest.of(0, 2, sort);
    Page<UserEs> userEsPage = userRepositoryEs.findAll(pageRequest);
    System.out.println(JSON.toJSON(userEsPage).toString());
    userEsPage.getContent().forEach(System.out::println);
  }

  /**
   * ????????????
   */
  @Test
  public void termQuery() {
    PageRequest pageRequest = PageRequest.of(0, 5);
    Page<UserEs> userEsPage = userRepositoryEs.findByUserNameOrderByUserAgeAsc("??????", pageRequest);
    System.out.println(JSON.toJSONString(userEsPage));
  }

  /**
   * ??????
   */
  @Test
  public void searchSource() throws IOException {
    SearchSourceBuilder builder = new SearchSourceBuilder().query(
        QueryBuilders.termsQuery("userName", "???")
    );
    SearchRequest searchRequest = new SearchRequest();
    searchRequest.indices("user");
    searchRequest.source(builder);
    SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
    List<SearchHit> collect = Arrays.stream(searchResponse.getHits().getHits()).collect(Collectors.toList());
    collect.forEach(e -> {
      log.info("????????????-->{}", e.getSourceAsMap());
    });

    log.info("??????-->{}", searchResponse);
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
    log.info("???????????????-->{}", response);
    Aggregations aggregations = response.getAggregations();
    if (aggregations != null) {
      Terms terms = aggregations.get("group_userTelephone");
      //?????????
      for (Terms.Bucket bucket : terms.getBuckets()) {
        log.info("key-->{},value-->{}",bucket.getKeyAsString(),bucket.getDocCount());
      }
    }
  }

}
