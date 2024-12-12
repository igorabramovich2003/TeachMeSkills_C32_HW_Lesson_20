package com.teachmeskills.lesson_20.task_1;

import com.teachmeskills.lesson_20.task_1.model.MorningTask;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Task 1
 * 1. Create a program that simulates the morning: reading the news, tomorrow, coffee.
 * Set each thread a name and priority from the config file.
 * Let there be 3 threads.
 * Create and run 3 threads.
 * Make two options: using the Runnable interface and/or using the Thread class.
 */
public class ApplicationRunner {
    public static void main(String[] args) {
        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream("src/com/teachmeskills/lesson_20/task_1/resources/config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            System.err.println("Error loading configuration: " + e.getMessage());
            return;
        }

        Thread newsThread = new Thread(new MorningTask(properties.getProperty("thread1.name"),
                Integer.parseInt(properties.getProperty("thread1.priority")))
        );
        Thread breakfastThread = new Thread(new MorningTask(properties.getProperty("thread2.name"),
                Integer.parseInt(properties.getProperty("thread2.priority")))
        );
        Thread coffeeThread = new Thread(new MorningTask(properties.getProperty("thread3.name"),
                Integer.parseInt(properties.getProperty("thread3.priority")))
        );

        newsThread.setPriority(newsThread.getPriority());
        breakfastThread.setPriority(breakfastThread.getPriority());
        coffeeThread.setPriority(coffeeThread.getPriority());

        newsThread.start();
        breakfastThread.start();
        coffeeThread.start();

        try {
            newsThread.join();
            breakfastThread.join();
            coffeeThread.join();
        } catch (InterruptedException e) {
            System.out.println("The current flow has been interrupted." + e.getMessage());
        }
    }
}
