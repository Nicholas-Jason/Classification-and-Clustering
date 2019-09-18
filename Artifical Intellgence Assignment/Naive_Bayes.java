
/**
 * Calculate the probability of an event.
 *
 * @author Nicholas-Jason Roache
 * @version 2
 */
import java.util.*;
public class Naive_Bayes
{
    class Car
    {
        double x;
        double y;
        double z;
        boolean positivex = false;
        boolean positivey = false;
        boolean positivez = false;
        String type;
        String color;
        String model;
        public  Car(double x, double y, double z)
        {
            this.x = x;
            this.y = y;
            this.z = z;
            if(x >0)
            {
                positivex = true;
            }
            if(y>0)
            {
                positivey = true;
            }
            if(z>0)
            {
                positivez = true;
            }
        }
        
        public Car(String type,String color,String model, double x, double y,double z)
        {
            this.type = type;
            this.color = color;
            this.model = model;
            this.x = x;
            this.y = y;
            this.z = z;
            if(x >0)
            {
                positivex = true;
            }
            if(y>0)
            {
                positivey = true;
            }
            if(z>0)
            {
                positivez = true;
            }
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
    public ArrayList<Car>cars;
    
    public Hashtable<String,Integer> types;
    public Hashtable<String,Integer> models;
    public Hashtable<String,Integer> colors;
    
    public Naive_Bayes()
    {
        cars = new ArrayList<Car>();
        types = new Hashtable<String,Integer>();
        models = new Hashtable<String,Integer>();
        colors = new Hashtable<String,Integer>();
    }
    
    public void fillType()
    {
        for(int i = 0; i < cars.size(); i++)
        {
            
            String ak = cars.get(i).type;
            if(types.containsKey(ak) == false)
            {
                types.put(ak,1);
            }
            else
            {
                types.replace(ak,types.get(ak) + 1);
            }
            
        }
        
    }
    
    public void fillModels()
        {
            for(int i = 0; i < cars.size(); i++)
            {
                
            String pk = cars.get(i).model;
            if(models.containsKey(pk) == false)
            {
                models.put(pk,1);
            }
            else
            {
                models.replace(pk,models.get(pk) + 1);
            }
            }
        }
    
    public void fillColors()
       {
            for(int i = 0; i < cars.size(); i++)
            {
            String ek = cars.get(i).color;
            if(colors.containsKey(ek) == false)
            {
                colors.put(ek,1);
            }
            else
            {
                colors.replace(ek,colors.get(ek) + 1);
            }
            }
       }
       
    
    
    public int getConditionalTypeX(String x,boolean y)
    {
        int z = 0;
        for(int i = 0; i < cars.size();i++)
        {
            if(cars.get(i).type == x && (Boolean.compare(cars.get(i).positivex,y) == 0))
            {
                z = z + 1;
            }
        }
        return z;
    }
    
    public int getConditionalTypeY(String x,boolean y)
    {
        int z = 0;
        for(int i = 0; i < cars.size();i++)
        {
            if(cars.get(i).type == x && (Boolean.compare(cars.get(i).positivey,y) == 0))
            {
                z = z + 1;
            }
        }
        return z;
    }
    
    public int getConditionalTypeZ(String x,boolean y)
    {
        int z = 0;
        for(int i = 0; i < cars.size();i++)
        {
            if(cars.get(i).type == x && (Boolean.compare(cars.get(i).positivez,y) == 0))
            {
                z = z + 1;
            }
        }
        return z;
    }
    public int getConditionalModelX(String x,boolean y)
    {
        int z = 0;
        for(int i = 0; i < cars.size();i++)
        {
            if(cars.get(i).model == x && (Boolean.compare(cars.get(i).positivex,y) == 0))
            {
                z = z + 1;
            }
        }
        return z;
    }
    
    public int getConditionalModelY(String x,boolean y)
    {
        int z = 0;
        for(int i = 0; i < cars.size();i++)
        {
            if(cars.get(i).model == x && (Boolean.compare(cars.get(i).positivey,y) == 0))
            {
                z = z + 1;
            }
        }
        return z;
    }
    
    public int getConditionalModelZ(String x,boolean y)
    {
        int z = 0;
        for(int i = 0; i < cars.size();i++)
        {
            if(cars.get(i).model == x && (Boolean.compare(cars.get(i).positivez,y) == 0))
            {
                z = z + 1;
            }
        }
        return z;
    }
    
    public int getConditionalColorZ(String x,boolean y)
    {
        int z = 0;
        for(int i = 0; i < cars.size();i++)
        {
            if(cars.get(i).color == x && (Boolean.compare(cars.get(i).positivez,y) == 0))
            {
                z = z + 1;
            }
        }
        return z;
    }
    
    public int getConditionalColorY(String x,boolean y)
    {
        int z = 0;
        for(int i = 0; i < cars.size();i++)
        {
            if(cars.get(i).color == x && (Boolean.compare(cars.get(i).positivey,y) == 0))
            {
                z = z + 1;
            }
        }
        return z;
    }
    
    public int getConditionalColorX(String x,boolean y)
    {
        int z = 0;
        for(int i = 0; i < cars.size();i++)
        {
            if(cars.get(i).color == x && (Boolean.compare(cars.get(i).positivex,y) == 0))
            {
                z = z + 1;
            }
        }
        return z;
    }
    public double getProbability(int a, int b)
    {
        double c = 0;
        double d = (double) a;
        double e = (double) b;
        c = d/e;
        return c;
    }
    
    public double finalProbability(double x, double y, double w, double z)
    {
        double f;
        f = x*y*w*z;
        return f;
    }
    
    public static void main(String [] args)
    {
        Naive_Bayes NB = new Naive_Bayes();
        Naive_Bayes.Car c1 = NB.new Car("Toyota","Red","Wagon",12,9,16);
        Naive_Bayes.Car c2 = NB.new Car("Toyota","Yellow","Hatchback",8,-7,-9);
        Naive_Bayes.Car c3 = NB.new Car("BMW","Blue","Convertible",7,12,-8);
        Naive_Bayes.Car c4 = NB.new Car("Ferrari","Blue","Sports Car",-6,12,3);
        Naive_Bayes.Car c5 = NB.new Car("BMW","Yellow","Hatchback",-5,-4,13);
        Naive_Bayes.Car c6 = NB.new Car("Ferrari","Red","Sports Car",-2,8,-11);
        Naive_Bayes.Car c7 = NB.new Car("BMW","Red","Wagon",6,-5,-14);
        Naive_Bayes.Car c8 = NB.new Car("Ferrari","Yellow","Convertible",-6,-9,13);
        Naive_Bayes.Car c9 = NB.new Car("Ferrari","Yellow","Sports Car",-12,-7,-9);
        Naive_Bayes.Car c10 = NB.new Car("BMW","Red","Wagon",4,-9,-19);
        Naive_Bayes.Car c11 = NB.new Car("Toyota","Red","Wagon",16,5,13);
        Naive_Bayes.Car c12 = NB.new Car("BMW","Yellow","Hatchback",-2,-7,15);
        Naive_Bayes.Car c13 = NB.new Car("Ferrari","Red","Sports Car",-3,6,-11);
        Naive_Bayes.Car c14 = NB.new Car("BMW","Blue","Convertible",9,14,-13);
        Naive_Bayes.Car c15 = NB.new Car("Toyota","Yellow","Hatchback",10,-11,-5);
        Naive_Bayes.Car c16 = NB.new Car("Ferrari","Blue","Sports Car",-7,15,8);
        
        NB.cars.add(c1);
        NB.cars.add(c2);
        NB.cars.add(c3);
        NB.cars.add(c4);
        NB.cars.add(c5);
        NB.cars.add(c6);
        NB.cars.add(c7);
        NB.cars.add(c8);
        NB.cars.add(c9);
        NB.cars.add(c10);
        NB.cars.add(c11);
        NB.cars.add(c12);
        NB.cars.add(c13);
        NB.cars.add(c14);
        NB.cars.add(c15);
        NB.cars.add(c16);
        
        NB.fillModels();
        NB.fillType();
        NB.fillColors();
        
         Naive_Bayes.Car cx = NB.new Car(-3,-5,-11);
         
        System.out.println("Probability that the model is a Hatchback");
        double t = NB.getProbability(NB.models.get("Hatchback"),NB.cars.size());
        double mx = NB.getProbability(NB.getConditionalModelX("Hatchback",false),NB.models.get("Hatchback"));
        double my = NB.getProbability(NB.getConditionalModelY("Hatchback",false),NB.models.get("Hatchback"));
        double mz = NB.getProbability(NB.getConditionalModelZ("Hatchback",false),NB.models.get("Hatchback"));
        
        double mfinal = NB.finalProbability(t,mx,my,mz);
        System.out.println(mfinal);
    }
}
