package baekjoon.알고리즘기초1.자료구조1;

import java.util.Scanner;
import java.util.Stack;

public class Main1874 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        int idx = 1;
        for(int i=0; i<N; i++){
            int num = sc.nextInt();
            while(stack.isEmpty() || num > stack.peek()){
                stack.push(idx);
                idx++;
                sb.append("+").append('\n');
            }
            if(num == stack.peek()){
                stack.pop();
                sb.append("-").append('\n');
            }else{
                System.out.println("NO");
                return; //바로 출력하고 종료
            }

        }
        System.out.println(sb);
    }
}
