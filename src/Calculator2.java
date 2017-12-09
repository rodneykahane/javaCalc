import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Calculator2 extends JFrame{
	
	char functionChar;
	int topper,tmp,firstRun=0,result=0;
	
	private static final long serialVersionUID = 1L;
	
	private JLabel TopJLabel;
	private JTextField TopJTextField;
		
	private JLabel resultJLabel;
	private JTextField totalResultJTextField;
	
	private JButton equalsJButton;
	private JButton plusJButton;
	private JButton minusJButton;
	private JButton multJButton;
	private JButton divJButton;
	
	public Calculator2(){
		
		createUserInterface();
		
	}//end calculator
	
	public void createUserInterface(){		
		
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setLayout(null);				
			
			//text label for first input box
			TopJLabel = new JLabel();
			TopJLabel.setText("Input Value");
			TopJLabel.setBounds(16, 16, 130, 21);//field size
			contentPane.add( TopJLabel);
			
			//first input box
			TopJTextField = new JTextField();
			TopJTextField.setText("");
			TopJTextField.setBounds(128, 16, 40, 25);//field size
			TopJTextField.setHorizontalAlignment(JTextField.RIGHT);
			contentPane.add( TopJTextField);			
									
			//text label for result box
			resultJLabel = new JLabel();
			resultJLabel.setText("Result");
			resultJLabel.setBounds(196, 16, 40, 21);//field size
			contentPane.add( resultJLabel);			
			
			//result box
			totalResultJTextField = new JTextField();
			totalResultJTextField.setBounds(244, 16, 106, 21);
			totalResultJTextField.setHorizontalAlignment(JTextField.RIGHT);
			totalResultJTextField.setEditable( false);
			contentPane.add(totalResultJTextField);				
		
			//clear button
			multJButton = new JButton();
			multJButton.setText("C");
			multJButton.setBounds( 136, 48, 50, 24); //x,y,w,h
			contentPane.add( multJButton);					
			multJButton.addActionListener(
					new ActionListener() {						
						public void actionPerformed( ActionEvent event) {													
							clearVal(event);
							firstRun = 0;							
						} //end actionPerformed
					} //end ActionListener				
			);//end ActionListener
			
			//addition button
			plusJButton = new JButton();
			plusJButton.setText("+");
			plusJButton.setBounds( 196, 48, 50, 24); //x,y,w,h
			contentPane.add( plusJButton);					
			plusJButton.addActionListener(
					new ActionListener() {						
						public void actionPerformed( ActionEvent event) {
								if (firstRun == 0) {
									storeVal(event);
									functionChar='a';
								} else {
									result=tmp;
									storeVal(event);
									equalsAction(event);
								}//end if/else
						} //end actionPerformed
					} //end ActionListener				
			);//end ActionListener
			
			//subtraction button
			minusJButton = new JButton();
			minusJButton.setText("-");
			minusJButton.setBounds( 238, 48, 50, 24); //x,y,w,h
			contentPane.add( minusJButton);					
			minusJButton.addActionListener(
					new ActionListener() {						
						public void actionPerformed( ActionEvent event) {							
							if (firstRun == 0) {
								storeVal(event);
								functionChar='s';
							} else {
								result=tmp;
								storeVal(event);
								equalsAction(event);
							}//end if/else
						} //end actionPerformed
					} //end ActionListener				
			);//end ActionListener
			
			//mult button
			multJButton = new JButton();
			multJButton.setText("*");
			multJButton.setBounds( 196, 74, 50, 24); //x,y,w,h
			contentPane.add( multJButton);					
			multJButton.addActionListener(
					new ActionListener() {						
						public void actionPerformed( ActionEvent event) {													
							if (firstRun == 0) {
								storeVal(event);
								functionChar='m';
							} else {
								result=tmp;
								storeVal(event);
								equalsAction(event);
							}//end if/else
						} //end actionPerformed
					} //end ActionListener				
			);//end ActionListener
			
			//division button
			divJButton = new JButton();
			divJButton.setText("*/*");
			divJButton.setBounds( 238, 74, 50, 24); //x,y,w,h
			contentPane.add( divJButton);					
			divJButton.addActionListener(
					new ActionListener() {						
						public void actionPerformed( ActionEvent event) {
							if (firstRun == 0) {
								storeVal(event);
								functionChar='d';
							} else {
								result=tmp;
								storeVal(event);
								equalsAction(event);
							}//end if/else							
						} //end actionPerformed
					} //end ActionListener				
			);//end ActionListener
						
			//equals button; use as a submit
			equalsJButton = new JButton();
			equalsJButton.setText("=");
			equalsJButton.setBounds( 196, 100, 126, 24);
			contentPane.add( equalsJButton);					
			equalsJButton.addActionListener(
					new ActionListener() {						
						public void actionPerformed( ActionEvent event) {
							if (firstRun == 0) {
							storeSecondVal(event);
							equalsAction(event);
							} else {
								result=tmp;
								equalsAction(event);															
							}//end if/else								
						} //end actionPerformed
					} //end ActionListener				
			);//end ActionListener
						
			//label and set size of window
			setTitle("Simple 4 function calculator");
			setSize(454,212);
			setVisible(true);			
			
		} //end createUserInterface
	
private void storeVal(ActionEvent event) {
		
		topper = Integer.parseInt(TopJTextField.getText());
			}//end storeVal

private void storeSecondVal(ActionEvent event) {
	tmp = Integer.parseInt(TopJTextField.getText());
	firstRun = 1;
}
	private void clearVal(ActionEvent event) {
		topper = 0;
		tmp = 0;
		totalResultJTextField.setText(String.valueOf(tmp));
		TopJTextField.setText(String.valueOf(tmp));
	}
	private void equalsAction(ActionEvent event) {
						
		if (functionChar == 'm') {					
				result=topper*tmp;
		 		totalResultJTextField.setText(String.valueOf(result));
		 		tmp = result;
		}else if (functionChar == 'a'){
			result=topper+tmp;
	 		totalResultJTextField.setText(String.valueOf(result));
	 		tmp = result;
		}else if (functionChar == 's'){
				if (firstRun==0){
					result=topper-tmp;
			 		totalResultJTextField.setText(String.valueOf(result));
				} else {
					result=tmp-topper;
			 		totalResultJTextField.setText(String.valueOf(result));
				}
	 		tmp = result;
		}else if (functionChar == 'd'){
			if (firstRun==0){
				result=topper/tmp;
		 		totalResultJTextField.setText(String.valueOf(result));
			} else {
				result=tmp/topper;
		 		totalResultJTextField.setText(String.valueOf(result));
			}
	 		tmp=result;
		}
	
	}//end equalsAction	
	
		public static void main(String[] args) {
			
			Calculator2 application = new Calculator2();
			application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	

	} //ends main method

}//end Calculator2 class

