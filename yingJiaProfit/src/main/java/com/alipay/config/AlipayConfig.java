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
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCAAfmsn3P4M60nzJZChD66Wpl8P9Uhu0sg7XZ4MoYtgs0nXRUGDXz4Qxixk8miGsVI1RdoQyKXc5hUyMYfhCl+4hJShCHCKz7j79wFgOU1kSzEr6IhKiZeKDPqoiwYPi8sslMbjRml+B0AwMXtdABc6DL09/e1hwr3Uvcsg2kIcuMCHyGw5+ZTCHAODR2FOuXAUuU+EgY0jUTDlz0dMiHV53osgAb7yEBu/l4rv7yTsZP/cz4pgBOKN6JF3/zByBtw+Syy/Y1X8SSI660DE3Ac6oGvhsI4oOPO8/FXtUbbgVAr0xn3ttaEBYt0D2vragVKmOySZFUTGzu+eBIO4YuvAgMBAAECggEAKNv4jSBMjSI5mCWWpN6/gw5eRam+Z0j4XydNFGrUJ3zD7Vep2Ue+5yPLowsQZlzzMh9KnG4pgXxVWGLJ0s+Fy0lwHcStXeQd6/XpHhyZjTKsvo9tSfbBTna4s6FWP9rBhhvZqUattCtxXocp5nSLlRxM/6KS/+9+EZn66ct8YESNX/6cHSIvDV5vgTi3uagN4iuzKpmiQOSg2sks5upus+cZA7LcQy4tBuqI6ZxxHYxiCxGFpDSHKwGKOEWtT11uidZ+IaaNtB7FhswDzHE5csYQ+sROBkLBwBfdcQsCfLwhvtGIRZjULg5VD3ekWjni8A+z3ueWYXIj9RQ8gn1GkQKBgQDhAkYulq9mPgQ8zHSZvoxgnHOdqVi0QwXKhB+mnjqeahnV76nRPL4ztwVdAXIH9oS64plcPHES6KcLOOH/gkh5KEmcNjleQtA88coXldHGwnVVp/dKUspIXXL4Q+Xkur50wT/RXXA7DDQr/PAxoRFJxZl5qmrevr6/tB5YpLrq6QKBgQCRo3pHEXq3VBVb5tnERr1PDx9HTtyHmWg5wBKR1RErD5toKlW9QOmRfw+DAVb15vAUriFBl15JK2a/JMiQjW5nii51D5wv1UEYFNFYn9jGE0CpwvC2JNpQqSc6PoB34KDOVbgLY2BYiqU3yxBZUIYSMxuSZgRWiR+uzLT5M2by1wKBgFg6rg5io9BxjPPSL/6BS0Yu0t8FonS8uy6X9Fk/PjkT3aGX4nzbVrGsmHvJr08UCSPG6t/SC3ygoa+y1Ft+WLC5bXPFh2VAyaq8HMR2yNUpNx0pSbxpDkyl6AkVhrXTzA64IDAWdYWR2XtOKVkskTzeMLoWauWA4gcFt8iGf4zRAoGAZdKiHyX9YkeLV2GjRzMeEDRGbhiY3sVGtXmwgf0xr6WNxdozb8n+gxcOxU0ee3YmzI6h+bXW2dlaULFq+IWpdwKJUJbFYDv88tU7OHcpm/LB9u6wVOiXKmXZY0NnlmiahSgxMOUd60mkEcoLeCZwVjEdSdHBnq7oU9IThVeG1qkCgYBMU0l4PylusMbOp1vIlAt3Zjs0FvvZpXLewtrdbCs6pz+LD0K6wiyTJRcjVTloAlT+UmKqDcbCh5MhRDjl3gr2d/d4+Ansrql5GewHyRLjghKGfXKcaACWh/soRHzf4jQ64u2eVzGX+k/MDuLoKLXiJlZwGoKsGQwE1WpZg/TUTg==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgAH5rJ9z+DOtJ8yWQoQ+ulqZfD/VIbtLIO12eDKGLYLNJ10VBg18+EMYsZPJohrFSNUXaEMil3OYVMjGH4QpfuISUoQhwis+4+/cBYDlNZEsxK+iISomXigz6qIsGD4vLLJTG40ZpfgdAMDF7XQAXOgy9Pf3tYcK91L3LINpCHLjAh8hsOfmUwhwDg0dhTrlwFLlPhIGNI1Ew5c9HTIh1ed6LIAG+8hAbv5eK7+8k7GT/3M+KYATijeiRd/8wcgbcPkssv2NV/EkiOutAxNwHOqBr4bCOKDjzvPxV7VG24FQK9MZ97bWhAWLdA9r62oFSpjskmRVExs7vngSDuGLrwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/yingJiaProfit/shopping/tonotice";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/yingJiaProfit/shopping/toreturn";

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

