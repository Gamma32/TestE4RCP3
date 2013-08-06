package teste4rcp3;

import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class E4Senderview {
	static public final String ID = "E4SenderView.e4view";
	private Text text;
	@Inject
	private IEventBroker eventBroker; 
	
	@Inject
	public void create(Composite parent){
		
		parent.setLayout(new GridLayout(2, false));
		
		text = new Text(parent, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		text.setText("Text to send");
		
		
		Button sendButton = new Button(parent, SWT.None);
		sendButton.setText("Send to other View");
		sendButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				eventBroker.send("TOPIC_TODO/SEND_TEXT", text.getText());
			}
		});
		
		
	}
}
