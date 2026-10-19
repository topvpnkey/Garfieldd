if (theme == 1) {
            background = 0xCDEAF4FA;
            panel = 0xDDF5FAFF;
            accent = 0xFF4A9FE8;
            titleColor = 0xFF2376B8;
        } else if (theme == 2) {
            background = 0xD910081D;
            panel = 0xDD251438;

            float hue =
                (System.currentTimeMillis() % 6000L) / 6000.0f;

            int rgb = java.awt.Color.HSBtoRGB(hue, 0.8f, 1.0f);
            accent = 0xFF000000 | (rgb & 0x00FFFFFF);
            titleColor = accent;
        }

        context.fill(0, 0, width, height, background);

        int cx = width / 2;
        int cy = height / 2;
        int panelWidth = Math.min(420, width - 20);
        int left = cx - panelWidth / 2;
        int right = cx + panelWidth / 2;

        context.fill(
            left, cy - 100,
            right, cy + 100,
            panel
        );

        context.fill(
            left, cy - 100,
            left + 3, cy + 100,
            accent
        );

        if (glass) {
            context.fill(
                left + 4, cy - 98,
                right - 2, cy - 96,
                0x44FFFFFF
            );

            context.fill(
                left + 8, cy - 90,
                right - 8, cy - 89,
                0x22FFFFFF
            );
        }

        context.drawCenteredTextWithShadow(
            textRenderer,
            Text.literal("GARFIELD"),
            cx, cy - 89,
            titleColor
        );

        context.drawCenteredTextWithShadow(
            textRenderer,
            Text.literal("ULTIMATE / LIQUID GLASS"),
            cx, cy - 78,
            0xFFE0E7F0
        );

        context.drawCenteredTextWithShadow(
            textRenderer,
            Text.literal(tabs[selectedTab]),
            cx, cy + 32,
            accent
        );

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
