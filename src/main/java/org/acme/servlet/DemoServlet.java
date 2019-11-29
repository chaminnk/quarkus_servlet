package org.acme.servlet;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(urlPatterns = {"/welcome"})
public class DemoServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputStream stream = null;
        try {
            stream = request.getInputStream();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY, true);
            JsonParser parser = new JsonFactory(objectMapper).createParser(stream);
            final JsonNode tree = parser.getCodec().readTree(parser);
            if (tree == null || !tree.isObject()) {
                throw new ServletException("Invalid JSON syntax.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}