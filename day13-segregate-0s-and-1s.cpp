/*
Segregate 0s and 1s (Easy)
(See Java file for full problem description)
*/

#include <vector>
#include <utility>
using namespace std;

class Solution {
  public:
    void segregate0and1(vector<int> &arr) {
        int left = 0;
        for(int i = 0; i < arr.size(); i++){
            if(arr[i] == 0){
               swap(arr[i], arr[left]);
               left++;
            }
        }
    }
};