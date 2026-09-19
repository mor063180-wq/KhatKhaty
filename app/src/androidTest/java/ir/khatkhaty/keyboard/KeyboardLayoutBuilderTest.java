package ir.khatkhaty.keyboard;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import ir.khatkhaty.keyboard.layout.Box;
import ir.khatkhaty.keyboard.layout.Key;
import ir.khatkhaty.keyboard.layout.builder.KeyboardLayoutBuilder;
import ir.khatkhaty.keyboard.layout.builder.KeyboardLayoutException;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class KeyboardLayoutBuilderTest {

    @Test
    public void build_returnsCorrectNumberOfKeys() throws KeyboardLayoutException {
        ArrayList<Key> keyboard = builder().setBox(Box.create(0,0,100,100))
                .newRow().addKey(1).addKey(1)
                .newRow().addKey(1).addKey(1).build();
        assertEquals(4, keyboard.size());
    }

    private KeyboardLayoutBuilder builder() {
        Context appContext = ApplicationProvider.getApplicationContext();
        return new KeyboardLayoutBuilder(appContext);
    }
}