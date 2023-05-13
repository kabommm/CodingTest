package baekjoon.알고리즘기초1.자료구조1;

import java.util.*;

public class Main10828 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++){
            String str = sc.next();
            if(str.contains("push")){
                int num = sc.nextInt();
                stack.push(num);
            }else if(str.equals("pop")){
                if(stack.isEmpty()){    //비었으면
                    sb.append(-1).append('\n');
                }else{
                    sb.append(stack.pop()).append('\n');
                }
            }else if(str.equals("size")){
                sb.append(stack.size()).append('\n');
            }else if(str.equals("empty")){
                if(stack.isEmpty()){    //비었으면
                    sb.append(1).append('\n');
                }else{
                    sb.append(0).append('\n');
                }
            }else if(str.equals("top")){  //top
                if(stack.isEmpty()){    //비었으면
                    sb.append(-1).append('\n');
                }else{
                    sb.append(stack.peek()).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}
