
package bank;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;

public class BankAccount1
      implements ActionListener
{
      private JTextField acctNumber;
      private JLabel numberOutput;
      private JTextField acctName;
      private JLabel nameOutput;
      private JTextField acctBalance;
      private JLabel balanceOutput;
      private JTextField depositAmount;
      private JTextField withdrawAmount;
      private JButton withdrawButton;
      private JButton depositButton;

    public BankAccount1()
    {
        JFrame frame = new JFrame ("Account Information");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(makePanel());
        frame.pack();
        frame.setVisible(true);

    }
    private JPanel makePanel() {
        JPanel panel = new JPanel();
        panel.add (new JLabel ("Account Number"));
        acctNumber = new JTextField();
        panel.add(acctNumber);
        panel.add (new JLabel ("Account Name"));
        acctName = new JTextField();
        panel.add(acctName);
        panel.add (new JLabel ("Account Balance"));
        acctBalance = new JTextField(10);
        panel.add(acctBalance);
        this.acctName.setText(account.getName());
        this.acctNumber.setText("" + account.getNumber());
        this.acctBalance.setText("" + account.getBalance());
        withdrawButton = new JButton ("Withdraw:");
        withdrawAmount = new JTextField(10);
        panel.add (withdrawButton);
        panel.add (withdrawAmount);
        withdrawButton.addActionListener(this);
        depositButton = new JButton ("Deposit:");
        depositAmount = new JTextField(10);
        panel.add (depositButton);
        panel.add (depositAmount);
        depositButton.addActionListener(this);
        panel.setPreferredSize(new Dimension(600,200));
        panel.setBackground(Color.green);
        return panel;
     }

      
    

          public void actionPerformed (ActionEvent event){
           
           
    
              
              if (event.getSource() == withdrawButton)
                {
                
                 double amount = Double.parseDouble(this.withdrawAmount.getText());
                  this.account.withdraw(amount, 1.000);
                  this.acctBalance.setText(Double.toString(this.account.getBalance())); 
                }
             
              if (event.getSource() == depositButton){
                  
                  double amount = Double.parseDouble(this.depositAmount.getText());
                  this.account.deposit(amount);
                  this.acctBalance.setText(Double.toString(this.account.getBalance())); 
                  
               
                } 

          }

     private Account account;{
          account = new Account("Julius seth",12345,100.00);
       }


        public static void main (String[] args)
         {
          new BankAccount1();
          new Database();
          
         }
}