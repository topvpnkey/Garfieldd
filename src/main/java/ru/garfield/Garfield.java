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
        int centerX = this.width / 2;
        int centerY = this.height / 2;

        addDrawableChild(
                ButtonWidget.builder(
                        Text.literal("Liquid Glass: ON"),
                        button -> {
                            button.setMessage(
                                    Text.literal(
                                            button.getMessage()
                                                    .getString()
                                                    .contains("ON")
                                                    ? "Liquid Glass: OFF"
                                                    : "Liquid Glass: ON"
                                    )
                            );
                        }
                ).dimensions(centerX - 100, centerY - 15, 200, 20).build()
        );

        addDrawableChild(
                ButtonWidget.builder(
                        Text.literal("Закрыть"),
                        button -> close()
                ).dimensions(centerX - 100, centerY + 20, 200, 20).build()
        );
    }

    @Override
    public void render(
            DrawContext context,
            int mouseX,
            int mouseY,
            float delta
    ) {
        context.fill(
                0, 0, width, height,
                0xD9101828
        );

        context.fill(
                width / 2 - 115,
                height / 2 - 75,
                width / 2 + 115,
                height / 2 + 65,
                0xAA263A50
        );

        context.drawCenteredTextWithShadow(
                textRenderer,
                Text.literal("GARFIELD"),
                width / 2,
                height / 2 - 60,
                0xFFFFA500
        );

        context.drawCenteredTextWithShadow(
                textRenderer,
                Text.literal("VISUAL SETTINGS"),
                width / 2,
                height / 2 - 40,
                0xFFFFFFFF
        );

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
