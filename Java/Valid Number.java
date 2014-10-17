class Valid Number{
	public boolean isNumber(String s) {
		//int[] inputType = {0,1,2,3,4,5};
                              //input: invalid(0)  numbers(1)  dot(2)  space(3)  e/E(4)  sign(5)
		int[][] transitionTable =     {{-1,           1,         2,       0,      -1,        8},//no input/only space(0)
									   {-1,           1,         3,       4,      5,        -1},//numbers(1)
									   {-1,           3,        -1,       -1,       -1,       -1},//dot(2)
									   {-1,           3,         -1,       4,       5,        -1},//number and dots(3)
									   {-1,           -1         -1,       4,      -4,         -4},//valid with space in the back(4)
									   {-1,           6,          -1,     -1        -1          7},//e/E(5)
									   {-1,           6,          -1,      4,       -1,         -1},//e/E with number in back(6)
									   {-1,           6,          -1,      -1,       -1,         -1},//e/E with sign in back
									   {-1,           1,          2,      -1,       -1,          -1}};//sign}
		int state = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int input = 0;
            if(c == ' ')
                input = 3;
            else if(c == '.')
                input = 2;
            else if(c == 'e' || c == 'E')
                input = 4;
            else if(c == '+' || c == '-')
                input = 5;
            else if(c >= '0' && c <= '9')
                input = 1;
            state = transitionTable[state][input];
            if(state == -1)
                return false;
        }
        return state == 6 || state == 1 || state == 5 || state == 7;							
	}
}