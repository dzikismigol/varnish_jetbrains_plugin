package rocks.blackcat.vcl.structureView;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rocks.blackcat.vcl.psi.VCLFile;

import java.util.Collection;

public class VCLFileStructureViewElement extends PsiTreeElementBase<VCLFile> {
    @NotNull
    @Override
    public Collection<StructureViewTreeElement> getChildrenBase() {
        return null;
    }

    @Nullable
    @Override
    public String getPresentableText() {
        return null;
    }
}
