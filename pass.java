import java.util.Scanner;

public class pass {

    public static void main(String[] args) {
        String pass_book;
        /*
         * try (Scanner scanner = new Scanner(System.in)) {
         * int a = scanner.nextInt();
         * int b = scanner.nextInt();
         * int c = scanner.nextInt();
         * int d = scanner.nextInt();
         * pass_book = seed(a, b, c, d);
         * }
         */
        for(int i=0;i<10;i++)
        {
            pass_book = seed(1001+11*i, 7+i, 51+i, 20);
            System.out.println(pass_book);
        }
    }

    // 自定义随机密码本
    public static String seed(int mod, int num, int radix, int times) {
        long seed = 1;
        String book = "";
        String l_str;
        for (int i = 0; i < times; i++) {
            seed = (radix * seed + num) % mod;
            l_str = String.valueOf(seed);
            book = book + l_str;
        }
        String[] ar = string_cut(book, 2);
        int[] cstr = new int[ar.length];
        for (int i = 0; i < ar.length; i++) {
            cstr[i] = Integer.valueOf(ar[i]).intValue();
        }
        book = book(cstr);
        return book;
    }

    // 自定义字符分割
    public static String[] string_cut(String n, int l) {
        StringBuilder str = new StringBuilder();
        str.append(n);
        int m = 0;
        for (int i = 1; i + m < str.length(); i++) {
            if (i % l == 0) {
                str.insert(i + m, ",");
                m++;
            }
        }
        String se = str.toString();
        String[] a = se.split(",");
        return a;
    }

    // 基本密码本
    public static String book(int[] pass) {
        String cstr_l = "";
        String book = "23456789abcdefghkmnpqrstuvwxyzABCDEFGHKMNPQRSTUVWXYZ"; // 0oO1ijlIJL
        String[] array = book.split("");
        for (int i = 0; i < pass.length; i++) {
            cstr_l = cstr_l + array[pass[i] % 52];
        }
        return cstr_l;
    }

}
