package ai.brace;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class EmployeeProcessor
{
    public static Path getPathForResource(final String path)
    {
        try
        {
            return Paths.get(ClassLoader.getSystemResource(path).toURI());
        }
        catch (URISyntaxException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args)
    {
    	/**
    	 * Change the Key type of the map to String then change the implementation on how count the duplicates by using 
    	 * first name, middle initial and last name.
    	 * 
    	 * The reason it has duplicates output because of the hashcode of each object if we are object type Employee.
    	 * I used String so that we can generate the right hashcode unique for first name, middle initial and last name.
    	 */
        final Map<String, Integer> duplicateCount = new HashMap<>();

        try (Stream<String> stream = Files.lines(getPathForResource("employees.csv")))
        {
            stream.forEach(line -> {
                final String[] elements = line.split(",");
                final Employee emp = new Employee(elements[0], elements[1], elements[2], elements[3]);
                duplicateCount.put(emp.firstName + " " + emp.middleInitial + " " + emp.lastName, 
                		duplicateCount.getOrDefault(emp.firstName + " " + emp.middleInitial + " " + emp.lastName, 0) + 1);
            });
        }
        catch (IOException ex)
        {
            throw new RuntimeException(ex);
        }

        for (Map.Entry<String, Integer> entry : duplicateCount.entrySet())
        {
            final String emp = entry.getKey();
            System.out.println(emp + ": " + entry.getValue());
        }
    }
}
