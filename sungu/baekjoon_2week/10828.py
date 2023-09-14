import sys
input = sys.stdin.readline

n = int(input())
arr = [input() for _ in range(n)]
queue = []

for i in arr:
    if 'push' in i.split()[0]:
        queue.append(i.split()[1])
    elif 'pop' in i:
        print(queue.pop(0)) if queue else print(-1)
    elif 'size' in i:
        print(len(queue))
    elif 'empty' in i:
        print(0) if queue else print(1)
    elif 'front' in i:
        print(queue[0]) if queue else print(-1)
    elif 'back' in i:
        print(queue[-1]) if queue else print(-1)