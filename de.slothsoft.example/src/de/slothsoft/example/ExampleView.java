package de.slothsoft.example;

import javax.inject.Inject;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.part.ViewPart;

public class ExampleView extends ViewPart {

	public static final String ID = "de.slothsoft.example.ExampleView";

	class ViewLabelProvider extends LabelProvider implements ITableLabelProvider {
		@Override
		public String getColumnText(Object obj, int index) {
			return getText(obj);
		}
		@Override
		public Image getColumnImage(Object obj, int index) {
			return getImage(obj);
		}
		@Override
		public Image getImage(Object obj) {
			return ExampleView.this.workbench.getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}
	}

	@Inject
	IWorkbench workbench;

	private TableViewer viewer;

	@Override
	public void createPartControl(Composite parent) {
		this.viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		this.viewer.setContentProvider(ArrayContentProvider.getInstance());
		this.viewer.setInput(new String[]{"One", "Two", "Three"});
		this.viewer.setLabelProvider(new ViewLabelProvider());

		getSite().setSelectionProvider(this.viewer);
	}

	@Override
	public void setFocus() {
		this.viewer.getControl().setFocus();
	}
}
