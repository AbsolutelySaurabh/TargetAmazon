#include<iostream>
using namespace std;

void solve(int arr[], int n, int k){

    int start = 0, end = 0;
    int max = INT_MIN;
    while(end < k-1){
        if(arr[end] > max){
            max = arr[end];
        }
        end++;
    }
    if(arr[end] > max){
        max = arr[end];
    }
    cout<<max<<" ";
    while(end <= n-k){

        end++;
        start++;
        if(arr[end] > max){
            max = arr[end];
        }
        cout<<max<<" ";
    }
}

int main(){

    int test;
    cin>>test;

    while(test){

        int n;
        cin>>n;

        int arr[n];
        for(int i = 0; i<n; i++){
            cin>>arr[i];
        }
        int k;
        cin>>k;
        solve(arr, n, k);
        test--;
    }

}