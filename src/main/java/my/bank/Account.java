package my.bank;

/**
 * @author Mathieu Carbou (mathieu.carbou@gmail.com)
 */
public final class Account {

    private final String number;
    private int amount;

    private Account(String number, int initialAmmount) {
        this.amount = initialAmmount;
        this.number = number;
    }

    public int amount() {
        return amount;
    }

    public String number() {
        return number;
    }

    @Override
    public String toString() {
        return number + ": " + amount;
    }

    public static Builder account(String number) {
        return new Builder(number);
    }

    public static final class Builder {
        private final Account account;

        private Builder(String number) {
            this.account = new Account(number, 0);
        }

        public Builder withAmmount(int ammount) {
            if (ammount < 0) {
                throw new IllegalArgumentException("Amount must be positive");
            }
            account.amount = ammount;
            return this;
        }

        public Account build() {
            return account;
        }
    }
}
