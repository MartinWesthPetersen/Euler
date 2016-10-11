#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <sstream>

using namespace std;

bool is_perm(vector<char> x, vector<char> y) {
  if (x.size() != y.size()) {
    return false;
  }
  vector<char>::iterator itx;
  for (itx = x.begin(); itx != x.end(); itx++) {
    if (find(y.begin(), y.end(), *itx) == y.end()) {
      return false;
    } else {
      y.erase(find(y.begin(), y.end(), *itx));
    }
  }
  return true;
}

vector<char> split_int(int x) {
  vector<char> v;
  stringstream ss;
  ss << x;
  string s = ss.str();
  for (string::iterator it = s.begin(); it != s.end(); it++) {
    v.push_back(*it);
  }
  return v;
}

int find_number() {
  for (int i = 1; i < 1000000; i++) {
    vector<char> l = split_int(i);
    if (is_perm(l, split_int(i * 2)) 
        && is_perm(l, split_int(i * 3))
        && is_perm(l, split_int(i * 4))
        && is_perm(l, split_int(i * 5))
        && is_perm(l, split_int(i * 6))) {
      return i;
    }
  }
  return 0;
}

int main() {
  cout << find_number() << "\n";
  return 0;
}
