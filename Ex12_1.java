import java.util.Scanner;


public class Ex12_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("연산>>");
		int a = scanner.nextInt();
		String i = scanner.next();
		int b = scanner.nextInt();
		int abi = 0;
		
		if (i.equals("*")) {
			abi = a*b;	
		}
		else if (i.equals("+")) {
			abi = a+b;
		}
		else if (i.equals("-")) {
			abi = a-b;
		}
		else if (i.equals("/")) {
			if (b==0) {
				System.out.print("0으로 나눌 수 없습니다.");
				scanner.close();
				return;
			}
			else
				abi = a/b;
		}
		else {
			System.out.print("사칙연산이 아닙니다.");
			scanner.close();
			return;
		}
		System.out.println(a+i+b+"의 계산 결과는"+abi);
		scanner.close();
	}

}
