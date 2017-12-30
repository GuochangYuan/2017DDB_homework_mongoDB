package com.vma.code.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class JspUtil {
	public static final void printOperationMsg(HttpServletResponse response, String Msg, String operation)
	  {
	    response.setContentType("text/html;charset=utf-8");
	    try {
	      PrintWriter out = response.getWriter();
	      out.println("<SCRIPT>");
	      if ((Msg != null) && (!"".equals(Msg))) {
	        out.println("alert('"+Msg+"');");
	      }
	      if ((operation != null) && (!"".equals(operation))) {
	        out.println(operation);
	      }
	      out.println("</SCRIPT>");
	      out.close();
	    }
	    catch (IOException e) {
	      e.printStackTrace();
	    }
	  }
}
