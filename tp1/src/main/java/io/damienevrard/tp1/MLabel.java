

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JLabel;

/**
 *
 * @author IDEA Developers
 * 
 * 
 * 
 */
public class MLabel extends JLabel{
    
    private int randomSpeed;
    
    public MLabel(String c, int x, int y, int randomSpeed){
        super(c);
        this.randomSpeed = randomSpeed;
        Rectangle rec = new Rectangle();
        rec.x = x;
        rec.y = y;
        rec.width = 20;
        rec.height = 20;
        this.setBackground(Color.BLACK);
        this.setForeground(Color.GREEN);
        this.setBounds(rec);
        moveDown();
    }
    
    public void moveDown() {
        new Thread(() -> {
            int mHeight = MatrixView.instance.height;
            boolean finish = false;
            try {
                while(!finish){
                    
                    Rectangle rec = this.getBounds();
                    rec.y += 2;
                    this.setBounds(rec);
                    Thread.sleep(randomSpeed);
                    
                    if(rec.y >= mHeight){
                        finish = true;
                    }
                }
                
                if(this.getParent() != null){
                    this.getParent().remove(this);
                }
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
            
        }).start();
    }
    
    
}
