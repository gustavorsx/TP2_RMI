package Interface;
public class Cliente {
    int team;
    int number = 0;

    public Cliente(int team) {
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
