package cn.lp.dto;

import lombok.Data;

import java.util.Map;

@Data
public class ThreeElements {
    private Map<String,String> result;
    private String reason;
    private String errorCode;
}
