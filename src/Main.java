import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Scanner input = null;
        List<Apartment> list1 = new ArrayList<>();
        Map<String, Integer> cityApCounter = new HashMap<>();
        Set<String> cities = new HashSet<>();
        cities.add("Sofia"); cities.add("Plovdiv"); cities.add("Varna");
        List<Map.Entry<String, Integer>> list = new ArrayList<>(cityApCounter.entrySet());

        list.sort(Map.Entry.comparingByValue());
        try {
            Path resource = Paths.get("src", "resources");
            String absolutepath = resource.toFile().getAbsolutePath();
            File file = new File(absolutepath + "/testData_Apartments.txt");
            input = new Scanner(file);

            while (input.hasNext()) {
                String city = input.next();
                int numOfRooms = input.nextInt();
                int areaOfAp = input.nextInt();
                int price= input.nextInt();
                String telephone  = input.next();
                Apartment a =new Apartment(city,numOfRooms,areaOfAp,price,telephone);

                if (areaOfAp >= 100 || numOfRooms==3 || price<=30000 ||  !cities.contains(city)) {
                    list1.add(a);
                    continue;
                }

                if(!cityApCounter.containsKey(city)) {
                    cityApCounter.put(city, 1);
                } else {
                    cityApCounter.put(city,cityApCounter.get(city)+1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            assert input != null;
            input.close();
        }

        cityApCounter = sortByValue(cityApCounter);

        File file2 = new File("output.txt");
        if (file2.exists()) {
            System.out.println("File already exists");
            System.exit(1);
        }
        PrintWriter output = null;

        try {
            output = new PrintWriter(file2);

            int i = 1;
            for(String telephone : cityApCounter.keySet()) {
                if (i == 3) break;
                i++;
                output.print(telephone + ": ");
                for(String el : list.get(telephone)) {
                    output.print(el + " ");
                }
                output.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            assert output != null;
            output.close();
        }
    }

    private static HashMap<String, Integer> sortByValue(Map<String, Integer> hm)
    {
        List<Map.Entry<String, Integer> > list =
                new LinkedList<>(hm.entrySet());

        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> el : list) {
            temp.put(el.getKey(), el.getValue());
        }
        return temp;
    }
}


