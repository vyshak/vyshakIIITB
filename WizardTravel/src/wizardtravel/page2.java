package wizardtravel;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class page2 extends WizardPage {
  private Text from;
  private Text to;
  private Text via1;
  private Text via2;
  private Text via3;
  private int count;
  private Composite container;

  public page2() {
	  
    super("Travel Details");
    setTitle("Travel Details");
    setDescription("Enter the travel details here");
    setControl(from);
    count=0;
  }

  @Override
  public void createControl(Composite parent) {
	  //setPageComplete(false);
    container = new Composite(parent, SWT.NULL);
    GridLayout layout = new GridLayout();
    container.setLayout(layout);
    layout.numColumns = 2;
    Label label1 = new Label(container, SWT.NULL);
    label1.setText("FROM :");

    from = new Text(container, SWT.BORDER | SWT.SINGLE);
    from.setText("");
    Label label2 = new Label(container, SWT.NULL);
    label2.setText("TO :");

    to = new Text(container, SWT.BORDER | SWT.SINGLE);
    to.setText("");
    Label label3 = new Label(container, SWT.NULL);
    label3.setText("via:");
    via1 = new Text(container, SWT.BORDER | SWT.SINGLE);
    via1.setText("");
    Label label4 = new Label(container, SWT.NULL);
    label4.setText("via:");
    via2 = new Text(container, SWT.BORDER | SWT.SINGLE);
    via2.setText("");
    Label label5 = new Label(container, SWT.NULL);
    label5.setText("via:");
    via3 = new Text(container, SWT.BORDER | SWT.SINGLE);
    via3.setText("");
    from.addKeyListener(new KeyListener() {

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
          if (!from.getText().isEmpty()) {
        	  canFinish();

          }
        }

      });
    to.addKeyListener(new KeyListener() {

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
          if (!to.getText().isEmpty()) {
        	  canFinish();
          }
        }

      });
    
    



    GridData gd = new GridData(GridData.FILL_HORIZONTAL);
    from.setLayoutData(gd);
    to.setLayoutData(gd);
    via1.setLayoutData(gd);
    via2.setLayoutData(gd);
    via3.setLayoutData(gd);
   /* Label labelCheck = new Label(container, SWT.NONE);
    labelCheck.setText("This is a check");
    Button check = new Button(container, SWT.CHECK);*/
    //check.setSelection(true);
    // Required to avoid an error in the system
    setControl(container);
    
    setPageComplete(false);
  }

  public String getText1() {
    return from.getText();
  }
  public String getText2() {
	    return to.getText();
	  }
  public String getVia(){
	  String via= new String();
	  via= via1.getText();
	   if(!via2.getText().isEmpty())
		   via= via+ " ," + via2.getText();
	   if(!via3.getText().isEmpty())
		   via= via + " ," + via3.getText();
	   
	   return via;
  }
  public boolean checkPageComplete(){
		 if (!from.getText().isEmpty() && !to.getText().isEmpty())
			 return true;
		 else 
			 return false;
	}
  private void canFinish() {
	// TODO Auto-generated method stub
	  if(checkPageComplete())
		  setPageComplete(true);
		  //getWizard().getContainer().updateButtons();
}
} 