#include <iostream>
#include<bits/stdc++.h>
#define MAX 1000
using namespace std;
class Queue{
  int pos;
public:
  int a[MAX];
  Queue(){
    pos=-1;
  }
  void push(int n);
  void pop();
  int front();
  int back();
};
void Queue::push(int n){
  if(pos>=MAX){
    cout<<"Override"<<endl;
    return;
  }
  a[++pos]=n;
  cout<<n<<" has been added"<<endl;
}
void Queue::pop(){
  cout<<"popped element : "<<a[pos];
  pos--;
}
int Queue::front(){
  return a[0];
}
int Queue::back(){
  return a[pos];
}
int main() {
  class queue q;
	return 0;
}