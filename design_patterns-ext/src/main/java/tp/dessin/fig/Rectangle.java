package tp.dessin.fig;

public class Rectangle extends Figure{
	
	private static final long serialVersionUID = 1L;
	private int x1,y1,l,h; //+get/set
	
	public Rectangle() {
		super();
	}


	public Rectangle(int x1, int y1, int l, int h) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.l = l;
		this.h = h;
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


	public int getL() {
		return l;
	}


	public void setL(int l) {
		this.l = l;
	}


	public int getH() {
		return h;
	}


	public void setH(int h) {
		this.h = h;
	}

	@Override
	public void performVisit(AbstractFigVisitor figVisitor) {
		figVisitor.doActionForRectangle(this);
	}


	@Override
	public void translate(int dx, int dy) {
		this.x1+=dx;
		this.y1+=dy;
	}


	@Override
	public void resize(double coeff) {
		this.l=(int)((double)this.l*coeff);
		this.h=(int)((double)this.h*coeff);
	}
	
	@Override
	public void setOrigin(int x, int y) {
		this.x1=x;this.y1=y;
	}
	
}
