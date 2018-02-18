package swtest;

public class IntPair {

    
    private String sum;
    public int n1,n2;

    public IntPair(int n1, int n2) {
        this.n1=n1;
        this.n2=n2;
    }

    public IntPair add(){
    	this.sum=Integer.toString(n1+n2);
    	return this;
	}

    

    public String getSum() {
        return sum;
    }
}
