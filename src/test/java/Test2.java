import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: HuangRui
 * @Date: 2021/3/8 11:09
 * @Description:
 */
public class Test2 {
    static String[] arr1 = new String[]{"进港", "离港"};
    static String[] arr2 = new String[]{"航司", "航班", "航站楼"};
    static String[] arr3 = new String[]{"出发地", "到达地"};
    static String[] arr4 = new String[]{"正常", "挂包", "丢失", "破损"};
    static String[] arr5 = new String[]{"托运","安检","分拣","早到存储","装箱/车","登机","卸载","分拣","抵达","中转"};

    static String[][] arrayList = new String[][]{arr1, arr2, arr3, arr4,arr5};

    public static Stack<Integer> stack = new Stack<Integer>();
    public static void main(String[] args) {
        int shu[] = {1,2,3,4,5};

        c(shu,2,0,0); // 从这个数组5个数中选择2个
//        c(shu,3,0,0); // 从这个数组5个数中选择3个
//        c(shu,4,0,0); // 从这个数组5个数中选择4个
//        c(shu,5,0,0); // 从这个数组5个数中选择5个
    }

    /**
     *
     * @param shu  元素
     * @param targ  要选多少个元素
     * @param has   当前有多少个元素
     * @param cur   当前选到的下标
     *
     * 1    2   3     //开始下标到2
     * 1    2   4     //然后从3开始
     */
    private static void c(int[] shu, int targ, int has, int cur) {
        if(has == targ) {
            System.out.println(stack);
            Stack<Integer> clone = (Stack<Integer>) stack.clone();
            printGroup(clone,"行李量报表",0);
            return;
        }

        for(int i=cur;i<shu.length;i++) {
            if(!stack.contains(shu[i])) {
                stack.add(shu[i]);
                c(shu, targ, has+1, i);
                stack.pop();
            }
        }

    }

    public static String printGroup(Stack<Integer> integers,String str,int cur){
        for(int i=cur;i<integers.size();i++){
            String[] strings = arrayList[integers.get(i)-1];

            for(int j=0;j<strings.length;j++){
                if(i<integers.size()-1){
                    return printGroup(integers, strings[j] + str, i + 1);
                }
                System.out.println(str);
            }
            integers.remove(i);
        }
        return null;








//        while (!integers.empty()){
//            String[] arr = arrayList[integers.pop()-1];
//            for(int i=0;i<arr.length;i++){
//                if(integers.isEmpty()){
//                    System.out.println(arr[i]+"+"+str);
//                    continue;
//                }
//                printGroup(integers,arr[i]+"+"+str);
//
//            }
//        }

    }
}
