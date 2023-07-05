#페인트가 칠해지지 않은 첫번 째 지점에서 롤러 길이만큼 더한 곳까지 칠한다(횟수 + 1)
#롤러를 칠한 끝 지점으로 옮긴다
#해당 지점이 section에 있는 다음 칠해지지 않은 곳보다 멀리 있다는 말은 첫번째꺼 칠할 때 같이 칠해졌을테니까 무시
#반복



def solution(n, m, section):
    answer = 0
    while section:
        painter = section[0] + m  #첫번 째 지점에서 롤러로 칠했을 때 가장 끝 지점
        while section and section[0] < painter: #칠해지지 않은 곳이 남아 있고 롤러가 더 멀리 가있다면
            section.pop(0)  #다음 번 째 칠해지지 않은 곳은 앞에서 같이 칠해졌을테니 무시
        answer += 1 #횟수 + 1
    return answer