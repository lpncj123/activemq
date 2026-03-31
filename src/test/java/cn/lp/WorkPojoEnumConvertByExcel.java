package cn.lp;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Data;

import java.io.File;
import java.util.List;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp
 * @Author: lp
 * @CreateTime: 2026-01-06 17:20
 * @Description: 从 Excel 读取支付渠道数据 → 转换金额限制 & 机构枚举 → 输出 JSON
 * @Version: 1.0
 */
public class WorkPojoEnumConvertByExcel {

    private static final String EXCEL_FILE_PATH = "C:/Users/18012/Desktop/Yearning_Table_Data.xlsx";
    // private static final String EXCEL_FILE_PATH = "C:/data/Yearning_Table_Data.xlsx";  // 如需绝对路径请修改


    public static void main(String[] args) throws Exception {
        // 1. 使用 EasyExcel 读取 Excel
        List<WorkPojo> list = EasyExcel.read(EXCEL_FILE_PATH)
            .head(WorkPojo.class)
            .sheet(0)                   // 读取第一个 sheet（也可以写 sheet("Sheet1")）
            .headRowNumber(1)           // 第一行是表头
            .doReadSync();

        System.out.println("从 Excel 读取到 " + list.size() + " 条记录");

        // 2. 遍历并替换 minAmount / maxAmount（核心逻辑）
        for (WorkPojo item : list) {
            // 清理可能存在的空格
            if (item.getTargetOrg() != null) {
                item.setTargetOrg(item.getTargetOrg().trim());
            }
            if (item.getCurrency() != null) {
                item.setCurrency(item.getCurrency().trim().toUpperCase());
            }

            if ("CARD".equalsIgnoreCase(item.getProductCode())) {
                item.setCountry("*");
            }

            FundingAmountLimit limit = FundingAmountLimit.getByCurrency(item.getCurrency());
            if (limit != null) {
                item.setMinAmount(limit.getMinAmount().toString());
                item.setMaxAmount(limit.getMaxAmount().toString());
            } else {
                System.out.println("警告: 未配置货币 " + item.getCurrency() + " 的金额限制");
            }

            // 可选：把 targetOrg 替换为标准化值（如 qrph → QRPH）
            WalletTypeEnum wallet = WalletTypeEnum.fromOriginalType(item.getTargetOrg());
            if (wallet != null) {
                item.setTargetOrg(wallet.getTargetType());
            }
        }

        // 3. 序列化输出（格式与原 JSON 一致）
        ObjectMapper mapper = new ObjectMapper();
//        mapper.enable(SerializationFeature.INDENT_OUTPUT);  // 美化输出，便于查看

        String result = mapper.writeValueAsString(list);
//        System.out.println("\n转换后的 JSON：");
        System.out.println(result);

        // 如果你想保存到文件（可选）
        // mapper.writeValue(new File("payment_channels_converted.json"), list);
    }

    @Data
    public static class WorkPojo {

        @ExcelProperty("productCode")
        private String productCode;

        @ExcelProperty("targetOrg")
        private String targetOrg;

        @ExcelProperty("country")
        private String country;

        @ExcelProperty("currency")
        private String currency;

        @ExcelProperty("minAmount")
        private String minAmount;   // 读出来是 String，后面会被替换

        @ExcelProperty("maxAmount")
        private String maxAmount;

        @ExcelProperty("expireTime")
        private Integer expireTime;

        // 你原本的 getter（保留）
         @JsonIgnore
         public Integer getExpireTime() {
             return expireTime;
         }
    }
}