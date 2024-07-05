import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;

public class LoginPage extends JFrame {

    private JPanel contentPane;
    private JLabel lblLoginPage;
    private JLabel lblUsername;
    private static JTextField textField;
    private JPasswordField passwordField;
    private static JTextField textField_1;
    private JButton btnLogin;
    private JButton btnBack; // New back button
    private JButton btnShowPassword; // Show Password button
    private boolean passwordVisible = false; // Flag to track password visibility

    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginPage frame = new LoginPage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    
    public LoginPage() {
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1920, 1080);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(120, 370, 350, 200));
        setContentPane(contentPane);
        contentPane.setBackground(new Color(230, 169, 125));

        lblLoginPage = new JLabel("ENTER YOUR DETAILS ");
        lblLoginPage.setFont(new Font("Papyrus", Font.BOLD, 30));

        lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Papyrus", Font.BOLD, 25));

        textField = new JTextField();
        textField.setColumns(20);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Papyrus", Font.BOLD, 25));

        passwordField = new JPasswordField();
        passwordField.setColumns(20);

        textField_1 = new JTextField();
        textField_1.setColumns(20);

        btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Papyrus", Font.BOLD, 25));
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NotSignedUp np = new NotSignedUp();
                if (np.database(textField.getText().toString(), textField_1.getText().toString())) {
                    String templatePath = "E:\\ResumeBuilder\\demo\\src\\main\\java\\com\\example\\demo\\Template\\template1.docx";
                    ResumeUI rui = new ResumeUI(templatePath);
                    rui.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Not able to Login", "Cannot Login", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        btnLogin.setBorder(null);
        btnLogin.setOpaque(false);
        btnLogin.setContentAreaFilled(false);

        // Adding Back button
        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Papyrus", Font.BOLD, 25));
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login loginFrame = new Login();
                loginFrame.setVisible(true);
                dispose(); // Close the current window
            }
        });
        btnBack.setBorder(null);
        btnBack.setOpaque(false);
        btnBack.setContentAreaFilled(false);

        // Show Password button
        btnShowPassword = new JButton("Show Password");
        btnShowPassword.setFont(new Font("Papyrus", Font.BOLD, 25));
        btnShowPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (passwordVisible) {
                    passwordField.setEchoChar('\u2022'); // Hide password
                    btnShowPassword.setText("Show Password");
                } else {
                    passwordField.setEchoChar((char) 0); // Show password
                    btnShowPassword.setText("Hide Password");
                }
                passwordVisible = !passwordVisible; // Toggle password visibility
            }
        });
        btnShowPassword.setBorder(null);
        btnShowPassword.setOpaque(false);
        btnShowPassword.setContentAreaFilled(false);

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(70)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblPassword, Alignment.TRAILING)
                                .addComponent(lblUsername, Alignment.TRAILING))
                            .addGap(56)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(159)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addComponent(btnLogin)
                                .addComponent(lblLoginPage)
                                .addComponent(btnBack)
                                .addComponent(btnShowPassword))))
                    .addContainerGap(113, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap(33, Short.MAX_VALUE)
                    .addComponent(lblLoginPage)
                    .addGap(31)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblUsername)
                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblPassword)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(31)
                    .addComponent(btnLogin)
                    .addGap(18)
                    .addComponent(btnBack)
                    .addGap(18)
                    .addComponent(btnShowPassword)
                    .addGap(20))
        );
        contentPane.setLayout(gl_contentPane);
    }
}
