#include <stdio.h>

int main() {
    int n, k;
    
    scanf("%d %d", &n, &k);
    
    int wires[n];
    long start, end = 1;
    
    for (int i = 0; i < n; i++) {
        scanf("%ld", &wires[i]);
        if (wires[i] > end) end = wires[i];
    }
    // printf("%d", max);

    while(start <= end) {
        long mid = (start+end)/2;
        if (mid == 0) break;
        long count = 0;
        for (int i = 0; i < n; i++) {
            count += wires[i]/mid;
        }

        if (count < k) end = mid-1; // 개수가 부족하면 더 작은 길이로 잘라야 하니까
        else start = mid + 1;
    }

    printf("%ld",  end);
}