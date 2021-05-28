import com.ApiServerApplication;
import com.constant.CountTableType;
import com.mapper.BaggageTaskMapper;
import com.service.impl.ScheduleTaskServiceImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.time.LocalDate;

/**
 * @Auther: HuangRui
 * @Date: 2021/4/1 17:27
 * @Description:
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ApiServerApplication.class})
public class SpringTest {

    @Autowired
    private ScheduleTaskServiceImpl scheduleTaskService;

    @Resource
    private BaggageTaskMapper taskMapper;

    @Test
    public void test() {
        LocalDate beginDate = LocalDate.of(2019, 5, 1);
        LocalDate endDate = LocalDate.of(2021, 4, 16);
//        LocalDate beginDate = LocalDate.of(2019, 5, 5);

        scheduleTaskService.init(beginDate, endDate);
    }

    //机场角度 source_airport
//进港 离港 / 航站楼 / 国际 国内  airline.type
//行李分类(超重，超规..)
//异常行李
//
//航司角度
//进港 离港 / 国际 国内
//行李分类(超重，超规..)
//异常行李
    @Test
    public void testCreateTable() {
//        CountTableType[] enums = new CountTableType[]
//                {CountTableType.AIRPORT_OUTIN, CountTableType.AIRPORT_TERMINAL, CountTableType.AIRPORT_AIRELINETYPE, CountTableType.AIRPORT_BAGTYPE, CountTableType.AIRPORT_ERRBAG,
//                        CountTableType.COMPANY_OUTIN, CountTableType.COMPANY_AIRELINETYPE, CountTableType.COMPANY_BAGTYPE, CountTableType.COMPANY_ERRBAG};
        CountTableType[] enums = new CountTableType[]
                {CountTableType.AIRPORT_OUT, CountTableType.AIRPORT_IN,
                        CountTableType.COMPANY_OUT, CountTableType.COMPANY_IN};
        for (int i = 0; i < enums.length; i++) {
            CountTableType table = enums[i];
            taskMapper.createNewTable(table.code(), table.value());
        }
    }
}
