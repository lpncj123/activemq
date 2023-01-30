package cn.lp;

import cn.lp.ext.TestExtPt;
import com.alibaba.cola.extension.BizScenario;
import com.alibaba.cola.extension.ExtensionExecutor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class TestExtension extends TestJunit{

    @Autowired
    private ExtensionExecutor extensionExecutor;
    @Test
    public void testExt(){

        BizScenario bizScenario = BizScenario.valueOf("test", "sout", "A");
//        extensionExecutor.execute(TestExtPt.class, bizScenario, extensionExecutor.);
        extensionExecutor.executeVoid(TestExtPt.class, bizScenario, ex->ex.testExten("dsadjsald"));
    }
}
