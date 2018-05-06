package rocks.blackcat.vcl.structureView;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.structureView.TextEditorBasedStructureViewModel;
import com.intellij.openapi.editor.Editor;
import org.jetbrains.annotations.NotNull;
import rocks.blackcat.vcl.psi.VCLFile;

public class VCLFileStructureViewModel extends TextEditorBasedStructureViewModel {

    public VCLFileStructureViewModel(VCLFile file, Editor editor) {
        super(editor, file);
    }

    @NotNull
    @Override
    public StructureViewTreeElement getRoot() {
        return null;
    }
}
