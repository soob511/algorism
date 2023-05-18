def solution(my_string, overwrite_string, s):
    answer = ''
    answer += my_string[0:s]
    answer += overwrite_string
    answer += my_string[len(answer):]
    return answer
  
  //return my_string[:s] + overwrite_string + my_string[s + len(overwrite_string):]
