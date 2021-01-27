#include<iostream>
#include<math.h>

using namespace std;

int _len(int n){
    int len = 0;
    while(n > 0){
        len++;
        n/=10;
    }
    return len;
}

int reverse(int n){

    int ans = 0;
    int index = _len(n);
    while(n > 0){

        int rem = n%10;
        ans = ans + rem*pow(10, index-1);
        index--;
        n/=10;
    }
    return ans;
}

int main(){
    int n;
    cin>>n;
    cout<<reverse(n);
}