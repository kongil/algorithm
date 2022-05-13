import java.util.*;

class Solution4_1 {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answerList = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            int plays_genre = map.getOrDefault(genre, 0);

            map.put(genre, plays_genre+play);

        }

        ArrayList<String> genreList = new ArrayList<>();
        for (String genre : map.keySet()) {
            genreList.add(genre);
        }
        Collections.sort(genreList, ((o1, o2) -> map.get(o2) - map.get(o1)));

        for (String genre : genreList) {
            int first_idx = -1;
            int second_idx = -1;
            int max = 0;
            for (int i = 0; i < genres.length; i++) {
                if (genre.equals(genres[i]) && max < plays[i]) {
                    max = plays[i];
                    first_idx = i;
                }
            }

            max = 0;
            for (int i = 0; i < genres.length; i++) {
                if (genre.equals(genres[i]) && max < plays[i] && i != first_idx) {
                    max = plays[i];
                    second_idx = i;
                }
            }

            answerList.add(first_idx);
            if (second_idx != -1) answerList.add(second_idx);
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0 ; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}

public class Heap4_1 {
    public static void main(String[] args) {
        Solution4_1 solution = new Solution4_1();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        int[] ans = solution.solution(genres, plays);
        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}
