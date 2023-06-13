package T08Generics.JarOfT_01;

import T08Generics.JarOfT_01.Jar;

public class Main {
    public static void main(String[] args) {
        Jar<Integer> jar = new Jar<>();
        jar.add(12);
        jar.add(13);
        jar.add(14);

        System.out.println(jar.remove());
        System.out.println(jar.remove());

    }
}
