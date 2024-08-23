package cn.lp.easyexcelexamle;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: interviewexamples
 * @BelongsPackage: cn.lp.easyexecel
 * @Author: lp
 * @CreateTime: 2024-07-24  16:25
 * @Description: TODO 生成百万条数据Excel
 * @Version: 1.0
 */
public class EasyExcelExample {
    public static void main(String[] args) {
        String fileName = "million_data.xlsx";

        // 使用EasyExcel生成Excel文件
        ExcelWriterBuilder writerBuilder = EasyExcel.write(fileName, DemoData.class);
        ExcelWriter excelWriter = writerBuilder.build();
        WriteSheet writeSheet = EasyExcel.writerSheet("Sheet1").build();

        List<DemoData> dataList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            DemoData data = new DemoData();
            data.setName("Name " + i);
            data.setAge(i);
            dataList.add(data);

            // 每当数据列表达到一定大小时，写入数据并清空列表以节省内存
            if (dataList.size() >= 10000) {
                excelWriter.write(dataList, writeSheet);
                dataList.clear();
            }
        }

        // 写入剩余的数据
        if (!dataList.isEmpty()) {
            excelWriter.write(dataList, writeSheet);
        }

        // 关闭excelWriter
        excelWriter.finish();

        System.out.println("Excel file generated successfully!");
    }
}
