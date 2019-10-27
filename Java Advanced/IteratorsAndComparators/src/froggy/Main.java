package froggy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lake lake = new Lake(Arrays.stream(scanner.nextLine()
                .split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
        List<Integer> result = lake.getResult();
        List<String> toStr = result.stream().map(e -> String.valueOf(e)).collect(Collectors.toList());
        System.out.println(String.join(", ",toStr));


    }
}
