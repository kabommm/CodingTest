package baekjoon.알고리즘기초1.자료구조1;

import java.util.Scanner;
import java.util.Stack;

public class Main9012 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=0; i<N; i++){
            String str = sc.next();
            Stack<Character> stack = new Stack<>();
            for(int j=0; j<str.length(); j++) {
                if(str.charAt(j) == ')') {
                    if(stack.isEmpty()){
                        stack.push(str.charAt(j));
                        break;
                    }
                    stack.pop();
                }else{  //'('
                    stack.push(str.charAt(j));
                }
            }
            if(stack.isEmpty()) {
                sb.append("YES").append('\n');
            }else if(stack.size() == 1 && stack.peek() == ')'){
                sb.append("NO").append('\n');
            }else{
                sb.append("NO").append('\n');
            }
        }
        System.out.println(sb);
    }
}
