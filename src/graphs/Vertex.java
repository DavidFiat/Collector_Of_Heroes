package graphs;

public class Vertex<T> implements Comparable<Vertex<T>>{

	public static final int WHITE = 0;
	public static final int GRAY = 1;
	public static final int BLACK = 2;
	
	private T t;
	private double initialTimeStamp;
	private int finalTimeStamp;
	private int color;
	private int index;
	private int x;
	private int y;
	private Vertex<T> pred;
	
	public Vertex(T t) {
		this.t = t;
		pred = null;
		color = WHITE;
	}

	public T getValue() {
		return t;
	}

	public void setValue(T t) {
		this.t = t;
	}

	public double getInitialTimeStamp() {
		return initialTimeStamp;
	}

	public void setInitialTimeStamp(double initialTimeStamp) {
		this.initialTimeStamp = initialTimeStamp;
	}

	public int getFinalTimeStamp() {
		return finalTimeStamp;
	}

	public void setFinalTimeStamp(int finalTimeStamp) {
		this.finalTimeStamp = finalTimeStamp;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public Vertex<T> getPred() {
		return pred;
	}

	public void setPred(Vertex<T> pred) {
		this.pred = pred;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public void setIndex(int index) {
		this.index=index;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int compareTo(Vertex<T> vertex) {
		int ans = Double.compare(initialTimeStamp, vertex.initialTimeStamp);
		if(t instanceof Comparable) {
			if(ans == 0) {
				return ((Comparable)t).compareTo(vertex.getValue());
			}
		}
		return ans;
	}
	
	@Override
	public String toString() {
		return t.toString();
	}
}
