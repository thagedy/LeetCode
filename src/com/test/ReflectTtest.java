package com.test;

import java.io.*;
import java.util.List;
import java.util.Properties;

/**
 * Created by Kaijia Wei on 2017/3/30.
 */
public class ReflectTtest {


    public static void getProperties(){
        try {
            InputStream inputStream = new FileInputStream("src/resource/config.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            Object className = properties.get("className");
            List<String> list = (List<String>) Class.forName(String.valueOf(className)).newInstance();
            list.add("1");
            list.add("3");
            System.out.println(list.toString());
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
  /*      String aa = "test";
        Class clazz = aa.getClass();
        Constructor[] constructors = clazz.getConstructors();
        System.out.println("------------获取字符串类的全部构造方法---------");
        for (Constructor constructor : constructors)
            System.out.println(constructor);

        Method[] methods = clazz.getMethods();
        System.out.println("------------获取字符串类的全部普通方法---------");
        for (Method constructor : methods)
            System.out.println(constructor);

        Field[] fields = clazz.getFields();
        System.out.println("------------获取字符串类的属性---------");
        for (Field constructor : fields)
            System.out.println(constructor);

        System.out.println("------------获取字符串类的类加载器---------");
        System.out.println(clazz.getClassLoader());
*/
        System.out.println("新建ArrayList对象");
        getProperties();
    }
}
