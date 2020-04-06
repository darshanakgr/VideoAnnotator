/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.larc.videoannotator;

import static edu.larc.videoannotator.Main.Mat2BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

/**
 *
 * @author Darshana Rathnayake
 */
public class MainUIForm extends javax.swing.JFrame {
    
    private String filePath;
    private Mat resizedFrame;
    private Mat frame;
    private VideoCapture capture;
    private Thread playThread;
    private double currentPosition;
    private int duration;
    private final ArrayList<String> annotations;
    private boolean opened;
    private int counter = 0;
    private int[] repetitions = {0, 0, 0, 0};

    /**
     * Creates new form MainUIForm
     */
    public MainUIForm() {
        initComponents();
        frame = new Mat();
        resizedFrame = new Mat();
        annotations = new ArrayList<String>();
        startBtn.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewLabel = new javax.swing.JLabel();
        openVideoBtn = new javax.swing.JButton();
        pathText = new javax.swing.JTextField();
        controlPanel = new javax.swing.JPanel();
        startBtn = new javax.swing.JButton();
        timeLabel = new javax.swing.JLabel();
        timeText = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        annotatePanel = new javax.swing.JPanel();
        userIdlabel = new javax.swing.JLabel();
        userIdText = new javax.swing.JTextField();
        exerciseLabel = new javax.swing.JLabel();
        mistakeLabel = new javax.swing.JLabel();
        exerciseCombo = new javax.swing.JComboBox<>();
        mistakeCombo = new javax.swing.JComboBox<>();
        pauseBtn = new javax.swing.JButton();
        annotateBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        removeLastRecordBtn = new javax.swing.JButton();
        setCombo = new javax.swing.JComboBox<>();
        setLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        repLabel = new javax.swing.JLabel();
        repIncBtn = new javax.swing.JButton();
        repDecBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1625, 819));
        setMinimumSize(new java.awt.Dimension(1625, 819));
        setPreferredSize(new java.awt.Dimension(1625, 819));
        setSize(new java.awt.Dimension(1625, 819));

        viewLabel.setBackground(new java.awt.Color(255, 255, 255));
        viewLabel.setMaximumSize(new java.awt.Dimension(1366, 768));
        viewLabel.setMinimumSize(new java.awt.Dimension(1366, 768));
        viewLabel.setName(""); // NOI18N
        viewLabel.setPreferredSize(new java.awt.Dimension(1366, 768));

        openVideoBtn.setText("Open");
        openVideoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openVideoBtnActionPerformed(evt);
            }
        });

        pathText.setEditable(false);
        pathText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathTextActionPerformed(evt);
            }
        });

        controlPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Controls"));

        startBtn.setText("Start");
        startBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBtnActionPerformed(evt);
            }
        });

        timeLabel.setText("Time");

        timeText.setText("00:00");

        jButton1.setText("10s >>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("<< 10s");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(startBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, controlPanelLayout.createSequentialGroup()
                        .addComponent(timeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timeText, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(startBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeLabel)
                    .addComponent(timeText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        annotatePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Annotating Tools"));

        userIdlabel.setText("User ID");

        userIdText.setPreferredSize(new java.awt.Dimension(128, 25));

        exerciseLabel.setText("Exercise");

        mistakeLabel.setText("Mistake");

        exerciseCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DB-Biceps", "DB-LatRaise", "DB-Triceps" }));
        exerciseCombo.setPreferredSize(new java.awt.Dimension(128, 25));

        mistakeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ICROM", "WR-CURL", "MOTION", "SPEED", "POS-DRIFT", "ROM-DRIFT" }));
        mistakeCombo.setPreferredSize(new java.awt.Dimension(128, 25));

        pauseBtn.setText("Pause");
        pauseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseBtnActionPerformed(evt);
            }
        });

        annotateBtn.setText("Annotate");
        annotateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annotateBtnActionPerformed(evt);
            }
        });

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        removeLastRecordBtn.setText("Remove Last Record");
        removeLastRecordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeLastRecordBtnActionPerformed(evt);
            }
        });

        setCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S1", "S2", "S3", "S4" }));
        setCombo.setPreferredSize(new java.awt.Dimension(128, 25));

        setLabel.setText("Set");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Repetitions"));

        repLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        repLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        repLabel.setText("0");

        repIncBtn.setText("Repetition ++");
        repIncBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repIncBtnActionPerformed(evt);
            }
        });

        repDecBtn.setText("Repetition --");
        repDecBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repDecBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(repLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(repIncBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(repDecBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(repLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(repIncBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(repDecBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout annotatePanelLayout = new javax.swing.GroupLayout(annotatePanel);
        annotatePanel.setLayout(annotatePanelLayout);
        annotatePanelLayout.setHorizontalGroup(
            annotatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(annotatePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(annotatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(annotatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pauseBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(annotateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, annotatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(annotatePanelLayout.createSequentialGroup()
                                .addComponent(mistakeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mistakeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(annotatePanelLayout.createSequentialGroup()
                                .addComponent(userIdlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(userIdText, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(saveBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(removeLastRecordBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(annotatePanelLayout.createSequentialGroup()
                        .addComponent(setLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(setCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(annotatePanelLayout.createSequentialGroup()
                        .addComponent(exerciseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exerciseCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        annotatePanelLayout.setVerticalGroup(
            annotatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(annotatePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pauseBtn)
                .addGap(35, 35, 35)
                .addGroup(annotatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userIdlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userIdText, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(annotatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exerciseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exerciseCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(annotatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(setLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(annotatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mistakeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mistakeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(removeLastRecordBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(annotateBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveBtn)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(openVideoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pathText))
                    .addComponent(viewLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1368, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(annotatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(openVideoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pathText, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(annotatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void openVideoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openVideoBtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int res = fileChooser.showDialog(this, "Open");
        if(res == JFileChooser.APPROVE_OPTION){
            filePath = fileChooser.getSelectedFile().getPath();
            capture = new VideoCapture();
            opened = capture.open(filePath);
            duration = (int) (1000 / capture.get(Videoio.CAP_PROP_FPS));
            annotations.clear();
            currentPosition = 0.0;
            startBtn.setEnabled(true);
            repetitions = new int[]{0, 0, 0, 0};
            updateRepLabel();
        } else {
            filePath = "";
        }
        pathText.setText(filePath);
    }//GEN-LAST:event_openVideoBtnActionPerformed

    private void pathTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pathTextActionPerformed

    private void startBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBtnActionPerformed
        if (opened) {
            playThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (capture.grab()) {
                        if (capture.retrieve​(frame)) {
                            if (counter != 0) {
                                capture.set(Videoio.CAP_PROP_POS_MSEC, (currentPosition + counter) < 0 ? 0: (currentPosition + counter));
                                counter = 0;
                                continue;
                            }
                            
                            currentPosition = capture.get(Videoio.CAP_PROP_POS_MSEC);
                            timeText.setText(String.format("%2d:%2d", (int) currentPosition / 60000, (int) currentPosition % 60000));
                            // Resize the frame
                            Imgproc.resize(frame, resizedFrame, new Size(1366, 768));
                            ImageIcon image = new ImageIcon(Main.Mat2BufferedImage(resizedFrame));
                            viewLabel.setIcon(image);
                            viewLabel.repaint();
                            try {
                                Thread.sleep(duration);
                            } catch (InterruptedException ex) {
                                break;
                            }
                        }
                    }
                }
            });
            playThread.start();
            startBtn.setText("Stop");
            opened = false;
        } else {
            if (playThread != null) {
                playThread.interrupt();
                playThread = null;
            }
            if (capture != null) {
                capture.release();
                capture = null;
            }
            startBtn.setText("Start");
            startBtn.setEnabled(false);
        }        
    }//GEN-LAST:event_startBtnActionPerformed

    private void pauseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseBtnActionPerformed
        if (playThread != null) {
            playThread.interrupt();
            playThread = null;
            pauseBtn.setText("Play");
        } else {
            playThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean set = capture.set(Videoio.CAP_PROP_POS_MSEC, currentPosition);
                    while (capture.grab()) {
                        if (capture.retrieve​(frame)) {
                            currentPosition = capture.get(Videoio.CAP_PROP_POS_MSEC);
                            timeText.setText(String.format("%2d:%2d", (int) currentPosition / 60000, (int) currentPosition % 60000));
                            // Resize the frame
                            Imgproc.resize(frame, resizedFrame, new Size(1366, 768));
                            ImageIcon image = new ImageIcon(Main.Mat2BufferedImage(resizedFrame));
                            viewLabel.setIcon(image);
                            viewLabel.repaint();
                            try {
                                Thread.sleep(duration);
                            } catch (InterruptedException ex) {
                                break;
                            }
                        }
                    }
                }
            });
            playThread.start();
            pauseBtn.setText("Pause");
        }
    }//GEN-LAST:event_pauseBtnActionPerformed

    private void annotateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annotateBtnActionPerformed
        String userId = userIdText.getText();
        String exercise = exerciseCombo.getSelectedItem().toString();
        String mistake = mistakeCombo.getSelectedItem().toString();
        String set = setCombo.getSelectedItem().toString();
        int index = setCombo.getSelectedIndex();
        String annotation = String.format("%.2f,%s,%s,%s,%d,%s\n", currentPosition, userId, exercise, set, repetitions[index], mistake);
        annotations.add(annotation);
    }//GEN-LAST:event_annotateBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        String logPath = filePath.replace(".mp4", ".txt");
        try {
            FileWriter fileWriter = new FileWriter(logPath);
            for (String annotation : annotations) {
                fileWriter.write(annotation);
            }
            fileWriter.write(String.format("REPETITIONS,%d,%d,%d,%d", repetitions[0], repetitions[1], repetitions[2], repetitions[3]));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(MainUIForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void removeLastRecordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeLastRecordBtnActionPerformed
        if (annotations.size() > 0) {
            annotations.remove(annotations.size() - 1);
        }
    }//GEN-LAST:event_removeLastRecordBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        counter = 10000;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        counter = -10000;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void repIncBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repIncBtnActionPerformed
        int index = setCombo.getSelectedIndex();
        repetitions[index]++;
        updateRepLabel();
    }//GEN-LAST:event_repIncBtnActionPerformed

    private void repDecBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repDecBtnActionPerformed
        int index = setCombo.getSelectedIndex();
        repetitions[index]--;
        updateRepLabel();
    }//GEN-LAST:event_repDecBtnActionPerformed

    private void updateRepLabel(){
        int index = setCombo.getSelectedIndex();
        repLabel.setText(Integer.toString(repetitions[index]));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton annotateBtn;
    private javax.swing.JPanel annotatePanel;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JComboBox<String> exerciseCombo;
    private javax.swing.JLabel exerciseLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> mistakeCombo;
    private javax.swing.JLabel mistakeLabel;
    private javax.swing.JButton openVideoBtn;
    private javax.swing.JTextField pathText;
    private javax.swing.JButton pauseBtn;
    private javax.swing.JButton removeLastRecordBtn;
    private javax.swing.JButton repDecBtn;
    private javax.swing.JButton repIncBtn;
    private javax.swing.JLabel repLabel;
    private javax.swing.JButton saveBtn;
    private javax.swing.JComboBox<String> setCombo;
    private javax.swing.JLabel setLabel;
    private javax.swing.JButton startBtn;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel timeText;
    private javax.swing.JTextField userIdText;
    private javax.swing.JLabel userIdlabel;
    private javax.swing.JLabel viewLabel;
    // End of variables declaration//GEN-END:variables
}
