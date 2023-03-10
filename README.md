# 工程简介
* 接收request，响应response；
* 做业务逻辑处理，像校验参数，状态流转，业务计算等等；
* 和外部系统有联动，像数据库，微服务，搜索引擎等；
* DDD（领域驱动设计）模式
# 延伸阅读
- 在Controller层接收网络请求数据后，由于Controller层并不需要处理额外的逻辑，所以大部分情况下直接将DTO对象传送给Service层；
- 而Service层如果逻辑不复杂只是需要根据DTO的数据进行数据库操作，那么此时根据需要将DTO转换为PO进行操作，完成后由于大部分场景下Service的输出参数与输入DTO对象都存在差异，
    - 因此为了区分我们将Service层的输出数据对象统一定义为BO。
- 而Service层拆分时对于Manager层方法的输入/输出对象则统一为BO，
    - 包括Manager层操作第三方数据接口的数据对象转换也统一为BO。以上划分并没有什么特别的强制约定，而过分人为的去揣摩其含义本质上也没什么意义，只是大家共同遵守一个约定，这样代码风格看起来会更加统一一点。
##命名约束
|  操作   | 方法名约定 |
|  ----  | ----  |
| 新增  | create|
| 添加  | add |
| 删除	  | remove.delete |
| 修改	  | update |
| 查询（返回单个结果）		  | get |
| 查询（返回多个结果）			  | list |
| 分页查询			  | page |
| 统计			  | count |
