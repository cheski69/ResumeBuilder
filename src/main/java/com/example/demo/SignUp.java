import java.awt.EventQueue;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class SignUp extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JPasswordField passwordField;
    private JPasswordField passwordField_1;
    private boolean showPassword = false;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SignUp frame = new SignUp();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SignUp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1920, 1080);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(200, 400, 100, 200));
        setContentPane(contentPane);
        contentPane.setBackground(new Color(230, 169, 125));

        JLabel lblFullName = new JLabel("Full Name:");
        lblFullName.setFont(new Font("Papyrus", Font.BOLD, 20));

        textField = new JTextField();
        textField.setColumns(20);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Papyrus", Font.BOLD, 20));

        textField_1 = new JTextField();
        textField_1.setColumns(20);

        JLabel lblEmailId = new JLabel("Email Id: ");
        lblEmailId.setFont(new Font("Papyrus", Font.BOLD, 20));

        textField_2 = new JTextField();
        textField_2.setColumns(20);

        JLabel lblPhoneNo = new JLabel("Phone No.:");
        lblPhoneNo.setFont(new Font("Papyrus", Font.BOLD, 20));

        textField_3 = new JTextField();
        textField_3.setColumns(20);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Papyrus", Font.BOLD, 20));

        passwordField = new JPasswordField();
        passwordField.setColumns(20);

        JButton btnShowPassword = new JButton("Show Password");
        btnShowPassword.setFont(new Font("Papyrus", Font.BOLD, 20));
        btnShowPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (showPassword) {
                    passwordField.setEchoChar('*');
                    passwordField_1.setEchoChar('*');
                    btnShowPassword.setText("Show Password");
                } else {
                    passwordField.setEchoChar((char) 0);
                    passwordField_1.setEchoChar((char) 0);
                    btnShowPassword.setText("Hide Password");
                }
                showPassword = !showPassword;
            }
        });
        btnShowPassword.setBorder(null);
        btnShowPassword.setOpaque(false);
        btnShowPassword.setContentAreaFilled(false);

        JLabel lblRetypePassword = new JLabel("Retype password:");
        lblRetypePassword.setFont(new Font("Papyrus", Font.BOLD, 20));

        passwordField_1 = new JPasswordField();
        passwordField_1.setColumns(20);

        JButton btnRegister = new JButton("Register");
        btnRegister.setFont(new Font("Papyrus", Font.BOLD, 20));
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty() || textField_3.getText().isEmpty() || new String(passwordField.getPassword()).isEmpty() || new String(passwordField_1.getPassword()).isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    SignUpDb s = new SignUpDb();
                    s.database(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), new String(passwordField.getPassword()));
                    ResumeUI rui = new ResumeUI("template1.docx"); // Pass template filename here
                    rui.setVisible(true);
                    dispose(); 
                }
            }
        });
        btnRegister.setBorder(null);
        btnRegister.setOpaque(false);
        btnRegister.setContentAreaFilled(false);

        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Papyrus", Font.BOLD, 20));
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginPage loginFrame = new LoginPage();
                loginFrame.setVisible(true);
                dispose();
            }
        });
        btnBack.setBorder(null);
        btnBack.setOpaque(false);
        btnBack.setContentAreaFilled(false);

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblFullName)
                        .addComponent(lblUsername)
                        .addComponent(lblEmailId)
                        .addComponent(lblPhoneNo)
                        .addComponent(lblPassword)
                        .addComponent(lblRetypePassword))
                    .addGap(5)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(btnShowPassword))
                        .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addComponent(btnRegister)
                            .addPreferredGap(ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                            .addComponent(btnBack)))
                    .addContainerGap(170, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblFullName)
                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblUsername)
                        .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblEmailId)
                        .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblPhoneNo)
                        .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblPassword)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnShowPassword))
                    .addGap(22)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblRetypePassword)
                        .addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(80) 
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnRegister)
                        .addComponent(btnBack))
                    .addContainerGap(21, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public JTextField getTextField_1() {
        return textField_1;
    }

    public void setTextField_1(JTextField textField_1) {
        this.textField_1 = textField_1;
    }

    public JTextField getTextField_2() {
        return textField_2;
    }

    public void setTextField_2(JTextField textField_2) {
        this.textField_2 = textField_2;
    }

    public JTextField getTextField_3() {
        return textField_3;
    }

    public void setTextField_3(JTextField textField_3) {
        this.textField_3 = textField_3;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public JPasswordField getPasswordField_1() {
        return passwordField_1;
    }

    public void setPasswordField_1(JPasswordField passwordField_1) {
        this.passwordField_1 = passwordField_1;
    }
}
