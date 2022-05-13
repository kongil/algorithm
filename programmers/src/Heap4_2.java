import java.util.*;

class Song implements Comparable<Song> {
    String genre;
    int play;

    public Song(String genre, int play) {
        this.genre = genre;
        this.play = play;
    }

    public String getGenre() {
        return genre;
    }

    public int getPlay() {
        return play;
    }

    @Override
    public int compareTo(Song o) {
        return o.play - this.play;
    }
}
class Solution4 {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            map.put(genre, map.getOrDefault(genre, 0) + play);
        }

        ArrayList<Song> list = new ArrayList<>();
        for (String key : map.keySet()) {
            list.add(new Song(key, map.get(key)));
        }
        Collections.sort(list);

        ArrayList<Integer> answer = new ArrayList<>();
        for (Song song : list) {
            int firstIdx = -1;
            int secondIdx = -1;
            int max = 0;
            for (int i = 0; i < genres.length; i++) {
                if (song.getGenre().equals(genres[i]) && plays[i] > max) {
                    firstIdx = i;
                    max = plays[i];
                }
            }
            max = 0;
            for (int i = 0; i < genres.length; i++) {
                if (song.getGenre().equals(genres[i]) && plays[i] > max && i != firstIdx) {
                    secondIdx = i;
                    max = plays[i];
                }
            }
            answer.add(firstIdx);
            if (secondIdx != -1) answer.add(secondIdx);
        }
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}

public class Heap4_2 {
    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        int[] ans = solution.solution(genres, plays);
        for (int an : ans) {
            System.out.print(an + " ");
        }

    }
}
