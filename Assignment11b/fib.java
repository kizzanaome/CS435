import java.util.HashMap;

class Fib{

    int count = 0;
    int countMemoizedFib = 0;
    int interativeCount = 0;
    HashMap<Integer, Integer> memo = new HashMap<>();
   

    public int bruteForceFib(int n){
        count++;
        if (n == 0){
            return 0;
        }else{
            if (n == 1){
                return 1;
            }
        }
        return bruteForceFib(n-2) + bruteForceFib(n-1);
    }

    
    public int memoizedFib(int n){
        countMemoizedFib ++;
        if(n ==1 || n == 0){
            return n;
        }

        if (memo.containsKey(n)) return memo.get(n);
        int fibValue = memoizedFib(n-1) + memoizedFib(n-2);
        memo.put(n, fibValue);
        return fibValue;
        
    }


    public int fibIterative(int n){
        interativeCount ++;

        int prev1 = 0;
        int prev2 = 1;
        if (n ==1 | n==0){
            return n;
        }
        int current = 0;
        for(int i=2; i<=n; i++){
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }
        return current;

    }


    public void main(String[] args){
        System.out.println(bruteForceFib(30));
        System.out.println("count: "+count);
        System.out.println(memoizedFib(30));
        System.out.println("memoized_count: "+countMemoizedFib);
        System.out.println(fibIterative(30));
        System.out.println("interativeCount: "+ interativeCount);

    }
} 



