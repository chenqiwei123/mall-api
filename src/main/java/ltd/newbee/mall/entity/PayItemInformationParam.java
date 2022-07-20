package ltd.newbee.mall.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 支付商品信息类
 * Created by macro on 2018/4/26.
 */
@Data
public class PayItemInformationParam {
    @ApiModelProperty(value = "商品订单号", required = true)
    private String outTradeNo;
    @ApiModelProperty(value = "付款金额", required = true)
    private String totalAmount;
    @ApiModelProperty(value = "订单名称", required = true)
    private String subject;
    @ApiModelProperty(value = "销售产品码", required = true)
    private String productCode="QUICK_WAP_PAY";//必填 付款方式  如果值是FAST_INSTANT_TRADE_PAY的话就是扫二维码付款,需要用手机下载一个沙箱支付宝支付
}
