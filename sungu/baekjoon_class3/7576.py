from collections import deque
q = deque()
m, n = map(int, input().split())
graph = [list(map(int, input().split()) for _ in range(n))]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
res = 0

for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            q.append([i, j])

def bfs():
    while q:
        y, x = q.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < n and 0 <= nx < m and graph[ny][nx] == 0:
                q.append([ny, nx])
                graph[ny][nx] = graph[y][x] + 1

bfs()
for i in range(n):
    for j in i:
        if j == 0:
            print(-1)
            exit(0)
    res = max(res, max(i))
print(res - 1)