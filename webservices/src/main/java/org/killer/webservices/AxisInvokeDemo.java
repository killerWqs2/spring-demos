package org.killer.webservices;

import cn.hutool.core.util.RandomUtil;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import java.util.*;

/**
 * @author killer
 * @date 2020/06/15 - 15:25
 */
public class AxisInvokeDemo {

    public static void main1(String[] args) {
        try {
            String phone = "18651867695";
            String content = "test";
            String endpoint = "http://10.1.13.15:8080/ewell/Ewell_Sms.asmx?wsdl";
            String key = "cfddd7b-8cdb-4fd8-b15a-f4deb03eb5a9";
            String hospitalId = "";
            // 随机生成字符串

            String messageTemplate = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                                "\t<Request>\n" +
                                "\t<HospitalId>%s</HospitalId>\n" +
                                "\t<Signature>%s</Signature>\n" +
                                "\t<NonceStr>%s</NonceStr>\n" +
                                "\t<Key>%s</Key>\n" +
                                "\t<ReceiveName></ReceiveName>\n" +
                                "\t<ReceiverType></ReceiverType>\n" +
                                "\t<PatMedNo></PatMedNo>\n" +
                                "\t<PatMedType></PatMedType>\n" +
                                "\t<StaffNo></StaffNo>\n" +
                                "\t<Mobile>%s</Mobile>\n" +
                                "\t<Content>%s</Content>\n" +
                                "\t<Resource>LIS</Resource>\n" +
                            "\t</ Request >\n";

            String nonceStr = RandomUtil.randomString(8);
            String nameSpace = null;

            String signature = null;
            String message = String.format(messageTemplate, hospitalId, signature, nonceStr, key, phone, content);
            //直接引用远程的wsdl文件
            //以下都是套路
            Service service = new Service();
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(endpoint);
            //WSDL里面描述的接口名称
            call.setOperationName("SendShortMessage");
            //接口的参数
            call.addParameter("userName", org.apache.axis.encoding.XMLType.XSD_DATE,
                    javax.xml.rpc.ParameterMode.IN);
            //设置返回类型

            List<Object> list = new ArrayList<>();
            Map<String,Object> map= new HashMap<>();
            //输入参数值
            map.put("message",message);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getValue() instanceof String) {
                    call.addParameter(new QName(nameSpace, entry.getKey()),
                            XMLType.XSD_STRING, ParameterMode.IN);
                } else if (entry.getValue() instanceof Long) {
                    call.addParameter(new QName(nameSpace, entry.getKey()),
                            XMLType.XSD_LONG, ParameterMode.IN);
                } else if (entry.getValue() instanceof Double) {
                    call.addParameter(new QName(nameSpace, entry.getKey()),
                            XMLType.XSD_DOUBLE, ParameterMode.IN);
                } else if (entry.getValue() instanceof Float) {
                    call.addParameter(new QName(nameSpace, entry.getKey()),
                            XMLType.XSD_FLOAT, ParameterMode.IN);
                } else if (entry.getValue() instanceof Integer) {
                    call.addParameter(new QName(nameSpace, entry.getKey()),
                            XMLType.XSD_INTEGER, ParameterMode.IN);
                } else if (entry.getValue() instanceof Date) {
                    call.addParameter(new QName(nameSpace, entry.getKey()),
                            XMLType.XSD_DATETIME, ParameterMode.IN);
                } else if (entry.getValue() instanceof Boolean) {
                    call.addParameter(new QName(nameSpace, entry.getKey()),
                            XMLType.XSD_BOOLEAN, ParameterMode.IN);
                }
                list.add(entry.getValue());
            }

            call.setReturnType(XMLType.XSD_SCHEMA);
            //给方法传递参数，并且调用方法
            String result = (String) call.invoke(list.toArray());
            System.out.println("result is " + result);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public static void main(String[] args) {
        System.out.println(RandomUtil.randomString(8));
    }

}
