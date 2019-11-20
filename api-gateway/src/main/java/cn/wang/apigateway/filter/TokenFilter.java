package cn.wang.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: wbh
 * @Date: 2019/11/20 11:35
 * @Description:
 */
@Component
public class TokenFilter extends ZuulFilter {


    /**
     * 过滤器的类型,他决定过滤器在请求的那个生命周期中执行。
     * 这里定义为pre，代表会在请求被路由执行之前执行
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * filter执行顺序,通过数字指定
     * 数字越大,优先级越低
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器是否需要执行,这里我们直接返回了true,代表会对所有请求都生效
     * 实际运用中我们可以利用该函数来指定过滤器的有效范围
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        String token = request.getHeader("token");
        if (token == null || token.isEmpty()) {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            context.setResponseBody("token is empty");
        }
        return null;
    }
}
