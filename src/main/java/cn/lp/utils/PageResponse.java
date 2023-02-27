package cn.lp.utils;

import com.alibaba.cola.dto.MultiResponse;
import lombok.Data;

@Data
public class PageResponse<T> extends MultiResponse {
    private Integer current;
    private Long totalPage;
    private Integer totalSize;
    private Long pageSize;
    private Boolean hasNext;
}
