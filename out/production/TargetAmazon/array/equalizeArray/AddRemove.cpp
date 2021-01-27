/*
Make all array elements eqial with min operations
[1, 100, 101] = 100
1 -> 100, 100-> 100, 101-> 100
*/

#include <iostream>
// #include <bits/stdc++.h>

using namespace std;

int solve(int arr[], int n){
    
    //cout<<"n: "<<n;
    int mid = 0;
    if(n%2 == 0){
        mid = arr[n/2] + arr[(n-1)/2];
    }else{
        mid = arr[n/2];
    }
    
    int sum = 0;
    for(int i = 0; i<n; i++){
        sum+=abs(arr[i] - mid);
    }
    return sum;
}

int main() {
    
    int test;
    cin>>test;
    while(test){
        
        int n;
        cin>>n;
        int arr[n];
        for(int i = 0; i<n; i++){
            cin>>arr[i];
        }
        int size = sizeof(arr)/sizeof(arr[0]);
        cout<<solve(arr, size);
        test--;
    }
    
    return 0;
}