public boolean canReach(int[] arr, int start) {
    if (arr == null || arr.length == 0) 
        return false;

    int[] visited = new int[arr.length];
    return canReachFromIndex(arr, start, visited);
}

private boolean canReachFromIndex(int[] arr, int start, int[] visited) {
    if (start < 0 || start >= arr.length || visited[start] == 1) 
        return false;

    if (arr[start] == 0) 
        return true;

    visited[start] = 1;

    return canReachFromIndex(arr, start + arr[start], visited) || 
           canReachFromIndex(arr, start - arr[start], visited);
}
