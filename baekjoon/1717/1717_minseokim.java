import java.util.*;
 
public class Main {
    
    static int[] unionArray;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        unionArray = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            unionArray[i] = i;
        }
        
        int m = scan.nextInt();
        for(int i = 0; i < m; i++) {
            int command = scan.nextInt();
            int arg1 = scan.nextInt();
            int arg2 = scan.nextInt();   
            
            if(command == 0) update(unionFind(arg1), unionFind(arg2));
            else if(command == 1) test(arg1, arg2);
        }
    }
    
    public static void update(int a, int b) {
        unionArray[a] = b;
    }
    
    public static void test(int a, int b) {
        if (unionFind(a) == unionFind(b)) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }
    
    public static int unionFind(int a) {
        if(unionArray[a] == a) return a;
        else return unionArray[a] = unionFind(unionArray[a]);
    }
}    
