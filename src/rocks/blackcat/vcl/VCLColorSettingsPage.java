package rocks.blackcat.vcl;

import com.intellij.openapi.editor.colors.*;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rocks.blackcat.vcl.VCLIcons;
import rocks.blackcat.vcl.VCLSyntaxHighlighter;

import javax.swing.*;
import java.util.Map;

public class VCLColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Comment", VCLSyntaxHighlighter.COMMENT),
            new AttributesDescriptor("Keyword", VCLSyntaxHighlighter.KEYWORD),
            new AttributesDescriptor("Global variables", VCLSyntaxHighlighter.GLOBAL_VARIABLE)
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return VCLIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new VCLSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "sub vcl_hash {\n" +
                "    # this is a comment\n" +
                "    if (req.http.host ~ \"^(www.|embed.|)example.com$\" && req.url !~ \"\\.(png|gif|jpg|swf|css|js|htc|exe|ico|svg)$\") {\n" +
                "        hash_data(req.http.X-Forwarded-Proto);\n" +
                "    }\n" +
                "}";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "VCL";
    }
}
