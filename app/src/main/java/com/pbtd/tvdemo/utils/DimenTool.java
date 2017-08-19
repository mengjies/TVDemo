package com.pbtd.tvdemo.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by cdy on 2016/2/3.
 * 快速生成适配工具类
 */
public class DimenTool {

    public static void main(String[] args) {
        gen();
    }

    public static void gen() {
        //以此文件夹下的dimens.xml文件内容为初始值参照(360dp)
        File file = new File("./app/src/main/res/values/dimens.xml");

        BufferedReader reader = null;
        StringBuilder sw240 = new StringBuilder();//0.667
        StringBuilder sw320 = new StringBuilder();//0.889
        StringBuilder sw360 = new StringBuilder();//1.0

        StringBuilder sw480 = new StringBuilder();//1.333
        StringBuilder sw600 = new StringBuilder();//1.667
        StringBuilder sw720 = new StringBuilder();//2.0
        StringBuilder sw800 = new StringBuilder();//2.222

        StringBuilder sw1440 = new StringBuilder();//4.0
        StringBuilder sw1920 = new StringBuilder();//5.333
        StringBuilder sw2400 = new StringBuilder();//6.667
        StringBuilder sw2880 = new StringBuilder();//8.0

        StringBuilder sw2160 = new StringBuilder();//6.0

        try {
            System.out.println("生成不同分辨率：");
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {

                if (tempString.contains("</dimen>")) {
                    //tempString = tempString.replaceAll(" ", "");
                    String start = tempString.substring(0, tempString.indexOf(">") + 1);
                    String end = tempString.substring(tempString.lastIndexOf("<") - 2);
                    //截取<dimen></dimen>标签内的内容，从>右括号开始，到左括号减2，取得配置的数字
                    Double num = Double.parseDouble
                            (tempString.substring(tempString.indexOf(">") + 1,
                                    tempString.indexOf("</dimen>") - 2));

                    //根据不同的尺寸，计算新的值，拼接新的字符串，并且结尾处换行。
                    sw240.append(start).append((float)(Math.round(num * 0.667*100))/100).append(end).append("\r\n");
                    sw320.append(start).append((float)(Math.round(num * 0.889*100))/100).append(end).append("\r\n");
                    sw360.append(start).append((float)(Math.round(num * 1.0*100))/100).append(end).append("\r\n");
                    sw480.append(start).append((float)(Math.round(num * 1.333*100))/100).append(end).append("\r\n");
                    sw600.append(start).append((float)(Math.round(num * 1.667*100))/100).append(end).append("\r\n");
                    sw720.append(start).append((float)(Math.round(num * 2.0*100))/100).append(end).append("\r\n");
                    sw800.append(start).append((float)(Math.round(num * 2.222*100))/100).append(end).append("\r\n");
                    sw1440.append(start).append((float)(Math.round(num * 4.0*100))/100).append(end).append("\r\n");
                    sw1920.append(start).append((float)(Math.round(num * 5.333*100))/100).append(end).append("\r\n");
                    sw2400.append(start).append((float)(Math.round(num * 6.667*100))/100).append(end).append("\r\n");
                    sw2880.append(start).append((float)(Math.round(num * 8.0*100))/100).append(end).append("\r\n");
                    sw2160.append(start).append((float)(Math.round(num * 6.0*100))/100).append(end).append("\r\n");


                } else {
                    sw240.append(tempString).append("");
                    sw320.append(tempString).append("");
                    sw360.append(tempString).append("");
                    sw480.append(tempString).append("");
                    sw600.append(tempString).append("");
                    sw720.append(tempString).append("");
                    sw800.append(tempString).append("");
                    sw1440.append(tempString).append("");
                    sw1920.append(tempString).append("");
                    sw2400.append(tempString).append("");
                    sw2880.append(tempString).append("");
                    sw2160.append(tempString).append("");
                }

                line++;

            }

            reader.close();

            String sw240file = "./app/src/main/res/values-sw240dp-land/dimens.xml";
            String sw320file = "./app/src/main/res/values-sw320dp-land/dimens.xml";
            String sw360file = "./app/src/main/res/values-sw360dp-land/dimens.xml";
            String sw480file = "./app/src/main/res/values-sw480dp-land/dimens.xml";
            String sw600file = "./app/src/main/res/values-sw600dp-land/dimens.xml";
            String sw720file = "./app/src/main/res/values-sw720dp-land/dimens.xml";
            String sw800file = "./app/src/main/res/values-sw800dp-land/dimens.xml";
            String sw1440file = "./app/src/main/res/values-sw1440dp-land-ldpi/dimens.xml";
            String sw1920file = "./app/src/main/res/values-sw1920dp-land-ldpi/dimens.xml";
            String sw2400file = "./app/src/main/res/values-sw2400dp-land-ldpi/dimens.xml";
            String sw2880file = "./app/src/main/res/values-sw2880dp-land-ldpi/dimens.xml";
            String sw2160file = "./app/src/main/res/values-sw2160dp-land-mdpi/dimens.xml";
            //将新的内容，写入到指定的文件中去
            writeFile(sw240file, sw240.toString());
            writeFile(sw320file, sw320.toString());
            writeFile(sw360file, sw360.toString());
            writeFile(sw480file, sw480.toString());
            writeFile(sw600file, sw600.toString());
            writeFile(sw720file, sw720.toString());
            writeFile(sw800file, sw800.toString());
            writeFile(sw1440file, sw1440.toString());
            writeFile(sw1920file, sw1920.toString());
            writeFile(sw2400file, sw2400.toString());
            writeFile(sw2880file, sw2880.toString());
            writeFile(sw2160file, sw2160.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }


    /**
     * 写入方法
     */

    public static void writeFile(String file, String text) {

        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.close();
    }

}
