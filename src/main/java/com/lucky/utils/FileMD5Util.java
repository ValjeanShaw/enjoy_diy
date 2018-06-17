package com.lucky.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.AccessController;
import java.security.MessageDigest;
import java.security.PrivilegedAction;

@Slf4j
@SuppressWarnings("restriction")
public class FileMD5Util {

    public static void main(String[] args) throws FileNotFoundException {
//        File[] files = new File("D:/home").listFiles();
//        for(File f : files){
//            if(f.isDirectory()){
//                continue;
//            }
//            String fileMD5 = getFileMD5(f);
//            System.out.println(fileMD5);
//        }

        String n = "123";
        System.out.println(n.substring(0, 2));

    }

    public static String getFilePathName(MultipartFile file, String type){
        String fileMd5 = getFileMD5(file);
        String dir = fileMd5.substring(0, 2);
        if(StringUtils.isEmpty(type)){
            return dir.concat("/").concat(fileMd5);
        }else{
            return dir.concat("/").concat(fileMd5).concat(".").concat(type);
        }
    }

    public static String getFilePathName(File file, String type){
        String fileMd5 = getFileMD5(file);
        String dir = fileMd5.substring(0, 2);
        if(StringUtils.isEmpty(type)){
            return dir.concat("/").concat(fileMd5);
        }else{
            return dir.concat("/").concat(fileMd5).concat(".").concat(type);
        }
    }

    public static String getFileMD5(MultipartFile file) {

        MessageDigest digest = null;
        byte buffer[] = new byte[1024];
        int len;
        try (InputStream in = file.getInputStream();){
            digest = MessageDigest.getInstance("MD5");

            while ((len = in.read(buffer, 0, 1024)) != -1) {
                digest.update(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        BigInteger bigInt = new BigInteger(1, digest.digest());
        return bigInt.toString(16);
    }

    public static String getFileMD5(InputStream in) {

        MessageDigest digest = null;
        byte buffer[] = new byte[1024];
        int len;
        try {
            digest = MessageDigest.getInstance("MD5");

            while ((len = in.read(buffer, 0, 1024)) != -1) {
                digest.update(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                if(in != null){
                    in.close();
                }
            } catch (IOException e) {
            }
        }

        BigInteger bigInt = new BigInteger(1, digest.digest());
        return bigInt.toString(16);
    }

  /**
     * 获取文件md5值
     */
    public static String getFileMD5(File file){
        String value = null;
        try (
            FileInputStream in = new FileInputStream(file);
            FileChannel fc = in.getChannel();
                ){
            MappedByteBuffer byteBuffer = fc.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(byteBuffer);
            BigInteger bi = new BigInteger(1, md5.digest());
            value = bi.toString(16);
            if (value.length() < 32) {
                value = "0" + value;
            }
            if (null != byteBuffer) {
                freedMappedByteBuffer(byteBuffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * 在MappedByteBuffer释放后再对它进行读操作的话就会引发jvm crash，在并发情况下很容易发生
     * 正在释放时另一个线程正开始读取，于是crash就发生了。所以为了系统稳定性释放前一般需要检 查是否还有线程在读或写
     *
     * @param mappedByteBuffer
     */
    public static void freedMappedByteBuffer(final MappedByteBuffer mappedByteBuffer) {
        try {
            if (mappedByteBuffer == null) {
                return;
            }

            mappedByteBuffer.force();
            AccessController.doPrivileged(new PrivilegedAction<Object>() {
                @Override
                public Object run() {
                    try {
                        Method getCleanerMethod = mappedByteBuffer.getClass().getMethod("cleaner", new Class[0]);
                        getCleanerMethod.setAccessible(true);
                        sun.misc.Cleaner cleaner = (sun.misc.Cleaner) getCleanerMethod.invoke(mappedByteBuffer,
                                new Object[0]);
                        cleaner.clean();
                    } catch (Exception e) {
                        log.error("clean MappedByteBuffer error!!!", e);
                    }
                    //log.info("clean MappedByteBuffer completed!!!");
                    return null;
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //释放 MappedByteBuffer 映射的文件
    public static void freedMappedByteBuffer2(final MappedByteBuffer mappedByteBuffer) {
        try {
            if (mappedByteBuffer == null) {
                return;
            }

            Method m = sun.nio.ch.FileChannelImpl.class.getDeclaredMethod("unmap", MappedByteBuffer.class);
            m.setAccessible(true);
            m.invoke(sun.nio.ch.FileChannelImpl.class, mappedByteBuffer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
