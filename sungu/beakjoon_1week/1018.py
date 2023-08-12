n, m = map(int, input().split())  #가로 세로 입력 받기
board = []
result = []
for _ in range(n):  #체스판 입력 받기
    board.append(input())

for i in range(n-7):  
    for j in range(m-7):
        draw1 = 0 #한 번에 흑백 한번씩 확인
        draw2 = 0
        
        for a in range(i, i+8): #반복문 돌면서 흑백 확인하고, 잘못 칠해진 곳이면 cnt+1
            for b in range(j, j+8):
                if (a+b) % 2 == 0:
                    if board[a][b] != "B":
                        draw1 += 1
                    if board[a][b] != "W":
                        draw2 += 1
                else:
                    if board[a][b] != "W":
                        draw1 += 1
                    if board[a][b] != "B":
                        draw2 += 1
        result.append(draw1)  
        result.append(draw2)
print(min(result))  #각각 result에 추가하고 가장 덜 바꿔도 되는 체스판 출력