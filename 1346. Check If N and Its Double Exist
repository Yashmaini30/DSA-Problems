class Solution {
    public boolean checkIfExist(int[] arr) {
        Map<Integer,Integer> map= new HashMap<>();
        for(int i:arr) {
            if(map.containsKey(2*i)) return true;
            if(i%2 ==0 && map.containsKey(i/2)) return true;
            map.put(i,map.getOrDefault(i,0)+1);

        }
        return false;
    }
}

// Brute force
// class Solution {
//     public boolean checkIfExist(int[] arr) {
//         int n = arr.length;
//         boolean flag = false;
//         for(int i=0; i<n; i++){
//             for(int j=i+1; j<n; j++){
//                 if(arr[i] == 2*arr[j] || arr[j] == 2*arr[i]){
//                     flag = true;
//                     break;
//                 }
//             }
//         }
//         return flag;
//     }
// }
