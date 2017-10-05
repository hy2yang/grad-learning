package assignment4;

class IntToRoman {
    public static void main(String args[]){
        System.out.println(intToRoman(40));
    }
    
    public static String intToRoman(int num) {
        StringBuilder result=new StringBuilder();
        int copy=num;
        while (copy-1000>=0) {
            result.append("M");
            copy-=1000;
        }
        String hundreds="";
        switch (copy/100) {
        case 9: hundreds="CM";break;
        case 8: hundreds="DCCC";break;
        case 7: hundreds="DCC";break;
        case 6: hundreds="DC";break;
        case 5: hundreds="D";break;
        case 4: hundreds="CD";break;
        case 3: hundreds="CCC";break;
        case 2: hundreds="CC";break;
        case 1: hundreds="C";break;
        case 0: break;
        }
        result.append(hundreds);
        
        copy%=100;
        if (copy>=50) {
            if (copy>=90) {
                result.append("XC");
                copy-=90;
            }
            else {
                result.append("L");
                while (copy-50>=10) {
                    result.append("X");
                    copy-=10;
                }
                copy-=50;
            }
        }
        else if(copy>9){
            if (copy/10==4) {
                result.append("XL");
                copy%=10;
            }
            else {
                while (copy-10>=0) {
                    result.append("X");
                    copy-=10;
                }
            }
        }
        String ones="";
        switch (copy) {
        case 9: ones="IX";break;
        case 8: ones="VIII";break;
        case 7: ones="VII";break;
        case 6: ones="VI";break;
        case 5: ones="V";break;
        case 4: ones="IV";break;
        case 3: ones="III";break;
        case 2: ones="II";break;
        case 1: ones="I";break;
        case 0: break;
        }
        result.append(ones);  
        return result.toString();
    }

}
