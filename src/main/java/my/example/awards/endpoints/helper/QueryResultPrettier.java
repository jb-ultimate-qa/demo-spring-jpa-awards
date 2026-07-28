package my.example.awards.endpoints.helper;

import java.util.List;

import static java.lang.System.out;

public class QueryResultPrettier {

    public static <T> String concatenateObjects(List<T> objects){
        if (objects.isEmpty()) return "";

        StringBuilder result = new StringBuilder();
        for (T item:objects){
            result.append(item.toString());
            result.append("\n");
        }
        return result.toString();
    }


    public static <T> String concatenateObjects(Iterable<T> objects){
        StringBuilder result = new StringBuilder();
        for (T item:objects){
            result.append(item.toString());
            result.append("\n");
        }
        return result.toString();
    }

    public static <T> void printObjects(List<T> objects){
        out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        if (objects.isEmpty()) out.println("~~~nothing~~~");
        else
            for (T item:objects){
                out.println(item.toString());
            }
    }
}
