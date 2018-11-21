import java.util.Scanner;

public class DataTypes {

       public static void main(String[] args) {
             // TODO Auto-generated method stub
             DataTypes dt;
             dt=new DataTypes();
             dt.doIt();

       }
      public void doIt() {
             Scanner s=new Scanner(System.in);
             double x;
             double y;
             double z;
			 System.out.println("Hypoteneuse Calculator");
             System.out.print("Enter one given side of the triangle: ");
             x=s.nextDouble();
             System.out.print("Enter the other given side of the triangle: ");
             y=s.nextDouble();
			 z= Math.sqrt((Math.pow(x,2)+Math.pow(y,2)));
             System.out.println("Hypoteneuse: "+z);

              }

}