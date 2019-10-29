/**
 * 
 */
package com.progesco.progescozuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author emile.camara
 *
 */
@Component
public class HeaderFilter extends ZuulFilter {

  Logger log = LoggerFactory.getLogger(this.getClass());

  @Override
  public String filterType() {
      return "pre";
  }

  @Override
  public int filterOrder() {
      return 1;
  }

  @Override
  public boolean shouldFilter() {
      return true;
  }

  @Override
  public Object run() throws ZuulException {
      HttpServletRequest req = RequestContext.getCurrentContext().getRequest();
      RequestContext ctx = RequestContext.getCurrentContext();
      HttpServletRequest request = ctx.getRequest();
      ctx.addZuulRequestHeader("Authorization", request.getHeader("Authorization"));

      return null;
  }
}
