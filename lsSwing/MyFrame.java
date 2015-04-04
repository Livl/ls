package lsSwing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

public class MyFrame extends JFrame {

        JButton wypisz, kasuj;
        JTextArea path;
        JScrollPane sp;
	public MyFrame() {
            super("Ls");
                
            JPanel content= (JPanel) getContentPane();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setSize(new Dimension(500,350));

            content.setLayout(new BorderLayout());
            JPanel buttons= new JPanel();
            buttons.setLayout(new GridLayout(1,2));

            wypisz=new JButton("Wypisz");
            kasuj = new JButton("Kasuj");

            buttons.add(wypisz);
            buttons.add(kasuj);
            content.add(buttons, BorderLayout.NORTH);

            path = new JTextArea("Podaj ścieżkę");
            path.setMargin(new Insets(5, 5, 5, 5));
            sp=new JScrollPane(path);
            content.add(sp, BorderLayout.CENTER);

            wypisz.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    ls(path);
                }
            });
                
            kasuj.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    path.setText(null);
                }
            });

            setVisible(true);
	}
        
        static void ls(JTextArea p){
            File file=new File(p.getText());           
            if(file.isDirectory()){
                String currentText = "";
                for (String name : file.list()) {
                    currentText += name+"\n\n";
                }
                p.setText(currentText); 
            }   
        }
}

