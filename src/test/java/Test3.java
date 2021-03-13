import com.entity.dto.BaggageLineData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: HuangRui
 * @Date: 2021/3/13 15:46
 * @Description:
 */
public class Test3 {
    public static void main(String[] args) {
        String[] times = new String[]{"周一","周二","周三","周四","周五"};
        List<BaggageLineData> data = new ArrayList<>();
        data.add(
                BaggageLineData.builder().time("周一").type("CA").count(10).build()
        );
        data.add(
                BaggageLineData.builder().time("周五").type("CA").count(20).build()
        );
        data.add(
                BaggageLineData.builder().time("周三").type("CU").count(20).build()
        );


        Map<String, int[]> result = validate(times, data);
        System.out.println(result);



    }

    private static Map<String, int[]> validate(String[] times, List<BaggageLineData> data) {
        Map<String,int[]> result = new HashMap<>();
        for(int i=0;i<data.size();i++){
            BaggageLineData baggage = data.get(i);
            if(result.get(baggage.getType())==null){
                result.put(baggage.getType(),new int[times.length]);
            }
            for(int j=0;j<times.length;j++){
                if(times[j].equals(baggage.getTime())){
                    result.get(baggage.getType())[j]=baggage.getCount();
                }
            }
        }
        return  result;
    }
}
