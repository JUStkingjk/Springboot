package com.official.project001.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Component
public class SessionListener implements HttpSessionListener {

    private static final Logger logger = LoggerFactory.getLogger(SessionListener.class);

    public Integer count = 0;

    @Override
    public synchronized void sessionCreated(HttpSessionEvent se) {
       logger.info("上线");
       count++;
       se.getSession().getServletContext().setAttribute("count",count);
    }

    @Override
    public synchronized void sessionDestroyed(HttpSessionEvent se) {
        logger.info("下线");
        count--;
        se.getSession().getServletContext().setAttribute("count",count);
    }
}
