class Integer to Roman{
	public String intToRoman(int num) {
        String[] romList = {"I","V","X","L","C","D","M"};
        int scale = 1000;
        String roman = "";
        for(int i=6;i>=0;i=i-2){
            int digit = num/scale;
            if(digit != 0){
                if(digit <= 3){
                    for(int j=0;j<digit;j++){
                        roman = roman + romList[i];
                    }
                }
                else if(digit == 4){
                    roman = roman + romList[i];
					roman = roman + romList[i+1];
                }
                else if(digit == 5){
                    roman = roman + romList[i+1];
                }
                else if(digit <= 8){
                    roman = roman + romList[i+1];
                    for(int j=0;j<(digit-5);j++){
                        roman = roman + romList[i];
                    }
                }
                else if(digit == 9){
                    roman = roman + romList[i];
					roman = roman + romList[i+2]; 
                }
            }
            num = num % scale;
			scale = scale / 10;
        }
        return roman;
    }
}