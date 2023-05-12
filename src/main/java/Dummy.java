import java.util.ArrayList;
import java.util.Objects;

public class Dummy {

	String name;
	String classs;
	
	
	
	public Dummy(String name, String classs) {
		super();
		this.name = name;
		this.classs = classs;
	}



	@Override
	public int hashCode() {
		return Objects.hash(classs, name);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dummy other = (Dummy) obj;
		return Objects.equals(classs, other.classs) && Objects.equals(name, other.name);
	}



	@Override
	public String toString() {
		return "Dummy [name=" + name + ", classs=" + classs + "]";
	}



	public static void main(String[] args) {
		ArrayList<Dummy> a=new ArrayList<>();
		a.add(new Dummy("vivek","sdfad"));
		a.add(new Dummy("sdfsdf","sdfdsfdsfsdf"));
		
		ArrayList<Dummy> b=new ArrayList<>();
		b.add(new Dummy("vivek","sdfad"));
//		b.add(new Dummy("sdfsdf","sdfdsfdsfsdf"));
		ArrayList<Dummy> c=new ArrayList<>(b);
	 c.removeAll(a);
	 
	 System.out.println(c.toString());
	 
	 StringBuilder name=new StringBuilder("vivek");
	 name.append("sdfdsf");
	 System.out.println(name);
	}

}
