from collections import deque

n, m, v = map(int, input().split())
graph = [[0] * (n+1) for _ in range(n+1)]
visited1 = [0] * (n+1)
visited2 = [0] * (n+1)

for _ in range(m):
    a, b = map(int, input().split())
    graph[a][b] = 1
    graph[b][a] = 1

def dfs(v):
    visited1[v] = 1
    print(v, end = " ")
    for i in range(1, n+1):
        if not visited1[i] and graph[v][i]:
            dfs(i)

def bfs(v):
    q = deque()
    q.append(v)
    visited2[v] = 1
    while q:
        v = q.popleft()
        print(v, end=" ")
        for i in range(1, n+1):
            if not visited2[i] and graph[v][i]:
                q.append(i)
                visited2[i] = 1
        
dfs(v)
print()
bfs(v)