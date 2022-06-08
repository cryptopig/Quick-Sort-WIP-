import java.util.Random;

public class quickSort {
    // This part is just making an array of random integers.

    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before: ");
        printArray(numbers);

        quicksort(numbers, 0, numbers.length - 1);

        System.out.println("\nAfter: ");
        printArray(numbers);
    }


    /* To partition the array, there is a low index consisting of the lower values and a high index that consists of the higher values.
       If one wants the entire array to be sorted, the low index would be 0, and the high index would be the last number, so array.length - 1.
     */
    private static void quicksort(int[] array, int lowIndex, int highIndex) {
        /* This is the first step to the quick sort method, which is defining the pivot. Since this is recursive and splits the array,
        the pivot is chosen from the high index or the low index instead of from the whole array.
        */
        if (lowIndex >= highIndex) {
            return;
        }

        int pivot = array[highIndex];

        // Now is the second step, which is the partitioning (moving numbers < pivot left and numbers > pivot right). The variables define the left and right pointers.
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        // The loop below repeats the sorting until the pointers hit each other.
        while (leftPointer < rightPointer) {
             // Here, the program wants to find a number higher than the pivot or the right pointer. If it doesn't, it increments the leftPointer by one.
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            // The right pointer is incremented with a -- because it goes in the negative direction.
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(array, leftPointer, rightPointer);
        }
        // This swap triggers when left pointer and right pointer meet. Instead of the pivot variable, highIndex is used because the pivot will always be the highIndex.
        swap(array, leftPointer, highIndex);
        // At this point, the partitioning is done, and the pivot is where it should be. Now, all that's left is the recursive part for both the right and left parts.

        // Since the low index is already set at the lowest number of the lowest section, that doesn't need to be changed; but the high index does.
        quicksort(array, lowIndex, leftPointer - 1);
        // Now, the right partition will be recursively quick sorted.
        quicksort(array, leftPointer + 1, highIndex);


    }
    // This is a method for swapping values in the array, since swapping is going to be done in multiple places.
    private static void swap(int array[], int index1, int index2) {
        // Temporary variable to store the value of index1 before being set to index2.
        int temp = array[index1];
        array[index1] = index2;
        array[index2] = temp;
    }

    private static void printArray(int[] numbers) {
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
