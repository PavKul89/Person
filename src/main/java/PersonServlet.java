package com.example;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

@WebServlet("/person")
public class PersonServlet extends HttpServlet {

    // Простой класс, который мы будем сериализовать в JSON
    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Геттеры и сеттеры
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Создаем объект Person
        Person person = new Person("John Doe", 30);

        // Создаем ObjectMapper для конвертации объекта в JSON
        ObjectMapper objectMapper = new ObjectMapper();

        // Устанавливаем тип контента на JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Сериализуем объект Person в JSON и записываем его в ответ
        objectMapper.writeValue(response.getWriter(), person);
    }
}

