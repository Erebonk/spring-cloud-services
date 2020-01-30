package com.ere.services.zuulservice.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

/**
 * Zuul filter
 *
 * @author ilya
 * @version 1.0
 */
@Component
public class ZuulOwnFilter extends ZuulFilter {

    private final DiscoveryClient client;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public ZuulOwnFilter(DiscoveryClient client) {
        this.client = client;
    }

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
    public Object run() {
        var request = RequestContext.getCurrentContext().getRequest();
        logger.info("request: " + request.getRequestURI());
        return null;
    }
}
