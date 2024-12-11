public class Ex1 {

    /**
     * Convert the given number (num) to a decimal representation (as int).
     * If the given number is not in a valid format returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return
     */

    public static int number2Int(String num) {
        int ans = -1;
        int baseInt;
        String baseString;
        int indexOfB;
        int indexOfBase;
        if(num.contains("b") && !num.isEmpty() && num != null){
            indexOfB= num.indexOf("b");
            if(indexOfB==0 || indexOfB== num.length()-1){
                return -1;
            }
            indexOfBase= indexOfB+1;
            baseString = num.substring(indexOfBase);
            if(baseString.length()!=1){
                return -1;
            }
            char baseChar = baseString.charAt(0);
            if(baseChar >= '0' && baseChar <= '9') {
                baseInt = baseChar - '0'; // converts the digit to integer
            }
            else if(baseChar >= 'A' && baseChar <= 'G') {
                baseInt = 10 + (baseChar- 'A');
            }
            else {return -1;}
            if (baseInt<2 || baseInt>16){
                return -1;
            }
            String mainNumber = num.substring(0, indexOfB);
            for (int i=0; i< mainNumber.length(); i++){
                char c = mainNumber.charAt(i);
                int value;
                if (c >= '0' && c<='9'){
                    value = c - '0';
                }
                else if (c >='A' && c<='F'){
                    value = 10 + (c-'A');
                }
                else {
                    return -1;
                }

                if (value >=baseInt) {
                    return -1;
                }
            }
             ans= 0;
            int power= 1;
            for (int i = mainNumber.length() - 1; i >= 0; i--) {
                char c = mainNumber.charAt(i);
                int value = (c >= '0' && c <= '9') ? c - '0' : 10 + (c - 'A');
                ans += value * power;
                power *= baseInt;
            }


        }

        return ans;
    }



    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     *///if(num.contains("b") && !num.isEmpty() && num != null)
    public static boolean isNumber(String a) {
        boolean ans = true;
        if(a==null || a.isEmpty()||!a.contains("b")) {
            return false;
        }
        int indexOfB= a.indexOf("b");
        if(indexOfB==0|| indexOfB == a.length()-1){
            return false;
        }
        String number = a.substring(0, indexOfB);
        String base = a.substring(indexOfB+1);
        if(base.length() !=1){
            return false;
        }
        char baseChar = base.charAt(0);
        int baseInt;
        if(baseChar>= '0' && baseChar<='9'){
            baseInt= baseChar - '0';
        } else if (baseChar>='A' && baseChar<= 'G')  {
            baseInt = 10 + (baseChar-'A');
        }
        else {
            return false;
        }
        if(baseInt< 2 || baseInt> 16){
            return false;
        }
        String mainNumber = a.substring(0, indexOfB);
        for (int i=0; i< mainNumber.length(); i++){
            char c = mainNumber.charAt(i);
            int value;
            if (c >= '0' && c<='9'){
                value = c - '0';
            }
            else if (c >='A' && c<='F'){
                value = 10 + (c-'A');
            }
            else {
                return false;
            }

            if (value >=baseInt) {
                return false;
            }
        }
        return ans;
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     * @param num the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        String ans = "";
        if(num < 0 || base<2 || base>16){
            return  " ";
        }
        if(num==0){
            String baseString;
            if(base<10){
                baseString= Integer.toString(base);
            }
            else {
                baseString= Character.toString((char) ('A' + (base-10)));
            }
            return "0b" + baseString;
        }
        while (num>0 ) {
            int remainder = num% base;
            char digit;
            if(remainder<10){
                digit = (char) ('0'+ remainder);
            }
            else {
                digit= (char) ('A'+ (remainder-10));
            }
            ans = digit+ ans;
            num /= base;
        }
        char baseChar;
        if(base<10){
            baseChar = (char)('0'+base);
        }
        else {
            baseChar= (char) ('A'+ (base-10));
        }
        ans+= "b" + baseChar;
        return ans;
    }

    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
       if(!isNumber(n1) || !isNumber(n2)){
           return false;
       }
       int number1 = number2Int(n1);
       int number2 = number2Int(n2);
       if(number1 ==-1 || number2==-1){
           return false;
       }
       ans = (number1 == number2);

        return ans;
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     *
     */
    public static int maxIndex(String[] arr) {
        int ans = 0;
        int maxNum=0;
        for(int i=0; i<arr.length;i++){
            String str = arr[i];
            if(str==null|| str.isEmpty()){
                continue;
            }
            int val= toInteger(str);
            if(val>maxNum){
                maxNum = val;
                ans = i;
            }
        }

        return ans;
    }
    private static int toInteger(String str) {
        int result = 0;

        // Loop through each character in the string
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i); // Access character at index i
            int digit = c - '0';   // Convert character to integer
            result = result * 10 + digit; // Build the integer
        }

        return result;
    }



}
