class Solution {
    public int getDecimalValue(ListNode head) {
        int res = head.val;

        while(head.next != null){
            head = head.next;
            res = res*2 + head.val;
        }
        return res;
    }
}
