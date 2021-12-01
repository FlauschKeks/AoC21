package de.carokaro.aoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        String input = args[0];
        Path inputPath = Paths.get(input);

        try(BufferedReader reader = Files.newBufferedReader(inputPath))
        {
            int last = Integer.MAX_VALUE;
            int count = 0;

            SlidingWindow<Integer> slidingWindow = new SlidingWindow<>(3, new ArrayDeque<>());
            String currentLine;
            while((currentLine = reader.readLine()) != null)
            {
                int currentValue = Integer.parseInt(currentLine);
                slidingWindow.push(currentValue);

                if(!slidingWindow.isFull())
                    continue;

                Iterator<Integer> i = slidingWindow.iterator();
                int sum = 0;
                while(i.hasNext())
                {
                    sum += i.next();
                }

                if(last < sum)
                    count++;
                last = sum;

            }
            System.out.println(count + " measurements were larger than the previous ones.");
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
