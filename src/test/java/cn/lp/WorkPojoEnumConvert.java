package cn.lp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.util.List;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp
 * @Author: lp
 * @CreateTime: 2026-01-06  17:20
 * @Description: TODO 文档支付渠道列表数据转换，机构替换，金额转换
 * @Version: 1.0
 */
public class WorkPojoEnumConvert {
//    id 92
    private static  final int sumCount = 51;
    public static void main(String[] args) throws JsonProcessingException {
        String json = "[\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"WECHATPAY\",\n" +
            "\"country\": \"HK\",\n" +
            "\"currency\": \"HKD\",\n" +
            "\"minAmount\": \"1.0\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"WECHATPAY\",\n" +
            "\"country\": \"CN\",\n" +
            "\"currency\": \"USD\",\n" +
            "\"minAmount\": \"1.0\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"WECHATPAY\",\n" +
            "\"country\": \"HK\",\n" +
            "\"currency\": \"CNY\",\n" +
            "\"minAmount\": \"1.0\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"WECHATPAY\",\n" +
            "\"country\": \"HK\",\n" +
            "\"currency\": \"CNY\",\n" +
            "\"minAmount\": \"1.0\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"ALIPAYCN\",\n" +
            "\"country\": \"HK\",\n" +
            "\"currency\": \"CNY\",\n" +
            "\"minAmount\": \"1.0\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"KAKAOPAY\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"KRW\",\n" +
            "\"minAmount\": \"100.0\",\n" +
            "\"maxAmount\": \"10000000000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"NAVER_PAY\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"KRW\",\n" +
            "\"minAmount\": \"100.0\",\n" +
            "\"maxAmount\": \"10000000000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"WECHATPAY\",\n" +
            "\"country\": \"CN\",\n" +
            "\"currency\": \"GHS\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"WECHATPAY\",\n" +
            "\"country\": \"CN\",\n" +
            "\"currency\": \"CNY\",\n" +
            "\"minAmount\": \"1.0\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"WECHATPAY\",\n" +
            "\"country\": \"HK\",\n" +
            "\"currency\": \"USD\",\n" +
            "\"minAmount\": \"1.0\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"ALIPAYCN\",\n" +
            "\"country\": \"CN\",\n" +
            "\"currency\": \"USD\",\n" +
            "\"minAmount\": \"1.0\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"ALIPAYCN\",\n" +
            "\"country\": \"CN\",\n" +
            "\"currency\": \"HKD\",\n" +
            "\"minAmount\": \"1.0\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"ALIPAYHK\",\n" +
            "\"country\": \"HK\",\n" +
            "\"currency\": \"HKD\",\n" +
            "\"minAmount\": \"1.0\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"ALIPAYHK\",\n" +
            "\"country\": \"HK\",\n" +
            "\"currency\": \"USD\",\n" +
            "\"minAmount\": \"1.0\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"GCASH\",\n" +
            "\"country\": \"PH\",\n" +
            "\"currency\": \"PHP\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"GCASH\",\n" +
            "\"country\": \"PH\",\n" +
            "\"currency\": \"USD\",\n" +
            "\"minAmount\": \"1.0\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"KAKAOPAY\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"KRW\",\n" +
            "\"minAmount\": \"100.0\",\n" +
            "\"maxAmount\": \"10000000000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"KAKAOPAY\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"USD\",\n" +
            "\"minAmount\": \"1.0\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"NAVER_PAY\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"KRW\",\n" +
            "\"minAmount\": \"100.0\",\n" +
            "\"maxAmount\": \"10000000000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"NAVER_PAY\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"USD\",\n" +
            "\"minAmount\": \"1.0\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"TOSS_PAY\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"USD\",\n" +
            "\"minAmount\": \"1.0\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"TOSS_PAY\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"KRW\",\n" +
            "\"minAmount\": \"100.0\",\n" +
            "\"maxAmount\": \"10000000000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"TOSS_PAY\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"KRW\",\n" +
            "\"minAmount\": \"100.0\",\n" +
            "\"maxAmount\": \"10000000000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"PAYCO\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"KRW\",\n" +
            "\"minAmount\": \"100.0\",\n" +
            "\"maxAmount\": \"10000000000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"BPI\",\n" +
            "\"country\": \"PH\",\n" +
            "\"currency\": \"PHP\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"BPI\",\n" +
            "\"country\": \"PH\",\n" +
            "\"currency\": \"USD\",\n" +
            "\"minAmount\": \"1.0\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"BILLEASE\",\n" +
            "\"country\": \"PH\",\n" +
            "\"currency\": \"PHP\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"BILLEASE\",\n" +
            "\"country\": \"PH\",\n" +
            "\"currency\": \"USD\",\n" +
            "\"minAmount\": \"1.0\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"TRUEMONEY\",\n" +
            "\"country\": \"TH\",\n" +
            "\"currency\": \"THB\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"TRUEMONEY\",\n" +
            "\"country\": \"TH\",\n" +
            "\"currency\": \"USD\",\n" +
            "\"minAmount\": \"1.0\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"RABBIT_LINE_PAY\",\n" +
            "\"country\": \"TH\",\n" +
            "\"currency\": \"USD\",\n" +
            "\"minAmount\": \"1.0\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"RABBIT_LINE_PAY\",\n" +
            "\"country\": \"TH\",\n" +
            "\"currency\": \"THB\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"PAYCO\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"KRW\",\n" +
            "\"minAmount\": \"100.0\",\n" +
            "\"maxAmount\": \"10000000000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"PAYCO\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"USD\",\n" +
            "\"minAmount\": \"1.0\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"TNG\",\n" +
            "\"country\": \"MY\",\n" +
            "\"currency\": \"MYR\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"TNG\",\n" +
            "\"country\": \"MY\",\n" +
            "\"currency\": \"USD\",\n" +
            "\"minAmount\": \"1.0\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"BOOST\",\n" +
            "\"country\": \"MY\",\n" +
            "\"currency\": \"USD\",\n" +
            "\"minAmount\": \"1.0\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"BOOST\",\n" +
            "\"country\": \"MY\",\n" +
            "\"currency\": \"MYR\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"DANA\",\n" +
            "\"country\": \"ID\",\n" +
            "\"currency\": \"IDR\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"WECHATPAY\",\n" +
            "\"country\": \"HK\",\n" +
            "\"currency\": \"HKD\",\n" +
            "\"minAmount\": \"1.0\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"KAKAOPAY\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"KRW\",\n" +
            "\"minAmount\": \"100.0\",\n" +
            "\"maxAmount\": \"10000000000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"NAVER_PAY\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"KRW\",\n" +
            "\"minAmount\": \"100.0\",\n" +
            "\"maxAmount\": \"10000000000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"PAYCO\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"KRW\",\n" +
            "\"minAmount\": \"100.0\",\n" +
            "\"maxAmount\": \"10000000000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"TOSS_PAY\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"KRW\",\n" +
            "\"minAmount\": \"100.0\",\n" +
            "\"maxAmount\": \"10000000000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"KAKAOPAY\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"KRW\",\n" +
            "\"minAmount\": \"100.0\",\n" +
            "\"maxAmount\": \"10000000000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"NAVER_PAY\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"KRW\",\n" +
            "\"minAmount\": \"100.0\",\n" +
            "\"maxAmount\": \"10000000000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"PAYCO\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"KRW\",\n" +
            "\"minAmount\": \"100.0\",\n" +
            "\"maxAmount\": \"10000000000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"TOSS_PAY\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"KRW\",\n" +
            "\"minAmount\": \"100.0\",\n" +
            "\"maxAmount\": \"10000000000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"AED\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"ARS\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"AUD\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"BDT\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"BND\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"BRL\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"BANK_TRANSFER\",\n" +
            "\"targetOrg\": \"BANK_TRANSFER\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"KRW\",\n" +
            "\"minAmount\": \"100.0\",\n" +
            "\"maxAmount\": \"10000000000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"WALLET\",\n" +
            "\"targetOrg\": \"QRPH\",\n" +
            "\"country\": \"PH\",\n" +
            "\"currency\": \"PHP\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"KOREAN_CARDS\",\n" +
            "\"targetOrg\": \"KOREAN_CARDS\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"KRW\",\n" +
            "\"minAmount\": \"100.0\",\n" +
            "\"maxAmount\": \"10000000000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"CAD\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"CLP\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"CNY\",\n" +
            "\"minAmount\": \"1.0\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"DKK\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"EGP\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"EUR\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"GBP\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"HKD\",\n" +
            "\"minAmount\": \"1.0\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"HNL\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"HRK\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"HUF\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"IDR\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"ILS\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"INR\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"IQD\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"ISK\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"JOD\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"JPY\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"KES\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"KGS\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"KHR\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"KRW\",\n" +
            "\"minAmount\": \"100.0\",\n" +
            "\"maxAmount\": \"10000000000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"KWD\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"KZT\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"LAK\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"LYD\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"MAD\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"MKD\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"MMK\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"MOP\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"MUR\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"MVR\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"MXN\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"MYR\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"NAD\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"NGN\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"NIO\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"NOK\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"NPR\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"NZD\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"OMR\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"PAB\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"PEN\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"PGK\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"PHP\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"PKR\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"PYG\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"QAR\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"RSD\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"RUB\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"RWF\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"SAR\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"SCR\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"SEK\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"SGD\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"SZL\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"TWD\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"UGX\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"USD\",\n" +
            "\"minAmount\": \"1.0\",\n" +
            "\"maxAmount\": \"10000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"UYU\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"UZS\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"VND\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "},\n" +
            "{\n" +
            "\"productCode\": \"CARD\",\n" +
            "\"targetOrg\": \"CARD\",\n" +
            "\"country\": \"KR\",\n" +
            "\"currency\": \"XCD\",\n" +
            "\"minAmount\": \"0.01\",\n" +
            "\"maxAmount\": \"100000.0\",\n" +
            "\"expireTime\": 60\n" +
            "}\n" +
            "]";
        ObjectMapper mapper = new ObjectMapper();
        List<WorkPojo> list = mapper.readValue(json, new TypeReference<List<WorkPojo>>() {});
        System.out.println(list.size());
        // 2. 遍历并替换 minAmount / maxAmount（核心逻辑）
        for (WorkPojo item : list) {
            FundingAmountLimit limit = FundingAmountLimit.getByCurrency(item.getCurrency());

            if (limit != null) {
                item.setMinAmount(limit.getMinAmount().toString());
                item.setMaxAmount(limit.getMaxAmount().toString());
            } else {
                System.out.println("警告: 未配置货币 " + item.getCurrency() + " 的金额限制");
            }

            // 可选：同时把 targetOrg 替换为大写标准化值（如 qrph → QRPH）
            WalletTypeEnum wallet = WalletTypeEnum.fromOriginalType(item.getTargetOrg());
            if (wallet != null) {
                item.setTargetOrg(wallet.getTargetType());
            }
        }

        // 3. 序列化输出（格式与原 JSON 一致）
        String result = mapper.writeValueAsString(list);
        System.out.println(result);

    }

    @Data
    static  class WorkPojo{

        private String productCode;

        private String targetOrg;        // 原始值（qrph、korean_cards 等）

        private String country;
        private String currency;
        private String minAmount;
        private String maxAmount;
        private Integer expireTime;

        @JsonIgnore
        public Integer getExpireTime() {
            return expireTime;
        }

    }
}
