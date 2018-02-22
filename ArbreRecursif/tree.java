import java.util.Scanner;
public class tree {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    System.out.println("Please, enter an integer number:");
    int n = sc.nextInt();
    //System.out.println("Vous avez saisi le nombre : " + str);

    // Declare and read a positive integer.
    //int n = Integer.parseInt(args[0]);
    
    // Draw the tree plug by plug
    plugged(0.5, 0.0, 0, 0.4, n);
  }
  
  /**********************************************************
  *         t: cases
  * 
  *                    2                                    
  *                 -------                                       
  *               /         \                              
  *            3 /           \ 1                           
  *             /             \                           
  *            |               \                             
  *          4 |                |                            
  *            |                |                            
  *             \       | 0     | 0                           
  *            5 \     / 7      |                            
  *                --- 6        |                                
  *                             |                            
  *                                                                                                   
  *                                                         
  ************************************************************/
  
  public static void plugged(double x1, double y1, int t, double l, int p) {
    double x2, y2;
    if(p == 0) return;
    
    switch (t)
    {
      case 0:
        x2 = x1;
        y2 = y1 + l;
        break;
      case 1:
        x2 = x1 - dl(l);
        y2 = y1 + dl(l);
        break;
      case 2:
        y2 = y1;
        x2 = x1 - l;
        break;
      case 3:
        x2 = x1 - dl(l);
        y2 = y1 - dl(l);
        break;
      case 4:
        x2 = x1;
        y2 = y1 - l;
        break;
      case 5:
        x2 = x1 + dl(l);
        y2 = y1 - dl(l);
        break;
      case 6:
        y2 = y1;
        x2 = x1 + l;
        break;
      case 7:
        x2 = x1 + dl(l);
        y2 = y1 + dl(l);
        break; 
      default:
        x2 = 0;
        y2 = 0;
    }
    
    StdDraw.line(x1, y1, x2, y2);
    
    plugged(x2, y2, (t+1)%8, (3*l)/5, p-1);
    plugged(x2, y2, (t+7)%8, (3*l)/5, p-1);
  }

  public static double squareRoot(double nber) {
    double epsilon = 1.0E-10, min = 0, max = nber, middle = nber / 2;
    if (nber < 0) System.err.println("Error : " + nber + "is < 0.");
    
    while(min + epsilon < max) {
      if(middle * middle <= nber) min = middle;
      else max = middle;
      middle = (min + max) / 2;
    }
    return middle;
  }
  
  public static double dl(double l) {return l/squareRoot(2);}
}