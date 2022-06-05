package project;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
class Saving implements ActionListener
{
    JFrame f=new JFrame();
    JButton b1=new JButton("Sign Up");
    JButton b2=new JButton("Close");
    JLabel l1=new JLabel("Enter your name");
    JLabel l2=new JLabel("Enter your date of birth (DD-MM-YYYY)");
    JLabel l3=new JLabel("Enter your phone number");
    JLabel l4=new JLabel("Enter your Aadhar card number");
    JLabel l5=new JLabel("Enter your address");
    JLabel l6=new JLabel("Enter your annual Salary");
    JLabel l7=new JLabel("Enter amount you want to deposit");
    JLabel l8=new JLabel("Sign Up Successful");
    JTextField t1=new JTextField();
    JTextField t2=new JTextField();
    JTextField t3=new JTextField();
    JTextField t4=new JTextField();
    JTextField t5=new JTextField();
    JTextField t6=new JTextField();
    JTextField t7=new JTextField();
    Saving()
    {
        l1.setBounds(75,25,300,20);
        t1.setBounds(75,50,300,20);
        l2.setBounds(75,75,300,20);
        t2.setBounds(75,100,300,20);
        l3.setBounds(75,125,300,20);
        t3.setBounds(75,150,300,20);
        l4.setBounds(75,175,300,20);
        t4.setBounds(75,200,300,20);
        l5.setBounds(75,225,300,20);
        t5.setBounds(75,250,300,20);
        l6.setBounds(75,275,300,20);
        t6.setBounds(75,300,300,20);
        l7.setBounds(75,325,300,20);
        t7.setBounds(75,350,300,20);
        b1.setBounds(150,375,100,20);
        l8.setBounds(150,400,200,20);
        b2.setBounds(150,425,100,20);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(l6);
        f.add(l7);
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(t4);
        f.add(t5);
        f.add(t6);
        f.add(t7);
        f.add(b1);
        f.add(l8);
        f.add(b2);
        l8.setVisible(false);
        b2.setVisible(false);
        b1.addActionListener(this);
        b2.addActionListener(this);
        f.setTitle("Saving Account");
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(500,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            String name,dob,address;
            double annualsalary=0,balance=0;
            long number=0,aadhar=0;
            name=t1.getText();
            dob=t2.getText();
            if(t3.getText().trim().isEmpty()){
                number=0;
            }
            else{
                number=Long.valueOf(t3.getText());
            }
            if(t4.getText().trim().isEmpty()){
                aadhar=0;
            }
            else{
                aadhar=Long.valueOf(t4.getText());
            }
            address=t5.getText();
            if(t6.getText().trim().isEmpty()){
                annualsalary=0;
            }
            else{
                annualsalary=Double.valueOf(t6.getText());
            }
            if(t7.getText().trim().isEmpty()){
                balance=0;
            }
            else{
                balance=Double.valueOf(t7.getText());
            }
            if(name.trim().isEmpty() || dob.trim().isEmpty() || number==0 || aadhar==0 || address.trim().isEmpty() || annualsalary==0.0 || balance==0.0){
                l8.setVisible(false);
                b2.setVisible(false);
                JOptionPane.showMessageDialog(f,"All fields are required","WARNING",JOptionPane.WARNING_MESSAGE);
            }
            else{
                try{
                    Connection conn=DriverManager.getConnection("jdbc:ucanaccess://E:\\Bhavik\\Java\\project\\src\\project.accdb");
                    Statement st=conn.createStatement();
                    st.execute("INSERT INTO acount(name,dob,number,aadhar,address,annualsalary,balance) VALUES('"+name+"','"+dob+"','"+number+"','"+aadhar+"','"+address+"','"+annualsalary+"','"+balance+"')");
                    conn.close();
                    l8.setVisible(true);
                    b2.setVisible(true);
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(f,"Aadhar number already used","WARNING",JOptionPane.WARNING_MESSAGE);
                }
            }
	}
        if(e.getSource()==b2)
        {
            System.exit(0);
        }
    }
}
class Ask implements ActionListener
{
    JFrame f=new JFrame();
    JLabel l1=new JLabel("Welcome TO National Bank"); 
    JButton b1=new JButton("Sign In");
    JButton b2=new JButton("Sign Up");
    JButton b3=new JButton("Close");
    Ask()
    {
	l1.setBounds(150,150,200,20);
        b1.setBounds(170,175,100,20);
        b2.setBounds(170,200,100,20);
        b3.setBounds(170,225,100,20);
	f.add(l1);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        f.setTitle("Ask");
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(500,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            new Login();
            f.setVisible(false);
        }
        if(e.getSource()==b2)
        {
            new Saving();
            f.setVisible(false);
        }
        if(e.getSource()==b3)
        {
            System.exit(0);
	}
    }
}
class Login implements ActionListener
{
    JFrame f=new JFrame();
    JButton b1=new JButton("Log In");
    JButton b2=new JButton("Close");
    JLabel l1=new JLabel("Enter your Name");
    JLabel l2=new JLabel("Enter your Aadhar number");
    JTextField t1=new JTextField();
    JTextField t2=new JTextField();
    Login()
    {
        l1.setBounds(150,125,200,20);
        t1.setBounds(150,150,200,20);
        l2.setBounds(150,175,200,20);
        t2.setBounds(150,200,200,20);
        b1.setBounds(170,225,100,20);
        b2.setBounds(170,250,100,20);
        f.add(l1);
        f.add(l2);
        f.add(t1);
        f.add(t2);
        f.add(b1);
        f.add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        f.setTitle("Log In");
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(500,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {
        String name,dob="1",address="2";
        double annualsalary=0.0,balance=0.0;
        long number=0,aadhar=0;
        if(e.getSource()==b2)
        {
            System.exit(0);
	}
        if(e.getSource()==b1){
            name=t1.getText();
            if(t2.getText().trim().isEmpty()){
                aadhar=0;
            }
            else{
                aadhar=Long.valueOf(t2.getText());
            }
            if(name.trim().isEmpty() || aadhar==0){
                JOptionPane.showMessageDialog(f,"All fields are required","WARNING",JOptionPane.WARNING_MESSAGE);
            }
            else{
                try{
                    Connection conn=DriverManager.getConnection("jdbc:ucanaccess://E:\\Bhavik\\Java\\project\\src\\project.accdb");
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("SELECT * FROM acount WHERE aadhar='"+aadhar+"'");
                    while(rs.next()){
                        name=rs.getString("name");
                        dob=rs.getString("dob");
                        number=rs.getLong("number");
                        aadhar=rs.getLong("aadhar");
                        address=rs.getString("address");
                        annualsalary=rs.getDouble("annualsalary");
                        balance=rs.getDouble("balance");
                    }
                    rs.close();
                    if(name.trim().isEmpty() || dob=="1" || number==0 || aadhar==0 || address=="2" || annualsalary==0.0 || balance==0.0){
                        JOptionPane.showMessageDialog(f,"Invalid 'name' or 'Aadhar number'","WARNING",JOptionPane.WARNING_MESSAGE);
                    }
                    else{
                        f.setVisible(false);
                        new Lg_Operations(name,dob,address,annualsalary,balance,number,aadhar);
                    }
                }
                catch(Exception ex){
                    System.out.println(ex);
                }
            }
        }
    }
}
class Lg_Operations implements ActionListener
{ 
    JFrame f=new JFrame();
    double balance;
    long aadhar;
    JButton b1=new JButton("Deposit");
    JButton b2=new JButton("Withdraw");
    JButton b3=new JButton("Close");
    JLabel l1=new JLabel();
    JLabel l2=new JLabel();
    JLabel l3=new JLabel();
    JLabel l4=new JLabel();
    JLabel l5=new JLabel();
    JLabel l6=new JLabel();
    JLabel l7=new JLabel();
    Lg_Operations(String name,String dob,String address,double annualsalary,double amm,long number,long adhar)
    {
        balance=amm;
        aadhar=adhar;
        l1.setBounds(100,75,400,20);
        l2.setBounds(100,100,400,20);
        l3.setBounds(100,125,400,20);
        l4.setBounds(100,150,400,20);
        l5.setBounds(100,175,500,20);
        l6.setBounds(100,200,400,20);
        l7.setBounds(100,225,400,20);
        b1.setBounds(190,275,100,20);
        b2.setBounds(190,300,100,20);
        b3.setBounds(190,325,100,20);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(l6);
        f.add(l7);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        f.setTitle("Display");
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(500,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l1.setText("Name: "+name);
        l2.setText("Date of birth: "+dob);
        l3.setText("Phone number: "+number);
        l4.setText("Aadhar number: "+aadhar);
        l5.setText("Addres: "+address);
        l6.setText("Annual salary: "+annualsalary);
        l7.setText("Balance: "+balance);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            new Deposit(balance,aadhar);
            f.setVisible(false);
        }
        if(e.getSource()==b2)
        {
            new Widrow(balance,aadhar);
            f.setVisible(false);
        }
        if(e.getSource()==b3)
        {
            System.exit(0);
	}
    }
}
class Deposit implements ActionListener
{
    double b,operation;
    long aadhar;
    JFrame f=new JFrame();
    JLabel l1=new JLabel("Enter the amount you want to deposit");
    JTextField t1=new JTextField();
    JButton b1=new JButton("Deposit");
    JButton b2=new JButton("Close");
    Deposit(double balance,long adhar)
    {
        b=balance;
        aadhar=adhar;
        JLabel l3=new JLabel("Your current balance is '"+b+"'");
        l3.setBounds(150,100,400,20);
        l1.setBounds(150,125,450,20);
        t1.setBounds(150,150,150,20);
        b1.setBounds(170,175,100,20);
        b2.setBounds(170,200,100,20);
        f.add(l1);
        f.add(b1);
        f.add(t1);
        f.add(b2);
        f.add(l3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        f.setTitle("Deposit");
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(500,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b2)
        {
            System.exit(0);
	}
        operation=Double.valueOf(t1.getText());
        if(e.getSource()==b1)
        {
            b+=operation;
            try{
                Connection conn=DriverManager.getConnection("jdbc:ucanaccess://E:\\Bhavik\\Java\\project\\src\\project.accdb");
                Statement st=conn.createStatement();
                st.executeUpdate("UPDATE acount SET balance='"+b+"' WHERE aadhar='"+aadhar+"'");
                JOptionPane.showMessageDialog(f,"Now your updated balance is: "+b);
            }
            catch(Exception ex){
                System.out.println(ex);
            }
        }
    }
}
class Widrow implements ActionListener
{
    double b,operation;
    long aadhar;
    JFrame f=new JFrame();
    JLabel l1=new JLabel("Enter the amount you want to Withdraw");
    JTextField t1=new JTextField();
    JButton b1=new JButton("Withdraw");
    JButton b2=new JButton("Close");
    Widrow(double balance,long adhar)
    {
        b=balance;
        aadhar=adhar;
        JLabel l4=new JLabel("Your current balance is '"+b+"'");
        l4.setBounds(150,100,400,20);
        l1.setBounds(150,125,450,20);
        t1.setBounds(150,150,150,20);
        b1.setBounds(170,175,100,20);
        b2.setBounds(170,200,100,20);
        f.add(l1);
        f.add(b1);
        f.add(t1);
        f.add(b2);
        f.add(l4);
        b1.addActionListener(this);
        b2.addActionListener(this);
        f.setTitle("Withdraw");
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(500,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b2)
        {
            System.exit(0);
	}
        operation=Double.valueOf(t1.getText());
        if(e.getSource()==b1 && operation<b)
        {
            b-=operation;
            try{
                Connection conn=DriverManager.getConnection("jdbc:ucanaccess://E:\\Bhavik\\Java\\project\\src\\project.accdb");
                Statement st=conn.createStatement();
                st.executeUpdate("UPDATE acount SET balance='"+b+"' WHERE aadhar='"+aadhar+"'");
                JOptionPane.showMessageDialog(f,"Now your updated balance is: "+b);
            }
            catch(Exception ex){
                System.out.println(ex);
            }
        }
        if(e.getSource()==b1 && operation>b){
            JOptionPane.showMessageDialog(f,"Insufficient balance","WARNING",JOptionPane.WARNING_MESSAGE);
        }
    }
}
class Project
{
    public static void main(String[] args) 
    {
        new Ask();
    }
}