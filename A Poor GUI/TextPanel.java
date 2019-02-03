import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {

    private TextArea textArea;

    public TextPanel(){

        textArea = new TextArea();

        setLayout(new BorderLayout());

        add(new JScrollPane(textArea), BorderLayout.CENTER);

    }

    public void appendText(String text){
        textArea.append(text);
    }
}
