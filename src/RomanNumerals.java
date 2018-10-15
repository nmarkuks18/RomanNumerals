
public class RomanNumerals {
	public int convertToInteger(String romanNum) {
		String input=romanNum;
		int numeric=0;
		int subtraction=0;		
		int lenght=input.length();
		int i=0;
		checkIfRepeated(input);//L, D or V can't be repeated
		checkIf4inARow(input);//I, X, C or M can be repeated max 3 times in a row
		checkTooHighSubtraction(input);//symbols I, X, and C can only be subtracted from the 2 next highest values
		checkSubtractionsPerNumeral(input);//only one subtraction can be made per numeral
		checkSubtractionOf5Symbols(input);//V, L and D can never be subtracted
		checkInputCharacters(input);//only accept roman numbers as input
		 
		
		while(i<lenght) {
			
			if(lenght==i+1) {//only one roman character inserted
				numeric=numeric+getNumber(input.charAt(0));								
			}
			else if(getNumber(input.charAt(i))<getNumber(input.charAt(i+1))){				
				subtraction=getNumber(input.charAt(i+1))-getNumber(input.charAt(i));
				numeric=numeric+subtraction;
				i++;
				subtraction=0;
			}
			else {
				numeric=numeric+getNumber(input.charAt(i));
			}
			i++;			
		}
		
		return numeric;		 
	}

	private void checkInputCharacters(String input) {
		if (input.matches(".*[0-9].*") || !input.matches("[M|D|C|L|X|V|I]*")) {
            throw new IllegalArgumentException();
        }
		
	}

	private void checkSubtractionOf5Symbols(String input) {
		int lenght=input.length();
		int i=0;
		while(i<lenght-1) {
			if(getNumber(input.charAt(i))<getNumber(input.charAt(i+1))) {
				if(input.charAt(i)=='V' || input.charAt(i)=='L' || input.charAt(i)=='D') {
					throw new IllegalArgumentException();
				}
			}
			i++;
		}
		
	}

	private void checkSubtractionsPerNumeral(String input) {
		int lenght=input.length();
		int i=0;
		while(i<lenght-1) {
			if(getNumber(input.charAt(i))<getNumber(input.charAt(i+1))) {
			if(i>0) {
				if(getNumber(input.charAt(i-1))<=getNumber(input.charAt(i))) {
					throw new IllegalArgumentException();
				}
			}}
			i++;
		}
		
	}

	private void checkTooHighSubtraction(String input) {
		int a=input.indexOf("IL");
		int b=input.indexOf("IC");
		int c=input.indexOf("ID");
		int d=input.indexOf("IM");
		int e=input.indexOf("XD");
		int f=input.indexOf("XM");
		
		if(a>=0 || b>=0 || c>=0 || d>=0 || e>=0 || f>=0) {
			throw new IllegalArgumentException();
		}
		
	}

	private void checkIf4inARow(String input) {
		int a=input.indexOf("IIII");
		int b=input.indexOf("XXXX");
		int c=input.indexOf("CCCC");
		int d=input.indexOf("MMMM");
		
		if (a>=0 || b>=0 || c>=0 || d>=0) {
			throw new IllegalArgumentException("Invalid input");
		}
		
	}

	private void checkIfRepeated(String input) {
		int a=input.indexOf("VV");
		int b=input.indexOf("LL");
		int c=input.indexOf("DD");
		
		if (a>=0 || b>=0 || c>=0) {
			throw new IllegalArgumentException("Invalid input");
		}
	}

	public int getNumber(char c) {
			
		int number=0;
		char symbol=c;
		
		switch (symbol) {
        case ('I'):
            number = 1;
            break;
        case ('V'):
            number = 5;
            break;
        case ('X'):
        	number = 10;
            break;
        case ('L'):
        	number = 50;
            break;
        case ('C'):
        	number = 100;
            break;
        case ('D'):
        	number = 500;
            break;
        case ('M'):
        	number = 1000;
            break;
        }
		
		return number;
	}
	
}
