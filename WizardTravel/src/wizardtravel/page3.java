package wizardtravel;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
public class page3 extends WizardPage {
	  private Text text1;
	  ListViewer listViewer;
	  StringBuffer date = new StringBuffer("");
	  String sb = new String("");
	  DateTime dateFrom;
	  private Composite container;
      private List<String> list=new ArrayList<String>();
	  public page3() {
	    super("Select agent and date");
	    setTitle("Select your agent and date of travel");
	    setDescription("Third page of travel world. You need to select your agent and travel date here.");
	  }

	  @Override
	  public void createControl(Composite parent) {
	    container = new Composite(parent, SWT.NULL);
	    GridLayout layout = new GridLayout();
	    container.setLayout(layout);
	   
	   layout.numColumns = 2;
	   Label label1 = new Label(container, SWT.NULL);
	    label1.setText("Select Your Agent");
	    listViewer=new ListViewer(container);
	   list.add("Big Travels");
	    list.add("Aviator Travels");
	    list.add("BTM Travels");
	    list.add("Arihanth Travels");
	    list.add("Atlas Travels");
	    Object[] list1= list.toArray();
	    listViewer.add(list1);
	    
	    Label label2 = new Label(container, SWT.NULL);
	    label2.setText("Select travel start date:");
	    dateFrom = new DateTime(container, SWT.BORDER | SWT.DATE | SWT.DROP_DOWN);
	    listViewer.addSelectionChangedListener(new ISelectionChangedListener() {
	        public void selectionChanged(SelectionChangedEvent event) {
	          IStructuredSelection selection = (IStructuredSelection)event.getSelection();
	          sb="";
	          //sb.append("tatal " + selection.size() + " items selected: ");
	          for(java.util.Iterator iterator = selection.iterator(); iterator.hasNext(); ) {
	           sb=(String) (iterator.next());
	            //sb.replace(0,sb.length(),(String) iterator.next());
	            break;
	          }
	          
	          System.out.println("Your agent is " +sb);
	        }
	      });
	   dateFrom.addSelectionListener(new SelectionAdapter() {
		   
		   public void widgetSelected (SelectionEvent e) {
			   
			  // System.out.println ("Calendar date selected (MM/DD/YYYY) = " + (dateFrom.getMonth () + 1) + "/" + dateFrom.getDay () + "/" + dateFrom.getYear ());
			   date.delete(0,date.length());
			   date.append((dateFrom.getMonth () + 1));
			   date.append("/");
			   date.append(dateFrom.getDay());
			   date.append("/");
			   date.append(dateFrom.getYear());
			   //System.out.println("After adding to date "+date);
			   //System.out.println ("Date selected (MM/YYYY) = " + (date.getMonth () + 1) + "/" + date.getYear ());
			   
			   //System.out.println ("Time selected (HH:MM) = " + time.getHours () + ":" + (time.getMinutes () < 10 ? "0" : "") + time.getMinutes ());
			   
			   //dialog.close ();
			   
			   }
	});
	    
	    //dateFrom.setDate();
	    /*L bel label1 = new Label(container, SWT.NULL);
	    label1.setText("Travel Name");

	    text1 = new Text(container, SWT.BORDER | SWT.SINGLE);
	    text1.setText("");
	    text1.addKeyListener(new KeyListener() {

	      @Override
	      public void keyPressed(KeyEvent e) {
	      }

	      @Override
	      public void keyReleased(KeyEvent e) {
	        if (!text1.getText().isEmpty()) {
	          setPageComplete(true);
             
	        }
	      }

	    });*/
	    GridData gd = new GridData(GridData.FILL_HORIZONTAL);
	    //listViewer.setLayoutData(gd);
	    // Required to avoid an error in the system
	    setControl(container);
	    setPageComplete(false);

	  }

	  public StringBuffer getDate() {
	    return date;
	  }
   public String getAgent(){
	   return sb;
   }
}
