package com.dzz.policy.service.service.common;

import com.dzz.util.encrypt.EncryptAES;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 统一加密工具
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月23 下午4:37
 */
@Component
@Slf4j
public class EncryptToolsService {

    @Value("${pay.appId.key}")
    private String appKey;

    /**
     * 数据加密
     * @param data 待加密数据
     * @return 结果
     */
    public String encrypt(String data) {
        return encrypt(data, appKey);
    }

    /**
     * 数据加密
     * @param data 待加密数据
     * @param key 加密密钥
     * @return 加密结果
     */
    public String encrypt(String data,String key) {
        String encryptData = "";
        try {
            encryptData = EncryptAES.encrypt(data, key);
        } catch (Exception e) {
            log.info("数据加密异常",e);
        }
        //转换成Base64
        return Base64.encodeBase64String(encryptData.getBytes());
    }

    /**
     * 数据解密
     * @param signData 待解密数据
     * @return 解密结果
     */
    public String decrypt(String signData) {

        return decrypt(signData, appKey);
    }

    /**
     * 数据解密
     * @param signData 待解密数据
     * @param key 解密密钥
     * @return 解密结果
     */
    public String decrypt(String signData,String key) {

        String decryptData = "";
        try {
            decryptData = EncryptAES.decrypt(new String(Base64.decodeBase64(signData)), key);
        } catch (Exception e) {
            log.info("数据解密异常",e);
        }
        return decryptData;
    }


}
