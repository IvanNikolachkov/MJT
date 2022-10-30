#include <assert.h>
#include <ctype.h>
#include <limits.h>
#include <math.h>
#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int totalCost(int arrCount, int* arr, int cost){
    if(arrCount == 2){
        return ceil((arr[0]+arr[1])/(fmax(arr[0],arr[1])-fmin(arr[0],arr[1])+1)) + cost;
    }
    int minEl = arr[0];
    int maxEl = arr[0];
    int sum = 0;
    int* arr2 = malloc(sizeof(int)*(arrCount-1));
    for(int i = 0; i<arrCount; i++){
        if(arr[i]>maxEl)
            maxEl = arr[i];
        if(arr[i]<minEl)
            minEl = arr[i];
    }
    sum = minEl + maxEl;
    int j = 0;
    for(int i = 0; i<arrCount; i++){
        if(arr[i]!=minEl || arr[i]!= maxEl){
            arr2[j] = arr[i];
            j++;
        }
    }
    arr2[arrCount-2] = sum;
    
    return totalCost(arrCount-1, arr2, ceil((minEl+maxEl)/(maxEl-minEl + 1))+cost);
    
}

int findTotalCost(int arr_count, int* arr) {
    return totalCost(arr_count, arr, 0);
}

int main(){
	int arr[] = {2,3,4,5,7};
	int res = findTotalCost(5,&arr);
	printf("%d",res);
	return 0;
}