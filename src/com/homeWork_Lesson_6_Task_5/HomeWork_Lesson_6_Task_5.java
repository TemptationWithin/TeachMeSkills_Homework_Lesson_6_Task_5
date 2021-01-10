package com.homeWork_Lesson_6_Task_5;

import com.homeWork_Lesson_6_Task_5.arrayAnalyzer.ArrayAnalyzer;
import com.homeWork_Lesson_6_Task_5.exceptions.WrongArrayException;

import java.util.Scanner;
/**
 *ЗАДАНИЕ 5
 * 	Написать метод, который возвращает пропущенное число в массиве.
 * 	На вход метод будет принимать массив целых чисел, числа будут отличаться на 1. массив может быть не отсортирован.
 * 	Например, массив 1,4,2,5 -> пропущенно число 3
 *
 * 	Что практикуем в этом задании:
 * 		- построение алгоритмов
 * 		- управляющие конструкции, операции ветвления
 */
public class HomeWork_Lesson_6_Task_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);           // scanner opened
        System.out.println("Press a size of array (>1): ");
        int size = scanner.nextInt();

        if (size < 2){                                      // no gaps with size array = 1
            throw new WrongArrayException("Wrong input array!");
        }
        int[] array = new int[size];                        // array created

        System.out.println("Press a number: ");
        for (int i = 0; i < array.length; i++) {            // array initialized
            array[i] = scanner.nextInt();
        }

        scanner.close();                                    // scanner closed
        ArrayAnalyzer.searcherMissElement(array);
    }
}
