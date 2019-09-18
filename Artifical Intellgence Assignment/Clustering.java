
/**
 * Group together objects based on their proximity to each other
 *
 * @author Nicholas-Jason Roache
 * @version February 23,2019
 */
import java.util.ArrayList;
import java.lang.Math;
public class Clustering
{
    class DataPoint
    {
        int x;
        int y;
        
        public DataPoint(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    
    ArrayList<DataPoint> datapoints = new ArrayList<DataPoint>(10);
    //Clusters
    ArrayList<DataPoint> C1 = new ArrayList<DataPoint>();
    ArrayList<DataPoint> C2 = new ArrayList<DataPoint>();
    
    public Clustering()
    {
        datapoints.add(new DataPoint(1,7));
        datapoints.add(new DataPoint(1,11));
        datapoints.add(new DataPoint(3,17));
        datapoints.add(new DataPoint(7,18));
        datapoints.add(new DataPoint(8,4));
        datapoints.add(new DataPoint(8,12));
        datapoints.add(new DataPoint(11,7));
        datapoints.add(new DataPoint(12,14));
        datapoints.add(new DataPoint(13,17));
        datapoints.add(new DataPoint(16,11));
        
        
    }
    /*
    * Uses the Manhattan Distance formula
    */
    public int calcDistance(DataPoint a, DataPoint b)
    {
        int d = 0;
        d = Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
        return d;
    }
    /*
     * Intializes the centurioid the cluster
     */
    public void setCenter(ArrayList<DataPoint>dp,DataPoint p)
    {
        dp.add(p);
        System.out.println("The intial center of the cluster is located at " + p.x + ", " + p.y);
    }
    
    public void populateClusters()
    {
        DataPoint center1 = datapoints.remove(4);
        DataPoint center2 = datapoints.remove(5);
        setCenter(C1,center1);
        setCenter(C2,center2);
        for(int i = 0; i < datapoints.size();i++)
        {
            int distance1 = calcDistance(center1,datapoints.get(i));
            int distance2 = calcDistance(center2,datapoints.get(i));
            if(Math.min(distance1,distance2) == distance1)
            {
                C1.add(datapoints.get(i));
            }
            else
            {
                C2.add(datapoints.get(i));
            }
        }
    }
    
    public void showClusters()
    {
        System.out.println("Cluster C1 contains values: ");
        for(int i = 0; i < C1.size(); i++)
        {
            System.out.print("(" + C1.get(i).x + "," + C1.get(i).y + "), ");
        }
        System.out.println("\n");
        System.out.println("Cluster C2 contains values: ");
        for(int i = 0; i < C2.size(); i++)
        {
            System.out.print("(" + C2.get(i).x + "," + C2.get(i).y + "), ");
        }
        System.out.println("\n");
    }
    
    public void calcCenter(ArrayList<DataPoint> c)
    {
        int avg_x = 0;
        int avg_y = 0;
        int sum_x = 0;
        int sum_y = 0;
        for(int i = 0; i<c.size(); i++)
        {
            sum_x = sum_x + c.get(i).x;
            sum_y = sum_y + c.get(i).y;
        }
        avg_x = sum_x/c.size();
        avg_y = sum_y/c.size();
        System.out.println("The actual center of the cluster is located at " + "(" + avg_x + "," + avg_y + ")");
    }
    public static void main(String [] args)
    {
        Clustering cl = new Clustering();
        cl.populateClusters();
        cl.showClusters();
        cl.calcCenter(cl.C1);
        cl.calcCenter(cl.C2);
    }
}
