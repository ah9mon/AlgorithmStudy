import sys
input = sys.stdin.readline

n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]

result = []
def solution(x, y, N):
    color = graph[x][y]
    for i in range(x, x+N):
        for j in range(y, y+N):
            if color != graph[i][j]:
                solution(x, y, N//2)
                solution(x, y+N //2, N//2)
                solution(x+N//2, y, N//2)
                solution(x+N//2, y+N//2, N//2)
                return
    if color == 0:
        result.append(0)
    else:
        result.append(1)

solution(0, 0, n)
print(result.count(0))
print(result.count(1))