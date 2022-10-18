
public class User {
    int team;
    int number = 0;

    public User(int team) {
        this.team = team;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public int getTeam() {
        return this.team;
    }
}
