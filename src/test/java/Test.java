/**
 * @Auther: HuangRui
 * @Date: 2021/3/6 18:22
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        String[] arr1 = new String[]{"进港","离港"};
        String[] arr2 = new String[]{"航司","航班","航站楼"};
        String[] arr3 = new String[]{"出发地","到达地"};
        String[] arr4 = new String[]{"正常","挂失","丢失","破损"};

        String[][] array2= new String[][]{arr1,arr2,arr3,arr4};
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2.length;j++){
                for(int k=0;k<arr3.length;k++){
                    for(int m=0;m<arr4.length;m++) {
                        if((i==0&&k==3)||(i==1&&k==0)){
                            continue;
                        }
                        System.out.println(arr1[i] + "+" + arr2[j] + "+" + arr3[k] + "+" + arr4[m] + "行李量统计报表");
                    }
                }
            }
        }
    }
}
