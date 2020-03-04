public class OptionalTask1 {

    public static void printArray(int[] arr) {
        if (arr.length != 1) {
            for (int i = 0; i < arr.length; i++) {
                if (i == 0) {
                    System.out.print("[" + arr[i] + ", ");
                } else if (i == arr.length - 1) {
                    System.out.println(arr[i] + "]");
                } else {
                    System.out.print(arr[i] + ", ");
                }
            }
        } else {
            System.out.println("[" + arr[0] + "]");
        }
    }
    public static void printArray(String[] arr) {
        if (arr.length != 1) {
            for (int i = 0; i < arr.length; i++) {
                if (i == 0) {
                    System.out.print("[" + arr[i] + ", ");
                } else if (i == arr.length - 1) {
                    System.out.println(arr[i] + "]");
                } else {
                    System.out.print(arr[i] + ", ");
                }
            }
        } else {
            System.out.println("[" + arr[0] + "]");
        }
    }

    public static void main(String[] args) {
        //случайное количество чисел
        int n = 1 + (int)(Math.random()*20);
		System.out.println("n = " + n);
		//создаем массивы чисел с типами int и String
        String[] strNumbers = new String[n];
        int[] intNumbers = new int[n];
        for (int i = 0; i < n; i++) {
            intNumbers[i] = (int)(Math.random()*(int)(Math.random()*10000));
            strNumbers[i] = Integer.toString(intNumbers[i]);
        }
        System.out.print("Original array ");
        printArray(intNumbers);

        //задание 1 - самое короткое и самое длинное число
        System.out.println("=====Task 1=====");
        String minLength = strNumbers[0];
        String maxLength = strNumbers[0];
        int count = 0;
        for (String element : strNumbers) {
            if (element.length() < minLength.length()) {
                minLength = element;
            } else if (element.length() > maxLength.length()) {
                maxLength = element;
            } else {
                count++;
            }
        }
        if (count != n) {
            System.out.println("The first shortest number - " + minLength + ", it's length - " + minLength.length());
            System.out.println("The first longest number - " + maxLength + ", it's length - " + maxLength.length());
        } else {
            System.out.println("All numbers have the same length - " + strNumbers[0].length());
        }

        //задание 2 - числа в порядке возрастания (убывания)
        System.out.println("=====Task 2=====");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (intNumbers[i] < intNumbers[j]) {
                    int a = intNumbers[i];
                    intNumbers[i] = intNumbers[j];
                    intNumbers[j] = a;
                }
            }
        }
        System.out.print("Increasing array ");
        printArray(intNumbers);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (intNumbers[i] > intNumbers[j]) {
                    int a = intNumbers[i];
                    intNumbers[i] = intNumbers[j];
                    intNumbers[j] = a;
                }
            }
        }
        System.out.print("Decreasing array ");
        printArray(intNumbers);

        //задание 3 - числа, длина которых меньше (больше) средней длины по всем числам
        System.out.println("=====Task 3=====");
        if (minLength != maxLength) {
            double avgLength = (double) (maxLength.length() + minLength.length())/2;
            System.out.println("Average length - " + avgLength);
            System.out.println("Numbers larger than average length: ");
            for (String element : strNumbers) {
                if (element.length() > avgLength) {
                    System.out.println(element + ", length - " + element.length());
                }
            }
        } else {
            System.out.println("All numbers have the same length - " + strNumbers[0].length());
        }

        //задание 4 - число, в котором количество различных цифр минимально
        System.out.println("=====Task 4=====");
        String hasMinDifferentDigit = strNumbers[0];
        count = 0;
        int temp = 0;
        for (String element : strNumbers) {
            for (int i = 0; i < element.length(); i++) {
                for (int j = i + 1; j < element.length(); j++) {
                    if (element.charAt(j) != element.charAt(i)) {
                        count++;
                    }
                }
            }
            if (count > temp) {
                hasMinDifferentDigit = element;
                temp = count;
            }
            count = 0;
        }
        System.out.println(hasMinDifferentDigit);

        //задание 5 - количество чисел, содержащих только четные цифры,
        //а среди оставшихся — количество чисел с равным числом четных и нечетных цифр
        System.out.println("=====Task 5=====");
        int countOnlyEvenDigits = 0;
        int countEvenOddNumbers = 0;
        int countEvenDigits = 0;
        int countOddDigits = 0;
        for (String element : strNumbers) {
            for (int i = 0; i < element.length(); i++) {
                if (Character.digit(element.charAt(i), 10) % 2 == 0) {
                    countEvenDigits++;
                } else {
                    countOddDigits++;

                }
            }
            if (countEvenDigits == element.length()) {
                countOnlyEvenDigits++;
            } else if (countEvenDigits == countOddDigits) {
                countEvenOddNumbers++;
            }
            countEvenDigits = 0;
            countOddDigits = 0;
        }
        System.out.println("Only even digits - " + countOnlyEvenDigits);
        System.out.println("Even = odd digits - " + countEvenOddNumbers);

        //задание 6 - число, цифры в котором идут в строгом порядке возрастания
        System.out.println("=====Task 6=====");
        count = 1;
        temp = 1;
        for (String element : strNumbers) {
            for (int i = 0; i < element.length() - 1; i++) {
                if (Character.digit(element.charAt(i + 1), 10) > Character.digit(element.charAt(i), 10)) {
                    count++;
                }
            }
            if (count == element.length() && element.length() != 1) {
                System.out.println(element);
                temp = count;
                break;
            }
            count = 1;
        }
        if (temp == 1) {
            System.out.println("There is no required number.");
        }

        //задание 7 - число, состоящее только из различных цифр
        System.out.println("=====Task 7=====");
        count = 0;
        temp = 1;
        for (String element : strNumbers) {
            for (int i = 0; i < element.length(); i++) {
                for (int j = i + 1; j < element.length(); j++) {
                    if (element.charAt(j) == element.charAt(i)) {
                        count++;
                    }
                }
            }
            if (count == 0) {
                System.out.println(element);
                temp = count;
                break;
            }
            count = 0;
        }
        if (temp != 0) {
            System.out.println("There is no required number.");
        }


    }
}
