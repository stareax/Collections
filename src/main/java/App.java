import list.CustomArrayList;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        CustomArrayList<String> list = new CustomArrayList<>();
        ArrayList arrayList;
        list.add("one");
        list.add("two");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        list.add("eight");
        list.add("nine");
        list.add("ten");
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        list.remove(5);
        System.out.println(list);
        list.remove(7);
        System.out.println(list);
        System.out.println(list.contains("four"));
        System.out.println(list.contains("eleven"));
        System.out.println(list.get(3));

    }

}
