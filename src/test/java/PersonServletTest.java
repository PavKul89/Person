package com.example;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.PrintWriter;

import static org.mockito.Mockito.*;

class PersonServletTest {

    // Внутренний класс Person, чтобы тесты работали
    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    private com.example.PersonServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private PrintWriter writer;

    @BeforeEach
    void setUp() {
        servlet = new com.example.PersonServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        writer = mock(PrintWriter.class);
    }


    @Test
    void testContentType() throws IOException {
        // Настройка моков
        when(response.getWriter()).thenReturn(writer);

        // Вызов метода doGet
        servlet.doGet(request, response);

        // Проверка, что тип контента был установлен на application/json
        verify(response).setContentType("application/json");
    }

    @Test
    void testCharacterEncoding() throws IOException {
        // Настройка моков
        when(response.getWriter()).thenReturn(writer);

        // Вызов метода doGet
        servlet.doGet(request, response);

        // Проверка, что кодировка была установлена на UTF-8
        verify(response).setCharacterEncoding("UTF-8");
    }
}
