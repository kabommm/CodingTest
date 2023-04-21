package baekjoon.그래프와순회;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main24444 {
    static StringBuilder sb = new StringBuilder();  // 빠른 출력을 위한 StringBuilder선언
    // 정점들의 정보를 기록할 그래프
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int visit[]; // 방문한 정점을 기록할 배열
    static int rank = 0;    //방문 순서

    public static void bfs(int i) { //i는 시작 정점
        visit[i] = rank;    // 방문처리
        LinkedList<Integer> q = new LinkedList<>(); //LinkedList로 큐를 만든다.
        q.offer(i); //방문한 노드를 큐에 넣는다.

        while (!q.isEmpty()) {  //큐가 비어있을 떄 까지 반복
            int num = q.poll(); //방문한 노드를 빼고
            for(int j=0; j< graph.get(num).size(); j++) {
                int next = graph.get(num).get(j);
                //다음 갈 정점을 방문했었는지 체크
                if(visit[next] == 0){   //방문한 적이 없으면
                    rank++;
                    visit[next] = rank;
                    q.offer(next);  //큐에 저장
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();  //정점의 수
        int m = sc.nextInt(); //간선의 수
        int r = sc.nextInt(); //시작 정점
        visit = new int[n+1];	// 정점의 탐색 여부 체크
        // graph의 index를 정점의 개수만큼 만들어줌
        for(int i =0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){ // 인접리스트 통한 연결정보 저장
            int start  = sc.nextInt();
            int last  = sc.nextInt();
            graph.get(start).add(last);
            graph.get(last).add(start);
        }
        // 오름차순을 위해 정렬
        for(int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }
        // 시작 정점도 순서에 포함이므로 rank 초기값 1 할당
        rank = 1;
        // 깊이 우선 탐색 재귀 시작
        bfs(r);

        // 각 인덱스별로 방문 순서가 기록된 배열을 순회하며, 값을 StringBuilder에 저장
        for(int i = 1; i < visit.length; i++) {
            sb.append(visit[i]).append('\n');
        }
        System.out.println(sb);
    }
}
