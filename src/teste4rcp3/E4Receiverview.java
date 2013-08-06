package teste4rcp3;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class E4Receiverview {

	static public final String ID = "E4ReceiverView.e4view";
	private Label label;

	@Inject
	public void create(Composite parent) {
		label = new Label(parent, SWT.NONE);
		label.setText("Test");
	}

	@Inject
	@Optional
	private void getNotified(@UIEventTopic("TOPIC_TODO/*") String s) {
		label.setText(s);
		
	}
}
