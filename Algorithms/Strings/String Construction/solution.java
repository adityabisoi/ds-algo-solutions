import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class solution {
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    for(int a0 = 0; a0 < n; a0++){
        String s = in.next(); //input the string
        System.out.println(s.chars().distinct().count()); //count the distinct characters in the string as copying
        // distinct characters will cost 1 dollar each
    }
}
}
