package de.carokaro.aoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        Path inputPath = Paths.get(args[0]);

        int depth = 0;
        int horizontal = 0;

        try(BufferedReader reader = Files.newBufferedReader(inputPath))
        {
            String line;
            while((line = reader.readLine()) != null)
            {
                String[] foo = line.split(" ");
                switch (foo[0])
                {
                    case "forward":
                        horizontal += Integer.parseInt(foo[1]);
                        break;
                    case "up":
                        depth -= Integer.parseInt(foo[1]);
                        break;
                    case "down":
                        depth += Integer.parseInt(foo[1]);
                        break;
                }
            }
            System.out.println("Depth: " + depth);
            System.out.println("Horizontal: " + horizontal);
            System.out.println("Product: " + depth * horizontal);
        }
        catch(IOException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
