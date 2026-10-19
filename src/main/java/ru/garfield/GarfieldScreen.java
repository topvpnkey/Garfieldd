package ru.garfield;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class GarfieldScreen extends Screen {

    private String tab = "VISUALS";

    public GarfieldScreen() {
        super(Text.literal("GARFIELD"));
    }

    @Override
    protected void init() {
        clearChildren();

        int centerX = width / 2;
        int centerY = height / 2;

        addDrawableChild(ButtonWidget.builder(
                Text.literal("VISUALS"),
                b -> {
                    tab = "VISUALS";
                    clearAndInit();
                }
        ).dimensions(centerX - 150, centerY - 65, 72, 20).build());

        addDrawableChild(ButtonWidget.builder(
                Text.literal("THEME"),
                b -> {
                    tab = "THEME";
                    clearAndInit();
                }
        ).dimensions(centerX - 74, centerY - 65, 72, 20).build());

        addDrawableChild(ButtonWidget.builder(
                Text.literal("ANIMATIONS"),
                b -> {
                    tab = "ANIMATIONS";
                    clearAndInit();
                }
        ).dimensions(centerX + 2, centerY - 65, 88, 20).build());

        addDrawableChild(ButtonWidget.builder(
                Text.literal("SETTINGS"),
                b -> {
                    tab = "SETTINGS";
                    clearAndInit();
                }
        ).dimensions(centerX + 94, centerY - 65, 72, 20).build());

        if (tab.equals("VISUALS")) {
            addDrawableChild(ButtonWidget.builder(
                    Text.literal("Liquid Glass: ON"),
                    b -> b.setMessage(Text.literal(
                            b.getMessage().getString().endsWith("ON")
                                    ? "Liquid Glass: OFF"
                                    : "Liquid Glass: ON"
                    ))
            ).dimensions(centerX - 100, centerY - 5, 200, 20).build());
        }

        addDrawableChild(ButtonWidget.builder(
                Text.literal("CLOSE"),
                b -> close()
        ).dimensions(centerX - 100, centerY + 55, 200, 20).build());
    }

    @Override
    public void render(
            DrawContext context,
            int mouseX,
            int mouseY,
            float delta
    ) {
        // Dark background
        context.fill(0, 0, width, height, 0xD908101C);

        int cx = width / 2;
        int cy = height / 2;

        // Outer glass panel
        context.fill(
                cx - 180, cy - 100,
                cx + 180, cy + 100,
                0xBB172536
        );

        // Glass highlight
        context.fill(
                cx - 178, cy - 98,
                cx + 178, cy - 96,
                0x55FFFFFF
        );

        // Orange accent
        context.fill(
                cx - 180, cy - 100,
                cx - 176, cy + 100,
                0xFFFFA500
        );

        // Logo
        context.drawCenteredTextWithShadow(
                textRenderer,
                Text.literal("GARFIELD"),
                cx, cy - 88,
                0xFFFFA500
        );

        context.drawCenteredTextWithShadow(
                textRenderer,
                Text.literal(tab),
                cx, cy + 30,
                0xFFFFFFFF
        );

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
