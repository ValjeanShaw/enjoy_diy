package com.lucky.utils;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

public class SHA256File {

    public static void main(String[] args) {
        SHA256File sha256File = new SHA256File();
        File[] files = new File("D:/home").listFiles();
        for(File f : files){
            if(f.isDirectory()){
                continue;
            }
            sha256File.OnEncFile(f);
        }
    }

    void OnEncFile(File file) {

        String FileSHA256 = getFileSHA256(file);
        System.out.println(FileSHA256 +" \t "+file.getName());
    }

    private String getFileSHA256(File file) {
        if (!file.isFile()) {
            System.err.println("not file");
            return null;
        }
        MessageDigest digest = null;
        FileInputStream in = null;
        byte buffer[] = new byte[1024];
        int len;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            in = new FileInputStream(file);
            while ((len = in.read(buffer, 0, 1024)) != -1) {
                digest.update(buffer, 0, len);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        BigInteger bigInt = new BigInteger(1, digest.digest());
        return bigInt.toString(16);

    }

}