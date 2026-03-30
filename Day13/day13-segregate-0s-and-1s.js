/*
Segregate 0s and 1s (Easy)
(See Java file for full problem description)
*/

class Solution {
  segregate0and1(arr) {
    let left = 0;
    for (let i = 0; i < arr.length; i++) {
      if (arr[i] === 0) {
        // Using array destructuring for a clean swap
        [arr[i], arr[left]] = [arr[left], arr[i]];
        left++;
      }
    }
  }
}
