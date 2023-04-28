package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class MockHttpServletResponse implements HttpServletResponse {

    private final StringWriter stringWriter = new StringWriter();

    @Override
    public String toString() {
        return stringWriter.toString();
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(stringWriter);
    }

    // Implement other methods as needed
    // ...

    @Override
    public void addCookie(Cookie cookie) {

    }

    // Implement other methods as needed
    // ...

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return null;
    }

    // Implement other methods as needed
    // ...

}
