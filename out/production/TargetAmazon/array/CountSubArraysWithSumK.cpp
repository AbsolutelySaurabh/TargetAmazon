/*
count subarryas with sum = K
eg: {4, 5, 0, -2, -3, 1}
K = 5
ans = 3
*/

/*
Algorithm:
---------
sum+=arr[i];
if(sum == K) --> count++;
if(map[sum-K]!=null) --> count+=map[sum-K]
map.put(sum-k, 1)

*/

#include<iostream>
#include<unordered_map>
using namespace std;

int solve(int arr[], int n, int K){

    int count = 0;
    unordered_map<int, int> map;
    int sum = 0;

    for(int i =0; i<n; i++){

        sum+=arr[i];
        if(sum == K){
            count++;
        }
        if(map.find(sum - K) != map.end()){
            count+=map[sum-K];
        }
        map[sum]++;
    }
    return count;
}

int main(){

    int test;
    cin>>test;

    while(test > 0){

        int n;
        cin>>n;

        int arr[n];
        for(int i = 0; i<n; i++){
            cin>>arr[i];
        }
        int k;
        cin>>k;
        cout<<solve(arr, sizeof(arr)/sizeof(arr[0]), k)<<endl;

        test--;
    }

}