import java.util.Objects;

public class Controller extends User{
    private int userID;
    private boolean hasAccess;
    private double wealth;

    {
        System.out.printf("New controller for satellites has been created!\n");
    }

    public Controller(int age, String name, int number, int userID, boolean hasAccess, double wealth){
        super(age, name, number);
        this.userID = userID;
        this.hasAccess = hasAccess;
        this.wealth = wealth;
        System.out.printf("Constructor for new controller has been called!\n");
    }

    public Controller(){
        this(15, "Vitalya", 45632 , 0, true, 675.75);
        System.out.printf("Default controller has been created!\n");
    }

    @Override
    public String toString() {
        return "Controller{" +
                "userID=" + userID +
                ", hasAccess=" + hasAccess +
                ", wealth=" + wealth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Controller that = (Controller) o;
        return getUserID() == that.getUserID() && isHasAccess() == that.isHasAccess() && Double.compare(getWealth(), that.getWealth()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserID(), isHasAccess(), getWealth());
    }

    void buySat(double satPrice) {
        if (this.wealth >= satPrice) {
            this.wealth -= satPrice;
            this.hasAccess = true;
            System.out.printf("[System]: Satellite purchased for %.2f!\n", satPrice);
        } else {
            System.out.printf("[System]: Not enough money! You need %.2f, but have only %.2f\n", satPrice, this.wealth);
        }
    }

    public double getWealth() {
        return wealth;
    }

    public void setWealth(double wealth) {
        this.wealth = wealth;
    }

    public boolean isHasAccess() {
        return hasAccess;
    }

    public void setHasAccess(boolean hasAccess) {
        this.hasAccess = hasAccess;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
