import Mathop.Floor;
import Mathop.Ceil;
import Mathop.Round;

public class Main{
	public static void main(String[] args){
		Floor f=new Floor(1);
		Ceil c=new Ceil(1);
		Round r=new Round(2);
		
		f.get();
		c.get1();
		r.get2();
		
		f.set();
		c.set1();
		r.set2();
		
	}
}
