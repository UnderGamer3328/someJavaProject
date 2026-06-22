import java.util.Objects;

public class Satellite {
    private String name;
    private double frequency;
    private int sr;
    private char polarisation;
    private String fec;
    private boolean isOn;

    static {
        System.out.printf("System is on! Starting services...\n");
    }

    {
        System.out.printf("New satellite has been created!\n");
    }

    public Satellite(String name, double frequency, int sr, char polarisation, String fec, boolean isOn){
        this.name = name;
        this.frequency = frequency;
        this.sr = sr;
        this.polarisation = polarisation;
        this.fec = fec;
        this.isOn = isOn;
        System.out.printf("Constructor for new satellite has been called!\n");
    }

    public Satellite(){
        this("UnderSat-Default", 2478.83, 27500, 'H', "3/4", true);
        System.out.printf("Default Satellite has been created!\n");
    }

    @Override
    public String toString() {
        return "Satellite{" +
                "name='" + name + '\'' +
                ", frequency=" + frequency +
                ", sr=" + sr +
                ", polarisation=" + polarisation +
                ", fec='" + fec + '\'' +
                ", isOn=" + isOn +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Satellite satellite = (Satellite) o;
        return Double.compare(getFrequency(), satellite.getFrequency()) == 0 && getSr() == satellite.getSr() && getPolarisation() == satellite.getPolarisation() && isOn() == satellite.isOn() && Objects.equals(getName(), satellite.getName()) && Objects.equals(getFec(), satellite.getFec());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFrequency(), getSr(), getPolarisation(), getFec(), isOn());
    }

    public void print(){
        System.out.println("Satellite is sending data...\n");
        System.out.println(this.toString());
    }

    public void transmitSignal(){
        System.out.printf("%s is sending a signal on %.2f Ghz\n", name, frequency);
    }

    public void updateOrbit(){
        System.out.printf("Orbit correction for %s is completed\n", name);
    }

    public void togglePower(){
        this.isOn = !isOn;
        System.out.printf("%s is %b", name, (isOn ? "powered on" : "powered off"));
    }

    public void performSelfTest(){
        System.out.printf("SelfTest %s: everything's all right!\n", name);
    }

    public char getPolarisation() {
        return polarisation;
    }

    public void setPolarisation(char polarisation) {
        this.polarisation = polarisation;
    }

    public int getSr() {
        return sr;
    }

    public void setSr(int sr) {
        this.sr = sr;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFec() {
        return fec;
    }

    public void setFec(String fec) {
        this.fec = fec;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}
