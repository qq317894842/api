public class Test {
    static String[] arr1 = new String[]{"进港", "离港"};
    static String[] arr2 = new String[]{"航司", "航班", "航站楼"};
    static String[] arr3 = new String[]{"出发地", "到达地"};
    static String[] arr4 = new String[]{"正常", "挂包", "丢失", "破损"};
    static String[] arr5 = new String[]{"托运","安检","分拣","早到存储","装箱/车","登机","卸载","分拣","抵达","中转"};

    static String[][] arrayList = new String[][]{arr1, arr2, arr3, arr4};
    public static void printC43(int a,int b,int c){
        //c43 = 1,2,3   1,2,4   1,3,4   2,3,4
        String[] c1 = arrayList[a-1];
        String[] c2 = arrayList[b-1];
        String[] c3 = arrayList[c-1];
        for(int i=0;i<c1.length;i++){
            for(int j=0;j<c2.length;j++){
                for(int k=0;k<c3.length;k++){
                        String str = c1[i] + "+" + c2[j] + "+" + c3[k] + "行李量统计报表";
                        if ((str.contains("进港") && str.contains("到达地")) || (str.contains("离港") && str.contains("出发地"))) {
                            continue;
                        }
                        System.out.println(str);
                }
            }
        }



    }

    public static void main(String[] args) {



        System.out.println("******************************************* 四维度组合 *****************************************************");
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2.length;j++){
                for(int k=0;k<arr3.length;k++){
                    for(int m=0;m<arr4.length;m++) {
                        String str = arr1[i] + "+" + arr2[j] + "+" + arr3[k] + "+" + arr4[m] + "行李量统计报表";
                        if ((str.contains("进港") && str.contains("到达地")) || (str.contains("离港") && str.contains("出发地"))) {
                            continue;
                        }
                        System.out.println(str);
                    }
                }
            }
        }
        System.out.println("******************************************* 三维度组合 *****************************************************");
        printC43(1,2,3);
        printC43(1,2,4);
        printC43(1,3,4);
        printC43(2,3,4);
        System.out.println("******************************************* 两维度组合 *****************************************************");
        for (int i = 0; i < arrayList.length - 1; i++) {
            String[] c1 = arrayList[i];
            for (int j = i + 1; j < arrayList.length; j++) {
                String[] c2 = arrayList[j];
                for (int m = 0; m < c1.length; m++) {
                    for (int n = 0; n < c2.length; n++) {
                        String str = c1[m] + "+" + c2[n] + "行李量统计报表";
                        if ((str.contains("进港") && str.contains("到达地")) || (str.contains("离港") && str.contains("出发地"))) {
                            continue;
                        }
                        System.out.println(str);
                    }
                }
            }
        }
    }
}