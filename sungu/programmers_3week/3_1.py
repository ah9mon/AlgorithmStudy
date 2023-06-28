def solution(today, terms, privacies):
    answer = []
    today_year = int(float(today[0:5])) #오늘 년도
    today_month = int(float(today[5:7]))  #오늘 달
    today_day = int(float(today[8:10])) #오늘 날짜
    
    for i in range(len(privacies)):
        privacy = privacies[i]
        year = int(float(privacy[0:5])) #테스트케이스 년도
        month = int(float(privacy[5:7]))  #테스트케이스 달
        day = int(float(privacy[8:10])) #테스트케이스 날짜
        term = privacy[11]  #약관 종류
        year_dif = today_year - year  #오늘 년도 - 테스트케이스 년도
        month_dif = today_month - month #오늘 달 - 테스트케이스 달
        day_dif = today_day - day   #오늘 날짜 - 테스트케이스 날짜
        total_dif = day_dif + (month_dif*28) + (year_dif*12*28) #개인정보 수집 날짜로부터 오늘까지 총 일 수
        for j in range(len(terms)): #어떤 약관 종류인지 찾기
            if term == terms[j][0]:
                term_of_privacies = int(terms[j][2:]) * 28  
                if term_of_privacies <= total_dif:  #해당 약관 유효기간을 지났으면
                    answer.append(i+1)  #정답에 추가
        
    return answer