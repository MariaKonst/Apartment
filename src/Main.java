import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

public class Main {



    public static void main(String[] args) {
        Path resourceDirectory= Paths.get("src");
        String absolutePath=resourceDirectory.toFile().getAbsolutePath();
        File f1=new File(absolutePath+ "/resources/testData_Apartments.txt");
        Scanner sc=null;
        List<Apartment> ap=new ArrayList<>();
        Map<String,Integer> numApartments=new HashMap<>();
        Set<String> brokers=new HashSet<>();


        try{
            sc=new Scanner(f1);
            while(sc.hasNext()){
                String city=sc.next();
                int  rooms=sc.nextInt();
                int area=sc.nextInt();
                int cost=sc.nextInt();
                String tel=sc.next();

                Apartment a=new Apartment(city,rooms,area,cost,tel);
                if(rooms==3 && area>=100 && (city.equals("Бургас") || city.equals("София") || city.equals("Варна"))){
                    ap.add(a);
                }
                if(!numApartments.containsKey(city)){
                    numApartments.put(city,1);
                } else{
                    numApartments.put(city,numApartments.get(city)+1);
                }

            }
            if(ap.isEmpty()){
                throw new UnsuitableApartmentsException();
            }


        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(UnsuitableApartmentsException e){
            System.out.println("No suitable apartmenhts");
        }finally{

        }
        Collections.sort(ap);

        for(int i=0;i<5;i++) {
            if (!brokers.contains(ap.get(i).getTelephoneNumber())) {
                brokers.add(ap.get(i).getTelephoneNumber());

            }
        }
        PrintWriter output=null;
        try{
            Map<String, Integer> cityApCounter = new HashMap<>();

            List<Map.Entry<String, Integer>> list = new ArrayList<>(numApartments.entrySet());

            list.sort(Map.Entry.comparingByValue());

            String city1=list.get(3).getKey();
            for (Map.Entry<String, Integer> entry : list) {
                cityApCounter.put(entry.getKey(), entry.getValue());
            }
            numApartments=cityApCounter;
            File file2=new File(absolutePath+ "/resources/output.txt");
            output=new PrintWriter(file2);


            output.println(city1);
            for(String s:brokers){
                output.println( s);}
        } catch (FileNotFoundException o) {
            o.printStackTrace();
        }finally{
            output.close();
        }

    }
}
