package java.com.xzw;

import com.xzw.payment.config.Result;
import com.xzw.payment.controller.BalanceLogController;
import com.xzw.payment.vo.PageVo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class ApplicationTests {
    @Resource
    BalanceLogController balanceLogController;
    @Test
    public void test(){
    }
}
