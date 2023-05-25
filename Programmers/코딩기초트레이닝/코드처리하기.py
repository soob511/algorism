def solution(code):
    answer = ''
    mode = 0
    idx=0
    for i in code:
        if mode==0:
             if i=="1": mode=1
             else:
                if idx%2==0:
                    answer+=i
        else:
            if mode==1:
             if i=="1": mode=0
             else:
                if idx%2==1:
                    answer+=i
        idx+=1 
    
    if(answer==""):return "EMPTY"
    else:
        return answer
      
      
      
      def solution(code):
    answer = ''
    mode = 0
    for i in range(len(code)):
        if mode==0:
             if code[i]=="1": mode=1
             else:
                if i%2==0:
                    answer+=code[i]
        else:
            if mode==1:
             if code[i]=="1": mode=0
             else:
                if i%2==1:
                    answer+=code[i]
    
    return answer if answer else "EMPTY"
    
