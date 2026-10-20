package ru.garfield;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class GarfieldScreen extends Screen {

    private int theme = 0;

    private final String[] themes = {
        "DARK GLASS",
        "APPLE GLASS",
        "RGB GLASS"
    };

    public GarfieldScreen() {
        super(Text.literal("GARFIELD"));
    }

    @Override
    protected void init() {
        int cx = width / 2;
        int cy = height / 2;

        addDrawableChild(ButtonWidget.builder(
            Text.literal("THEME: " + themes[theme]),
            button -> {
                theme = (theme + 1) % themes.length;
                button.setMessage(
                    Text.literal("THEME: " + themes[theme])
                );
            }
        ).dimensions(cx - 100, cy - 10, 200, 20).build());

        addDrawableChild(ButtonWidget.builder(
            Text.literal("CLOSE"),
            button -> close()
        ).dimensions(cx - 100, cy + 20, 200, 20).build());
    }

    @Override
    public void render(
        DrawContext context,
        int mouseX,
        int mouseY,
        float delta
    ) {
        int background = 0xD908101C;
        int panel = 0xDD172536;
        int accent = 0xFFFFA500;

        if (theme == 1) {
            background = 0xCDEAF4FA;
            panel = 0xDDF5FAFF;
            accent = 0xFF4A9FE8;
        } else if (theme == 2) {
            background = 0xD910081D;
            panel = 0xDD251438;
            long time = System.currentTimeMillis();
            int step = (int) ((time / 20) % 360);
            int r = (int) (127 + 127 * Math.sin(step * Math.PI / 180));
            int g = (int) (127 + 127 * Math.sin((step + 120) * Math.PI / 180));
            int b = (int) (127 + 127 * Math.sin((step + 240) * Math.PI / 180));
            accent = 0xFF000000 | (r << 16) | (g << 8) | b;
        }

        context.fill(0, 0, width, height, background);

        int cx = width / 2;
        int cy = height / 2;

        context.fill(
            cx - 130, cy - 65,
            cx + 130, cy + 65,
            panel
        );

        context.fill(
            cx - 130, cy - 65,
            cx - 126, cy + 65,
            accent
        );

        context.fill(
            cx - 126, cy - 63,
            cx + 128, cy - 61,
            0x55FFFFFF
        );

        context.drawCenteredTextWithShadow(
            textRenderer,
            Text.literal("GARFIELD"),
            cx,
            cy - 48,
            accent
        );

        context.drawCenteredTextWithShadow(
            textRenderer,
            Text.literal("LIQUID GLASS"),
            cx,
            cy - 32,
            0xFFFFFFFF
        );

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
