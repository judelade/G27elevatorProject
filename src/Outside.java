import java.awt.*;

import javax.swing.*;

public class Outside implements Runnable{
    JPanel panel;
    JLabel[] floors;
    JButton[] updown;
    int[] floorTobutton;
    int[] stateTobutton;
    int[] pushed;
    int[] answerelevator;
    ButtonListener l;

    Outside(){
        panel = new JPanel();
        floors = new JLabel[Const.floornumber];
        updown = new JButton[Const.floornumber*2-2];
        pushed = new int[Const.floornumber*2-2];
        for(int i = 0; i < pushed.length; i++)
            pushed[i] = 0;

        floorTobutton = new int[Const.floornumber*2-2];
        for(int i = 0; i < floorTobutton.length; i++)
            if(i % 2 == 0)
                floorTobutton[i] = Const.floornumber-i/2;
            else
                floorTobutton[i] = Const.floornumber-(i+1)/2;

        stateTobutton = new int[Const.floornumber*2-2];
        for(int i = 0; i < stateTobutton.length; i++)
            if(i % 2 == 0)
                stateTobutton[i] = -1;
            else
                stateTobutton[i] = 1;

        answerelevator = new int[Const.floornumber*2-2];
        for(int i = 0; i < answerelevator.length; i++)
            answerelevator[i] = -1;

        l = new ButtonListener();
        //layout();
    }



    public void run() {
        while(true) {
            if(checkNewButton())
                try {
                    traverseButton();
                } catch(Exception e) {
                    System.exit(0);
                }
        }
    }

    private boolean checkNewButton() {
        for(int i = 0; i < updown.length; i++) {
            if(updown[i].getBackground()==Color.RED && pushed[i]==0)
                return true;
        }
        return false;
    }

    private void traverseButton() {
        for(int i = 0; i < updown.length; i++) {
            if(updown[i].getBackground()==Color.RED && pushed[i]==0)
                pushed[i] = 1;
        }
    }
}
