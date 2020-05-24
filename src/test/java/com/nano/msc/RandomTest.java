package com.nano.msc;

import com.nano.msc.common.converter.LocalDateTimeConverter;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class RandomTest {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] data = new int[k];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }

        Arrays.sort(data);

    }

}
