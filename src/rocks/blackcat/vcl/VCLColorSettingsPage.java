package rocks.blackcat.vcl;

import com.intellij.openapi.editor.colors.*;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class VCLColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Comment", VCLSyntaxHighlighter.COMMENT),
            new AttributesDescriptor("Keyword", VCLSyntaxHighlighter.KEYWORD),
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
                "\n" +
                "    # hash lokalizacyjny ale nie dla statickow i niektorych URL promocyjnych\n" +
                "    if (req.http.host ~ \"^(www.|embed.|)gog.com$\" && req.url !~ \"\\.(png|gif|jpg|swf|css|js|htc|exe|ico|svg)$\" && req.url !~ \"^/insomnia/current_deal$\" && req.url !~ \"^/api/users\" && req.url !~ \"^/api/news\" && req.url !~ \"^/api/users\") {\n" +
                "        # plus inny cache dla X-Forwarded-Proto - problemy z redirect loop https->http\n" +
                "                if(req.http.X-Forwarded-Proto) {\n" +
                "                        hash_data(req.http.X-Forwarded-Proto);\n" +
                "                }\n" +
                "    }\n" +
                "\n" +
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
