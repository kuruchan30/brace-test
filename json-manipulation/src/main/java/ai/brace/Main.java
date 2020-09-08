package ai.brace;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.google.gson.Gson;

public class Main
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
        System.out.println("Hello, world.");
        System.out.println("TASK 1:");
        System.out.println("");
        try {
        	Gson gson = new Gson();
        	Reader reader = Files.newBufferedReader(getPathForResource("a1.json"));

            AObject aObj = gson.fromJson(reader, AObject.class);
            Collections.sort(aObj.getTextArray(), Comparator.comparingInt(TextObj::getId));
            
            for (TextObj data : aObj.getTextArray()) {
            	System.out.println(data.getTextdata());
            }
            
            reader.close();
            
            System.out.println("");
            System.out.println("TASK 2:");
            System.out.println("");
            
            reader = Files.newBufferedReader(getPathForResource("a2.json"));
            AObject aObj2 = gson.fromJson(reader, AObject.class);
            Collections.sort(aObj2.getTextArray(), Comparator.comparingInt(TextObj::getId));
            
            ArrayList<TextObj> textObjs = new ArrayList<>();
            textObjs.addAll(aObj.getTextArray());
            textObjs.addAll(aObj2.getTextArray());
            
            for (TextObj data : textObjs) {
            	System.out.println(data.getTextdata());
            }
            
            reader.close();
            
        } catch (IOException ex)
        {
            throw new RuntimeException(ex);
        }
    }
}
