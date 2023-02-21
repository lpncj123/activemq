package cn.lp.ext.impl;

import cn.lp.ext.TestExtPt;
import com.alibaba.cola.extension.Extension;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Extension(bizId = "test" ,useCase = "sout",scenario = "B")
public class TextPtExtSoutBImpl implements TestExtPt {
    @Override
    public void testExten(String s) {
        log.info("B执行成功：{}",s);
    }
}
