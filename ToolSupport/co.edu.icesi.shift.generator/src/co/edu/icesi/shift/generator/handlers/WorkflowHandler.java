package co.edu.icesi.shift.generator.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.mwe2.launch.runtime.Mwe2Launcher;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;

public class WorkflowHandler implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		//IProject project = root.getProject("prueba2");
		

		//org.eclipse.emf.mwe2.launch.runtime.Mwe2Launcher launcher = new Mwe2Launcher();
		//String[] args = {root.getLocation().toOSString()+"/prueba2/src/co/shift/generators/workflows/WF.mwe2"};
//		String[] args = {"src/co/shift/generators/workflows/WF.mwe2"};
		String[] args = {"co.shift.generators.workflows.WF"};
		//MessageDialog.openInformation(HandlerUtil.getActiveShell(event), "Generar Enterprise APP", "opción ejecutada: Mwe2Launcher "+args[0]);
		//IQualifiedNameConverter. 
		new org.eclipse.emf.mwe2.launch.runtime.Mwe2Launcher().run(args);

		return null;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isHandled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}
	//org.eclipse.emf.mwe2.launch.runtime.Mwe2Launcher src/co/shift/generators/workflows/WF.mwe2

}
