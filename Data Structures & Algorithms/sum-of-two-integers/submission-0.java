class Solution {
    public int getSum(int a, int b) {
        while(b != 0) {
            int carry = a & b;
            int shiftCarry = carry << 1;
            int sum = a ^ b;
            a = sum;
            b = shiftCarry;
        }
        return a;
    }
}
