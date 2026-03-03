class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) return '0';
        
        int length = (1 << n) - 1;     // Length of Sn
        int middle = (length + 1) / 2; // Middle index of Sn

        // Middle element is always '1'
        if (k == middle) return '1';

        // Left half is exactly Sn-1
        if (k < middle) {
            return findKthBit(n - 1, k);
        }

        // Right half is reversed + inverted Sn-1
        int mirroredIndex = length - k + 1;
        char bit = findKthBit(n - 1, mirroredIndex);

        // Invert the bit
        return (bit == '0') ? '1' : '0';
    }
}
