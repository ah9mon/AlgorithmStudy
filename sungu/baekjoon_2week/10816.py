import sys
from collections import Counter
input = sys.stdin.readline

M=int(sys.stdin.readline())
list1=list(map(int,sys.stdin.readline().split()))
N=int(sys.stdin.readline())
list2=list(map(int,sys.stdin.readline().split()))

c= Counter(list1)

for i in list2:
  if i in c:
    print(c[i], end=' ')
  else:
    print(0, end=' ')