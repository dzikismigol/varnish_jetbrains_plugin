package rocks.blackcat.vcl;

import com.intellij.testFramework.ParsingTestCase;

public class ProbeParsingTest extends ParsingTestCase {
    public ProbeParsingTest() {
        super("", "vcl", new VCLParserDefinition());
    }

    public void testParsingTestData() {
        doTest(true);
    }

    @Override
    protected boolean skipSpaces() {
        return false;
    }

    @Override
    protected boolean includeRanges() {
        return true;
    }

    @Override
    protected String getTestDataPath() {
        return "testData";
    }


}
