// Name: Lee Chia Lin
// UOW Student ID: 6097881
// This is my own work, and I have not passed your to my friends

import java.util.Random;
import java.util.ArrayList;

interface Shape
{
	public double area();
	public double getArea();
}

//TwoD
abstract class TwoD implements Shape
{
	protected int a, b, c;
	
	public TwoD(int a)
	{
		this.a = a;	
	}
	public TwoD(int a, int b)
	{
		this.a = a;
		this.b = b;
	}
	public TwoD(int a, int b, int c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	//Copy constructor
	public TwoD(TwoD td)
	{
		this.a = td.a;
		this.b = td.b;
		this.c = td.c;	
	}
	
	//Accessor
	public int getA()
	{
		return a;
	}
	public int getB()
	{
		return b;
	}
	public int getC()
	{
		return c;
	}
	
	//Mutator
	public void set(int a, int b, int c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public String toString()
	{
		return String.format("2D");
	}
}
//Circle
class Circle extends TwoD
{
	public Circle(int radius)
	{
		super(radius);
	}
	@Override
	public double area()
	{
		return Math.PI * a * a;	
	}
	@Override
	public double getArea()
	{
		return area();
	}
	
	@Override
	public String toString()
	{
		return String.format("Circle (%s (%d))==> Area == %.3f%nI am a circle shape", super.toString(), a, area());
	}
}
//Rectangle
class Rectangle extends TwoD
{
	public Rectangle(int length, int width)
	{
		super(length, width);
	}
	@Override
	public double area()
	{
		return a * b;
	}
	@Override
	public double getArea()
	{
		return area();
	}
	
	@Override
	public String toString()
	{
		return String.format("Rectangle (%s (%d, %d))==> Area == %.3f%nI am a rectangle shape", 
							super.toString(), a, b, area());
	}
}
//Triangle
class Triangle extends TwoD
{
	public Triangle(int a, int b, int c)
	{
		super(a,b,c);
	}
	@Override
	public double area()
	{
		double s = (a + b + c) / 2.0;
		return Math.sqrt (s * (s - a) * (s - b) * (s - c));
	}
	@Override
	public double getArea()
	{
		return area();
	}
	
	@Override
	public String toString()
	{
		return String.format("Triangle (%s (%d, %d, %d))==> Area == %.3f%nI am a triangle shape", 
							super.toString(), a, b, c, area());
	}
}
//ThreeD
abstract class ThreeD implements Shape
{
	protected int a;
	
	public ThreeD(int a)
	{
		this.a = a;
	}
	public ThreeD(ThreeD td)
	{
		this.a = td.a;
	}
	//Accessor
	public int getA()
	{
		return a;
	}
	//Mutator
	public void set(int a)
	{
		this.a = a;
	}
	
	protected double volume()
	{
		return a * a * a;
	}
	
	public double getVolume()
	{
		return volume();
	}
	
	@Override
	public String toString()
	{
		return String.format("3D");
	}
}
//Sphere
class Sphere extends ThreeD
{
	public Sphere(int a)
	{
		super(a);
	}
	@Override
	public double area()
	{
		return Math.PI * 4.0 * a * a;
	}
	@Override
	public double getArea()
	{
		return area();
	}
	@Override
	protected double volume()
	{
		return (4.0/3.0) * super.volume() * Math.PI;
	}
	@Override
	public double getVolume()
	{
		return volume();
	}
	
	@Override
	public String toString()
	{
		return String.format("Sphere (%s (%d))==> Surface area == %.3f, Volume = %.3f%nI am a sphere shape", 
							super.toString(), a, area(), volume());
	}
}
//Cube
class Cube extends ThreeD
{
	public Cube(int a)
	{
		super(a);
	}
	@Override
	public double area()
	{
		return 6.0 * a * a;
	}
	@Override
	public double getArea()
	{
		return area();
	}
	@Override
	protected double volume()
	{
		return super.volume();
	}
	@Override
	public double getVolume()
	{
		return volume();
	}
	
	@Override
	public String toString()
	{
		return String.format("Cube (%s (%d))==> Surface area == %.3f, Volume = %.3f%nI am a cube shape", 
							super.toString(), a, area(), volume());
	}
}
//Tetrahedron
class Tetrahedron extends ThreeD
{
	public Tetrahedron(int a)
	{
		super(a);
	}
	@Override
	public double area()
	{
		return Math.sqrt(3) * a * a;
	}
	@Override
	public double getArea()
	{
		return area();
	}
	@Override
	protected double volume()
	{
		return super.volume()/(6.0 * Math.sqrt(2));
	}
	@Override
	public double getVolume()
	{
		return volume();
	}
	
	@Override
	public String toString()
	{
		return String.format("Tetrahedron (%s (%d))==> Surface area == %.3f, Volume = %.3f%nI am a tetrahedron", 
							super.toString(), a, area(), volume());
	}
}

class TestShape
{
	private static Random rand = new Random();
	
	private static int getInt()
	{
		//generate random 1 to 9
		return rand.nextInt(9)+1;
	}
	
	//random generate one TwoD shape
	private static TwoD getTwoD()
	{
		int x = rand.nextInt(3);
		
		if(x == 0)
		{
			return new Circle(getInt());
		}
		else if(x == 1)
		{
			return new Rectangle(getInt(),getInt());
		}
		else
		{
			int a = getInt();
			int b = getInt();
			int c = getInt();
			
			//check if it is a valid triangle
			while((a+b)<=c || (a+c)<=b || (b+c)<=a) 
			{
				a = getInt();
				b = getInt();
				c = getInt();	
			}
			return new Triangle(a, b, c);
		}
	}
	
	//random generate one ThreeD shape
	private static ThreeD getThreeD()
	{
		int x = rand.nextInt(3);
		
		if(x == 0)
			return new Sphere (getInt());
		else if(x == 1)
			return new Cube (getInt());
		else
			return new Tetrahedron(getInt());
		
	}

	//Print
	private static void displayList(ArrayList<Shape> alist)
	{
		for(int i=0; i<alist.size(); i++)
		{
			System.out.printf("Shape [%d] = %s%n", i+1, alist.get(i));
			System.out.println("------------------------------------");
		}
	}
	public static void main(String [] args)
	{
		ArrayList <Shape> alist = new ArrayList <Shape> ();
		
		//generate shape 9 times
		//random shuffle TwoD and ThreeD
		for(int i=1; i<10; i++)
		{
			int x = rand.nextInt(2);
			
			if(x == 0)
				alist.add(getTwoD());
			else
				alist.add(getThreeD());
		}
		
		displayList(alist);	
	}
}