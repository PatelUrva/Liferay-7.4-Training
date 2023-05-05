package com.aixtor.training.portletfilter;

/**
 * @author Urva Patel
 */
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.portlet.RenderResponse;
import javax.portlet.filter.RenderResponseWrapper;

public class BufferedRenderResponseWrapper extends RenderResponseWrapper {
	
	protected CharArrayWriter charWriter;
	protected PrintWriter writer;
	protected boolean getOutputStreamCalled;
	protected boolean getWriterCalled;

	/**
	 * @return object of CharArrayWriter
	 * @param response
	 */
	public BufferedRenderResponseWrapper(RenderResponse response) {
		super(response);
		charWriter = new CharArrayWriter();
	}


	/**
	 * 
	 * @return boolean getOutputStreamCalled
	 * @throws IOException
	 */
	public OutputStream getOutputStream() throws IOException {
		
		// 1. Checks if getWriter already called
		if (getWriterCalled) {
			throw new IllegalStateException("getWriter already called");
		}

		getOutputStreamCalled = true;

		return super.getPortletOutputStream();
	}
	
	/**
	 * @return write data to the response before it’s sent back to the client.
	 */
	public PrintWriter getWriter() throws IOException {
		if (writer != null) {
			return writer;
		}

		if (getOutputStreamCalled) {
			throw new IllegalStateException("getOutputStream already called");
		}

		getWriterCalled = true;

		writer = new PrintWriter(charWriter);

		return writer;
	}

	/**
	 * @return the current response text 
	 */
	public String toString() {
		String s = null;

		if (writer != null) {
			s = charWriter.toString();
		}

		return s;
	}

}
