package tp.dessin.fig;

public class Ligne extends Figure{
	
	private static final long serialVersionUID = 1L;
	private int x1,y1,x2,y2; //+get/set
	
	public Ligne() {
		super();
	}

	

	public Ligne(int x1, int y1, int x2, int y2) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
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


	@Override
	public void performVisit(AbstractFigVisitor figVisitor) {
		figVisitor.doActionForLigne(this);
	}
	
	@Override
	public Ligne clone() throws CloneNotSupportedException {   
		return (Ligne)super.clone();
	}



	@Override
	public void translate(int dx, int dy) {
		this.x1+=dx;		this.y1+=dy;
		this.x2+=dx;		this.y2+=dy;
	}



	@Override
	public void resize(double coeff) {
		double dx=x2-x1;
		dx=dx*coeff;
		x2=(int)(x1+dx);
		
		double dy=y2-y1;
		dy=dy*coeff;
		y2=(int)(y1+dy);
	}

	@Override
	public void setOrigin(int x, int y) {
		this.x1=x;this.y1=y;
	}
	
	
}
