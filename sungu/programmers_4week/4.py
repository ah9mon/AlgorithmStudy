def solution(m, n, board):
    for i in range(m):  #board가 str로 저장되어 있어서 나중에 수정 불가하니 리스트로 미리 나눠줌
        board[i] = list(board[i])
    answer = 0
    while True: #4개 세트 안 만들어질 때 까지 반복
        visited = [[0 for _ in range(n)] for _ in range(m)] #한번의 반복마다 몇개 없어지는지 체크하기 위함
        cnt = 0
        #4개 쌍 찾기
        for i in range(m-1):  #젤 위 왼쪽꺼 기준으로 오른쪽, 아래, 왼쪽으로 돌면서 4개 세트 만들고 똑같으면 visited에 체크 
            for j in range(n-1):
                if board[i][j] == board[i+1][j+1] == board[i+1][j] == board[i][j+1] and board[i][j] != "":
                    visited[i][j] = 1
                    visited[i][j+1] = 1
                    visited[i+1][j+1] = 1
                    visited[i+1][j] = 1

        #삭제
        for i in range(m):
            for j in range(n):
                if visited[i][j] == 1:
                    board[i][j] = ""

        #없어지는 칸 개수 세기               
        for i in range(m):
            for j in range(n):
                if visited[i][j] == 1:
                    cnt += 1
        answer += cnt            
        if cnt == 0:
            break #없어지는 칸 없으면 break, 종료

        #한 칸씩 내리기
        move = True
        while move: #계속 내려오고, 더이상 내려오는 거 없으면 종료
            move = False
            for i in range(1, m):
                for j in range(n):
                    if board[i][j] == "" and board[i-1][j] != "":
                        board[i][j] = board[i-1][j]
                        board[i-1][j] = ""
                        move = True
    return answer