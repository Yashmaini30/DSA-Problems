class Solution {
    public int smallestNumber(int n) {
        if (n==1) return 1;
        else if (n==2 || n==3) return 3;
        else if (n>=4 && n<8) return 7;
        else if (n>=8 && n<16) return 15;
        else if (n>=16 && n<32) return 31;
        else if (n>=32 && n<64) return 63;
        else if (n>=64 && n<128) return 127;
        else if (n>=128 && n<256) return 255;
        else if (n>=256 && n<512) return 511;
        else return 1023;
    }
}
