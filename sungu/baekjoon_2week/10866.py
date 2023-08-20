import sys
from collections import deque

input = sys.stdin.readline
n = int(input())
q = deque()
answer = []

for _ in range(n):
    a, *b = input().split()
    if a == 'push_front':
        q.appendleft(b[0])
    elif a == 'push_back':
        q.append(b[0])
    elif a == 'pop_front':
        answer.append(q.popleft() if q else '-1')
    elif a == 'pop_back':
        answer.append(q.pop() if q else '-1')
    elif a == 'size':
        answer.append(str(len(q)))
    elif a == 'empty':
        answer.append('0' if q else '1')
    elif a == 'front':
        answer.append(q[0] if q else '-1')
    elif a == 'back':
        answer.append(q[-1] if q else '-1')

print('\n'.join(answer))