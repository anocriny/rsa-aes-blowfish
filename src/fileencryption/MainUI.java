package fileencryption;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainUI extends JFrame {

    String rsafileinputdir,rsadecryptfileinputdir, aesfileinputdir, aesdecryptfileinputdir;
    JTabbedPane tab;
    JPanel pn1,pn2,pn3;
    JLabel rsatitle, bftitle, aestitle;


    public MainUI(){

        setLayout(new BorderLayout());
        setSize(800, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setResizable(false);

        tab = new JTabbedPane();
        pn1 = new JPanel(new GridBagLayout());
        pn2 = new JPanel(new GridBagLayout());
        pn3 = new JPanel(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();

        tab.addTab("RSA", pn1);
        tab.addTab("AES", pn2);
        tab.addTab("Blowfish", pn3);




        ////////////////RSA Panel

        gb.fill = GridBagConstraints.HORIZONTAL;
        gb.gridx = 0;
        gb.gridy = 0;
        gb.ipady = 40;
        gb.gridwidth = 3;
        rsatitle = new JLabel("RSA Encryption" , SwingConstants.CENTER);
        rsatitle.setFont(new Font("Serif", Font.BOLD, 30));
        rsatitle.setForeground(Color.blue);
        pn1.add(rsatitle,gb);

        gb.gridx = 0;
        gb.gridy = 1;
        gb.ipady = 7;
        gb.gridwidth = 1;
        JLabel rsaselectFileLabel = new JLabel("SELECT FILE :");
        pn1.add(rsaselectFileLabel, gb);

        gb.gridx = 1;
        gb.gridy = 1;
        JTextField selectInputFileTxtRSA = new JTextField(20);
        pn1.add(selectInputFileTxtRSA, gb);

        gb.gridx = 2;
        gb.gridy = 1;
        gb.weightx = 0.5;
        gb.ipady = 0;
        JButton selectInputBrowseBtnRSA = new JButton("Browse");
        pn1.add(selectInputBrowseBtnRSA, gb);
        selectInputBrowseBtnRSA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser c = new JFileChooser();
                // Demonstrate "Open" dialog:
                int rVal = c.showOpenDialog(MainUI.this);
                if (rVal == JFileChooser.APPROVE_OPTION) {
                    selectInputFileTxtRSA.setText(c.getSelectedFile().getAbsolutePath());
                    rsafileinputdir = c.getCurrentDirectory().toString();
                }
            }
        });

        gb.gridx = 0;
        gb.gridy = 2;
        gb.ipady = 7;
        JLabel rsaselectPubKeyLabel = new JLabel("Public KEY : ");
        pn1.add(rsaselectPubKeyLabel, gb);

        gb.gridx = 1;
        gb.gridy = 2;
        JTextField selectPubKeyTxtRSA = new JTextField(20);
        pn1.add(selectPubKeyTxtRSA, gb);

        gb.gridx = 2;
        gb.gridy = 2;
        gb.weightx = 0.5;
        gb.ipady = 0;
        JButton selectPubKeyBrowseBtnRSA = new JButton("Browse");
        pn1.add(selectPubKeyBrowseBtnRSA, gb);
        selectPubKeyBrowseBtnRSA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser c = new JFileChooser();
                // Demonstrate "Open" dialog:
                int rVal = c.showOpenDialog(MainUI.this);
                if (rVal == JFileChooser.APPROVE_OPTION) {
                    selectPubKeyTxtRSA.setText(c.getSelectedFile().getAbsolutePath());
                }
            }
        });

        gb.gridx = 0;
        gb.gridy = 3;
        JLabel rsanewFilenameLabel = new JLabel("NEW FILENAME :");
        pn1.add(rsanewFilenameLabel, gb);

        gb.gridx = 1;
        gb.gridy = 3;
        JTextField outputFileTxtRSA = new JTextField(20);
        pn1.add(outputFileTxtRSA, gb);

        gb.gridx = 0;
        gb.gridy = 4;
        JButton encryptBtnRSA = new JButton("ENCRYPT");
        pn1.add(encryptBtnRSA, gb);
        encryptBtnRSA.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String fileinputdir, fileoutputdir, pubkeydir;
                fileinputdir = selectInputFileTxtRSA.getText();
                fileoutputdir = rsafileinputdir+"/"+outputFileTxtRSA.getText();
                pubkeydir = selectPubKeyTxtRSA.getText();
                MainRSAActivity rsaActivity = new MainRSAActivity();
                rsaActivity.setInputdir(fileinputdir);
                rsaActivity.setOutputdir(fileoutputdir);
                rsaActivity.setPubkeydir(pubkeydir);
                rsaActivity.doEncryptRSA();
                System.out.println(fileinputdir);
                System.out.println(fileoutputdir);
                System.out.println(pubkeydir);
            }
        });



        gb.gridx = 0;
        gb.gridy = 5;
        gb.ipady = 7;
        gb.gridwidth = 1;
        JLabel rsaselectFileLabel_dec = new JLabel("SELECT FILE :");
        pn1.add(rsaselectFileLabel_dec, gb);

        gb.gridx = 1;
        gb.gridy = 5;
        JTextField selectInputFileTxtRSA_dec = new JTextField(20);
        pn1.add(selectInputFileTxtRSA_dec, gb);


        gb.gridx = 2;
        gb.gridy = 5;
        gb.weightx = 0.5;
        gb.ipady = 0;
        JButton selectInputBrowseBtnRSA_dec = new JButton("Browse");
        pn1.add(selectInputBrowseBtnRSA_dec, gb);
        selectInputBrowseBtnRSA_dec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser c = new JFileChooser();
                // Demonstrate "Open" dialog:
                int rVal = c.showOpenDialog(MainUI.this);
                if (rVal == JFileChooser.APPROVE_OPTION) {
                    selectInputFileTxtRSA_dec.setText(c.getSelectedFile().getAbsolutePath());
                    rsadecryptfileinputdir = c.getCurrentDirectory().toString();
                }
            }
        });

        gb.gridx = 0;
        gb.gridy = 6;
        gb.ipady = 7;
        JLabel rsaselectPrivKeyLabel = new JLabel("Private KEY : ");
        pn1.add(rsaselectPrivKeyLabel, gb);

        gb.gridx = 1;
        gb.gridy = 6;
        JTextField selectPrivKeyTxtRSA = new JTextField(20);
        pn1.add(selectPrivKeyTxtRSA, gb);

        gb.gridx = 2;
        gb.gridy = 6;
        gb.weightx = 0.5;
        gb.ipady = 0;
        JButton selectPrivKeyBrowseBtnRSA = new JButton("Browse");
        pn1.add(selectPrivKeyBrowseBtnRSA, gb);
        selectPrivKeyBrowseBtnRSA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser c = new JFileChooser();
                // Demonstrate "Open" dialog:
                int rVal = c.showOpenDialog(MainUI.this);
                if (rVal == JFileChooser.APPROVE_OPTION) {
                    selectPrivKeyTxtRSA.setText(c.getSelectedFile().getAbsolutePath());
                }
            }
        });



        gb.gridx = 0;
        gb.gridy = 7;
        JLabel rsanewFilenameLabelAES_dec = new JLabel("NEW FILENAME :");
        pn1.add(rsanewFilenameLabel, gb);

        gb.gridx = 1;
        gb.gridy = 7;
        JTextField outputFileTxtRSA_dec = new JTextField(20);
        pn1.add(outputFileTxtRSA_dec, gb);


        gb.gridx = 0;
        gb.gridy = 8;
        JButton decryptBtnRSA = new JButton("DECRYPT");
        pn1.add(decryptBtnRSA, gb);
        decryptBtnRSA.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String fileinputdir, fileoutputdir, privkeydir;
                fileinputdir = selectInputFileTxtRSA_dec.getText();
                fileoutputdir = rsadecryptfileinputdir+"/"+outputFileTxtRSA_dec.getText();
                privkeydir = selectPrivKeyTxtRSA.getText();
                MainRSAActivity rsaActivity = new MainRSAActivity();
                rsaActivity.setInputdir(fileinputdir);
                rsaActivity.setOutputdir(fileoutputdir);
                rsaActivity.setPrivkeydir(privkeydir);
                rsaActivity.doDecryptRSA();
                System.out.println(fileinputdir);
                System.out.println(fileoutputdir);
                System.out.println(privkeydir);
            }
        });






        /////////////////AES Panel
        gb.fill = GridBagConstraints.HORIZONTAL;
        gb.gridx = 0;
        gb.gridy = 0;
        gb.ipady = 40;
        gb.gridwidth = 3;
        aestitle = new JLabel("AES Encryption" , SwingConstants.CENTER);
        aestitle.setFont(new Font("Serif", Font.BOLD, 30));
        aestitle.setForeground(Color.blue);
        pn2.add(aestitle,gb);

        gb.gridx = 0;
        gb.gridy = 1;
        gb.ipady = 7;
        gb.gridwidth = 1;
        JLabel selectFileLabelAES = new JLabel("SELECT FILE :");
        pn2.add(selectFileLabelAES, gb);

        gb.gridx = 1;
        gb.gridy = 1;

        JTextField selectInputFileTxtAES = new JTextField(20);
        pn2.add(selectInputFileTxtAES, gb);

        gb.gridx = 2;
        gb.gridy = 1;
        gb.weightx = 0.5;
        gb.ipady = 0;
        JButton selectInputBrowseBtnAES = new JButton("Browse");
        pn2.add(selectInputBrowseBtnAES, gb);
        selectInputBrowseBtnAES.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser c = new JFileChooser();
                // Demonstrate "Open" dialog:
                int rVal = c.showOpenDialog(MainUI.this);
                if (rVal == JFileChooser.APPROVE_OPTION) {
                    selectInputFileTxtAES.setText(c.getSelectedFile().getAbsolutePath());
                    aesfileinputdir = c.getCurrentDirectory().toString();
                }
            }
        });

        gb.gridx = 0;
        gb.gridy = 2;
        gb.ipady = 7;
        JLabel keyLabelAES = new JLabel("KEY : ");
        pn2.add(keyLabelAES, gb);

        gb.gridx = 1;
        gb.gridy = 2;
        JTextField keyTxtAES = new JTextField(20);
        pn2.add(keyTxtAES, gb);

        gb.gridx = 0;
        gb.gridy = 3;
        JLabel newFilenameLabelAES = new JLabel("NEW FILENAME :");
        pn2.add(newFilenameLabelAES, gb);

        gb.gridx = 1;
        gb.gridy = 3;
        JTextField outputFileTxtAES = new JTextField(20);
        pn2.add(outputFileTxtAES, gb);

        gb.gridx = 0;
        gb.gridy = 4;
        JButton encryptBtnAES = new JButton("ENCRYPT");
        pn2.add(encryptBtnAES, gb);
        encryptBtnAES.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                MainAESActivity maes = new MainAESActivity();
                String fileinputdir, fileoutputdir, key;
                fileinputdir = selectInputFileTxtAES.getText();
                fileoutputdir = aesfileinputdir+"/"+outputFileTxtAES.getText();
                key = keyTxtAES.getText();
                maes.setInputdir(fileinputdir);
                maes.setOutputdir(fileoutputdir);
                maes.setKey(key);
                maes.doEncryptAES();
//                System.out.println(fileinputdir);
//                System.out.println(fileoutputdir);
//                System.out.println(key);

            }
        });

        gb.gridx = 0;
        gb.gridy = 5;
        gb.ipady = 7;
        gb.gridwidth = 1;
        JLabel selectFileLabelAES_dec = new JLabel("SELECT FILE :");
        pn2.add(selectFileLabelAES_dec, gb);

        gb.gridx = 1;
        gb.gridy = 5;

        JTextField selectInputFileTxtAES_dec = new JTextField(20);
        pn2.add(selectInputFileTxtAES_dec, gb);

        gb.gridx = 2;
        gb.gridy = 5;
        gb.weightx = 0.5;
        gb.ipady = 0;
        JButton selectInputBrowseBtnAES_dec = new JButton("Browse");
        pn2.add(selectInputBrowseBtnAES_dec, gb);

        gb.gridx = 0;
        gb.gridy = 6;
        gb.ipady = 7;
        JLabel keyLabelAES_dec = new JLabel("KEY : ");
        pn2.add(keyLabelAES_dec, gb);

        gb.gridx = 1;
        gb.gridy = 6;
        JTextField keyTxtAES_dec = new JTextField(20);
        pn2.add(keyTxtAES_dec, gb);

        gb.gridx = 0;
        gb.gridy = 7;
        JLabel newFilenameLabelAES_dec = new JLabel("NEW FILENAME :");
        pn2.add(newFilenameLabelAES_dec, gb);

        gb.gridx = 1;
        gb.gridy = 7;
        JTextField outputFileTxtAES_dec = new JTextField(20);
        pn2.add(outputFileTxtAES_dec, gb);

        gb.gridx = 0;
        gb.gridy = 8;
        JButton encryptBtnAES_dec = new JButton("DECRYPT");
        pn2.add(encryptBtnAES_dec, gb);
        encryptBtnAES.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //panggil fungsi ikuuk radiobutton
            }
        });







//        /////////Blowfish Panel
//        gb.fill = GridBagConstraints.HORIZONTAL;
//        gb.gridx = 0;
//        gb.gridy = 0;
//        gb.ipady = 40;
//        gb.gridwidth = 3;
//        bftitle = new JLabel("Blowfish Encryption" , SwingConstants.CENTER);
//        bftitle.setFont(new Font("Serif", Font.BOLD, 30));
//        bftitle.setForeground(Color.blue);
//        pn3.add(bftitle,gb);
//
//
//        gb.gridx = 0;
//        gb.gridy = 1;
//        gb.ipady = 7;
//        gb.gridwidth = 1;
//        selectFileLabel = new JLabel("SELECT FILE :");
//        pn3.add(selectFileLabel, gb);
//
//        gb.gridx = 1;
//        gb.gridy = 1;
//        selectFileTxt = new JTextField(20);
//        pn3.add(selectFileTxt, gb);
//
//        gb.gridx = 2;
//        gb.gridy = 1;
//        gb.weightx = 0.5;
//        gb.ipady = 0;
//        browseSelectFileBtn = new JButton("Browse");
//        pn3.add(browseSelectFileBtn, gb);
//
//        gb.gridx = 0;
//        gb.gridy = 2;
//        gb.ipady = 7;
//        selectPubKeyLabel = new JLabel("Public KEY : ");
//        pn3.add(selectPubKeyLabel, gb);
//
//        gb.gridx = 1;
//        gb.gridy = 2;
//        selectPubKeyTxt = new JTextField(20);
//        pn3.add(selectPubKeyTxt, gb);
//
//        gb.gridx = 0;
//        gb.gridy = 3;
//        newFilenameLabel = new JLabel("NEW FILENAME :");
//        pn3.add(newFilenameLabel, gb);
//
//        gb.gridx = 1;
//        gb.gridy = 3;
//        newFilenameTxt = new JTextField(20);
//        pn3.add(newFilenameTxt, gb);
//
//        gb.gridx = 0;
//        gb.gridy = 4;
//        encryptBtn = new JButton("ENCRYPT");
//        pn3.add(encryptBtn, gb);
//        encryptBtn.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent rima){
//                //panggil fungsi ikuuk radiobutton
//            }
//        });
//
//
//
//        gb.gridx = 0;
//        gb.gridy = 5;
//        gb.ipady = 7;
//        gb.gridwidth = 1;
//        selectFileLabel = new JLabel("SELECT FILE :");
//        pn3.add(selectFileLabel, gb);
//
//        gb.gridx = 1;
//        gb.gridy = 5;
//        decryptselectFileTxt = new JTextField(20);
//        pn3.add(decryptselectFileTxt, gb);
//
//        gb.gridx = 2;
//        gb.gridy = 5;
//        gb.weightx = 0.5;
//        gb.ipady = 0;
//        browseSelectFileBtn = new JButton("Browse");
//        pn3.add(browseSelectFileBtn, gb);
//
//        gb.gridx = 0;
//        gb.gridy = 6;
//        gb.ipady = 7;
//        selectPrivKeyLabel = new JLabel("Private KEY : ");
//        pn3.add(selectPrivKeyLabel, gb);
//
//        gb.gridx = 1;
//        gb.gridy = 6;
//        selectPrivKeyTxt = new JTextField(20);
//        pn3.add(selectPrivKeyTxt, gb);
//
//        gb.gridx = 0;
//        gb.gridy = 7;
//        lblNew = new JLabel("NEW FILENAME :");
//        pn3.add(lblNew, gb);
//
//        gb.gridx = 1;
//        gb.gridy = 7;
//        decryptnewFilenameTxt = new JTextField(20);
//        pn3.add(decryptnewFilenameTxt, gb);
//
//
//        gb.gridx = 0;
//        gb.gridy = 8;
//        decryptBtn = new JButton("DECRYPT");
//        pn3.add(decryptBtn, gb);
//        decryptBtn.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent rima){
//                //panggil fungsi ikuuk radiobutton
//            }
//        });
//






        add(tab, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        MainUI f = new MainUI();
    }
}
