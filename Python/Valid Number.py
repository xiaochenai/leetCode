class Solution:
    # @param s, a string
    # @return a boolean
    # @finite automation
	# 首先这个题有9种状态：

# 0初始无输入或者只有space的状态
# 1输入了数字之后的状态
# 2前面无数字，只输入了dot的状态
# 3输入了符号状态
# 4前面有数字和有dot的状态
# 5'e' or 'E'输入后的状态
# 6输入e之后输入Sign的状态
# 7输入e后输入数字的状态
# 8前面有有效数输入之后，输入space的状态

# 共9种状态了，难设计的是6,7,8状态。

# 分好之后就好办了，设计出根据输入进行状态转换就OK了。

# 这里的输入可以分：

# INVALID=0;#无效输入包括: Alphas, '(', '&' ans so on
# SPACE=1
# SIGN=2 # '+' or '-'
# DIGIT=3 # numbers
# DOT=4 # '.'
# EXPONENT=5 # 'e' or 'E'

# 转移矩阵A(9X6)如下：

# -1,  0,  3,  1,  2,  -1
# -1,  8, -1,  1,  4,   5
# -1, -1, -1,  4, -1, -1
# -1, -1, -1,  1, 2,  -1
# -1,  8, -1,  4, -1,  5
# -1, -1,  6,  7, -1, -1
# -1, -1, -1,  7, -1, -1
# -1,  8, -1,  7, -1, -1
# -1,  8, -1, -1, -1, -1

# 行代表了9种状态，列代表了6种输入方式也就是6种跳转方式。举个例子：A[0][2]=3，这有什么含义呢？意思是：第0种状态为【0初始无输入或者只有space的状态】，在输入第2种输入【SIGN=2 # '+' or '-'】后，会跳转到第3种状态【3输入了符号状态】。A[1][1]=8是什么意思呢？意思是：第1种状态为【1输入了数字之后的状态】，在输入第1种输入【SPACE=1】后，跳转到了第8种状态【8前面有有效数输入之后，输入space的状态】。

# 根据以上的解释，大家应该明白什么事状态间的跳转了，这个共9种状态，所以是确定有穷自动机。其实难点在于状态的分割，要把每种情况都想到。

# 而这9种状态中：只有1、4、7、8这四种状态合法，所以最后state跳转到这四种状态之一时，说明输入是合法的！
    def isNumber(self, s):
        INVALID=0; SPACE=1; SIGN=2; DIGIT=3; DOT=4; EXPONENT=5;
        #0invalid,1space,2sign,3digit,4dot,5exponent,6num_inputs
        transitionTable=[[-1,  0,  3,  1,  2, -1],    #0 no input or just spaces 
                         [-1,  8, -1,  1,  4,  5],    #1 input is digits 
                         [-1, -1, -1,  4, -1, -1],    #2 no digits in front just Dot 
                         [-1, -1, -1,  1,  2, -1],    #3 sign 
                         [-1,  8, -1,  4, -1,  5],    #4 digits and dot in front 
                         [-1, -1,  6,  7, -1, -1],    #5 input 'e' or 'E' 
                         [-1, -1, -1,  7, -1, -1],    #6 after 'e' input sign 
                         [-1,  8, -1,  7, -1, -1],    #7 after 'e' input digits 
                         [-1,  8, -1, -1, -1, -1]]    #8 after valid input input space
        state=0; i=0
        while i<len(s):
            inputtype = INVALID
            if s[i]==' ': inputtype=SPACE
            elif s[i]=='-' or s[i]=='+': inputtype=SIGN
            elif s[i] in '0123456789': inputtype=DIGIT
            elif s[i]=='.': inputtype=DOT
            elif s[i]=='e' or s[i]=='E': inputtype=EXPONENT
            
            state=transitionTable[state][inputtype]
            if state==-1: return False
            else: i+=1
        return state == 1 or state == 4 or state == 7 or state == 8