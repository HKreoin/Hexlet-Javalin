package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        // Описываем, что загрузится по адресу /
        app.get("/hello", ctx -> ctx.result("Hello " + ctx.queryParamAsClass("name", String.class).getOrDefault("World") + "!"));
        app.get("users/{id}/post/{postId}", ctx -> {
            ctx.result("id: " + ctx.pathParam("id") + " postId: " + ctx.pathParam("postId"));
        });
        app.start(7070); // Стартуем веб-сервер
    }
}
