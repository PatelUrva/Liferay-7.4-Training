package com.aixtor.training.dynamic.include;

/**
 * @author Urva Patel
 */

import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	service = DynamicInclude.class
)
public class BlogsDynamicInclude implements DynamicInclude {

	@Override
	public void include(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String key)
			throws IOException {
		System.out.println("Inside include");
		PrintWriter printWriter = httpServletResponse.getWriter();
		printWriter.println("<h2>Added by Blogs Dynamic Include Post!</h2><br />");
	}

	@Override
	public void register(DynamicIncludeRegistry dynamicIncludeRegistry) {
		System.out.println("Inside register");
		dynamicIncludeRegistry.register("com.liferay.blogs.web#/blogs/view_entry.jsp#pre");
	}

}