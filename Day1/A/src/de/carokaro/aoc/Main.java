package de.carokaro.aoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {



    public static void main(String[] args) {

        String input = args[0];
        Path inputPath = Paths.get(input);

        try(BufferedReader reader = Files.newBufferedReader(inputPath))
        {
            int last = Integer.MAX_VALUE;
            int count = 0;
            String foo;
            while((foo = reader.readLine()) != null)
            {
                int cur = Integer.parseInt(foo);
                if(cur > last)
                    count++;
                last = cur;
            }
            System.out.println(count + " measurements were larger than the previous ones.");
        }
        catch (IOException e)
        {

        }
    }
}
