/**
 * 
 */
package co.edu.icesi.shift.qaconfig.creator;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;

/**
 * @author julián cifuentes
 *
 */
public class QAConfigPage extends WizardPage {

	/**
	 * @param pageName
	 */
	public QAConfigPage(String pageName) {
		super(pageName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param pageName
	 * @param title
	 * @param titleImage
	 */
	public QAConfigPage(String pageName, String title, ImageDescriptor titleImage) {
		super(pageName, title, titleImage);
		setTitle("QA Title");
		setDescription("QA Description");
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub

	}

}
