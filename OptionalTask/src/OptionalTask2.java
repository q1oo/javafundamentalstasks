import java.util.Random;

public class OptionalTask2 {

    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + "    ");
            }
            System.out.println();
        }
    }

    public static int[][] cloneArray(int[][] arr) {
        int[][] newArray = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                newArray[i][j] = arr[i][j];
            }
        }
        return newArray;
    }

    public static void main(String[] args) {
        int n = 4;//(int) (Math.random()*11);
        System.out.println("n = " + n);
        int[][] originalArray = new int[n][n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                originalArray[i][j] = -100 + random.nextInt(200);
            }
        }
        System.out.println("Original array:");
        printArray(originalArray);

        //задание 1 - Упорядочить строки (столбцы) матрицы в порядке возрастания
        // значений элементов k-го столбца (строки)
        System.out.println("=====Task 1=====");
        int[][] arrSortedLines = cloneArray(originalArray);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n - 1; k++) {
                    if (arrSortedLines[j][k] > arrSortedLines[j][k + 1]) {
                        int a = arrSortedLines[j][k];
                        arrSortedLines[j][k] = arrSortedLines[j][k + 1];
                        arrSortedLines[j][k + 1] = a;
                    }
                }
            }
        }
        System.out.println("Array with sorted lines:");
        printArray(arrSortedLines);

        int[][] arrSortedColumns = cloneArray(originalArray);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n - 1; k++) {
                    if (arrSortedColumns[k][j] > arrSortedColumns[k + 1][j]) {
                        int a = arrSortedColumns[k][j];
                        arrSortedColumns[k][j] = arrSortedColumns[k + 1][j];
                        arrSortedColumns[k + 1][j] = a;
                    }
                }
            }
        }
        System.out.println("Array with sorted columns:");
        printArray(arrSortedColumns);

        //задание 2 - Найти и вывести наибольшее число возрастающих (убывающих)
        // элементов матрицы, идущих подряд
        System.out.println("=====Task 2=====");
        int[] arrMaxElements = new int [n];
        int count = 0;
        int tempInLine = 0;
        int tempLine = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (originalArray[i][j + 1] > originalArray[i][j]) {
                    count++;
                } else if (j == n - 1) {
                    if (count > tempInLine) {
                        tempInLine = count;
                        count = 0;
                        index = j - count;
                    }
                } else {
                    if (count > tempInLine) {
                        tempInLine = count;
                        count = 0;
                        index = j - count;
                    }
                }
            }
            if (tempInLine > tempLine) {
                for (int j = index; j < tempInLine + 1; j++) {
                    arrMaxElements[j] = originalArray[i][j];
                    System.out.print(arrMaxElements[j] + " ");
                }
            }
        }




    }
}