import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final int[] regionalTeam1 = {45, 31, 24, 22, 20, 17, 14, 13, 12, 10};
    public static final int[] regionalTeam2 = {31, 18, 15, 12, 10, 8, 6, 4, 2, 1};
    public static final int[] regionalTeam3 = {51, 30, 10, 9, 8, 7, 6, 5, 2, 1};
    public static final int TEAM_SIZE = 10;

    public static void main(String[] args) {
        List<int[]> regionalTeamsList = new ArrayList<>();
        regionalTeamsList.add(regionalTeam1);
        regionalTeamsList.add(regionalTeam2);
        regionalTeamsList.add(regionalTeam3);
        int[] nationalTeam = getNationalTeam(regionalTeamsList);
        for (int i : nationalTeam) {
            System.out.print(i + " ");
        }
    }

    public static int[] getNationalTeam(List<int[]> regionalTeams) {
        int[] nationaTeam = regionalTeams.get(0);
        for (int i = 1; i < regionalTeams.size(); i++) {
            nationaTeam = merge(nationaTeam, regionalTeams.get(i));
        }
        return nationaTeam;
    }

    public static int[] merge(int[] team1, int[] team2) {
        int[] mergedTeam = new int[TEAM_SIZE];
        int i1 = 0;
        int i2 = 0;
        int im = 0;
        while (im != TEAM_SIZE) {
            if (team1[i1] >= team2[i2]) {
                mergedTeam[im] = team1[i1];
                i1++;
            } else {
                mergedTeam[im] = team2[i2];
                i2++;
            }
            im++;
        }
        return mergedTeam;
    }
}