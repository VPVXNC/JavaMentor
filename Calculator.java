package sample;

import java.util.Scanner;

class Calculator {

    static Scanner scanner = new Scanner(System.in);

    static String[] input () {
        System.out.println("Введите выражение:");
        String s = scanner.nextLine();
        s = s.trim();
        s = s.replaceAll(" +", " ");
        s = s.toUpperCase();
        String[] exp = s.split(" ");
        if (exp.length > 3) throw new ArrayIndexOutOfBoundsException("Неверное выражение: "+(s));
        return exp;
    }

    public static void main(String[] args) {
        String[] inp = input();
        try {
            int number1 = Translator.romanToArabic(inp[0]);
            int number2 = Translator.romanToArabic(inp[2]);
            int result = operation(number1, inp[1], number2);
            if (result < 0) System.out.printf("Ответ:\n-%s", Translator.arabToRoman(result));
            else if (result == 0) System.out.printf("Output:\n0");
            else System.out.printf("Ответ:\n%s", Translator.arabToRoman(result));
        } catch (IllegalStateException exception) {
            int number1 = Integer.parseInt(inp[0]);
            int number2 = Integer.parseInt(inp[2]);
            int result = operation(number1, inp[1], number2);
            System.out.printf("Ответ:\n%d", result);
        }
    }

    static int operation(int number1, String expression, int number2) {
        int result;
        if ((number1 < 1) || (number1 > 10)) throw new IllegalStateException("Введенное значение не может быть меньше 1 или больше 10: "+(number1));
        if ((number2 < 1) || (number2 > 10)) throw new IllegalStateException("Введенное значение не может быть меньше 1 или больше 10: "+(number2));
        switch (expression) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    result = number1 / number2;
                    break;
                default:
                    throw new IllegalArgumentException("Неверная операция: "+(expression));
            }
            return result;
        }
    }