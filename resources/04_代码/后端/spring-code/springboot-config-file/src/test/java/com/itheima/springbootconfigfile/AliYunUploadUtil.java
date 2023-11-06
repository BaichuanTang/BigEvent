package com.itheima.springbootconfigfile;


import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;

import java.io.ByteArrayInputStream;

class AliYunUploadUtil {
    public static void upload(String objectName,String content){
        String endpoint        = "https://oss-cn-hangzhou.aliyuncs.com";
        String accessKeyId     = "LTAI5tQ8e13SYZUMTjMEEQV";
        String accessKeySecret = "MffMJoM24sc59SDEEJQDb0cfBVOAC9";
        String bucketName      = "gsw";

        OSS ossClient = new OSSClientBuilder().build(endpoint,
                accessKeyId,accessKeySecret);
        try {
            PutObjectRequest putObjectRequest =
                    new PutObjectRequest(bucketName,
                                         objectName,
                                         new ByteArrayInputStream(
                                                 content.getBytes())
                    );
            PutObjectResult result = ossClient.putObject(putObjectRequest);
            System.out.println(result);
        } catch (ClientException ce) {
            System.out.println(ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
}


