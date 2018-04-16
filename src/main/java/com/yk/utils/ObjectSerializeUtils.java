package com.yk.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * [com.yk desc]
 *
 * @author yangkun[Email:vectormail@163.com] 2018/4/16
 */
public class ObjectSerializeUtils {

    /**
     * 对象序列化为字符串
     * @param object
     * @return
     */
    public static String serializeObject(Object object)throws Exception{
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteArrayOutputStream);
        out.writeObject(object);
        //必须是ISO-8859-1
        String objectStr = byteArrayOutputStream.toString("ISO-8859-1");
        out.close();
        byteArrayOutputStream.close();
        return objectStr;
    }

    /**
     * 字符串序列化为对象
     * @param objectStr
     * @return
     * @throws Exception
     */
    public static Object stringSerializeObject(String objectStr)throws Exception{
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(objectStr.getBytes("ISO-8859-1"));
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Object object =  objectInputStream.readObject();
        objectInputStream.close();
        byteArrayInputStream.close();
        return object;
    }
}
