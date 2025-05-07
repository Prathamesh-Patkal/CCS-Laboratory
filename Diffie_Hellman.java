import java.math.BigInteger;
import java.util.*;
class Diffie_Hellman {
    public static boolean checkPrime(int n){
        if (n<2) {
            return false;
        }
        for (int i=2; i*i <=n; i++) {
            if (n%i==0) {
                return false;
            }
        }
        return true;
    }
    public static void calSecreteKey(int p, int q, int Xa, int Xb){
        if(checkPrime(p)){
            if(q<p){
                BigInteger P = BigInteger.valueOf(p);
                BigInteger Q = BigInteger.valueOf(q);
                BigInteger Xa_BI = BigInteger.valueOf(Xa);
                BigInteger Xb_BI = BigInteger.valueOf(Xb);
                BigInteger Ya = Q.modPow(Xa_BI, P);
                BigInteger Yb = Q.modPow(Xb_BI, P);
                BigInteger Kab = Yb.modPow(Xa_BI, P); 
                BigInteger Kba = Ya.modPow(Xb_BI, P);
                if (Kab.equals(Kba)){
                    System.out.println("The secret key is "+ Kab);
                } 
            }else{
                System.out.println("not a primitive root of p");
            }
        }else{
            System.out.println("the given entered "+p+" is not a Prime no");
        }
    }
    public static void main(String[] args) {
        calSecreteKey(17, 5, 4, 6);
    }
}
