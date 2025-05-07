import java.util.*;
public class RSA{
    public static boolean checkPrime(int no){
        if (no<2) {
            return false;
        }
        for (int i=2; i*i <=no; i++) {
            if (no%i==0) {
                return false;
            }
        }
        return true;
    }
    //find the value of e
    public static int find_Val_e(int phi_of_n) {
        for(int e=2; e<phi_of_n; e++) {
            int a=e, b=phi_of_n;
            while(b !=0) {
                int temp=b;
                b=a%b;
                a=temp;
            }
            if (a ==1) { 
                return e;
            }
        }
        return -1;
    }
    public static void rsaAlgorithm(int p, int q, int msg){
        if (checkPrime(p) && checkPrime(q) && p!=q) {
            int n = p*q;
            int phi_of_n = (p-1)*(q-1);
            int e = find_Val_e(phi_of_n);
            int d=0;
            for(int i=0; i<=phi_of_n;i++){
                if (((phi_of_n*i)+1)%e==0) {
                    d=((phi_of_n*i)+1)/e;
                    break;
                } 
            }
            long c=1;
            for(int i=0; i<e; i++) {
                c = (c*msg)%n;
            }
            long m=1;
            for(int i=0; i<d; i++) {
                m = (m*c)%n;
            }
            System.out.println("the Original message is :"+msg);
            System.out.println("the Decrypted message is :"+m);
        }else{
            System.out.println("there is no output:");
        }
    }
    public static void main(String[] args){
        rsaAlgorithm(11,17,11);
    }
}