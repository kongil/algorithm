import java.util.*;

class Money implements Comparable<Money> {
    int date;
    int interest;
    int price;

    public Money(int date, int interest, int price) {
        this.date = date;
        this.interest = interest;
        this.price = price;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void minusPrice(int price) {
        this.price -= price;
    }

    public void plusPrice(int price) {
        this.price += price;
    }

    public void minusDate(int date) {
        this.date -= date;
    }

    public int getSumInterest() {
        return (int)((double) this.price * (double) this.interest / 100.0 * ((double) this.date / (double) 365));
    }

    @Override
    public String toString() {
        return "Money{" +
                "date=" + date +
                ", interest=" + interest +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Money o) {
        if (o.getDate() > this.date)
            return -1;
        else
            return 1;
    }
}

class Solution {
    int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int calculate(String date) {
        String[] md = date.split("/");
        int m = Integer.parseInt(md[0]);
        int d = Integer.parseInt(md[1]);
        int day = 0;
        for (int i = 1; i <= m-1; i++)
            day += days[i];
        day += d;

        return 365-day;
    }
    public int solution(String[] ledgers) {
        PriorityQueue<Money> pq = new PriorityQueue<>();
        int answer = 0;

        for (int i = 0; i < ledgers.length; i++) {
            String[] moneys = ledgers[i].split(" ");

            int date = calculate(moneys[0]);
            int interest = Integer.parseInt(moneys[1]);
            int price = Integer.parseInt(moneys[2]);
            Money newMoney = new Money(date, interest, price);

            if (price > 0)
                pq.offer(newMoney);
            else {
                while (newMoney.getPrice() < 0) {
                    Money recent = pq.poll();
                    if (recent.getPrice() <= -newMoney.getPrice()) {
                        recent.minusDate(newMoney.getDate());
                        answer += recent.getSumInterest();
                    }
                    else {
                        answer += (double)-newMoney.getPrice() * (double)(recent.getDate() - newMoney.getDate()) / 365.0 * recent.getInterest() / 100.0;
                        recent.plusPrice(newMoney.getPrice());
                        pq.offer(recent);
                    }
                    newMoney.plusPrice(recent.getPrice());
                }
            }
        }

        while (!pq.isEmpty()) {
            Money money = pq.poll();
            answer += money.getSumInterest();
        }

        return answer;
    }
}

public class Kakao1 {
    public static void main(String[] args) {
        //String[] strings = {"04/01 1 40000","05/01 5 20000","08/31 4 10000","11/11 0 -45000"};
        String[] strings = {"01/01 4 50000","01/11 6 3555","02/01 0 -23555","02/25 5 5000","03/25 0 -15000","06/09 8 43951","12/30 9 99999"};
        Solution solution = new Solution();
        System.out.println(solution.solution(strings));

    }
}
