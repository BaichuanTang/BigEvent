package com.itheima.springbootconfigfile;

public class Aa {

    public static void main(String[] args) {
        try {
            AliYunUploadUtil.upload("aa","bb");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
