int top = cy - 100;
        int bottom = cy + 78;

        int accent = accentColor();

        int panelColor;

        if (theme == 1) {
            panelColor = 0xDCEAF2FA;
        } else if (theme == 2) {
            panelColor = 0xC8181029;
        } else {
            panelColor = 0xC8101725;
        }

        // BACKGROUND PANEL

        context.fill(
            left, top,
            right, bottom,
            panelColor
        );

        // GLASS BORDER

        context.fill(
            left, top,
            right, top + 1,
            0x66FFFFFF
        );

        context.fill(
            left, bottom - 1,
            right, bottom,
            0x44FFFFFF
        );

        context.fill(
            left, top,
            left + 1, bottom,
            0x44FFFFFF
        );

        context.fill(
            right - 1, top,
            right, bottom,
            0x44FFFFFF
        );

        // GLASS HIGHLIGHT

        context.fill(
            left + 8,
            cy - 53,
            right - 8,
            cy - 52,
            0x22FFFFFF
        );

        // PARTICLES

        if (particles) {
            long time = System.currentTimeMillis();

            for (int i = 0; i < 12; i++) {
                int px = left + 10
                    + (int) (
                        Math.abs(
                            Math.sin(time * 0.001 + i * 1.7)
                        ) * Math.max(1, panelWidth - 20)
                    );

                int py = top + 5
                    + (int) (
                        Math.abs(
                            Math.cos(time * 0.0015 + i)
                        ) * 165
                    );

                if (px >= left && px < right
                    && py >= top && py < bottom) {

                    context.fill(
                        px, py,
                        px + 2, py + 2,
                        accent
                    );
                }
            }
        }

        // LOGO

        context.drawCenteredTextWithShadow(
            this.textRenderer,
            Text.literal("GARFIELD"),
            cx,
            cy - 84,
            accent
        );

        // SUBTITLE

        context.drawCenteredTextWithShadow(
            this.textRenderer,
            Text.literal("ULTIMATE / LIQUID GLASS"),
            cx,
            cy - 72,
            theme == 1
                ? 0xFF25384A
                : 0xFFE0E7F0
        );

        // CURRENT SECTION

        context.drawCenteredTextWithShadow(
            this.textRenderer,
            Text.literal(TABS[selectedTab]),
            cx,
            cy + 1,
            accent
        );

        // ANIMATED UNDERLINE

        int lineWidth = 30;

        if (animations) {
            lineWidth += (int) (
                Math.abs(
                    Math.sin(
                        (System.currentTimeMillis() - openedAt)
                        / 350.0
                    )
                ) * 65
            );
        }

        context.fill(
            cx - lineWidth,
            cy + 12,
            cx + lineWidth,
            cy + 13,
            accent
        );

        // BUTTONS AND SCREEN

        super.render(
            context,
            mouseX,
            mouseY,
            delta
        );
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
