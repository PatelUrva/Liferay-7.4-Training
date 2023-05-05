package com.aixtor.training.employee.filters;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Urva Patel
 */

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

@Component(
	 immediate = true, 
	 property = {
	 "servlet-context-name=", 
	 "servlet-filter-name=Custom Filter",
	 "url-pattern=/web/manali/remote-app/*" 
	 }, 
	 service = Filter.class
)
public class CustomFilter implements javax.servlet.Filter {
	
	private static final Log log = LogFactoryUtil.getLog(CustomFilter.class); 
	private boolean forward = false;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("CustomFilter >>> init() >>> Init Called");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		try {
			
			log.info("CustomFilter >>> doFilter() >>> Expression Matched"); 	
			
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			
			String pathInfo = ((HttpServletRequest) request).getPathInfo();
			log.info("CustomFilter >>> doFilter() >>> PathInfo >>> " + pathInfo);
            
            if(pathInfo.endsWith("employee") || pathInfo.endsWith("branch") ) {
            	
            	forward = true;
            	
            	log.info("CustomFilter >>> doFilter() >>> Path Matched");
            	httpServletRequest.getRequestDispatcher("https://www.google.com/")
            		.forward(request, response);
            	
            }else {
            	log.info("CustomFilter >>> doFilter() >>> Path Not Matched");
            }
            
            if(!forward) {
            	filterChain.doFilter(request, response);
            }
            
        } catch (Exception e) {
        	log.info("CustomFilter >>> doFilter() >>> Error Occured : " +e);
        }
	}

	@Override
	public void destroy() {
		log.info("CustomFilter >>> destroy() >>> Destroy Called");
	}

}
