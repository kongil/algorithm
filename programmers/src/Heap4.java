import java.util.*;

class Song implements Comparable<Song> {
    String genre;
    int cnt;
    int no;

    public Song(String genre, int cnt, int no) {
        this.genre = genre;
        this.cnt = cnt;
        this.no = no;
    }

    public String getGenre() {
        return genre;
    }

    public int getCnt() {
        return cnt;
    }

    public int getNo() {
        return no;
    }

    @Override
    public int compareTo(Song o) {
        if (o.cnt < cnt) {
            return -1;
        }
        else if (o.cnt == cnt) {
            if (o.no > no) {
                return -1;
            }
        }

        return 1;
    }
}
class Solution4 {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answerList = new ArrayList<>();
        HashMap<String, ArrayList<Song>> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            int plays_genre = map2.getOrDefault(genre, 0);

            map2.put(genre, plays_genre+play);

            ArrayList<Song> songs = map.getOrDefault(genre, new ArrayList<>());
            songs.add(new Song(genre, play, i));
        }

        ArrayList<String> genreList = new ArrayList<>();
        for (String genre : map2.keySet()) {
            genreList.add(genre);
        }
        Collections.sort(genreList, ((o1, o2) -> map2.get(o2) - map2.get(o1)));

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

public class Heap4 {
    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        String[][] s = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        System.out.println(solution.solution(s));
    }
}
