package baekjoon.알고리즘기초1.자료구조1.큐10845;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        int last = 0;
        for(int i=0; i<num; i++){
            String str = sc.next();

            if(str.equals("push")){
                //String arr[] = str.split(" ");
                last = sc.nextInt();
                queue.add(last);
            }else if(str.equals("pop")){
                if(queue.isEmpty()){    //비었으면
                    sb.append(-1).append('\n');
                }else{
                    sb.append(queue.poll()).append('\n');
                }
            }else if(str.equals("size")){
                sb.append(queue.size()).append('\n');
            }else if(str.equals("empty")){
                if(queue.isEmpty()){    //비었으면
                    sb.append(1).append('\n');
                }else{
                    sb.append(0).append('\n');
                }
            }else if(str.equals("front")){
                if(queue.isEmpty()){    //비었으면
                    sb.append(-1).append('\n');
                }else{
                    sb.append(queue.peek()).append('\n');
                }
            }else if(str.equals("back")){
                if(queue.isEmpty()){    //비었으면
                    sb.append(-1).append('\n');
                }else{
                    sb.append(last).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}
