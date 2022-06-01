////////////////////////////////////////////////////////////////////////////////
// File:            Main.java
// Course:          CSC 232 A, Spring 2021
// Authors:         Brian Howard, Minh Nguyen
//
// Acknowledgments: None
//
// Online sources:  None
////////////////////////////////////////////////////////////////////////////////
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class Main
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Animation");

      // Construct a simple animation: a large circle, followed by a
      // rectangle that grows from the left to fill the window, followed
      // by a circle that grows from the center.
      // WARNING: there are magic numbers here, and I don't care.

      Animation square1 = new Animation(time-> Image.square1().scale(time,1)); 
      Animation square2 = new Animation(time-> Image.square2().scale(1,time));
      Animation square3 = new Animation(time-> Image.square3().scale(1-time, 1));
      Animation square4 = new Animation(time-> Image.square4().scale(1, 1-time));

      Animation squareAnimation = square1.before(square2).before(square3).before(square4);


      Animation cloud = new Animation(time-> Image.cloud(0.1, 0.1, 0.1, Color.BLUE).scale(time,1));
      Animation cloud1 = new Animation(time-> Image.cloud(0.5, 0.5, 0.2, Color.GREEN).scale(time,1));
      Animation cloud2 = new Animation(time-> Image.cloud(0.4, 0.7, 0.05, Color.GRAY).scale(time,1));

      Animation cloudAnimation = cloud.before(cloud1).before(cloud2);

      
      Animation spade =  new Animation(time->(Image.circle1(0,0,0.1,0.1)
                                 .over(Image.circle1(0.05, 0, 0.1, 0.1))
                                 .over(Image.cone(0.1+0.05, 0+0.05, 0.1+0.05, 0.2, Color.BLACK))
                                 .over(Image.cone(0.1+0.01, 0.12, 0.075, 0.1, Color.BLACK))
                                 .translate(0.45,0.45)
                                 .scale(time, time)
                                 ));

      Animation club = new Animation(time -> Image.circle1(0,0.1,0.1,0.1)
                                 .over(Image.circle1(0.05, 0.1, 0.1, 0.1))
                                 .over(Image.circle1(0.05/2,0.03, 0.1,0.1))
                                 .over(Image.cone(0.1+0.01, 0.25, 0.075, 0.1, Color.BLACK))
                                 .translate(0.40,0.35)
                                 .scale(time,1)
                                 );

      Animation diamond = new Animation(time -> Image.cone(0.2,0.2, 0.15, 0.2, Color.RED)
                                                      .over(Image.triangle(0.05,0.2, 0.15, 0.2, Color.RED))
                                                      .scale(time, time).translate(0.5 - time / 2, 0.5 - time / 2)
                                                      );

      Animation heart = new Animation(time->Image.circle1(0,0,0.1,0.1)
                                             .over(Image.circle1(0.05, 0, 0.1, 0.1))
                                             .over(Image.triangle(0, 0.05, 0.1+0.05, 0.15, Color.RED))
                                             .translate(0.45,0.45)
                                             .scale(time, time)
                                             );

      Animation cardDeck = spade.before(club).before(diamond).before(heart);

      Animation part1 = Animation.fixed(Image.circle().over(Image.circle().scale(0.5, 0.5)));

      Animation part2 = new Animation(time -> Image.square().scale(time, 1));
      
      Animation part3 = new Animation(time -> Image.circle().scale(time, time).translate(0.5 - time / 2, 0.5 - time / 2));

      Animation animation = squareAnimation.before(cardDeck).before(cloudAnimation);

      Animation animation1 = part1.before(part2).before(part3);

      final AnimationComponent view = new AnimationComponent(animation, Color.BLACK);

      System.out.println(view.getDuration()); //duration is 10000 miliseconds aka 10s


      view.setPreferredSize(new Dimension(700, 700));

      // Build a simple user interface around the AnimationComponent
      frame.setLayout(new BorderLayout());
      frame.add(view, BorderLayout.CENTER);

      Box buttons = Box.createHorizontalBox();

      JButton startButton = new JButton("Start");
      startButton.addActionListener(event -> view.start());
      buttons.add(startButton);

      JButton stopResumeButton = new JButton("Resume");
      stopResumeButton.addActionListener(event -> {
         if (view.isRunning()) {
            view.stop();
         }
         else {
            view.resume();
         }
      });
      stopResumeButton.setEnabled(false); // initially disabled
      buttons.add(stopResumeButton);

      JButton slowerButton = new JButton("Slower");
      slowerButton.addActionListener(
               event -> view.setDuration(view.getDuration() * 6 / 5));
      buttons.add(slowerButton);

      JButton fasterButton = new JButton("Faster");
      fasterButton.addActionListener(
               event -> view.setDuration(view.getDuration() * 5 / 6));
      buttons.add(fasterButton);

      JCheckBox loopButton = new JCheckBox("Loop");
      loopButton.addActionListener(
               event -> view.setLoop(loopButton.isSelected()));
      buttons.add(loopButton);

      frame.add(buttons, BorderLayout.SOUTH);

      view.addRunStateListener(event -> {
         if (view.isRunning()) {
            startButton.setEnabled(false);
            stopResumeButton.setText("Stop");
            stopResumeButton.setEnabled(true);
         }
         else {
            startButton.setEnabled(true);
            stopResumeButton.setText("Resume");
            stopResumeButton.setEnabled(view.isPaused());
         }
      });

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
}
