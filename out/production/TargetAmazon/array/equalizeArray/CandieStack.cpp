#include<iostream>

using namespace std;

/*
Algorithm:
get the sum+=1rr[i]
if(sum%n!=0) = return -1
get the avg sum = sum/=n;
calc the cost to make sum

return cost/2; --> as each operation to change involves reval from 1 lement + addition to 1 eleemtn --> count it as 1
*/

int solve(int arr[], int n){

    int sum = 0;
    for(int i = 0; i<n; i++){
        sum+=arr[i];
    }
    if(sum%n!=0){
        return -1;
    }
    sum/=n;
    int ans = 0;
    cout<<"sum: "<<sum<<endl;
    for(int i = 0; i<n; i++){
        ans+=abs(sum - arr[i]);
    }
    return ans/2;

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

        cout<<solve(arr, sizeof(arr)/sizeof(arr[0]));

        test--;
    }

}