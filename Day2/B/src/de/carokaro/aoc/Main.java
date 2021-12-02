package de.carokaro.aoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args)
    {
        Path inputPath = Paths.get(args[0]);

        int aim = 0;
        int horizontal = 0;
        int depth = 0;

        try (BufferedReader reader = Files.newBufferedReader(inputPath))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] foo = line.split(" ");
                switch (foo[0])
                {
                    case "forward":
                        int displacement = Integer.parseInt(foo[1]);
                        horizontal += displacement;
                        depth += displacement * aim;
                        break;
                    case "up":
                        aim -= Integer.parseInt(foo[1]);
                        break;
                    case "down":
                        aim += Integer.parseInt(foo[1]);
                        break;
                }
            }
            System.out.println("Depth: " + depth);
            System.out.println("Horizontal: " + horizontal);
            System.out.println("Product: " + depth * horizontal);
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
