package org;

import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.RefreshableKeycloakSecurityContext;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

// Extend HttpServlet class
public class HelloWorld extends HttpServlet {

    private String message;

    public void init() throws ServletException {
        // Do required initialization
        message = "Hello World";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        RefreshableKeycloakSecurityContext keycloakSecurityContext = (RefreshableKeycloakSecurityContext ) request.getAttribute(KeycloakSecurityContext.class.getName());

        out.println("<h1>" + keycloakSecurityContext.getTokenString() + "</h1>");
    }

    public void destroy() {
        // do nothing.
    }
}
