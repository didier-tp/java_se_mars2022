package tp.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Getter  @Setter @ToString
public class Figure {
	public static final String TYPE_LINE = "line";
	public static final String TYPE_RECTANGLE = "rectangle";
	public static final String TYPE_CIRCLE = "circle";
	
	private String type;//"line" or "circle" or "rectangle" or ...
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private String color="black"; //ex: "black" , "red" or ...
	
	public Figure() {
		super();
	}

	public Figure(String type, int x1, int y1, int x2, int y2, String color) {
		super();
		this.type = type;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
	}

	public Figure(String type, int x1, int y1, int x2, int y2) {
		this(type,x1,y1,x2,y2,"black");
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Figure [type=" + type + ", x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + ", color=" + color
				+ "]";
	}
	
	
	
}
