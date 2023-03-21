import java.util.Scanner;

public class Ex12_2 {
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("연산 >>");
		int a = scanner.nextInt();
		String i = scanner.next();
		int b = scanner.nextInt();
		int abi = 0;
		
		switch(i) {
		case "+": abi=a+b;
		break;
		case "-": abi=a-b;
		case "*": abi=a*b;
		case "/":
			if(b==0) {
				System.out.print("0으로 나눌 수 없다.");
				scanner.close(); }
			break;
			default: System.out.print("사칙연산이 아닙니다.");
			scanner.close();
			break;
			}
		System.out.print(a+i+b+"의 계산 결과"+abi);
		scanner.close();
		}
}

