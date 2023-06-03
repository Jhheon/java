package KNU_Project;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class test4Server extends JFrame{

    ArrayList<String> wordList = new ArrayList<String>();
    JTextArea ta = new JTextArea();

    public test4Server() {
        readWordList();

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(ta);
        ta.setEnabled(false);
        ta.setDisabledTextColor(Color.black);

        setTitle("영어 단어 체크 서버");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        try {
            ServerSocket ss = new ServerSocket(9999);

            while(true) {
                Socket socket = ss.accept();
                ta.append("클라이언트 접속됨!"+"\n");
                Multiple multi = new Multiple(socket);
                multi.start();
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void readWordList() {
        File file = new File("word.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            while(true) {
                String word = br.readLine();
                if(word == null)
                    break;
                wordList.add(word);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    class Multiple extends Thread{

        Socket socket;

        public Multiple(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                while(true) {
                    String receiveWord = br.readLine();
                    if(receiveWord == null)
                        break;

                    if(wordList.indexOf(receiveWord) >= 0) {
                        ta.append(receiveWord+"=Yes"+"\n");
                        bw.write("Yes" + "\n");
                        bw.flush();
                    }
                    else {
                        ta.append(receiveWord+"=No"+"\n");
                        bw.write("No" + "\n");
                        bw.flush();
                    }
                }
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new test4Server();
    }
}
