package lesson6;

public class Homework {

    public static void main(String[] args) {

        System.out.println("Код буквы а - " + (int) 'а');
        System.out.println("Код буквы б - " + (int) 'б');
        System.out.println("Код буквы в - " + (int) 'в');
        System.out.println("Код буквы я - " + (int) 'я');
        System.out.println("Код буквы ё - " + (int) 'ё');

        buildDictionary("У лукоморья дуб зеленый;\n" +
                "Златая цепь на дубе том:\n" +
                "И днем и ночью кот ученый\n" +
                "Все ходит по цепи кругом;");
    }

    public static void buildDictionary(String text) {
        System.out.println(text);
        text = text.toLowerCase();

        int[] result = new int['я' - 'а' + 1];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'а' && ch <= 'я') {
                result[ch - 'а']++;
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println((char) (i + 'а') + " = " + result[i]);
        }
    }
}