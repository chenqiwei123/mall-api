package ltd.newbee.mall.api.pay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import io.swagger.annotations.Api;
import ltd.newbee.mall.entity.AlipayConfig;
import ltd.newbee.mall.entity.PayItemInformationParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@Api(value = "v1", tags = "5.支付宝支付")
@RequestMapping("/api/v1")
public class Alipay {
    @RequestMapping(value = "/Alipay",method = RequestMethod.POST)
    @ResponseBody
    public void pay(@RequestBody PayItemInformationParam payItemInformationParam, HttpServletResponse response){
        //开放平台 SDK 封装了签名实现，只需在创建 DefaultAlipayClient 对象时，下面是设置顺序
        //1.设置请求网关 (gateway)，
        //2.应用 id (app_id)，
        //3,应用私钥 (private_key)，
        //4.返回格式 (format)，
        //5.编码格式 (charset)，
        //6.支付宝公钥 (alipay_public_key)，
        //7.签名类型 (sign_type)
        //根据你的AlipayConfig里面的变量名来设置对应的值,获取AlipayConfig里面初始值
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL,AlipayConfig.APPID,AlipayConfig.RSA_PRIVATE_KEY,AlipayConfig.FORMAT,AlipayConfig.CHARSET,AlipayConfig.ALIPAY_PUBLIC_KEY,AlipayConfig.SIGNTYPE);
        // 创建API对应的request
        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();
        // 在公共参数中设置同步回跳和异步通知地址
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        //将前端获取到的值放到这个里面中,商品订单号,付款金额,订单名称，销售产品码是必填项，不能为空
    /*alipayRequest.setBizContent("{\"out_trade_no\":\"201934369242223\","
            + "\"total_amount\":\"88.88\","
            + "\"subject\":\"小米手机\","
            + "\"product_code\":\"QUICK_WAP_PAY\"}");*/
        alipayRequest.setBizContent("{" +
                " \"out_trade_no\":\""+ payItemInformationParam.getOutTradeNo()+"\"," +
                " \"total_amount\":\""+ payItemInformationParam.getTotalAmount().replaceAll("A","") +"\"," +
                " \"subject\":\""+ payItemInformationParam.getSubject() +"\"," +
                " \"product_code\":\""+ payItemInformationParam.getProductCode() +"\"" +
                " }");//填充业务参数
        String form="";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
        AlipayConfig.logResult(form);// 记录支付日志
        try {
            response.getWriter().write(form);//直接将完整的表单html输出到页面
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
