/**
 * Maman by ALmog Shtaigmann
 */

package mmn12.q1;

public class Onwer {
    private String name;
    private String phoneNumber;

    public Onwer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public Boolean equals(Onwer owner) {
        return this.name.equals(owner.getName()) && this.phoneNumber.equals(owner.getPhoneNumber());
    }
    //some getter and setter function
}
