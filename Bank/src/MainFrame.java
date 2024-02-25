import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private JPanel mainPanel;
    private JButton createAccountButton;
    private JTextField fNameText;
    private JTextField lNameText;
    private JTextField balanceText;
    private JButton enterButton;
    private JLabel balanceLabel;
    private JLabel lNameLabel;
    private JLabel fNameLabel;
    private JTable table1;
    private JScrollPane scrollPane1;
    private JButton depositB;
    private JTextField depositText;
    private JButton withdrawB;
    private JTextField withdrawText;
    private JButton updateDepositB;
    private JButton updateWithdrawB;
    private JLabel menuLabel;

    private BankAccount bankAccount;
    private double deposit, withdraw;
    public MainFrame() {
        setContentPane(mainPanel);
        setTitle("Bank Balance Application");
        setSize(500, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        bankAccount = new BankAccount();

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fNameLabel.setVisible(!fNameLabel.isVisible());
                lNameLabel.setVisible(!lNameLabel.isVisible());
                balanceLabel.setVisible(!balanceLabel.isVisible());
                fNameText.setVisible(!fNameText.isVisible());
                lNameText.setVisible(!lNameText.isVisible());
                balanceText.setVisible(!balanceText.isVisible());
                enterButton.setVisible(!enterButton.isVisible());
            }
        });
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fName = fNameText.getText();
                String lName = lNameText.getText();
                String balance = balanceText.getText();
                int bal = Integer.parseInt(balance);
                bankAccount = new BankAccount(fName, lName, bal);

                updateTable();
                depositB.setVisible(!depositB.isVisible());
                withdrawB.setVisible(!withdrawB.isVisible());

                fNameLabel.setVisible(!fNameLabel.isVisible());
                lNameLabel.setVisible(!lNameLabel.isVisible());
                balanceLabel.setVisible(!balanceLabel.isVisible());
                fNameText.setVisible(!fNameText.isVisible());
                lNameText.setVisible(!lNameText.isVisible());
                balanceText.setVisible(!balanceText.isVisible());
                enterButton.setVisible(!enterButton.isVisible());
                createAccountButton.setVisible(!createAccountButton.isVisible());
                menuLabel.setText("Account");
            }
        });
        depositB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depositText.setVisible(!depositText.isVisible());
                updateDepositB.setVisible(!updateDepositB.isVisible());
            }
        });
        withdrawB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdrawText.setVisible(!withdrawText.isVisible());
                updateWithdrawB.setVisible(!updateWithdrawB.isVisible());
            }
        });
        updateDepositB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = depositText.getText();
                deposit = Double.parseDouble(s);
                bankAccount.deposit(deposit);
                updateTable();
                depositText.setText("");
                depositText.setVisible(!depositText.isVisible());
                updateDepositB.setVisible(!updateDepositB.isVisible());
            }
        });

        updateWithdrawB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = withdrawText.getText();
                withdraw = Double.parseDouble(s);
                bankAccount.withdrawal(withdraw);
                updateTable();
                withdrawText.setText("");
                withdrawText.setVisible(!withdrawText.isVisible());
                updateWithdrawB.setVisible(!updateWithdrawB.isVisible());
            }
        });
    }
    private void updateTable() {
        String[] columnNames = {"Account ID", "Available Balance", "Name"};
        Object[][] data = {
                {bankAccount.getAccountID(), bankAccount.getBalance(), bankAccount.getFirstName() + " " + bankAccount.getLastName()}
        };

        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setDataVector(data, columnNames);
    }

}
