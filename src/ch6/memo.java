package ch6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class memo {

	public static void main(String[] args) {
        int i = 2;

        while (i <= 9) {
            int n = 1;

            while (n <= 9) {
                System.out.printf("%d\t",i * n);
                n++;
            }

            System.out.println();
            i++;
        }
	}
}
