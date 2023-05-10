package baekjoon.그래프와순회;

import java.util.*;

public class Main2667 {
    static StringBuilder sb = new StringBuilder();

    static int n;   //지도의 크기
    static int count;   //단지집의 숫자
    static int[][] Map;  //2차원 배열 지도
    static boolean[][] visited;   //방문 배열
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0,-1}};  //상하좌우
    static ArrayList<Integer> result;   //단지 집 수 저장

    public static void dfs(int x, int y) {
        count++;    //1이라서 들어온 함수이므로 단지 내의 집 수 +1
        visited[x][y] = true;
        //인접하는 점 찾기
        for(int i=0; i< dir.length; i++){
            int nx = x + dir[i][0]; //이동한 x좌표
            int ny = y + dir[i][1]; //이동한 y좌표
            //밖으로 나가지 않는 좌표라면
            if(nx >=0 && ny >=0 && nx < n && ny < n){
                ////처음 방문이면서 집이 있는(1)
                if(Map[nx][ny] == 1 && !visited[nx][ny]){
                    dfs(nx,ny);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n  = sc.nextInt();  //지도의 크기
        //배열 지도
        Map = new int[n][n];
        visited = new boolean[n][n];

        //지도에 입력값 삽입
        for(int i=0; i<n; i++){
            String input = sc.next();
            for(int j=0; j<n; j++){
                Map[i][j] = Integer.parseInt(input.charAt(j)+"");
            }
        }

        //단지를 찾을 때 마다 단지를 기록해 줄 배열
        result = new ArrayList<>();
        //지도 탐색
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                //처음 방문이면서 집이 있는(1)
                if(Map[i][j] == 1 && !visited[i][j]){
                    count = 0;  //단지를 세는 변수 초기화
                    dfs(i,j);
                    result.add(count);  //단지 배열에 단지 내 집 수 추가
                }
            }
        }
        //단지 오름차순
        Collections.sort(result);
        sb.append(result.size()).append('\n');

        for(int i : result){
            sb.append(i).append('\n');
        }
        System.out.println(sb);
    }
}
