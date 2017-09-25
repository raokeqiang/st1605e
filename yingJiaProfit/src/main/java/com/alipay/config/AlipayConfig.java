package com.alipay.config;

import java.io.FileWriter;

import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016081500253735";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDIPfCR46DzYhOQOClpkvf7JrBCzkLALkgdxo7MwC+PgRghef0tE8yqsyxkg+2fLqi7s5AvB00FOBzYIuvS7eoLhKC54arQJcYDoaFF3jqcb31JkAb4MGXLsXM2+nThW5blDibCdhvbBQS7IcvZDKIwcD0nuDEJccsXPKiM2ZJGNu1O8bahrrJde2/AoNYZKbdJT42uP7O137x+rLF9X9mpymtmVVImOGet5/2JOmTiWIjuKRQzvhZpYW0x+i0m62qnMjHjbxEj4SMRt0F/DGlx592grX3Xz2mZi8ojdUKSdw/ChjdQKIt7OhVy0KoASNKCbixT4w5nRZ/GcJ0oGwURAgMBAAECggEACplku4QuB9QALxkZ8BGseKnSmKasV9nbTWAuPN5LZjAyI8t+QD2VDtAPIH7vPAbPPahCkIq1Y/pVZIdsriyTv+pUS6KLVRs6wQR0MeuSdKdeHV+3TrnZGZAaBiX5u9gKQ7OdD5wK22wHlRQz4xhNGX1Hb2vLhLF2S5OVZGc72+WCaEwgO3H1Ok5x2Nix95Kje4A1W2MYn7BjP5GXjO0uzn8IKz8VCrrTSoTdQxyiqzzNwHiJYBPrpHggKp8r0un6wyg/AAWrDE0M46wZPxrC02qkNrltdx6yu3jmW3Gwtbn0vW0wKZywEU/gUbEXBPNownOaQL61SY+ME4Md4UtJpQKBgQDuIVWaowxvY6VrAfFTFHKLnAhW0qdL3bFsMAg+qOKk2NHnY8asVZdjPhbUe2lZouxrm6jGI3MdrmOFFBGTFSCvwJR9abp5hSmsyyss84MX0Ni9ctEOyo2hkxxRkWe9YEIteEK8aNgwG+qBlRzGk5YdR8pZN4tiedibsnWXPTHwcwKBgQDXRL4XJ9893U0KesC4Wn8B5dQ/9vC9Piqzyb8nchBzMrBw8zBjaXimLFsHQcbgTryzelR7LocQBXg24FZgzBGZPVOHJQL1fcvQ2CYGlSEflP7q8eQYOgoTbrysuCDX9wvkecs43tadygZTLar69nHJ1BwifXYlq/sG86S54H4nawKBgQCQVow4yxPCgLfHgMnx/bbggJddaRoWli3w0bxtnpiiKvowMv49fzPf58aWzKcyudpr71IBp4MjPoz8IQn2CRxi62wWCHwLJHf6ULu+52tSiDiXvHyTZpsqkKzdlDE5TJtQTFDHOxWvM3yVRvjGNLcM0HMKWOyXqBtvZGB6Z5FZmQKBgA/v8vLb7NczryR7ehEsAgMt9MzXh3M7SwYMha5x723X7uAt4QM7J8eFuSeMYyDwM2BGSkLkavNwtDm72ilIcnUZ6Tk0MEfkjFZl6krKd61S5pyWVADHKz/NDwLqjuPuUl8T9Uu8k78S2e0GkIYMANikb4DOMRUQ6oDVQPjR+gUJAoGAGADn0QU1BVM80KGjGiUozoPKBcH1AwhjF4ZIqmUD0OeUvLIIOlknytA5x/8yYura8N+kEMbBSKwRvNBXa+K+YTbCNr6JRLWdxlJOmxk9eEU+37Z4sQJpw6OohMjx0mEKVcfCOiiSfB0peNBDIG+uSSyNObd1Htf84ubYBKQLfLs=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxNP6lOn3vnugSdoYy/bQO2tvQD6Ec4+KybHMzxEYa3K+YhaKNidfzTlMSrzwYBSLbcl0lPNfJoTwsQcXf5sz2X/9WsXpv+YfNF3mJUrXmevCz/qXNGAMAO3gEpUHmv2JJ/vrZ0zCOxbKbZToynKV+UN4vPQdeOKXBNzE7HHv6L4ncQSO5bL+BgFX02Pf/WpSJKdfNnBNp8eXyhLg3cftYqTKopySBZ2yw76+5dKcGVx/nZGycMK8jNOwaUp7IbHM/HsiHgFXYp6mlnnAylc7Q75racphBmqGldPlkinWnll9gJN72wJdu5Sed59jMXAw+ZZHXL7TpNaMjUBPULfJ4wIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

