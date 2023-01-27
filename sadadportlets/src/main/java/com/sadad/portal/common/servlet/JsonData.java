/**
 * 
 */
package com.sadad.portal.common.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.json.java.JSON;
import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;
import com.sadad.portal.constant.PortalConstant;

/**
 * @author Tariq Siddiqui
 *
 */
public class JsonData extends HttpServlet
{
	private static final long serialVersionUID = -1890005512795080734L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String jsonResponse = null;

		if(request.getParameter("q") != null)
		{
			if(request.getParameter("q").equalsIgnoreCase(PortalConstant.JSON_BANK_QUERY_STRING))
				jsonResponse = (String) request.getServletContext().getAttribute(PortalConstant.JSON_BANK_LIST);
			else if(request.getParameter("q").equalsIgnoreCase(PortalConstant.JSON_BILLER_QUERY_STRING))
				jsonResponse = (String) request.getServletContext().getAttribute(PortalConstant.JSON_BILLER_LIST);
			else if (request.getParameter("q").equalsIgnoreCase(PortalConstant.JSON_BILLER_ONLY_QUERY_STRING))
				jsonResponse = (String) request.getServletContext().getAttribute(PortalConstant.JSON_BILLER_ONLY_LIST);
			else if(request.getParameter("q").equalsIgnoreCase(PortalConstant.JSON_SUBBILLER_QUERY_STRING))
				jsonResponse = (String) request.getServletContext().getAttribute(PortalConstant.JSON_SUBBILLER_LIST);
			else if(request.getParameter("q").equalsIgnoreCase(PortalConstant.JSON_AGGREGATOR_QUERY_STRING))
				jsonResponse = (String) request.getServletContext().getAttribute(PortalConstant.JSON_AGGREGATOR_LIST);
			else if(request.getParameter("q").equalsIgnoreCase(PortalConstant.JSON_AGGREGATOR_BILLER_QUERY_STRING))
				if(request.getParameter("q1") != null)
				{
					JSONObject jo = (JSONObject) JSON.parse((String) request.getServletContext().getAttribute(PortalConstant.JSON_AGGREGATOR_BILLER_LIST));
					JSONArray ja = (JSONArray) jo.get(request.getParameter("q1"));
					jsonResponse = ja.toString();
				}
		}

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.print(jsonResponse);
		pw.close();
	}
}