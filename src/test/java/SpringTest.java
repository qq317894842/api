import com.ApiServerApplication;
import com.mapper.BaggageMapper;
import com.mapper.BaggageTaskMapper;
import com.mapper.JimuReportMapper;
import com.service.ScheduleTaskService;
import com.service.impl.ScheduleTaskServiceImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDate;

/**
 * @Auther: HuangRui
 * @Date: 2021/4/1 17:27
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ApiServerApplication.class})
public class SpringTest {


    @Autowired
    private ScheduleTaskServiceImpl scheduleTaskService;

    @Test
    public void  test(){
        LocalDate beginDate = LocalDate.of(2019, 5, 1);
        LocalDate endDate = LocalDate.of(2021,4,1);
//        LocalDate beginDate = LocalDate.of(2019, 5, 5);

        scheduleTaskService.init(beginDate,endDate);
    }
}
