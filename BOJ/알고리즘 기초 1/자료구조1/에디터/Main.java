package baekjoon.알고리즘기초1.자료구조1.에디터;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int num = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        for(int i=0; i<num; i++){
            String com = br.readLine();
            if(com.equals("L")){
                if (!stack.empty()) {
                    stack2.push(stack.pop());
                }
            }else if(com.equals("D")){
                if (!stack2.empty()) {
                    stack.push(stack2.pop());

                }
            }
            else if(com.equals("B")){
                if (!stack.empty()) {
                    stack.pop();
                }
            }
            else if(com.contains("P")){   //P $
                stack.push(com.charAt(2));
            }
        }
        while(!stack.isEmpty()){ //abcdy x
            stack2.push(stack.pop());
        }
        while(!stack2.isEmpty()){
            sb.append(stack2.pop());
        }
        System.out.println(sb);
    }
}
