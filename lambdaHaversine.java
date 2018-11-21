
public class lambdaHaversine{
	public static void main(String args[]){
		MyInterface cd = (x1,y1,x2,y2)->{
			return 3959* 2 * Math.atan2(Math.sqrt(Math.pow(Math.sin(((x2-x1)*(Math.PI/180))/2),2) + Math.cos(x1) * Math.cos(x2) * Math.pow(Math.sin(((y2-y1)*(Math.PI/180))/2),2)), Math.sqrt(1-(Math.pow(Math.sin(((x2-x1)*(Math.PI/180))/2),2) + Math.cos(x1) * Math.cos(x2) * Math.pow(Math.sin(((y2-y1)*(Math.PI/180))/2),2))));
		};
		System.out.println("Distance: "+cd.calculateDistance(40.458896,-73.985130,41.825226,-71.418884)+" miles");
	}
	
	interface MyInterface{
		public double calculateDistance(double nLat1, double nLon1, double nLat2, double nLon2);
	}
}