import java.util.Objects;

public class Receiver {
    private int channel;
    private double frequency;
    private String encType;
    private boolean power;

    {
        System.out.printf("New receiver for satellites has been created!\n");
    }

    public Receiver(int channel, double frequency, String encType, boolean power){
        this.channel = channel;
        this.frequency = frequency;
        this.encType = encType;
        this.power = power;
        System.out.printf("Constructor for new receiver has been called!\n");
    }

    public Receiver(){
        this(1, 435.3, "AES-256", true);
        System.out.printf("Default Receiver has been created!\n");
    }

    @Override
    public String toString() {
        return "Receiver{" +
                "channel=" + channel +
                ", frequency=" + frequency +
                ", encType='" + encType + '\'' +
                ", power=" + power +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Receiver receiver = (Receiver) o;
        return getChannel() == receiver.getChannel() && Double.compare(getFrequency(), receiver.getFrequency()) == 0 && isPower() == receiver.isPower() && Objects.equals(getEncType(), receiver.getEncType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChannel(), getFrequency(), getEncType(), isPower());
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

    public String getEncType() {
        return encType;
    }

    public void setEncType(String encType) {
        this.encType = encType;
    }

    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }
}