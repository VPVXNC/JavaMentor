package sample;

public class Translator {

        public static void main(String[] args) {
            //Проверка работы
            printSolveOfSum("X + X");
            printSolveOfSum("10 + 10");
        }

        static void printSolveOfSum(String equation) {
            String romPat = "IVX";
            if (romPat.indexOf(equation.charAt(0)) != -1)
                System.out.println(getSolveRomanianNumsSum(equation.split("\\+")));
            else System.out.println(getSolveArabicNumsSum(equation.split("\\+")));
        }

        private static int getSolveArabicNumsSum(String [] nums) {
            return Integer.valueOf(nums[0].trim()) + Integer.valueOf(nums[1].trim());
        }

        private static String getSolveRomanianNumsSum(String [] nums) {
            return arabToRoman(romanToArabic(nums[0].trim()) + romanToArabic(nums[1].trim()));
        }

        public static String arabToRoman(int num) {
            String c[] = {"", "C"};
            String x[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
            String i[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
            String hundereds = c[(num % 1000) / 100];
            String tens = x[(num % 100) / 10];
            String ones = i[num % 10];
            return hundereds + tens + ones;
        }

        private static int value(char r) {
            if (r == 'I')
                return 1;
            if (r == 'V')
                return 5;
            if (r == 'X')
                return 10;
            if (r == 'L')
                return 50;
            if (r == 'C')
                return 100;
            return -1;
        }

        public static int romanToArabic(String str) {
            int res = 0;
            for (int i = 0; i < str.length(); i++) {
                int s1 = value(str.charAt(i));
                if (s1 < 1) throw new IllegalStateException("Введенное значение не может быть меньше I" +(s1));
                if (i + 1 < str.length()) {
                    int s2 = value(str.charAt(i + 1));
                    if (s2 < 1) throw new IllegalStateException("Введенное значение не может быть меньше I" +(s2));
                    if (s1 >= s2) {
                        res = res + s1;
                    } else {
                        res = res + s2 - s1;
                        i++;
                    }
                } else {
                    res = res + s1;
                    i++;
                }
            }
            return res;
        }
    }