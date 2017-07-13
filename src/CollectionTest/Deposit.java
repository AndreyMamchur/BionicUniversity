package CollectionTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Deposit implements Comparable<Deposit> {

    private String nameOfBank;
    private String depoType;
    private LocalDate startDate;
    private int dayLong;
    private long sum;
    private double interestRate;
    private String depositStatus;

    public Deposit(String depoType, LocalDate startDate, int dayLong) {
        this.depoType = depoType;
        this.startDate = startDate;
        this.dayLong = dayLong;
    }

    public Deposit(String depoType, LocalDate startDate, int dayLong, long sum, double interestRate) {
        this.depoType = depoType;
        this.startDate = startDate;
        this.dayLong = dayLong;
        this.sum = sum;
        this.interestRate = interestRate;
    }

    public Deposit(String nameOfBank, String depoType, LocalDate startDate, int dayLong, long sum, double interestRate) {
        this.nameOfBank = nameOfBank;
        this.depoType = depoType;
        this.startDate = startDate;
        this.dayLong = dayLong;
        this.sum = sum;
        this.interestRate = interestRate;
    }

    public String getDepositStatus() {
        return depositStatus;
    }

    public void setDepositStatus(String depositStatus) {
        this.depositStatus = depositStatus;
    }

    public String getNameOfBank() {
        return nameOfBank;
    }

    public void setNameOfBank(String nameOfBank) {
        this.nameOfBank = nameOfBank;
    }

    public String getDepoType() {
        return depoType;
    }

    public void setDepoType(String depoType) {
        this.depoType = depoType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getDayLong() {
        return dayLong;
    }

    public void setDayLong(int dayLong) {
        this.dayLong = dayLong;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "nameOfBank='" + nameOfBank + '\'' +
                ", depoType='" + depoType + '\'' +
                ", startDate=" + startDate +
                ", dayLong=" + dayLong +
                ", sum=" + sum +
                ", interestRate=" + interestRate +
                ", depositStatus='" + depositStatus + '\'' +
                '}';
    }

    @Override
    public int compareTo(Deposit dep) {
        return (int) (this.sum - dep.sum);
    }

}
