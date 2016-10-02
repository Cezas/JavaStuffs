/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessnum;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuessNumFrame extends JFrame implements ActionListener{
    //initialize
    private final JButton replay;
    private final JTextField inputbox;
    private final JLabel display;
    
    private int answer;
    private int prev;
    Random rand=new Random();
    
    //gennew num, refresh window, reenable textfield & clear display
    public void restart(){
        answer=1+rand.nextInt(1000)+1;
        getContentPane().setBackground(null);
        inputbox.setEditable(true);
        display.setText("Temperature Unknown");         
    }
    
    //check to see if input was closer to answer than previous
    //then change colors accordingly
    //TODO: Handle same number input
    public void check(int val){
        
        if(prev>0){
            //warmer
            if(answer-prev > answer-val) 
                getContentPane().setBackground(Color.RED);
            //colder     
            if(answer-prev < answer-val)
               getContentPane().setBackground(Color.BLUE); 
        }
        
        if(val>answer)
            display.setText("Too high");
        if(val<answer)
            display.setText("Too low");
        
        //display correct, make text uneditable, and green screen
        if(val == answer){
            display.setText("CORRECT! The answer was "+ val);
            System.out.println("CORRECT");
            inputbox.setEditable(false);
            getContentPane().setBackground(Color.GREEN);
        }
        prev=val;
    }
    
    //implement event handling
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource()==replay)
            restart();
            
        if(event.getSource()==inputbox){
            try{
                check(Integer.parseInt(inputbox.getText()));
            }
            catch(NumberFormatException e){
                display.setText("You must enter a number");              
            }
        }
    }

    public GuessNumFrame(){
        //initialize components
        super("The Guess Num Game");
        replay=new JButton("Replay");
        getContentPane().setBackground(null);///window.setBackground(null);
        inputbox=new JTextField("Your answer here");
        display=new JLabel("Temperature Unknown", JLabel.CENTER);
        
        //modify necessary components
        display.setSize(display.getPreferredSize());
        //display.setOpaque(true);
        display.setBackground(Color.WHITE);
        
        replay.addActionListener(this);
        inputbox.addActionListener(this);       
        
        
       //add components
        add(replay,  BorderLayout.SOUTH);
        add(inputbox, BorderLayout.NORTH);
        add(display, BorderLayout.CENTER);
        
        //ship
        pack();
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
        restart();
    }
    
}
