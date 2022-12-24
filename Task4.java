import java.util.*;


public class Task4 {
    public static void main(String[] args) {

        System.out.println("1. besiEssay: ");
        List list = besiEssay(10, 7, "hello my name is Bessie and this is my essay");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("2. spliter: " + spliter("((()))(())()()(()())"));
        System.out.println("3.1 toCamelCase: " + toCamelCase("hello_edabit"));
        System.out.println("3.2 toSnakeCase: " + toSnakeCase("helloEdabit"));
        System.out.println("4. overTime: " + overTime(new double[] {13.25, 15, 30, 1.5}));
        System.out.println("5. BMI: " + BMI("205 pounds", "73 inches"));
        System.out.println("6. bugger: " + bugger(39));
        System.out.println("7. toStarShothand: " + toStarShothand("abbccc"));
        System.out.println("8. doesRhyme: " + doesRhyme("Sam I am!", "Green eggs and ham"));
        System.out.println("9. trouble: " + trouble(45192777L, 41177722899L));
        System.out.println("10. countUniqueBooks: " + countUniqueBooks("$aa$bbcatt$c$$b$", '$'));
    }
    // 1. Метод, который форматирует строку из n слов в набор строк длины <=k
    public static List besiEssay(int n, int k, String line) {
        List<String> list = new ArrayList<String>();
        String[] lineA = line.split(" ");
        int count = 0;
        String str = "";
        for (int i = 0; i < lineA.length; i++) {
            String arrWord = lineA[i];
            count += arrWord.length();
            if (count <= k) {
                str = str + arrWord + " ";
            } else {
                list.add(str);
                str = arrWord + " ";
                count = arrWord.length();
                if (i == lineA.length - 1) {
                    list.add(str);
                }
            }
        }
        return list;
    }
    // 2. группировка строки в кластер скобок
    public static List spliter(String line) {
        int count1 = 0;
        int count2 = 0;
        String str = "";
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(' && count2 <= count1) {
                count1 ++;
                str += String.valueOf(line.charAt(i));
            } else if (line.charAt(i) == ')' && count1 > count2) {
                count2 ++;
                str += String.valueOf(line.charAt(i));
                if (count2 == count1) {
                    list.add(str);
                    str = "";
                    count2 = 0;
                    count1 = 0;
                }
            }
        }
        return list;
    }

    // 3. перевод строк в записи с пробелами из записей без них и наоборот.
    public static String toCamelCase(String line) {
        String[] lineArray = line.split("_");
        String strLine = lineArray[0];
        for (int i = 1; i < lineArray.length; i++) {
            String strArray = lineArray[i];
            char ch = strArray.charAt(0);
            String sch = String.valueOf(ch);
            sch = sch.toUpperCase();
            strLine = strLine + sch + strArray.substring(1);
        }
        return strLine;
    }

    public static String toSnakeCase(String line) {
        String lowerLine = line.toLowerCase();
        String result = "";
        for (int i = 0; i < line.length(); i++) {
            if (line.regionMatches(false, i, lowerLine, i, 1)) {
                char ch = line.charAt(i);
                result += String.valueOf(ch);
            } else {
                char ch = line.charAt(i);
                String sch = String.valueOf(ch);
                sch = sch.toLowerCase();
                result = result + "_" + sch;
            }
        }
        return result;
    }
    // 4. Заработная плата с учетом переработок
    public static String overTime(double[] array) {
        String result;

        if (array[0] >= 9 && array[1] <= 17) {
            double pay = (array[1] - array[0])*array[2];
            String payS = String.format("%.1f", pay);
            result = "$" + payS + "0";
        } else {
            double pay = (17-array[0])*array[2]+(array[1]-17)*array[2]*array[3];
            String payS = String.format("%.1f", pay);
            result = "$" + payS + "0";
        }
        return result;
    }
    // 5 индекс массы тела
    public static String BMI(String weight, String height) {
        String[] weightA = weight.split(" ");
        String[] heightA = height.split(" ");
        double we = Integer.valueOf(weightA[0]);
        double he = Integer.valueOf(heightA[0]);
        if (weightA[1].equals("pounds")) {
            we *= 0.45359237;
        }
        if (heightA[1].equals("inches")) {
            he *= 0.0254;
        }
        double bim = we / (he*he);
        if (bim < 18.5) {
            String bimS = String.format("%.1f", bim);
            return bimS + " Underweight";
        } else if (bim >= 18.5 && bim <= 24.9) {
            String bimS = String.format("%.1f", bim);
            return bimS + " Normal weight";
        } else {
            String bimS = String.format("%.1f", bim);
            return bimS + " Overweight";
        }
    }
    // 6 мультипликативное постоянство
    public static int bugger(int numb) {
        String numbS = String.valueOf(numb);
        int count = 0;
        int summ = 1;
        while (numbS.length() > 1) {
            for (int i = 0; i < numbS.length(); i++) {
                summ = summ * (numb % 10);
                numb /= 10;
            }
            numb = summ;
            numbS = String.valueOf(numb);
            summ = 1;
            count++;
        }
        return count;
    }
    // 7 звездная стенография
    public static String toStarShothand(String line) {
        int count = 1;
        String result = "";
        if (line.length() == 1) {
            result = line;
        } else {
            line = line + " ";
            for (int i = 0; i < line.length(); i++) {
                if (line.regionMatches(false, i, line, i+1, 1)){
                    count++;
                } else {
                    if (count == 1) {
                        char ch = line.charAt(i);
                        result += String.valueOf(ch);
                    } else {
                        char ch = line.charAt(i);
                        result = result + String.valueOf(ch) + "*" + String.valueOf(count);
                        count = 1;
                    }
                }
            }
        }
        return result;
    }
    // 8. рифмованные строки
    public static boolean doesRhyme(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        String[] arr1 = str1.split(" ");
        String[] arr2 = str2.split(" ");
        str1 = arr1[arr1.length-1];
        str2 = arr2[arr2.length-1];
        String vowels = "aeyiou";
        boolean flag = true;
        for (int i = 0; i < str1.length(); i++) {
            if (vowels.indexOf(str1.charAt(i)) != -1) {
                if (str2.indexOf(str1.charAt(i)) == -1) {
                    flag = false;
                }
            }
        }
        for (int i = 0; i < str2.length(); i++) {
            if (vowels.indexOf(str2.charAt(i)) != -1) {
                if (str1.indexOf(str2.charAt(i)) == -1) {
                    flag = false;
                }
            }
        }
        return flag;
    }
    // 9. три подряд в одном и два подряд в другом
    public static boolean trouble (long first, long second) {
        String firstS = String.valueOf(first);
        String secondS = String.valueOf(second);
        boolean flag = false;
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < firstS.length()-2; i++) {
            if (firstS.charAt(i) == firstS.charAt(i+1) && firstS.charAt(i) == firstS.charAt(i+2)) {
                String str = String.valueOf(firstS.charAt(i)) + String.valueOf(firstS.charAt(i));
                list.add(str);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            String next = list.get(i);
            if (secondS.indexOf(next) != -1) {
                flag = true;
            }
        }
        return flag;
    }
    // 10. уникальные книги между граничными элементами
    public static int countUniqueBooks(String books, char ch) {
        String chS = String.valueOf(ch);
        List<String> list = new ArrayList<String>();
        List<String> listWord = new ArrayList<String>(); // список для "слов" в промежутках между заданными символами
        int count = 0;
        for (int i = 0; i < books.length(); i++) {
            list.add(String.valueOf(books.charAt(i)));
        } // получаем список из элементов начальной строки
        list.add(" ");
        String word = "";
        boolean flag = false;
        // добавление в новый лист исключительно "слова", заключенные между граничными элементами
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i).equals(chS)) {
                if (list.get(i+1).equals(chS)) {
                    flag = false;
                    i++;
                } else {
                    flag = true;
                    continue;
                }
            }  else if (flag){
                if (list.get(i+1).equals(chS)) {
                    word += list.get(i);
                    listWord.add(word);
                    flag = false;
                    word = "";
                    count++;
                    i++;
                    continue;
                } else {
                    word += list.get(i);
                    count++;
                    continue;
                }
            }
        }
        for (int i = 0; i < listWord.size(); i++) {
            String newWord = listWord.get(i);
            if (newWord.length() == 1) {
                continue;
            }
            for (int k = 0; k < newWord.length()-1; k++) {
                int j = k;
                while (j < newWord.length()-1) {
                    j += 1;
                    if (newWord.charAt(k) == newWord.charAt(j)){
                        count -= 1;
                        break;
                    }
                }
            }
        }
        return count;
    }

}