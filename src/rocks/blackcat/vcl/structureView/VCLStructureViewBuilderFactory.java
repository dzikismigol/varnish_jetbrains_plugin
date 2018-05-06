package rocks.blackcat.vcl.structureView;

import com.intellij.ide.structureView.StructureView;
import com.intellij.ide.structureView.StructureViewBuilder;
import com.intellij.lang.PsiStructureViewFactory;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rocks.blackcat.vcl.psi.VCLFile;

public class VCLStructureViewBuilderFactory implements PsiStructureViewFactory {
    @Nullable
    @Override
    public StructureViewBuilder getStructureViewBuilder(@NotNull PsiFile psiFile) {
        return new StructureViewBuilder() {
            @NotNull
            @Override
            public StructureView createStructureView(FileEditor fileEditor, @NotNull Project project) {
                return new VCLFileStructureViewComponent(project, (VCLFile) psiFile, fileEditor);
            }
        };
    }
}
