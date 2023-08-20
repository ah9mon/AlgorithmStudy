import sys
from collections import deque

N, K = map(int, input().split())
d = deque([i for i in range(1, N+1)])

arr = []
while len(d) != 0:
    for _ in range(K-1):
        d.append(d.popleft())
    arr.append(str(d.popleft()))
print("<" + ",".join(arr) + ">")