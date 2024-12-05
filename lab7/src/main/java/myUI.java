import javax.swing.*;
import java.util.Arrays;

public class myUI extends JFrame {
    private JTextField sizeField;
    private JComboBox sortOrderComboBox;
    private JButton sortButton;
    private JTextField resultArea;
    private JPanel panel;

    public myUI() {
        resultArea.setEditable(false);

        sortButton.addActionListener(actionEvent -> {
            try {
                int size = Integer.parseInt(sizeField.getText());
                if (size <= 0) {
                    throw new NumberFormatException("Размер должен быть положительным");
                }

                int sortOrder = sortOrderComboBox.getSelectedIndex() + 1;
                MainThread mainthread = new MainThread(size, sortOrder);
                String str = "";
                str += "Массив: " + Arrays.toString(mainthread.getArray()) + "\n";
                //resultArea.append("Массив: " + Arrays.toString(mainthread.getArray()) + "\n");
                Thread thread = new Thread(mainthread);
                thread.start();
                thread.join();
                str += "Отсортированный массив: " + Arrays.toString(mainthread.getArray()) + "\n";
                resultArea.setText(str);
                //resultArea.append("Отсортированный массив: " + Arrays.toString(mainthread.getArray()) + "\n");
            } catch (NumberFormatException var8) {
                resultArea.setText("Error: Please enter a valid positive integer for the array size.\n");
            } catch (Exception e) {
                resultArea.setText("Error: " + e.getMessage());
            }
        });
    }

    public static void main(String[] args) {
        myUI frame = new myUI();
        frame.setContentPane(frame.panel);
        frame.setTitle("ArraySort");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
