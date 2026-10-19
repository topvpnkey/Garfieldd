package ru.garfield;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class GarfieldScreen extends Screen {

    public GarfieldScreen() {
        super(Text.literal("Garfield Visuals"));
    }

    @Override
    protected void init() {
        int x = width / 2 - 100;
        int y = height / 2;

        addDrawableChild(
                ButtonWidget.builder(
                        Text.literal("Liquid Glass: ON"),
                        button -> {
                            boolean enabled = button.getMessage()
                                    .getString().endsWith("ON");

                            button.setMessage(Text.literal(
                                    enabled
                                            ? "Liquid Glass: OFF"
                                            : "Liquid Glass: ON"
                            ));
                        }
                ).dimensions(x, y - 15, 200, 20).build()
        );

        addDrawableChild(
                ButtonWidget.builder(
                        Text.literal("Закрыть"),
                        button -> close()
                ).dimensions(x, y + 15, 200, 20).build()
        );
    }

    @Override
    public void render(
            DrawContext context,
            int mouseX,
            int mouseY,
            float delta
    ) {
        context.fill(0, 0, width, height, 0xD9101828);

        context.fill(
                width / 2 - 115,
                height / 2 - 65,
                width / 2 + 115,
                height / 2 + 60,
                0xAA263A50
        );

        context.drawCenteredTextWithShadow(
                textRenderer,
                Text.literal("GARFIELD"),
                width / 2,
                height / 2 - 50,
                0xFFFFA500
        );

        context.drawCenteredTextWithShadow(
                textRenderer,
                Text.literal("VISUAL SETTINGS"),
                width / 2,
                height / 2 - 30,
                0xFFFFFFFF
        );

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
