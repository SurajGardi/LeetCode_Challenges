class Day1 {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false ;
        }
        int number = x ;
        int reversedNumber = 0 ;
        while(number > 0){
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }
        if(reversedNumber == x ){
            return true ;
        }
        else{
            return false ;
        }
    }
}