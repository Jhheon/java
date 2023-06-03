package KNU_Project;
import java.awt.*;
import java.net.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.*;

public class test4Client extends JFrame{

    JTextField tf = new JTextField(10);
    JLabel lb = new JLabel();
    Socket socket;

    public test4Client() {

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(new JLabel("단어 입력 >>"));
        c.add(tf);
        c.add(lb);

        try {
            socket = new Socket("localhost",9999);
        }catch (Exception e1) {
            System.out.println(e1.getMessage());
        }

        tf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                    bw.write(tf.getText()+"\n");
                    bw.flush();
                    String result = br.readLine();
                    lb.setText(result);

                } catch (Exception e1) {
                    System.out.println(e1.getMessage());
                }
            }
        });

        setTitle("클라이언트");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350,100);
    }


    public static void main(String [] args) {
        new test4Client();
    }
}

