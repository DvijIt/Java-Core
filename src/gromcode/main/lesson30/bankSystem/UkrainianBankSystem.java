package gromcode.main.lesson30.bankSystem;

import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class UkrainianBankSystem implements BankSystem {
    private Set<Transaction> transaction = new TreeSet<>();
    @Override
    public void withdraw(User user, int amount) {
        if (!checkWithdraw(user, amount)) return;
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));

        createAndAddTransaction(TransactionType.WITHDRAW, amount, "description");
    }

    @Override
    public void fund(User user, int amount) {
        if(!checkFund(user, amount)) return;
        user.setBalance(user.getBalance() + amount - amount * user.getBank().getCommission(amount));

        createAndAddTransaction(TransactionType.FUND, amount, "descriptionFund");
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        if (!checkWithdraw(fromUser, amount) && !checkFund(toUser, amount)) {
            System.err.println("Can't transfer money " + amount + "\n   from" + fromUser.toString() + "\n   to " + toUser.toString());
            return;
        }

        fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount));
        toUser.setBalance(toUser.getBalance() + amount - amount * toUser.getBank().getCommission(amount));

        createAndAddTransaction(TransactionType.TRANSFER, amount, "descriptionTransfer");
    }

    @Override
    public void paySalary(User user) {
        int salary = user.getSalary();
        user.setBalance(user.getBalance() + salary - user.getBank().getCommission(salary));

        createAndAddTransaction(TransactionType.SALARY, salary, "descriptionSalary");
    }

    private boolean checkWithdraw(User user, int amount) {
        return checkWithdrawalLimit(amount, user, user.getBank().getLimitOfWithdrawal()) &&
                checkWithdrawalLimit(amount, user, user.getBalance());
    }

    private boolean checkWithdrawalLimit(int amount, User user, double limit) {
        if (amount + user.getBank().getCommission(amount) > limit) {
            printWithdrawalErrorMsg(amount, user);
            return false;
        };
        return true;
    }

    private void printWithdrawalErrorMsg(int amount, User user) {
        System.err.println("Can`t withdraw money " + amount + " from user " + user.toString());
    }

    private boolean checkFund(User user, int amount) {
        if (amount + user.getBank().getCommission(amount) > user.getBank().getLimitOfFunding()) {
            System.err.println("Can't fund money " + amount + "\n   from " + user.toString());
            return false;
        }
        return true;
    }

    private Transaction createAndAddTransaction(TransactionType type, int amount, String description) {
        Random random = new Random();
        Transaction tr = new Transaction(random.nextInt(), new Date(), null, type, amount, description);
        transaction.add(tr);
        return tr;
    }

    public Set<Transaction> getTransaction() {
        return transaction;
    }
}
