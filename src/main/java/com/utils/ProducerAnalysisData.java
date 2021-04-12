package com.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProducerAnalysisData {

    static List<String> flightNos = new ArrayList<String>();
    static List<String> bNo = new ArrayList<String>();

    static Integer bNumber = 100;
    static Integer pNumber = 12;

    /**
     * bpm bsm flight
     *
     * @param args
     */
    public static void main(String[] args) {
        Integer number = 100;
        producerFlight(number);
//        每个航班有100件行李
        producerBSM(number * bNumber);
        produceBPM(number * bNumber * pNumber);
//        getDateString();
//        System.out.println(getTimeString());
    }

    private static void writeFile(String name,String content) throws IOException {
//        String path = "/home/spfthree/IdeaProjects/trafficmonitor/flinkmonitor/src/main/scala/com/spf/cityTraffic/practice/data/"+name;
        String path = "D:/aaa/"+name;
//        FileOutputStream outputStream = new FileOutputStream(new File(path));
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(content);
        writer.close();

    }




    private static String getDateString() {
        return format.format(randomDate("2020-06-01", "2020-06-30"));
    }

    static String[] characters = {"a", "b", "c", "d", "e", "f", "g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
            "A", "B", "C", "D", "E", "F", "G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

    //    id, flightNo, flightDate, schDepApt, schArrApt, coSe,
    private static void producerFlight(int number) {
        StringBuilder res = new StringBuilder();
        Random random = new Random();

        LinkedList<String[]> data = new LinkedList<>();

        int[] nums = {4, 3, 5, 4, 3, 2};

        for (int i = 0; i < number; i++) {
            String[] line = new String[6];
            for (int j = 0; j < 6; j++) {
                if (j == 2) {
                    line[2] = getDateString();
                } else {
                    StringBuilder sb = new StringBuilder();
                    addNumber(nums[j], random, sb);
                    addChars(nums[j], random, sb);
                    line[j] = sb.toString();
                }

                if (j == 1) {
                    flightNos.add(line[j]);
                }

                if(j!=0)
                    res.append(",");

                res.append(line[j]);

//                System.out.print(line[j] + ",");
            }
            res.append("\n");
//            System.out.println();
            data.add(line);
        }

        try {
            writeFile("flightFile",res.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void addChars(Integer num, Random random, StringBuilder sb) {
        for (int i = 0; i < num; i++) {
            int index = random.nextInt(52);
            sb.append(characters[index]);
        }
    }

    private static void addNumber(Integer num, Random random, StringBuilder sb) {
        for (int i = 0; i < num; i++) {
            sb.append(random.nextInt(100));
        }
    }

    //    id ,baggageNo ,passenger ,flightNo ,flightDate ,weight
    private static void producerBSM(Integer number) {
        Random random = new Random();
        StringBuffer res = new StringBuffer();

        LinkedList<String[]> data = new LinkedList<>();

        int[] nums = {4, 3, 5, 4, 3, 2};

        for (int i = 0; i < number; i++) {
            String[] line = new String[6];
            for (int j = 0; j < 6; j++) {
                if (j == 4) {
                    line[j] = getDateString();
                } else if (j == 3) {
                    line[j] = flightNos.get(random.nextInt(number / bNumber));
                } else if(j == 5){
                    line[j] = random.nextDouble()+"";
                }else {
                    StringBuilder sb = new StringBuilder();
                    addNumber(nums[j], random, sb);
                    addChars(nums[j], random, sb);
                    line[j] = sb.toString();
                }

                if (j == 1) {
                    bNo.add(line[j]);
                }

//                System.out.print(line[j] + ",");
                if(j!=0) res.append(",");
                res.append(line[j]);
            }
//            System.out.println();
            res.append("\n");
            data.add(line);
        }

        try {
            writeFile("bsmFile",res.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //    id ,baggageNo ,createTime ,flightNo ,flightDate ,operatorTime ,nodeName ,optDeviceId
    private static void produceBPM(Integer number) {
        StringBuffer res = new StringBuffer();
        Random random = new Random();
        LinkedList<String[]> data = new LinkedList<>();
        int[] nums = {4, 3, 5, 4, 3, 2, 6, 8};

        for (int i = 0; i < number; i++) {
            String[] line = new String[8];
            for (int j = 0; j < 8; j++) {
                if (j == 2) {
                    line[j] = getDateString() + " "+getTimeString();
                } else if (j == 1) {
                    line[j] = bNo.get(random.nextInt(number / pNumber));
                } else if (j == 3) {
                    line[j] = flightNos.get(random.nextInt(number / pNumber / bNumber));
                } else if (j == 4) {
                    line[j] = getDateString();
                } else if (j == 5) {
                    line[j] =  random.nextDouble()+"";
                } else {
                    StringBuilder sb = new StringBuilder();
                    addNumber(nums[j], random, sb);
                    addChars(nums[j], random, sb);
                    line[j] = sb.toString();
                }


//                System.out.print(line[j] + ",");
                if(j!=0) res.append(",");
                res.append(line[j]);
            }
//            System.out.println();

            res.append("\n");
            data.add(line);
        }
        try {
            writeFile("bpmFile",res.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String getTimeString() {
        Random random = new Random();
        return String.format("%02d:%02d:%02d", random.nextInt(24), random.nextInt(24), random.nextInt(60));
    }

    static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    private static Date randomDate(String beginDate, String endDate) {


        try {


            Date start = format.parse(beginDate);//构造开始日期

            Date end = format.parse(endDate);//构造结束日期

//getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。

            if (start.getTime() >= end.getTime()) {

                return null;

            }

            long date = random(start.getTime(), end.getTime());

            return new Date(date);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }

    private static long random(long begin, long end) {

        long rtn = begin + (long) (Math.random() * (end - begin));

//如果返回的是开始时间和结束时间，则递归调用本函数查找随机值

        if (rtn == begin || rtn == end) {

            return random(begin, end);

        }

        return rtn;

    }
}