package swtest;

public class Math {

    
    private final String sum;

    public Math(int n1, int n2) {
        this.sum=Integer.toString(n1+n2);
    }

    

    public String getSum() {
        return sum;
    }
}
