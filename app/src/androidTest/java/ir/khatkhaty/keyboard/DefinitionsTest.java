package ir.khatkhaty.keyboard;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import ir.khatkhaty.keyboard.layout.Box;
import ir.khatkhaty.keyboard.layout.Definitions;
import ir.khatkhaty.keyboard.layout.Key;
import ir.khatkhaty.keyboard.layout.builder.KeyboardLayoutBuilder;
import ir.khatkhaty.keyboard.layout.builder.KeyboardLayoutException;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class DefinitionsTest {

    @Test
    public void addArrowsRow_producesValidResult() throws KeyboardLayoutException {

        Context appContext = ApplicationProvider.getApplicationContext();
        Definitions definitions = new Definitions(appContext);
        KeyboardLayoutBuilder builder = builder();
        definitions.addArrowsRow(builder);
        validate(builder);
    }

    @Test
    public void addCopyPasteRow() throws KeyboardLayoutException {
        Context appContext = ApplicationProvider.getApplicationContext();
        Definitions definitions = new Definitions(appContext);
        KeyboardLayoutBuilder builder = builder();
        definitions.addCopyPasteRow(builder);
        validate(builder);
    }


    @Test
    public void addQwertyRows() throws KeyboardLayoutException {
        Context appContext = ApplicationProvider.getApplicationContext();
        Definitions definitions = new Definitions(appContext);
        KeyboardLayoutBuilder builder = builder();
        definitions.addQwertyRows(builder);
        validate(builder);
    }

    @Test
    public void addQwertzRows() throws KeyboardLayoutException {
        Context appContext = ApplicationProvider.getApplicationContext();
        Definitions definitions = new Definitions(appContext);
        KeyboardLayoutBuilder builder = builder();
        definitions.addQwertzRows(builder);
        validate(builder);
    }

    @Test
    public void addAzertyRows() throws KeyboardLayoutException {
        Context appContext = ApplicationProvider.getApplicationContext();
        Definitions definitions = new Definitions(appContext);
        KeyboardLayoutBuilder builder = builder();
        definitions.addAzertyRows(builder);
        validate(builder);
    }

    @Test
    public void addClipboardRow() throws KeyboardLayoutException {
        Context appContext = ApplicationProvider.getApplicationContext();
        Definitions definitions = new Definitions(appContext);
        KeyboardLayoutBuilder builder = builder();
        definitions.addClipboardActions(builder);
        validate(builder);
    }


    private void validate(KeyboardLayoutBuilder builder) throws KeyboardLayoutException {
        for(Key key : builder.build()){
            assertNotNull(key.info);
            assertNotNull(key.box);
            // must have either code or outputText set
            assertTrue(key.info.code != 0 || key.info.outputText != null);
        }
    }

    private KeyboardLayoutBuilder builder() {
        Context appContext = ApplicationProvider.getApplicationContext();
        return new KeyboardLayoutBuilder(appContext).setBox(Box.create(0,0,1,1));
    }
}