package co.edu.icesi.sam.client;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.Text;

public class DialogoEditarMaterial extends Dialog {

	public DialogoEditarMaterial() {
		setModal(true);
		setHeading("Editar Material");
		setLayout(new AbsoluteLayout());
		
		Button editar = new Button("Editar");
		add(editar, new AbsoluteData(196, 98));
				
		TextArea txtrNewTextarea = new TextArea();
		add(txtrNewTextarea, new AbsoluteData(115, 32));
		txtrNewTextarea.setSize("212px", "60px");
		txtrNewTextarea.setFieldLabel("Material:");
				
		Text txtNewText_1 = new Text("Material:");
		add(txtNewText_1, new AbsoluteData(47, 32));
	}
	protected void onButtonPressed(Button button) {
		if (button == getButtonBar().getItemByItemId(OK)) {
			// TODO
		}
		super.onButtonPressed(button);
	}
}
