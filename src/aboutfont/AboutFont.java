 
package aboutfont;

 import java.awt.BorderLayout;
 import java.awt.FlowLayout;
 import javax.swing.JFrame;
 import javax.swing.JButton;
 import javax.swing.JLabel;
 import javax.swing.JComboBox;
 import javax.swing.JPanel;
 import javax.swing.JCheckBox;
 import javax.swing.border.TitledBorder;
 import java.awt.Color;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.awt.event.ItemEvent;
 import java.awt.event.ItemListener;
 import java.awt.Font;
 import java.awt.Cursor;
 
public class AboutFont extends JFrame{

    static int boldval = 0,size = 20;
    String[] fontnames = {"plain","SansSerif","Serif","Monospaced","Dialog","DialogInput","Courier"};
    String fontName = "plain";
    JComboBox box ;
    JButton plus,minus;
    JCheckBox bold,italic;
    JLabel label = new JLabel("Hello World"); 
    Font font = new Font(fontName,boldval,size);
    
    AboutFont(){
        
          super("getting RGB index "); 
          
          JPanel p1 = new JPanel();
          
          label.setFont(font);
          p1.setBackground(Color.WHITE);
          p1.setBorder(new TitledBorder("Change affect the Text"));
          p1.add(label);
          
          JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
          
          box = new JComboBox(fontnames);
          plus = new JButton("+");
          minus = new JButton("-");
         
          bold = new JCheckBox("Bold");
          italic = new JCheckBox("Italic");
          
          p2.setCursor(new Cursor(Cursor.HAND_CURSOR));
          p2.add(box);
          p2.add(bold);
          p2.add(italic);
          p2.add(plus);
          p2.add(minus);
          
          add(p1,BorderLayout.CENTER);
          add(p2,BorderLayout.SOUTH);
          
          box.addItemListener(new ItemListener(){
           @Override
           public void itemStateChanged(ItemEvent e){
              if(e.getStateChange() == ItemEvent.SELECTED){
                  label.setFont(new Font(fontName=fontnames[box.getSelectedIndex()],boldval,size));
              }
           }          
          });
          
          minus.addActionListener(new ActionListener(){
              @Override
              public void actionPerformed(ActionEvent e){
                  size-=5;
                  if(size<1)
                      size = 10;
                  label.setFont(new Font(fontName,boldval,size));
              }
          });
          
          plus.addActionListener(new ActionListener(){
              @Override
              public void actionPerformed(ActionEvent e){
                   if(e.getSource() == plus){
                       size+=5;
                  label.setFont(new Font(fontName,boldval,size));
                   }
              }
          });
          
          BoldHandler handler = new BoldHandler();
          
          bold.addItemListener(handler);
          italic.addItemListener(handler);
          
        }
        
        public class BoldHandler implements ItemListener{
            @Override
            public void itemStateChanged(ItemEvent e){
                if(italic.isSelected() && bold.isSelected()){
                    boldval = 3; 
                    label.setFont(new Font(fontName,boldval,size));
                }
                else if(italic.isSelected()){
                    boldval = 2;//fortexting italic use 2 for bold 3 instead of typing italic bold
                    label.setFont(new Font(fontName,boldval,size));
                }
                else  if(bold.isSelected()){
                    boldval = 1; 
                    label.setFont(new Font(fontName,boldval,size));
                }
                  else{
                    boldval = 0; 
                    label.setFont(new Font(fontName,boldval,size));
                }
            }
        }
    public static void main(String[] args) {
        AboutFont frame = new AboutFont();
        
        frame.setSize(330,350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); 
    }
    
}
