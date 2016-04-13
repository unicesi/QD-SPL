/*
 * Ya no se usa.
 * esta clase era la original del plugin, cuando se había diseñado para abrir el browser
 * al final del wizard. Se deja para referencia, por si se llega a necesitar la parte
 * del web browser.
 * Jcifuentes
 */

package co.edu.icesi.shift.qaconfig.creator;

import java.net.URL;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.browser.IWebBrowser;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.internal.browser.WorkbenchBrowserSupport;

public class QANewWizard extends Wizard implements INewWizard {

	private WizardNewFileCreationPage page;
	private ISelection selection;
	
	public QANewWizard() {
		// TODO Auto-generated constructor stub
		setWindowTitle("my window title");
	}

	@Override
	public void addPages() {
		// TODO Auto-generated method stub
		super.addPages();
	    page = new WizardNewFileCreationPage("From Scratch Project Wizard", (IStructuredSelection) selection);
	    page.setTitle("From Scratch Project");
	    page.setDescription("Create something from scratch.");

	    addPage(page);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub
		this.selection = selection;

	}

	@Override
	public boolean performFinish() {
		try{
		// TODO Auto-generated method stub
		final IWebBrowser browser = WorkbenchBrowserSupport.getInstance().createBrowser("Browser ID");
		browser.openURL(new URL("http://www.splot-research.org/SplotConfigurationServlet?action=interactive_configuration_main&op=reset&userModels=&selectedModels=model_20141006_1946000492.xml"));
		return true;
/*		final String projectName = page.getProjectName();
		try{
			getContainer().run(true, false, null);
		}
		catch(Exception e){
			
		}
*/		
		
	}catch (Exception e) {
		// TODO Auto-generated catch block
		MessageDialog.openError(getShell(), "Error", e.getMessage());
		return false;
	}
	}
	


}
