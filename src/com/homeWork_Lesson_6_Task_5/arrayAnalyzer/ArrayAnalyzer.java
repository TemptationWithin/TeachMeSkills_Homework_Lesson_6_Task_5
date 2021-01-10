package com.homeWork_Lesson_6_Task_5.arrayAnalyzer;

import com.homeWork_Lesson_6_Task_5.exceptions.WrongArrayException;

public class ArrayAnalyzer {
    public static int searcherMissElement(int[] array){
        int missedElement = 0;

        for (int i = array.length-1; i > 0; i--) {                // Bubble-sort of array
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j+1]) {
                    int buffer = array[j];
                    array[j] = array[j+1];
                    array[j+1] = buffer;
                }
            }
        }
        for (int i = array.length-1; i > 0; i--) {                      // looking for duplicates: Wrong array
            for (int j = 0; j < i; j++) {                               // (duplicates throw Exception: Wrong input array)
                if (array[j] == array[j+1]){
                    throw new WrongArrayException("Wrong input array!: " +
                            "You have duplicate elements in your array. " +
                            "This is prohibited by the condition");
                }
            }
        }
        int gapsCounter = 0;
        for (int i = 0; i < array.length-1; i++) {
            boolean isOperationImpossible = array[i+1] - array[i] > 2;     // for looking for big gaps (>2)
            boolean isOperationPossible = array[i+1] - array[i] == 2;      // for counting number of gaps (wrong if gapsCounter > 1)
            if (isOperationImpossible){
                throw new WrongArrayException("Wrong input array!: gaps should be less than 2!");
            }
            if (isOperationPossible){                                      //counting number of gaps (wrong if gapsCounter > 1)
                gapsCounter++;
                missedElement = array[i] + 1;                              // missed element detected!
            }
        }
        if (gapsCounter > 1){                                                   //checking number of gaps (wrong if gapsCounter > 1)
            throw new WrongArrayException("Wrong input array: many gaps between elements! ");
        }

        for (int i = 0; i < array.length; i++) {                            // output sort array (for checking: is result result)
            System.out.print(array[i] + " ");
        }
        System.out.println(" ");
        System.out.println("Missed element is: " + missedElement);          // output missed element

        return missedElement;
    }
}
