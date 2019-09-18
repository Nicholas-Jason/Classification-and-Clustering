
/**
 * Clustering using Hierachical algorithm.
 *
 * @author Nicholas-Jason Roache
 * @version May 14, 2019
 */
import java.util.ArrayList;
public class Hierarchal_Clustering
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
    ArrayList<DataPoint> cluster = new ArrayList<DataPoint>();
    /**
     * Constructor for objects of class Hierarchal_Clustering
     */
    public Hierarchal_Clustering()
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
    
    public int calcDistance(DataPoint a, DataPoint b)
    {
        int d = 0;
        d = Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
        return d;
    }
    
    public void findSmallest()
    {
        DataPoint s1;
        DataPoint s2;
        DataPoint p = null;
        DataPoint q = null;
        int smallest = calcDistance(datapoints.get(0),datapoints.get(1));
        while(datapoints.size() > 0)
        {
            for(int i = 0; i < datapoints.size();i++)
            {
            
            for(int j = 0; j < datapoints.size();j++)
            {
                s1 = datapoints.get(i);
                s2 = datapoints.get(j);
                int distance = calcDistance(s1,s2);
                if(distance > 0 && distance < smallest)
                {
                    smallest = distance;
                    p = s1;
                    q = s2;
                }
            }
           } 
        
        cluster.add(p);
        cluster.add(q);
        datapoints.remove(p);
        datapoints.remove(q);
        }
        
    }
    
    public void fillCluster()
        {
            int max = datapoints.size();
            for(int i = 0; i<max;i++)
            {
                findSmallest();
            }
        }
    
    public void findCenter()
    {
        double center_x = 0;
        double center_y = 0;
        int sum_x = 0;
        int sum_y = 0;
        for(int i = 0; i< cluster.size();i++)
        {
            sum_x = sum_x + cluster.get(i).x;
            sum_y = sum_y + cluster.get(i).y;
        }
        
        center_x = (double) sum_x/cluster.size();
        center_y = (double) sum_y/cluster.size();
        System.out.println("The center is located at " + center_x + ", " + center_y);
    }
}
