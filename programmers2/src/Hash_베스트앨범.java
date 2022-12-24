import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.*;

public class Hash_베스트앨범 {
    static class Solution {
        public int[] solution(String[] genres, int[] plays) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < genres.length; i++) {
                String genre = genres[i];
                if (map.containsKey(genre)) {
                    int ex = map.get(genre);
                    map.put(genre, ex + plays[i]);
                }
                else {
                    map.put(genre, plays[i]);
                }
            }
            List<String> genreList = new ArrayList<>();
            for (String key : map.keySet()) {
                genreList.add(key);
            }

            Collections.sort(genreList, ((s1, s2) -> (map.get(s2) - map.get(s1))));
            for (String s : genreList) {
                System.out.print(s + " " +map.get(s) + " " );
            }
            System.out.println();

            List<Integer> answerList = new ArrayList<>();
            for (int i = 0; i < genreList.size(); i++) {
                String genre = genreList.get(i);
                int m1 = 0, m2 = 0, i1 = -1, i2 = -1;
                for (int j = 0; j < plays.length; j++) {
                    if (genre.equals(genres[j]) && plays[j] > m1) {
                        i1 = j;
                        m1 = plays[j];
                    }
                }
                for (int j = 0; j < plays.length; j++) {
                    if (genre.equals(genres[j]) && plays[j] > m2 && j != i1) {
                        i2 = j;
                        m2 = plays[j];
                    }
                }
                answerList.add(i1);
                if (i2 != -1) answerList.add(i2);
            }

            int[] answer = new int[answerList.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = answerList.get(i);
            }

            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] genres = {"classic", "pop", "classic", "classic", "pop", "classic", "jazz"};
        int[] plays = {500, 600, 150, 800, 2500, 100, 10000};
        String[] a = {"a","b","c","d","a","d","d","d","a","a","c","c"};
        int[] b = {100, 300, 400, 150, 100, 300, 200, 600, 700, 110, 900, 9000};

        int[] answer = solution.solution(genres, plays);
//        int[] answer = solution.solution(a, b);
        for (int x : answer) {
            System.out.println("a = " + x);
        }

    }
}
