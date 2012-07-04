package co.edu.icesi.sam.client.dialogos;

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

public class DialogoCrearObjetivoTerminal extends Dialog {

	public DialogoCrearObjetivoTerminal() {
		setModal(true);
		setHeading("Crear Objetivo Terminal");
		setLayout(new AbsoluteLayout());
		
		Button btnNewButton = new Button("Guardar");
		add(btnNewButton, new AbsoluteData(238, 138));
		
		TextField txtfldNewTextfield = new TextField();
		add(txtfldNewTextfield, new AbsoluteData(157, 25));
		txtfldNewTextfield.setSize("212px", "24px");
		txtfldNewTextfield.setFieldLabel("Objetivo Terminal:");
		
		TextArea txtrNewTextarea = new TextArea();
		add(txtrNewTextarea, new AbsoluteData(157, 72));
		txtrNewTextarea.setSize("212px", "60px");
		txtrNewTextarea.setFieldLabel("Contenido:");
		
		Text txtNewText = new Text("Objetivo Terminal:");
		add(txtNewText, new AbsoluteData(30, 36));
		
		Text txtNewText_1 = new Text("Contenido:");
		add(txtNewText_1, new AbsoluteData(30, 72));
	}
	protected void onButtonPressed(Button button) {
		if (button == getButtonBar().getItemByItemId(OK)) {
			// TODO
		}
		super.onButtonPressed(button);
	}
}
