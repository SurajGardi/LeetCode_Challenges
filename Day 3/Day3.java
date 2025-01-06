class Day3 {
    public int fib(int n) {
        if(n == 0){
            return 0;
        }
        else if(n == 1){
            return 1;
        }
        int a = 0, b = 1, c, op = 0;

        for(int i=0; i<n; i++){
            c = a + b;
            a = b;
            b = c;
            op = a;
        }
        return op;
    }
}