import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

    private JPanel contentPane;
    private Image backgroundImage;

    // Load the background image
    public Login() {
        try {
            backgroundImage = ImageIO.read(new File("loginbackground.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1920, 1080);
        contentPane = new BackgroundPanel();
        contentPane.setBorder(new EmptyBorder(150, 300, 350, 200));
        setContentPane(contentPane);

        JLabel lblResumeBuilder = new JLabel("Resume Builder");
        lblResumeBuilder.setFont(new Font("Papyrus", Font.BOLD, 60));
        lblResumeBuilder.setForeground(Color.black); // Optional: Make text color contrast with background

        JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Papyrus", Font.BOLD, 25));
		

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginPage lp = new LoginPage();
                lp.setVisible(true);
            }
        });
		btnLogin.setBorder(null);
		btnLogin.setOpaque(false); 
        btnLogin.setContentAreaFilled(false); 
		

        JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setFont(new Font("Papyrus", Font.BOLD, 25));
        btnSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                SignUp sp = new SignUp();
                sp.setVisible(true);
            }
        });
		btnSignUp.setBorder(null);
		btnSignUp.setOpaque(false);
		btnSignUp.setContentAreaFilled(false);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("loginbackground.jpg"));

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(200)
                    .addComponent(btnLogin)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                    .addComponent(btnSignUp)
                    .addGap(300))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(142)
                    .addComponent(lblResumeBuilder)
                    .addContainerGap(160, Short.MAX_VALUE))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(130)
                    .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 159, Short.MAX_VALUE)
                    .addGap(151))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblResumeBuilder)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 118, Short.MAX_VALUE)
                    .addGap(28)
                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSignUp)
                        .addComponent(btnLogin))
                    .addGap(39))
        );
        contentPane.setLayout(gl_contentPane);
    }

    // Custom JPanel class to handle background image
    class BackgroundPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
