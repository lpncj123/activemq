package cn.lp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;

/**
 * @author lp
 */
@Document(indexName = "user" , shards = 3, replicas = 1)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEs{

  public UserEs(Integer userId,String userName, String userTelephone, Integer userAge) {
    this.userId = userId;
    this.userName = userName;
    this.userTelephone = userTelephone;
    this.userAge = userAge;
  }


  @Id
  private Integer id;
  @Field(type = FieldType.Keyword)
  private Integer userId;
  @Field(type = FieldType.Text, analyzer = "ik_max_word")
  private String userName;
  @Field(type = FieldType.Keyword)
  private String userTelephone;
  @Field(type = FieldType.Keyword)
  private Integer userAge;

}
