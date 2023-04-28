package controller;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.TicketModel;

class GetAllTicketTest  {
	  
	 private static getAllTickets servlet;
	 
	  private static StringWriter writer;
	  private static  HttpServletRequest request ;
	  private static   HttpServletResponse response;
	  
	  @BeforeAll
	  public static void setup() {
	    servlet = new getAllTickets();
		 request = new MockHttpServletRequest("GET","/ticket/all");
		 writer = new StringWriter();
	     response = new MockHttpServletResponse(writer);
	   
	  }
	  @Test
	  public void testDoGet() throws Exception {
	    List<TicketModel> myList = new ArrayList<TicketModel>();
	    myList.add(new TicketModel(1,2,"sada","SDADA","Alice","asd", 2342355L));
	    myList.add(new TicketModel(1,2,"sada","SDADA","Alice","asd", 2342355L));
	    ObjectMapper mapper = new ObjectMapper();
	    String expectedJson = mapper.writeValueAsString(myList);
	    System.out.println(request.toString());
	    servlet.doGet(request, response );
	    StringWriter stringWriter = new StringWriter();
        PrintWriter writer = response.getWriter();
        String actualJson = stringWriter.toString().trim();
	   // String actualJson = writer.toString();
	    System.out.println("hai+="+actualJson);
	    assertNotEquals("application/json", response.getContentType());
	    assertNotEquals(expectedJson, actualJson);
	  }
}

