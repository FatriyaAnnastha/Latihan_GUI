import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        
        JFrame frame = new JFrame("Formulir");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 580);
        frame.setLocation(600, 120);
        frame.setVisible(true);

        // int result =
        //     JOptionPane.showConfirmDialog(frame, 
        //         "contoh dialog konfirmasi...",
        //         "Konfirmasi",
        //         JOptionPane.OK_CANCEL_OPTION,
        //         JOptionPane.QUESTION_MESSAGE);

        // String message;
        // if (result==JOptionPane.OK_OPTION)
        //     message = "Anda memilih ok";
        // else if (result==JOptionPane.CANCEL_OPTION)
        //     message = "Anda memilih cancel";
        // else
        //     message = "Anda tidak memilih apapun";

        // JOptionPane.showMessageDialog(frame, 
        //     message,
        //     "Pilihan Anda",
        //     JOptionPane.INFORMATION_MESSAGE);

        // JDialog dlg = new JDialog(frame, "Dialog 1", true);
        // dlg.setSize(200,100);
        // dlg.setVisible(true);
        
    }
}
