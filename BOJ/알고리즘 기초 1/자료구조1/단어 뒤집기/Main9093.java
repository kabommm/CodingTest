package baekjoon.알고리즘기초1.자료구조1;

import java.util.Scanner;
import java.util.Stack;

public class Main9093 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        //Scanner는 nextInt()를 하면 띄워쓰기를 기준으로 입력값을 받아들이고,
        //개행문자인 \n이 그대로 남아있어
        //그 다음의 nextLine()을 쓰면 nextLine()이 씹히게 됩니다.
        //nextInt()뒤에 nextLine()을 하나 붙여주어야 한다.
        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            String str = sc.nextLine();
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == ' ') {  //공백이 나오면
                    while(!stack.empty()){    //스택이 비어있지 않으면
                        sb.append(stack.pop());
                    }
                    sb.append(" ");
                }else{
                    stack.add(str.charAt(j));
                }
            }
            while(!stack.empty()){  //맨 마지막 단어
                sb.append(stack.pop());
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
