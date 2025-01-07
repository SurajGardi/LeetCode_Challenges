class Day4 {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }

        int ft = 0 ;    // firstTerm
        int st = 1 ;    // secondTerm
        int tt = 1 ;    // thirdTerm

        for (int i = 1; i <= n; i++) {
            int fot = ft + st + tt ;
            ft = st ;
            st = tt ;
            tt = fot ;
        }
        return ft;
    }

    public static void main(String[] args) {
        Day4 solution = new Day4();
        System.out.println(solution.tribonacci(4));   
        System.out.println(solution.tribonacci(25));  
    }
}
