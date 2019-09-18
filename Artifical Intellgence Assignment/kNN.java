
/**
 * Calculate what color an instance is  based on nearest distance
 *
 * @author Nicholas-Jason Roache
 * @version April 25, 2019
 */
import java.util.*;
import java.lang.Math;

public class kNN
{
    
    class Car
    {
        double x;
        double y;
        double z;
        String type;
        String color;
        String model;
        public  Car(double x, double y, double z)
        {
            this.x = x;
            this.y = y;
            this.z = z;
        }
        
        public Car(String type,String color,String model, double x, double y,double z)
        {
            this.type = type;
            this.color = color;
            this.model = model;
            this.x = x;
            this.y = y;
            this.z = z;
        }
        
        public void setColor(String n)
        {
            color = n;
        }
        
        public void setType(String type)
        {
            this.type = type;
        }
        
        public void setModel(String model)
        {
            this.model = model;
        }
    }
    
    //Stores all the training datasets
    static ArrayList<Car> cars;
    //Stores the distances between the training examples and new instance
    TreeMap<Double,String> cdistances = new TreeMap<Double,String>();
    TreeMap<Double,String> tdistances = new TreeMap<Double,String>();
    TreeMap<Double,String> mdistances = new TreeMap<Double,String>();
    int k;
    public kNN()
    {
        cars = new ArrayList<Car>();
        k = 0;
    }
    
    public void calcEuDistances(ArrayList<Car> col, Car b)
    {
        double d;
       
        for(int i = 0; i < cars.size(); i++)
        {
            Car a = col.get(i);
            d = Math.sqrt((a.x - b.x)*(a.x - b.x) + (a.y-b.y)*(a.y-b.y) + (a.z -b.z)*(a.z-b.z));
            cdistances.put(d,a.color);
            tdistances.put(d,a.type);
            mdistances.put(d,a.model);
        }
    }
    
    public void calcMaDistances(ArrayList<Car> col, Car b)
    {
        cdistances.clear();
        tdistances.clear();
        mdistances.clear();
        double d;
        for(int i = 0; i < cars.size();i++)
        {
            Car a = col.get(i);
            d = Math.abs(a.x - b.x) + Math.abs(a.y - b.y) + Math.abs(a.z-b.z);
            cdistances.put(d,a.color);
            tdistances.put(d,a.type);
            mdistances.put(d,a.model);
        }
    }
    
    public void calcMiDistances(ArrayList<Car> col, Car b)
    {
        cdistances.clear();
        tdistances.clear();
        mdistances.clear();
        double d;
        for(int i = 0; i < cars.size();i++)
        {
            Car a = col.get(i);
            d = Math.pow((Math.pow(Math.abs(a.x - b.x),2) + Math.pow(Math.abs(a.y - b.y),2) + Math.pow(Math.abs(a.z - b.z),2)),.5);
            cdistances.put(d,a.color);
            tdistances.put(d,a.type);
            mdistances.put(d,a.model);
        }
    }
    public void setK()
    {
        double c = (double) cars.size();
        k = (int) (Math.sqrt(c) - 1.00);
        System.out.println("k is set to " + k);
    }
    
    public void calcColor(Car b)
    {
        ArrayList<String> c = new ArrayList<String>();
        c.add(cars.get(0).color);
        for(int i = 0; i < cars.size();i++)
        {
            if(c.contains(cars.get(i).color) == false)
            {
                c.add(cars.get(i).color);
            }
        }
        TreeMap<String,Integer> h = new TreeMap<String,Integer>();
        for(int j = 0; j < c.size();j++)
        {
            h.put(c.get(j),0);
        }
        Set s = cdistances.entrySet();
        Iterator it = s.iterator();
        System.out.println("The k nearest colors are: ");
        for(int i = 0; i < k; i++)
        {
           Map.Entry m = (Map.Entry) it.next();
           String key = (String) m.getValue();
           System.out.println(key);
           if(h.containsKey(key) == true)
           {
               h.put(key, h.get(key) + 1);
           }
        }
        Set sortedhash = h.entrySet();
        sortedhash.stream().sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()));
        Iterator t = sortedhash.iterator();
        Map.Entry m2 = (Map.Entry) t.next();
        String new_name = (String) m2.getKey();
        
        b.setColor(new_name);
        //System.out.println("The car's color is " + b.color);
    }
    
    public void calcType(Car b)
    {
        ArrayList<String> c = new ArrayList<String>();
        c.add(cars.get(0).type);
        for(int i = 0; i < cars.size();i++)
        {
            if(c.contains(cars.get(i).type) == false)
            {
                c.add(cars.get(i).type);
            }
        }
        TreeMap<String,Integer> h = new TreeMap<String,Integer>();
        for(int j = 0; j < c.size();j++)
        {
            h.put(c.get(j),0);
        }
        Set s = tdistances.entrySet();
        Iterator it = s.iterator();
        System.out.println("The k nearest types are: ");
        for(int i = 0; i < k; i++)
        {
           Map.Entry m = (Map.Entry) it.next();
           String key = (String) m.getValue();
           System.out.println(key);
           if(h.containsKey(key) == true)
           {
               h.put(key, h.get(key) + 1);
           }
        }
        Set sortedhash = h.entrySet();
        sortedhash.stream().sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()));
        Iterator t = sortedhash.iterator();
        Map.Entry m2 = (Map.Entry) t.next();
        String new_name = (String) m2.getKey();
        
        b.setType(new_name);
        //System.out.println("The car's type is " + b.type);
    }
    public void calcModel(Car b)
    {
        ArrayList<String> c = new ArrayList<String>();
        c.add(cars.get(0).model);
        for(int i = 0; i < cars.size();i++)
        {
            if(c.contains(cars.get(i).model) == false)
            {
                c.add(cars.get(i).model);
            }
        }
        TreeMap<String,Integer> h = new TreeMap<String,Integer>();
        for(int j = 0; j < c.size();j++)
        {
            h.put(c.get(j),0);
        }
        Set s = mdistances.entrySet();
        Iterator it = s.iterator();
        System.out.println("The k nearest model are: ");
        for(int i = 0; i < k; i++)
        {
           Map.Entry m = (Map.Entry) it.next();
           String key = (String) m.getValue();
           System.out.println(key);
           if(h.containsKey(key) == true)
           {
               h.put(key, h.get(key) + 1);
           }
        }
        Set sortedhash = h.entrySet();
        sortedhash.stream().sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()));
        Iterator t = sortedhash.iterator();
        Map.Entry m2 = (Map.Entry) t.next();
        String new_name = (String) m2.getKey();
        
        b.setModel(new_name);
        //System.out.println("The car's model is " + b.model);
    }
    public static void main(String [] args)
    {
       kNN test = new kNN();
       kNN.Car c1 = test.new Car("Toyota","Red","Wagon",12,9,16);
       kNN.Car c2 = test.new Car("Toyota","Yellow","Hatchback",8,-7,-9);
       kNN.Car c3 = test.new Car("BMW","Blue","Convertible",7,12,-8);
       kNN.Car c4 = test.new Car("Ferrari","Blue","Sports Car",-6,12,3);
       kNN.Car c5 = test.new Car("BMW","Yellow","Hatchback",-5,-4,13);
       kNN.Car c6 = test.new Car("Ferrari","Red","Sports Car",-2,8,-11);
       kNN.Car c7 = test.new Car("BMW","Red","Wagon",6,-5,-14);
       kNN.Car c8 = test.new Car("Ferrari","Yellow","Convertible",-6,-9,13);
       kNN.Car c9 = test.new Car("Ferrari","Yellow","Sports Car",-12,-7,-9);
       kNN.Car c10 = test.new Car("BMW","Red","Wagon",4,-9,-19);
       kNN.Car c11 = test.new Car("Toyota","Red","Wagon",16,5,13);
       kNN.Car c12 = test.new Car("BMW","Yellow","Hatchback",-2,-7,15);
       kNN.Car c13 = test.new Car("Ferrari","Red","Sports Car",-3,6,-11);
       kNN.Car c14 = test.new Car("BMW","Blue","Convertible",9,14,-13);
       kNN.Car c15 = test.new Car("Toyota","Yellow","Hatchback",10,-11,-5);
       kNN.Car c16 = test.new Car("Ferrari","Blue","Sports Car",-7,15,8);
       
       test.cars.add(c1);
       test.cars.add(c2);
       test.cars.add(c3);
       test.cars.add(c4);
       test.cars.add(c5);
       test.cars.add(c6);
       test.cars.add(c7);
       test.cars.add(c8);
       test.cars.add(c9);
       test.cars.add(c10);
       test.cars.add(c11);
       test.cars.add(c12);
       test.cars.add(c13);
       test.cars.add(c14);
       test.cars.add(c15);
       test.cars.add(c16);
       
       kNN.Car cx = test.new Car(-3,-5,-11);
       
       test.setK();
       //test.calcEuDistances(cars,cx);
       //test.calcModel(cx);
       //test.calcType(cx);
       //test.calcColor(cx);
       test.calcMaDistances(cars,cx);
       test.calcModel(cx);
       test.calcType(cx);
       test.calcColor(cx);
       //test.calcMiDistances(cars,cx);
       //test.calcModel(cx);
       //test.calcType(cx);
       //test.calcColor(cx);
    }
}
