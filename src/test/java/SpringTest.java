import com.mapper.BaggageMapper;
import com.mapper.BaggageTaskMapper;
import com.service.ScheduleTaskService;
import com.service.impl.ScheduleTaskServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDate;

/**
 * @Auther: HuangRui
 * @Date: 2021/4/1 17:27
 * @Description:
 */
@RunWith(SpringRunner.class)
@MapperScan({"com.mapper"})
@SpringBootTest(classes = {ScheduleTaskServiceImpl.class, BaggageMapper.class, BaggageTaskMapper.class})
public class SpringTest {

    @Autowired
    private ScheduleTaskServiceImpl scheduleTaskService;

    @Test
    public void  test(){
        LocalDate beginDate = LocalDate.of(2018, 1, 1);
        LocalDate endDate = LocalDate.of(2021,4,1);
        scheduleTaskService.init(beginDate,endDate);
    }
}
