package sortingefficiencies;

import javax.swing.*;

public class Main {

    public static int loopCounter, comparisonCounter, shiftCounter;

    public static void main(String[] args) {
        loopCounter = 0;
        comparisonCounter = 0;
        shiftCounter = 0;
        int arraySize;
        String myInput = JOptionPane.showInputDialog("How many random numbers do you wish to generate?");
        arraySize = Integer.parseInt(myInput);

        int nums[] = new int[arraySize];
        int nums2[] = new int[arraySize];
        int nums3[] = new int[arraySize];
        int nums4[] = new int[arraySize];

        int n;
        for (int i = 0; i < arraySize; i++) {
            n = (int) (Math.random() * 1000);
            nums[i] = n;
            nums2[i] = n;
            nums3[i] = n;
            nums4[i] = n;
        }

        //Display the unsorted list
        System.out.println("The unsorted list is:");
        for (int i = 0; i < arraySize; i++) {
            System.out.println(nums[i]);
        }
        System.out.println("\n------------------------------------");

        long time = -1; //timer variable

        //Selection Sort
        System.out.println("Perfoming Selection Sort");
        time = System.currentTimeMillis();
        selectionSort(nums);
        time = System.currentTimeMillis() - time;

        System.out.println("Processing Time: " + time + "ms");
        System.out.println("loopCounter = " + loopCounter);
        System.out.println("comparisonCounter = " + comparisonCounter);
        System.out.println("shiftCounter = " + shiftCounter);
        System.out.println("\n------------------------------------");

        loopCounter = 0;
        comparisonCounter = 0;
        shiftCounter = 0;

        //Bubble Sort
        System.out.println("Performing Bubble Sort");
        time = System.currentTimeMillis();
        bubbleSort(nums2);
        time = System.currentTimeMillis() - time;

        System.out.println("Processing Time: " + time + "ms");
        System.out.println("loopCounter = " + loopCounter);
        System.out.println("comparisonCounter = " + comparisonCounter);
        System.out.println("shiftCounter = " + shiftCounter);
        System.out.println("\n------------------------------------");

        loopCounter = 0;
        comparisonCounter = 0;
        shiftCounter = 0;

        //Insertion Sort
        System.out.println("Performing Insertion Sort");
        time = System.currentTimeMillis();
        insertionSort(nums3);
        time = System.currentTimeMillis() - time;

        System.out.println("Processing Time: " + time + "ms");
        System.out.println("loopCounter = " + loopCounter);
        System.out.println("comparisonCounter = " + comparisonCounter);
        System.out.println("shiftCounter = " + shiftCounter);
        System.out.println("\n------------------------------------");

        loopCounter = 0;
        comparisonCounter = 0;
        shiftCounter = 0;

        //Quick Sort
        System.out.println("Performing Quick Sort");
        time = System.currentTimeMillis();
        quickSort(nums4, 0, nums4.length - 1);
        time = System.currentTimeMillis() - time;


        System.out.println("Processing Time: " + time + "ms");
        System.out.println("loopCounter = " + loopCounter);
        System.out.println("comparisonCounter = " + comparisonCounter);
        System.out.println("shiftCounter = " + shiftCounter);
        System.out.println("\n------------------------------------");
    }

    public static void bubbleSort(int data[]) {
        int counter;
        //Loop to control number of passes
        for (int pass = 1; pass < data.length; pass++) {
            loopCounter++;
            //Loop to control number of comparisons for length of array - 1
            for (int element = 0; element < data.length - 1; element++) {
                loopCounter++;
                //compare side-by-side elements and swap them if
                //first element is greater than second element
                comparisonCounter++;
                if (data[element] > data[element + 1]) {
                    shiftCounter++;
                    swap(data, element, element + 1);  //call to swap method
                }
            }
        }
    }

    public static void swap(int array2[], int first, int second) {
        int hold = array2[first];
        array2[first] = array2[second];
        array2[second] = hold;
    }

    public static void insertionSort(int data[]) {
        int insert;

        for (int next = 1; next < data.length; next++) {
            loopCounter++;
            insert = data[next];
            int moveItem = next;

            while (moveItem > 0 && data[moveItem - 1] > insert) {
                loopCounter++;
                shiftCounter++;
                data[moveItem] = data[moveItem - 1];
                moveItem--;
            }
            data[moveItem] = insert;
        }
    }

    public static void quickSort(int data[], int low, int high) {
        loopCounter++;
        int partitionLoc;
        comparisonCounter++;
        if (low < high) {
            partitionLoc = partition(data, low, high);
            quickSort(data, low, partitionLoc - 1);
            quickSort(data, partitionLoc + 1, high);
        }
    }

    public static int partition(int data2[], int left, int right) {
        boolean moveLeft = true;
        int separator = data2[left];

        while (left < right) {
            loopCounter++;
            comparisonCounter++;
            if (moveLeft == true) {
                while ((data2[right] >= separator) && (left < right)) {
                    loopCounter++;
                    right--;
                }
                shiftCounter++;
                data2[left] = data2[right];
                moveLeft = false;
            } else {
                while ((data2[left] <= separator) && (left < right)) {
                    loopCounter++;
                    left++;
                }
                shiftCounter++;
                data2[right] = data2[left];
                moveLeft = true;
            }
        }
        shiftCounter++;
        data2[left] = separator;
        return left;
    }

    public static void selectionSort(int data[]) {
        int smallest;
        for (int i = 0; i < data.length - 1; i++) {
            loopCounter++;
            smallest = i;
            //see if there is a smaller number further in the array
            for (int index = i + 1; index < data.length; index++) {
                loopCounter++;
                comparisonCounter++;
                if (data[index] < data[smallest]) {
                    smallest = index;
                }
            }
            shiftCounter++;
            swap(data, i, smallest); //swap the smallest element into position
        }
    }
}
